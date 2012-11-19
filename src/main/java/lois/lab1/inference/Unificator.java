package lois.lab1.inference;

import java.util.ArrayList;
import java.util.List;

import lois.lab1.datastructure.AtomSign;
import lois.lab1.datastructure.AtomSignType;
import lois.lab1.datastructure.Pair;
import lois.lab1.datastructure.Predicate;

/**
 * Class that present unificator.
 *
 * @author Q-YAA
 */
public class Unificator {

    private List<Pair<AtomSign, AtomSign>> unificatorElementList = new ArrayList<Pair<AtomSign, AtomSign>>();

    public Unificator() {
    }

    public Unificator(List<Pair<AtomSign, AtomSign>> unificatorElementList) {
        this.unificatorElementList = unificatorElementList;
    }

    /**
     * Adds elemnt to the unificator.
     *
     * @param element element to add
     */
    public void addElement(Pair<AtomSign, AtomSign> element) {
        if (!unificatorElementList.contains(element)) {
            unificatorElementList.add(element);
        }
    }

    /**
     * Finds unification for the given sing.
     *
     * @param sign sign to find unification
     * @return unification for the sign
     */
    public AtomSign getUnificationFor(AtomSign sign) {
        AtomSign unificationResult = findUnificationForAtomSignWithType(sign, AtomSignType.CONST);

        if (unificationResult == null) {
            unificationResult = findUnificationForAtomSignWithType(sign, AtomSignType.VAR);
        }

        return unificationResult;
    }

    /**
     * Finds unification for the predicate.
     *
     * @param predicate predicate to find unification
     * @return unification for the predicate
     */
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

    /**
     * Check if it unificator valid.
     *
     * @return true - if unificator valid, false - if unificator invalid.
     */
    public boolean isValid() {
        boolean isValid = true;

        for (Pair<AtomSign, AtomSign> element : unificatorElementList) {

            if (element.getFirst().getType() == AtomSignType.CONST
                && element.getSecond().getType() == AtomSignType.CONST
                && !element.getFirst().equals(element.getSecond())) {

                isValid = false;
            }
        }

        for (Pair<AtomSign, AtomSign> element : unificatorElementList) {

            if (element.getFirst().getType() == AtomSignType.VAR
                && !isVariableHasOneConstantUnification(element.getFirst())) {

                isValid = false;
            }

            if (element.getSecond().getType() == AtomSignType.VAR
                && !isVariableHasOneConstantUnification(element.getSecond())) {

                isValid = false;
            }
        }

        return isValid;
    }

    private AtomSign findUnificationForAtomSignWithType(AtomSign atomSign, AtomSignType type) {
        AtomSign unification = null;

        for (Pair<AtomSign, AtomSign> element : unificatorElementList) {

            if (element.getFirst().equals(atomSign) && element.getSecond().getType() == type) {
                unification = element.getSecond();
            }
            else if (element.getSecond().equals(atomSign) && element.getFirst().getType() == type) {
                unification = element.getFirst();
            }
        }

        return unification;
    }

    private boolean isVariableHasOneConstantUnification(AtomSign variable) {
        List<AtomSign> constantList = new ArrayList<AtomSign>();

        for (Pair<AtomSign, AtomSign> element : unificatorElementList) {

            if (element.getFirst().equals(variable) && element.getSecond().getType() == AtomSignType.CONST) {
                if (!constantList.contains(element.getSecond())) {
                    constantList.add(element.getSecond());
                }
            }

            if (element.getSecond().equals(variable) && element.getFirst().getType() == AtomSignType.CONST) {
                if (!constantList.contains(element.getFirst())) {
                    constantList.add(element.getFirst());
                }
            }
        }

        return constantList.size() < 2;
    }
}
