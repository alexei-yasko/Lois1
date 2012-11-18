package lois.lab1.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Q-YAA
 */
public class RelationTableColumn {

    private Pair<Variable, List<AtomSign>> column;

    public RelationTableColumn(Variable title) {
        column = new Pair<Variable, List<AtomSign>>(title, new ArrayList<AtomSign>());
    }

    public RelationTableColumn(Variable title, List<AtomSign> values) {
        column = new Pair<Variable, List<AtomSign>>(title, values);
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

    public Variable getColumnTitle() {
        return column.getFirst();
    }

    public void setColumnTitle(Variable title) {
        column = new Pair<Variable, List<AtomSign>>(title, column.getSecond());
    }

    public void addColumnValueList(List<AtomSign> values) {
        column.getSecond().addAll(values);
    }

    public RelationTableColumn join(RelationTableColumn that) {
        if (!this.getColumnTitle().equals(that.getColumnTitle())) {
            throw new IllegalStateException("this and that columns have different title");
        }

        RelationTableColumn resultColumn = new RelationTableColumn(this.getColumnTitle());

        for (AtomSign value : getColumnValueList()) {

            if (that.getColumnValueList().contains(value)) {
                that.getColumnValueList().remove(value);
                resultColumn.addColumnValue(value);
            }
        }

        for (AtomSign value : that.getColumnValueList()) {
            if (this.getColumnValueList().contains(value)) {
                resultColumn.addColumnValue(value);
            }
        }

        return resultColumn;
    }

    @Override
    public String toString() {
        return column.toString();
    }
}
