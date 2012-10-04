package lois.lab1.datastructure;

/**
 * @author Svet
 */
public class Similarity extends Predicat {

    public Similarity(String name, AtomSign first, AtomSign second) {
        sign = name;

        arguments.add(first);
        arguments.add(second);
    }

    @Override
    public AtomSignType getType() {
        return AtomSignType.SIMILARITY;
    }
}
