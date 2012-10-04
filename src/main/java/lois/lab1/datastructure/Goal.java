package lois.lab1.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Svet
 */
public class Goal {

    private List<Predicate> goalTermList = new ArrayList<Predicate>();

    public Goal(List<Predicate> goalTermList) {
        this.goalTermList.addAll(goalTermList);
    }

    public List<Predicate> getGoalTermList() {
        return goalTermList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Goal goal = (Goal) o;

        if (goalTermList != null ? !goalTermList.equals(goal.goalTermList) : goal.goalTermList != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return goalTermList != null ? goalTermList.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Goal{" +
            "goalTermList=" + goalTermList +
            '}';
    }
}
