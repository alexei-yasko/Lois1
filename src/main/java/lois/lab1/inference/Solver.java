package lois.lab1.inference;

import java.util.ArrayList;
import java.util.List;

import lois.lab1.datastructure.AtomSign;
import lois.lab1.datastructure.AtomSignType;
import lois.lab1.datastructure.Constant;
import lois.lab1.datastructure.Goal;
import lois.lab1.datastructure.KnowledgeBase;
import lois.lab1.datastructure.Predicate;
import lois.lab1.datastructure.Rule;
import lois.lab1.datastructure.SimilarityRelation;
import lois.lab1.datastructure.Variable;

/**
 * @author Q-YAA
 */
public class Solver {

    private KnowledgeBase knowledgeBase;

    public Solver(KnowledgeBase knowledgeBase) {
        this.knowledgeBase = knowledgeBase;
    }

    public void solve(Goal goal) {

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

        if (ruleConsequent.getSign().equals(predicate.getSign())) {
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

        return new Predicate(predicate.getSign(), newArgumentList);
    }

    /**
     * Find all similar predicates from all similar relation.
     *
     * @param predicate predicate to find similar
     * @return list of the similar predicates
     */
    private List<Predicate> findAllSimilarPredicates(Predicate predicate) {

        List<Predicate> similarPredicates = new ArrayList<Predicate>();

        for (SimilarityRelation similarityRelation : knowledgeBase.getSimilarityRelationList()) {

            if (isSimilarExist(predicate, similarityRelation.getSign())) {
                similarPredicates.add(createSimilarPredicate(predicate, similarityRelation.getSign()));
            }
        }

        return similarPredicates;
    }
}
