package lois.lab1.datastructure;

import java.util.Arrays;

/**
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
}
