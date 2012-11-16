package lois.lab1.inference;

import java.util.ArrayList;
import java.util.List;

import lois.lab1.datastructure.Goal;
import lois.lab1.datastructure.KnowledgeBase;
import lois.lab1.datastructure.Pair;
import lois.lab1.datastructure.Predicate;
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

            TreeNode rootNode =
                solveRec(new TreeNode(TreeNode.OR_TYPE, null, predicate), predicate, "", 0, new ArrayList<Predicate>());

            rootNode.calculateRelationTable();
            rootNode.printInferenceTree();
        }
    }

    public TreeNode solveRec(
        TreeNode currentNode, Predicate predicate, String similarityName, int deep, List<Predicate> usedPredicate) {

        if (usedPredicate.contains(predicate)) {
            return currentNode;
        }
        usedPredicate.add(predicate);

        for (Predicate contradiction : knowledgeBase.findLogicallySameFacts(predicate)) {
            if (knowledgeBase.isSimilarExist(contradiction, similarityName)) {
                currentNode.setType(TreeNode.AND_TYPE);
                currentNode.getRelationTable().addRow(predicate.getArgumentList(), contradiction.getArgumentList());
            }
        }

        List<Rule> ruleList = knowledgeBase.findRuleForPredicate(predicate);

        for (Rule rule : ruleList) {

            List<Predicate> unifiedRulePredicates = unifyRule(predicate, rule);
            Predicate unifiedConsequent = unifyPredicate(rule.getConsequent(), predicate);

            TreeNode unifiedNode = null;
            if (!unifiedRulePredicates.isEmpty()) {
                unifiedNode = new TreeNode(TreeNode.AND_TYPE, currentNode, unifiedConsequent);
                unifiedNode.setSimilarityName(similarityName);
                currentNode.addChild(unifiedNode);
                currentNode.setType(TreeNode.OR_TYPE);

                usedPredicate.add(unifyPredicate(rule.getConsequent(), predicate));
            }

            for (Predicate nextPredicate : unifiedRulePredicates) {
                TreeNode nextNode = new TreeNode(TreeNode.OR_TYPE, unifiedNode, nextPredicate);
                nextNode.setSimilarityName(similarityName);

                unifiedNode.addChild(nextNode);
                unifiedNode.setType(TreeNode.AND_TYPE);

                solveRec(nextNode, nextPredicate, similarityName, deep + 1, usedPredicate);
                usedPredicate.remove(unifiedConsequent);
            }
        }

        if (similarityName.equals("")) {
            List<Pair<Rule, String>> ruleSimilarityPairList = knowledgeBase.findSimilarRuleForPredicate(predicate);

            for (Pair<Rule, String> ruleSimilarityPair : ruleSimilarityPairList) {
                similarityName = ruleSimilarityPair.getSecond();

                List<Predicate> unifiedRulePredicates = unifyRule(predicate, ruleSimilarityPair.getFirst());
                Predicate unifiedConsequent = unifyPredicate(ruleSimilarityPair.getFirst().getConsequent(), predicate);

                TreeNode unifiedNode = null;
                if (!unifiedRulePredicates.isEmpty()) {
                    unifiedNode = new TreeNode(TreeNode.AND_TYPE, currentNode, unifiedConsequent);
                    unifiedNode.setSimilarityName(similarityName);
                    currentNode.addChild(unifiedNode);
                    currentNode.setType(TreeNode.OR_TYPE);

                    usedPredicate.add(unifyPredicate(ruleSimilarityPair.getFirst().getConsequent(), predicate));
                }

                for (Predicate nextPredicate : unifiedRulePredicates) {
                    TreeNode nextNode = new TreeNode(TreeNode.OR_TYPE, unifiedNode, nextPredicate);
                    nextNode.setSimilarityName(similarityName);

                    unifiedNode.addChild(nextNode);
                    unifiedNode.setType(TreeNode.AND_TYPE);

                    solveRec(nextNode, nextPredicate, similarityName, deep + 1, usedPredicate);
                    usedPredicate.remove(unifiedConsequent);
                }
            }
        }

        usedPredicate.remove(predicate);
        return currentNode;
    }

    /**
     * Method for the rule unification.
     *
     * @param predicate predicate for the which it unified.
     * @param rule rule to unify
     * @return unified predicate list from the right part of the rule
     */
    private List<Predicate> unifyRule(Predicate predicate, Rule rule) {
        List<Predicate> resultList = new ArrayList<Predicate>();
        Predicate ruleConsequent = rule.getConsequent();

        if (!ruleConsequent.getSign().equals(predicate.getSign())) {
            return resultList;
        }

        UnificationGraph unificationGraph = UnificationGraph.create(predicate, ruleConsequent);
        Unificator unificator = unificationGraph.buildUnificator();

        if (unificator == null) {
            return resultList;
        }

        Predicate ruleConsequentUnification = unificator.getUnificationFor(ruleConsequent);
        Predicate predicateUnification = unificator.getUnificationFor(predicate);

        if (!ruleConsequentUnification.isLogicallyEquivalent(predicateUnification)) {
            return resultList;
        }

        for (Predicate reasonPredicate : rule.getReason()) {
            resultList.add(unificator.getUnificationFor(reasonPredicate));
        }

        return resultList;
    }

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

        return unificator.getUnificationFor(predicateToUnify);
    }
}
