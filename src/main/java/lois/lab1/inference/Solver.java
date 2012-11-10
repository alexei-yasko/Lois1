package lois.lab1.inference;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lois.lab1.datastructure.AtomSign;
import lois.lab1.datastructure.AtomSignType;
import lois.lab1.datastructure.Constant;
import lois.lab1.datastructure.Goal;
import lois.lab1.datastructure.KnowledgeBase;
import lois.lab1.datastructure.Pair;
import lois.lab1.datastructure.Predicate;
import lois.lab1.datastructure.Rule;
import lois.lab1.datastructure.SimilarityRelation;
import lois.lab1.datastructure.TreeNode;
import lois.lab1.datastructure.Variable;

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
     * Create tree of the logical inference.
     *
     * @param goal inference goal
     */
    public void solve(Goal goal) {

        for (Predicate predicate : goal.getGoalTermList()) {
            TreeNode rootNode = solveRec(new TreeNode(TreeNode.OR_TYPE, null, predicate), predicate, "", 0);
            printInferenceTree(rootNode);
        }
    }

    public TreeNode solveRec(TreeNode currentNode, Predicate predicate, String similarityName, int deep) {

        List<Predicate> contradictionList = findLogicallySamePredicatesFromFacts(predicate);

        for (Predicate contradiction : contradictionList) {
            TreeNode nextNode = new TreeNode(TreeNode.OR_TYPE, currentNode, contradiction);

            nextNode.addValueList(contradiction.getArgumentList());
            nextNode.setSimilarityName(similarityName);

            currentNode.addChild(nextNode);
            currentNode.setType(TreeNode.AND_TYPE);
        }

        for (Rule rule : knowledgeBase.getRuleList()) {

            List<Predicate> unificatedRulePredicates = unifyRule(predicate, rule);

            TreeNode unifiedNode = null;

            if (!unificatedRulePredicates.isEmpty()) {
                unifiedNode = new TreeNode(TreeNode.AND_TYPE, currentNode, unifyPredicate(rule.getConsequent(), predicate));

                currentNode.addChild(unifiedNode);
                currentNode.setType(TreeNode.OR_TYPE);
            }

            for (Predicate nextPredicate : unificatedRulePredicates) {
                TreeNode nextNode = new TreeNode(TreeNode.OR_TYPE, unifiedNode, nextPredicate);
                nextNode.setSimilarityName(similarityName);

                unifiedNode.addChild(nextNode);
                unifiedNode.setType(TreeNode.AND_TYPE);

                solveRec(nextNode, nextPredicate, similarityName, deep + 1);
            }
        }

        if (similarityName.equals("")) {

            List<Pair<Predicate, String>> similarPredicateList = findAllSimilarPredicates(predicate);

            for (Pair<Predicate, String> similarPredicate : similarPredicateList) {
                TreeNode similarNode = new TreeNode(TreeNode.OR_TYPE, currentNode, similarPredicate.getFirst());
                similarNode.setSimilarityName(similarPredicate.getSecond());

                currentNode.addChild(similarNode);
                currentNode.setType(TreeNode.OR_TYPE);

                solveRec(similarNode, similarPredicate.getFirst(), similarPredicate.getSecond(), deep + 1);
            }
        }

        return currentNode;
    }

    /**
     * Print inference tree.
     *
     * @param rootNode root node of the tree
     */
    public void printInferenceTree(TreeNode rootNode) {
        printInferenceTreeRec(rootNode, 0);
    }

    private void printInferenceTreeRec(TreeNode currentNode, int deep) {
        String levelIntend = "";
        for (int i = 0; i < deep; i++) {
            levelIntend = levelIntend + "\t";
        }

        System.out.println(levelIntend + "^" + currentNode.getNodePredicate());
        System.out.println(levelIntend + "values: " + currentNode.getValueList());
        System.out.println(levelIntend + "similarity relation: " + currentNode.getSimilarityName());
        System.out.println(levelIntend + "node type: " + currentNode.getType());

        for (TreeNode childNode : currentNode.getChildren()) {
            printInferenceTreeRec(childNode, deep + 1);
            System.out.println();
        }
    }

    /**
     * Method that find all possible logically equivalent predicates in knowledge base.
     *
     * <p> For the predicate unification used {@link UnificationGraph} and {@link Unificator} </p>
     *
     * @param predicate predicate to find logically the same predicates
     * @return logically equivalent predicates
     */
    private List<Predicate> findLogicallySamePredicatesFromFacts(Predicate predicate) {
        List<Predicate> resultPredicateList = new ArrayList<Predicate>();

        for (Predicate factPredicate : knowledgeBase.getPredicateList()) {
            UnificationGraph unificationGraph = UnificationGraph.create(factPredicate, predicate);
            Unificator unificator = unificationGraph.buildUnificator();

            if (unificator != null && unificator.getUnificationFor(predicate).isLogicallyEquivalent(factPredicate)) {
                resultPredicateList.add(factPredicate);
            }
        }

        return resultPredicateList;
    }

    /**
     * Method for rule unification.
     *
     * @param predicate predicate for witch the is unified.
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

    private Predicate unifyPredicate(Predicate predicateToUnify, Predicate predicate) {
        UnificationGraph unificationGraph = UnificationGraph.create(predicateToUnify, predicate);
        Unificator unificator = unificationGraph.buildUnificator();

        return unificator.getUnificationFor(predicateToUnify);
    }

    /**
     * Finds atom sign that's similar to the given atom sign (find by the sign).
     *
     * @param atomSign atom sign to find similar
     * @param similarityRelationName name of the similarity relation
     * @return similar atom sign
     */
    private AtomSign findSimilarSign(AtomSign atomSign, String similarityRelationName) {

        for (SimilarityRelation similarityRelation : knowledgeBase.getSimilarityRelationList()) {

            if (similarityRelation.getArgumentList().get(0).getSign().equals(atomSign.getSign())) {
                return similarityRelation.getArgumentList().get(1);
            }
            else if (similarityRelation.getArgumentList().get(1).getSign().equals(atomSign.getSign())) {
                return similarityRelation.getArgumentList().get(0);
            }
        }

        return null;
    }

    /**
     * Determines if the similar predicate exist in knowledge base.
     *
     * @param predicate predicate to check similar
     * @param similarityRelationName name of similarity relation
     * @return true - if similar exist, false - in the other case.
     */
    private boolean isSimilarExist(Predicate predicate, String similarityRelationName) {

        boolean isSimilarExist = findSimilarSign(predicate, similarityRelationName) != null;

        for (AtomSign argument : predicate.getArgumentList()) {
            AtomSign similar = findSimilarSign(argument, similarityRelationName);

            if (argument.getType() == AtomSignType.CONST && similar == null) {
                isSimilarExist = false;
                break;
            }
        }

        return isSimilarExist;
    }

    /**
     * Create predicate that similar to the given predicate.
     *
     * <p> If similar predicate doesn't exist returns null. </p>
     *
     * @param predicate predicate to find similar
     * @param similarityRelationName name of similarity relation
     * @return similar predicate or null
     */
    private Predicate createSimilarPredicate(Predicate predicate, String similarityRelationName) {

        if (!isSimilarExist(predicate, similarityRelationName)) {
            return null;
        }

        List<AtomSign> newArgumentList = new ArrayList<AtomSign>();

        for (AtomSign argument : predicate.getArgumentList()) {

            if (argument.getType() == AtomSignType.CONST) {
                newArgumentList.add(new Constant(findSimilarSign(argument, similarityRelationName).getSign()));
            }
            else if (argument.getType() == AtomSignType.VAR) {
                newArgumentList.add(new Variable(argument.getSign()));
            }
        }

        return new Predicate(findSimilarSign(predicate, similarityRelationName).getSign(), newArgumentList);
    }

    /**
     * Find all similar predicates from all similar relation.
     *
     * @param predicate predicate to find similar
     * @return list of the similar predicates with them name of the similar relations
     */
    private List<Pair<Predicate, String>> findAllSimilarPredicates(Predicate predicate) {

        Set<Pair<Predicate, String>> similarPredicates = new HashSet<Pair<Predicate, java.lang.String>>();

        for (SimilarityRelation similarityRelation : knowledgeBase.getSimilarityRelationList()) {

            if (isSimilarExist(predicate, similarityRelation.getSign())) {
                Predicate similarPredicate = createSimilarPredicate(predicate, similarityRelation.getSign());
                similarPredicates.add(new Pair<Predicate, String>(similarPredicate, similarityRelation.getSign()));
            }
        }

        return new ArrayList<Pair<Predicate, String>>(similarPredicates);
    }
}
