package lois.lab1.inference;

import java.util.ArrayList;
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
}
