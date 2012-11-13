package lois.lab1.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Q-YAA
 */
public class ValueTable {

    private List<List<AtomSign>> valueTable = new ArrayList<List<AtomSign>>();

    public ValueTable(){
    }

    public void addTableRow(List<AtomSign> row) {
        valueTable.add(row);
    }

    public List<List<AtomSign>> getValueTable() {
        return valueTable;
    }

    public void setValueTable(List<List<AtomSign>> valueTable) {
        this.valueTable = valueTable;
    }

    @Override
    public String toString() {
        return "ValueTable" + valueTable;
    }
}
