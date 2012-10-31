package lois.lab1.inference;

import java.util.List;

import lois.lab1.datastructure.Goal;
import lois.lab1.datastructure.KnowledgeBase;
import lois.lab1.datastructure.Predicate;

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
     * Method for the predicateToUnify unification.
     *
     * <p> For the predicateToUnify unification use {@link UnificationGraph}</p>
     *
     * @param predicateToUnify predicateToUnify that should be unificated
     * @param predicateList predicateToUnify list for unification
     * @return predicateToUnify list witch are the result of unification
     */
    private List<Predicate> unify(Predicate predicateToUnify, List<Predicate> predicateList) {
        for (Predicate currentPredicate : predicateList) {

            if (predicateToUnify.getSign().equals(currentPredicate.getSign())) {
                UnificationGraph unificationGraph = UnificationGraph.create(predicateToUnify, currentPredicate);
            }
        }

        return null;
    }
}
