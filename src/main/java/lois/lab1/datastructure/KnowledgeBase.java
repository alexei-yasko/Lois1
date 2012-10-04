package lois.lab1.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Svet
 */
public class KnowledgeBase {

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

    public Predicate getSimilarityRelationBySign(String sign) {

        for (SimilarityRelation similarityRelation : similarityRelationList) {

            if (similarityRelation.getSign().equals(sign)) {
                return similarityRelation;
            }
        }

        return null;
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
