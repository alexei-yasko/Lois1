package lois.lab1.inference;

import java.util.ArrayList;
import java.util.List;

import lois.lab1.datastructure.AtomSign;
import lois.lab1.datastructure.AtomSignType;
import lois.lab1.datastructure.Pair;
import lois.lab1.datastructure.Predicate;

/**
 * @author Q-YAA
 */
public class Unificator {

    private List<Pair<AtomSign, AtomSign>> unificatorElementList = new ArrayList<Pair<AtomSign, AtomSign>>();

    public Unificator() {
    }

    public Unificator(List<Pair<AtomSign, AtomSign>> unificatorElementList) {
        this.unificatorElementList = unificatorElementList;
    }

    public void addElement(Pair<AtomSign, AtomSign> element) {
        unificatorElementList.add(element);
    }

    public AtomSign getUnificationFor(AtomSign sign) {
        AtomSign unificationResult = findUnificationForAtomSignWithType(sign, AtomSignType.CONST);

        if (unificationResult == null) {
            unificationResult = findUnificationForAtomSignWithType(sign, AtomSignType.VAR);
        }

        return unificationResult;
    }

    public Predicate getUnificationFor(Predicate predicate) {
        List<AtomSign> unifitedPredicateArgList = new ArrayList<AtomSign>();

        for (AtomSign atomSign : predicate.getArgumentList()) {
            AtomSign unificatedArgument = getUnificationFor(atomSign);

            if (unificatedArgument == null) {
                unificatedArgument = atomSign;
            }

            unifitedPredicateArgList.add(unificatedArgument);
        }

        return new Predicate(predicate.getSign(), unifitedPredicateArgList);
    }

    private AtomSign findUnificationForAtomSignWithType(AtomSign atomSign, AtomSignType type) {
        AtomSign constUnification = null;

        for (Pair<AtomSign, AtomSign> element : unificatorElementList) {

            if (element.getFirst().equals(atomSign) && element.getSecond().getType() == type) {
                constUnification = element.getSecond();
            }
            else if (element.getSecond().equals(atomSign) && element.getFirst().getType() == type) {
                constUnification = element.getFirst();
            }
        }

        return constUnification;
    }
}
