package lois.lab1.inference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lois.lab1.datastructure.AtomSignType;
import lois.lab1.datastructure.Goal;
import lois.lab1.datastructure.KnowledgeBase;
import lois.lab1.datastructure.Pair;
import lois.lab1.datastructure.Predicate;
import lois.lab1.datastructure.RelationTable;
import lois.lab1.datastructure.RelationTableColumn;
import lois.lab1.datastructure.Rule;
import lois.lab1.datastructure.TreeNode;

/**
 * Class that execute logical inference.
 *
 * @author Q-YAA
 */
public class Solver {

    private KnowledgeBase knowledgeBase;

    public Solver(KnowledgeBase knowledgeBase) {
        this.knowledgeBase = knowledgeBase;
    }

    /**
     * Creates tree of the logical inference.
     *
     * @param goal inference goal
     */
    public void solve(Goal goal) {

        for (Predicate predicate : goal.getGoalTermList()) {

//            TreeNode rootNode =
//                solveRec1(new TreeNode(TreeNode.OR_TYPE, null, predicate), predicate, "", 0, new ArrayList<Predicate>());
            TreeNode rootNode =
                solveRec2(new TreeNode(TreeNode.OR_TYPE, null, predicate), predicate, 0, new ArrayList<String>());

            //rootNode.clearTree();
            rootNode.calculateRelationTable();
            rootNode.printInferenceTree();
        }
    }

    public TreeNode solveRec2(TreeNode currentNode, Predicate predicate, int deep, List<String> usedPredicates) {

        // find contradictions
        List<Predicate> contradictionList = knowledgeBase.findLogicallySameFacts(predicate);
        for (Predicate contradiction : contradictionList) {
            currentNode.setType(TreeNode.AND_TYPE);
            currentNode.setRelationTable(createRelationTableForContradiction(predicate, contradiction));
        }

        // prevents recursion
        if (usedPredicates.contains(predicate.getSign())) {
            return currentNode;
        }
        usedPredicates.add(predicate.getSign());

        // apply rules
        List<Rule> ruleList = knowledgeBase.findRuleForPredicate(predicate);
        for (Rule rule : ruleList) {
            Rule unifiedRule = unifyRule(predicate, rule);

            if (unifiedRule == null) {
                continue;
            }

            TreeNode unifiedNode = new TreeNode(TreeNode.AND_TYPE, currentNode, unifiedRule.getConsequent());
            currentNode.addChild(unifiedNode);
            currentNode.setType(TreeNode.OR_TYPE);

            for (Predicate reason : unifiedRule.getReason()) {
                TreeNode reasonNode = new TreeNode(TreeNode.AND_TYPE, unifiedNode, reason);
                unifiedNode.addChild(reasonNode);
                usedPredicates.add(unifiedRule.getConsequent().getSign());
                solveRec2(reasonNode, reason, deep + 1, usedPredicates);
                usedPredicates.remove(unifiedRule.getConsequent().getSign());
            }
        }

        // apply similarity relation
        List<Pair<Predicate, String>> similarPredicatePairList = knowledgeBase.findAllSimilarPredicates(predicate);
        for (Pair<Predicate, String> similarPredicatePair : similarPredicatePairList) {
            List<Rule> rulesForSimilarNode = knowledgeBase.findRuleForPredicate(similarPredicatePair.getFirst());

            for (Rule rule : rulesForSimilarNode) {
                Rule similarRule = knowledgeBase.createSimilarRule(rule, similarPredicatePair.getSecond());

                if (similarRule == null) {
                    continue;
                }

                Rule unifiedSimilarRule = unifyRule(predicate, similarRule);

                if (unifiedSimilarRule == null) {
                    continue;
                }

                TreeNode unifiedSimilarNode = new TreeNode(TreeNode.AND_TYPE, currentNode, unifiedSimilarRule.getConsequent());
                currentNode.addChild(unifiedSimilarNode);
                currentNode.setType(TreeNode.OR_TYPE);

                for (Predicate similarReason : unifiedSimilarRule.getReason()) {
                    TreeNode similarReasonNode = new TreeNode(TreeNode.AND_TYPE, unifiedSimilarNode, similarReason);
                    unifiedSimilarNode.addChild(similarReasonNode);
                    usedPredicates.add(unifiedSimilarRule.getConsequent().getSign());
                    solveRec2(similarReasonNode, similarReason, deep + 1, usedPredicates);
                    usedPredicates.remove(unifiedSimilarRule.getConsequent().getSign());
                }

                // append similar predicate
                TreeNode similarPredicateNode =
                    new TreeNode(TreeNode.AND_TYPE, unifiedSimilarNode, similarPredicatePair.getFirst());
                similarPredicateNode.setSimilarityName(similarPredicatePair.getSecond());
                unifiedSimilarNode.addChild(similarPredicateNode);
                solveRec2(similarPredicateNode, similarPredicatePair.getFirst(), deep + 1, usedPredicates);
            }
        }

        usedPredicates.remove(predicate.getSign());
        return currentNode;
    }

