package lois.lab1.datastructure;

import java.util.Arrays;

/**
 * Similarity relation.
 *
 * @author Svet
 */
public class SimilarityRelation extends Predicate {

    public SimilarityRelation(String sign, AtomSign first, AtomSign second) {
        super(sign, Arrays.asList(first, second));
    }

    @Override
    public AtomSignType getType() {
        return AtomSignType.SIMILARITY;
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
            || getArgumentList() != null ? !getArgumentList().equals(predicate.getArgumentList())
            : predicate.getArgumentList() != null) {

            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return (getArgumentList() != null ? getArgumentList().hashCode() : 0) + getSign().hashCode();
    }

    @Override
    public String toString() {
        return "SimilarityRelation{" +
            "sign=" + getSign() + ";" +
            "arguments=" + getArgumentList() +
            '}';
    }
}
