package lois.lab1.inference;

import java.util.ArrayList;
import java.util.List;

import lois.lab1.datastructure.AtomSign;
import lois.lab1.datastructure.Pair;

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

    public List<AtomSign> getUnificationFor(AtomSign sign) {
        List<AtomSign> resultUnification = new ArrayList<AtomSign>();

        for (Pair<AtomSign, AtomSign> element : unificatorElementList) {
            if (element.getFirst().equals(sign)) {
                resultUnification.add(element.getSecond());
            }
        }

        return resultUnification;
    }
}
