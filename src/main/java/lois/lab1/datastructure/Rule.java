package lois.lab1.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Rule.
 *
 * @author Svet
 */
public class Rule {

    private Predicate consequent;

    private List<Predicate> reason = new ArrayList<Predicate>();

    public Rule(Predicate consequent, List<Predicate> reason) {
        checkArguments(Arrays.asList(consequent));
        checkArguments(reason);

        this.consequent = consequent;
        this.reason.addAll(reason);
    }

    public Predicate getConsequent() {
        return consequent;
    }

    public List<Predicate> getReason() {
        return reason;
    }

    private void checkArguments(List<Predicate> arguments) {

        for (Predicate predicate : arguments) {

            if (predicate.getType() != AtomSignType.PREDICATE) {
                throw new IllegalStateException("Bad arguments for the rule! Arguments must be the PREDICATE type.");
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Rule rule = (Rule) o;

        if (consequent != null ? !consequent.equals(rule.consequent) : rule.consequent != null) {
            return false;
        }
        if (reason != null ? !reason.equals(rule.reason) : rule.reason != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = consequent != null ? consequent.hashCode() : 0;
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Rule{" +
            "consequent=" + consequent +
            ", reason=" + reason +
            '}';
    }
}
