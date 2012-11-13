package lois.lab1.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Svet
 */
public class KnowledgeBase {

    /**
     * Set of facts in the knowledge base.
     */
    private List<Predicate> predicateList = new ArrayList<Predicate>();

    private List<SimilarityRelation> similarityRelationList = new ArrayList<SimilarityRelation>();

    private List<Rule> ruleList = new ArrayList<Rule>();

    private static KnowledgeBase knowledgeBase;

    private KnowledgeBase() {
    }

    public static KnowledgeBase getInstance() {
        if (knowledgeBase == null) {
            knowledgeBase = new KnowledgeBase();
        }

        return knowledgeBase;
    }

    public void addPredicate(Predicate predicate) {
        predicateList.add(predicate);
    }

    public void addSimilarityRelation(SimilarityRelation similarityRelation) {
        similarityRelationList.add(similarityRelation);
    }

    public void addRule(Rule rule) {
        ruleList.add(rule);
    }

    public Predicate getPredicateBySign(String sign) {

        for (Predicate predicate : predicateList) {

            if (predicate.getSign().equals(sign)) {
                return predicate;
            }
        }

        return null;
    }

    public List<SimilarityRelation> getSimilarityRelationBySign(String sign) {
        List<SimilarityRelation> resultSimilarityRelationList = new ArrayList<SimilarityRelation>();

        for (SimilarityRelation similarityRelation : similarityRelationList) {

            if (similarityRelation.getSign().equals(sign)) {
                resultSimilarityRelationList.add(similarityRelation);
            }
        }

        return resultSimilarityRelationList;
    }

    /**
     * Return all names of the similarity relation from the knowledge base.
     *
     * @return list of the similarity relation names
     */
    public List<String> getAllNameOfSimilarityRelations() {
        List<String> similarityRelationNameList = new ArrayList<String>();

        for (SimilarityRelation similarityRelation : similarityRelationList) {

            if (!similarityRelationNameList.contains(similarityRelation.getSign())) {
                similarityRelationNameList.add(similarityRelation.getSign());
            }
        }

        return similarityRelationNameList;
    }

    public List<Predicate> getPredicateList() {
        return predicateList;
    }

    public List<Rule> getRuleList() {
        return ruleList;
    }

    public List<SimilarityRelation> getSimilarityRelationList() {
        return similarityRelationList;
    }

    @Override
    public String toString() {
        return "KnowledgeBase{" +
            "predicateList=" + predicateList +
            ", similarityRelationList=" + similarityRelationList +
            ", ruleList=" + ruleList +
            '}';
    }
}
