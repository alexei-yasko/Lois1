package lois.lab1.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Svet
 */
public class Rule {

    private Predicate consequent;

    private List<Predicate> reason = new ArrayList<Predicate>();

    public Rule(Predicate consequent, List<Predicate> reason) {
        this.consequent = consequent;
        this.reason.addAll(reason);
    }

    public Predicate getConsequent() {
        return consequent;
    }

    public List<Predicate> getReason() {
        return reason;
    }
}
