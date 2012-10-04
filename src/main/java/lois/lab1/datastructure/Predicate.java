package lois.lab1.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Svet
 */
public class Predicate extends AtomSign {

    private List<AtomSign> arguments = new ArrayList<AtomSign>();

    public Predicate(String sign) {
        setSign(sign);
    }

    public Predicate(String sign, List<? extends AtomSign> arguments) {
        setSign(sign);
        this.arguments.addAll(arguments);
    }

    @Override
    public AtomSignType getType() {
        return AtomSignType.PREDICATE;
    }

    public List<AtomSign> getArgumentList() {
        return arguments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Predicate predicate = (Predicate) o;

        if (!this.getSign().equals(predicate.getSign())
            || arguments != null ? !arguments.equals(predicate.arguments) : predicate.arguments != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return (arguments != null ? arguments.hashCode() : 0) + getSign().hashCode();
    }

    @Override
    public String toString() {
        return "Predicate{" +
            "sign=" + getSign() + ";" +
            "arguments=" + arguments +
            '}';
    }
}