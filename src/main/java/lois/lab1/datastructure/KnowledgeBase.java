package lois.lab1.datastructure;

import java.util.List;

/**
 * @author Svet
 */
public class KnowledgeBase {

    private List<Predicat> predicatList;

    private List<Similarity> relationList;

    private List<Rule> ruleList;

    private static KnowledgeBase knowledgeBase;

    public static KnowledgeBase getKnowledgeBase() {
        if (knowledgeBase == null) {
            knowledgeBase = new KnowledgeBase();
        }

        return knowledgeBase;
    }
}
