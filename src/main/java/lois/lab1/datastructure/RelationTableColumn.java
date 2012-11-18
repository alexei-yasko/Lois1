package lois.lab1.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Q-YAA
 */
public class RelationTableColumn {

    private Pair<AtomSign, List<AtomSign>> column;

    public RelationTableColumn(AtomSign title) {
        column = new Pair<AtomSign,List<AtomSign>>(title, new ArrayList<AtomSign>());
    }

    public RelationTableColumn(AtomSign title, List<AtomSign> values) {
        column = new Pair<AtomSign,List<AtomSign>>(title, values);
    }

    public void addColumnValue(AtomSign value) {
        column.getSecond().add(value);
    }

    public AtomSign getColumnValue(int index) {
        return column.getSecond().get(index);
    }

    public List<AtomSign> getColumnValueList() {
        return column.getSecond();
    }

    public AtomSign getColumnTitle() {
        return column.getFirst();
    }

    public void setColumnTitle(AtomSign title) {
        column = new Pair<AtomSign,List<AtomSign>>(title, column.getSecond());
    }

    public void addColumnValueList(List<AtomSign> values) {
        column.getSecond().addAll(values);
    }

    @Override
    public String toString() {
        return column.toString();
    }
}