    private RelationTable createRelationTableForContradiction(Predicate predicate, Predicate contradiction) {
        RelationTable relationTable = new RelationTable();

        for (int i = 0; i < predicate.getArgumentList().size(); i++) {

            if (predicate.getArgumentList().get(i).getType() == AtomSignType.VAR) {

                relationTable.addColumn(new RelationTableColumn(
                    predicate.getArgumentList().get(i), Arrays.asList(contradiction.getArgumentList().get(i))));
            }
        }

        return relationTable;
    }

//    public TreeNode solveRec1(
//        TreeNode currentNode, Predicate predicate, String similarityName, int deep, List<Predicate> usedPredicate) {
//
//        if (usedPredicate.contains(predicate)) {
//            currentNode.getParent().getChildren().remove(currentNode);
//            return currentNode.getParent();
//        }
//        usedPredicate.add(predicate);
//
//        for (Predicate contradiction : knowledgeBase.findLogicallySameFacts(predicate)) {
//            currentNode.setType(TreeNode.AND_TYPE);
//            currentNode.getRelationTable().addRow(predicate.getVariableArgumentList(), contradiction.getArgumentList());
//        }
//
//        List<Rule> ruleList = knowledgeBase.findRuleForPredicate(predicate);
//
//        for (Rule rule : ruleList) {
//
//            List<Predicate> unifiedRulePredicates = unifyRule(predicate, rule);
//            Predicate unifiedConsequent = unifyPredicate(rule.getConsequent(), predicate);
//
//            TreeNode unifiedNode = null;
//            if (!unifiedRulePredicates.isEmpty()) {
//                unifiedNode = new TreeNode(TreeNode.AND_TYPE, currentNode, unifiedConsequent);
//                currentNode.addChild(unifiedNode);
//                currentNode.setType(TreeNode.OR_TYPE);
//
//                usedPredicate.add(unifyPredicate(rule.getConsequent(), predicate));
//            }
//
//            for (Predicate nextPredicate : unifiedRulePredicates) {
//                TreeNode nextNode = new TreeNode(TreeNode.OR_TYPE, unifiedNode, nextPredicate);
//                unifiedNode.addChild(nextNode);
//                unifiedNode.setType(TreeNode.AND_TYPE);
//
//                solveRec1(nextNode, nextPredicate, similarityName, deep + 1, usedPredicate);
//                usedPredicate.remove(unifiedConsequent.getSign());
//            }
//        }
//
//        List<Pair<Predicate, String>> similarPredicatePairList = knowledgeBase.findAllSimilarPredicates(predicate);
//        for (Pair<Predicate, String> similarPredicatePair : similarPredicatePairList) {
//            List<Rule> similarRuleList =
//                knowledgeBase.findAllSimilarRuleForPredicate(predicate, similarPredicatePair.getSecond());
//
//            for (Rule similarRule : similarRuleList) {
//
//                List<Predicate> unifiedRulePredicates = unifyRule(predicate, similarRule);
//                Predicate unifiedConsequent = unifyPredicate(similarRule.getConsequent(), predicate);
//
//                if (unifiedConsequent != null) {
//                    //Predicate unifiedSimilarPredicate = unifyPredicate(similarPredicatePair.getFirst(), unifiedConsequent);
//
//                    //if (unifiedSimilarPredicate == null) {
//                    //    continue;
//                    //}
//
//                    TreeNode unifiedNode = null;
//                    unifiedNode = new TreeNode(TreeNode.AND_TYPE, currentNode, unifiedConsequent);
//                    currentNode.addChild(unifiedNode);
//                    currentNode.setType(TreeNode.OR_TYPE);
//                    usedPredicate.add(unifyPredicate(similarRule.getConsequent(), predicate));
//
//                    TreeNode similarPredicateNode =
//                        new TreeNode(TreeNode.OR_TYPE, unifiedNode, similarPredicatePair.getFirst());
//                    similarPredicateNode.setSimilarityName(similarPredicatePair.getSecond());
//                    unifiedNode.addChild(similarPredicateNode);
//
//                    solveRec1(similarPredicateNode, similarPredicatePair.getFirst(), similarityName, deep + 1, usedPredicate);
//
//                    for (Predicate nextPredicate : unifiedRulePredicates) {
//                        TreeNode nextNode = new TreeNode(TreeNode.OR_TYPE, unifiedNode, nextPredicate);
//                        unifiedNode.addChild(nextNode);
//                        unifiedNode.setType(TreeNode.AND_TYPE);
//
//                        solveRec1(nextNode, nextPredicate, similarityName, deep + 1, usedPredicate);
//                        usedPredicate.remove(unifiedConsequent);
//                    }
//                }
//            }
//        }
//
//
//        usedPredicate.remove(predicate);
//        return currentNode;
//    }

//    public TreeNode solveRec(
//        TreeNode currentNode, Predicate predicate, String similarityName, int deep, List<Predicate> usedPredicate) {
//
//        if (usedPredicate.contains(predicate)) {
//            return currentNode;
//        }
//        usedPredicate.add(predicate);
//
//        for (Predicate contradiction : knowledgeBase.findLogicallySameFacts(predicate)) {
//            if (knowledgeBase.isSimilarExist(contradiction, similarityName)) {
//                currentNode.setType(TreeNode.AND_TYPE);
//                currentNode.getRelationTable().addRow(predicate.getVariableArgumentList(), contradiction.getArgumentList());
//            }
//        }
//
//        List<Rule> ruleList = knowledgeBase.findRuleForPredicate(predicate);
//
//        for (Rule rule : ruleList) {
//
//            List<Predicate> unifiedRulePredicates = unifyRule(predicate, rule);
//            Predicate unifiedConsequent = unifyPredicate(rule.getConsequent(), predicate);
//
//            TreeNode unifiedNode = null;
//            if (!unifiedRulePredicates.isEmpty()) {
//                unifiedNode = new TreeNode(TreeNode.AND_TYPE, currentNode, unifiedConsequent);
//                unifiedNode.setSimilarityName(similarityName);
//                currentNode.addChild(unifiedNode);
//                currentNode.setType(TreeNode.OR_TYPE);
//
//                usedPredicate.add(unifyPredicate(rule.getConsequent(), predicate));
//            }
//
//            for (Predicate nextPredicate : unifiedRulePredicates) {
//                TreeNode nextNode = new TreeNode(TreeNode.OR_TYPE, unifiedNode, nextPredicate);
//                nextNode.setSimilarityName(similarityName);
//
//                unifiedNode.addChild(nextNode);
//                unifiedNode.setType(TreeNode.AND_TYPE);
//
//                solveRec(nextNode, nextPredicate, similarityName, deep + 1, usedPredicate);
//                usedPredicate.remove(unifiedConsequent);
//            }
//        }
//
//        if (similarityName.equals("")) {
//            List<Pair<Rule, String>> ruleSimilarityPairList = knowledgeBase.findAllSimilarRuleForPredicate(predicate);
//
//            for (Pair<Rule, String> ruleSimilarityPair : ruleSimilarityPairList) {
//                similarityName = ruleSimilarityPair.getSecond();
//
//                List<Predicate> unifiedRulePredicates = unifyRule(predicate, ruleSimilarityPair.getFirst());
//                Predicate unifiedConsequent = unifyPredicate(ruleSimilarityPair.getFirst().getConsequent(), predicate);
//
//                TreeNode unifiedNode = null;
//                if (!unifiedRulePredicates.isEmpty()) {
//                    unifiedNode = new TreeNode(TreeNode.AND_TYPE, currentNode, unifiedConsequent);
//                    unifiedNode.setSimilarityName(similarityName);
//                    currentNode.addChild(unifiedNode);
//                    currentNode.setType(TreeNode.OR_TYPE);
//
//                    usedPredicate.add(unifyPredicate(ruleSimilarityPair.getFirst().getConsequent(), predicate));
//                }
//
//                for (Predicate nextPredicate : unifiedRulePredicates) {
//                    TreeNode nextNode = new TreeNode(TreeNode.OR_TYPE, unifiedNode, nextPredicate);
//                    nextNode.setSimilarityName(similarityName);
//
//                    unifiedNode.addChild(nextNode);
//                    unifiedNode.setType(TreeNode.AND_TYPE);
//
//                    solveRec(nextNode, nextPredicate, similarityName, deep + 1, usedPredicate);
//                    usedPredicate.remove(unifiedConsequent);
//                }
//            }
//        }
//
//        usedPredicate.remove(predicate);
//        return currentNode;
//    }

    /**
     * Method for the rule unification.
     *
     * @param predicate predicate for the which it unified.
     * @param rule rule to unify
     * @return unified predicate list from the right part of the rule
     */
    private Rule unifyRule(Predicate predicate, Rule rule) {
        List<Predicate> resultList = new ArrayList<Predicate>();
        Predicate ruleConsequent = rule.getConsequent();

        if (!ruleConsequent.getSign().equals(predicate.getSign())) {
            return null;
        }

        UnificationGraph unificationGraph = UnificationGraph.create(predicate, ruleConsequent);
        Unificator unificator = unificationGraph.buildUnificator();

        if (unificator == null) {
            return null;
        }

        Predicate ruleConsequentUnification = unificator.getUnificationFor(ruleConsequent);
        Predicate predicateUnification = unificator.getUnificationFor(predicate);

        if (!ruleConsequentUnification.isLogicallyEquivalent(predicateUnification)) {
            return null;
        }

        for (Predicate reasonPredicate : rule.getReason()) {
            resultList.add(unificator.getUnificationFor(reasonPredicate));
        }

        return new Rule(ruleConsequentUnification, resultList);
    }

    /**
     * Method for the rule unification.
     *
     * @param predicate predicate for the which it unified.
     * @param rule rule to unify
     * @return unified predicate list from the right part of the rule
     */
//    private List<Predicate> unifyRule(Predicate predicate, Rule rule) {
//        List<Predicate> resultList = new ArrayList<Predicate>();
//        Predicate ruleConsequent = rule.getConsequent();
//
//        if (!ruleConsequent.getSign().equals(predicate.getSign())) {
//            return resultList;
//        }
//
//        UnificationGraph unificationGraph = UnificationGraph.create(predicate, ruleConsequent);
//        Unificator unificator = unificationGraph.buildUnificator();
//
//        if (unificator == null) {
//            return resultList;
//        }
//
//        Predicate ruleConsequentUnification = unificator.getUnificationFor(ruleConsequent);
//        Predicate predicateUnification = unificator.getUnificationFor(predicate);
//
//        if (!ruleConsequentUnification.isLogicallyEquivalent(predicateUnification)) {
//            return resultList;
//        }
//
//        for (Predicate reasonPredicate : rule.getReason()) {
//            resultList.add(unificator.getUnificationFor(reasonPredicate));
//        }
//
//        return new Rule(ruleConsequentUnification, resultList);
//        return resultList;
//    }

    /**
     * Method that unify one predicate with another.
     *
     * @param predicateToUnify predicate to be unified
     * @param predicate another predicate for unification
     * @return unified predicate
     */
    private Predicate unifyPredicate(Predicate predicateToUnify, Predicate predicate) {
        UnificationGraph unificationGraph = UnificationGraph.create(predicateToUnify, predicate);
        Unificator unificator = unificationGraph.buildUnificator();
        if (unificator != null) {
            return unificator.getUnificationFor(predicateToUnify);
        }
        else {
            return null;
        }
    }
}
