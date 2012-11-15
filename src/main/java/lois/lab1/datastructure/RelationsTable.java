package lois.lab1.datastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Q-YAA
 */
public class RelationsTable {

    private List<RelationTableColumn> columns = new ArrayList<RelationTableColumn>();

    public RelationsTable() {
    }

    public RelationsTable(List<AtomSign> titles, List<List<AtomSign>> values) {

        for (int i = 0; i < titles.size(); i++) {
            RelationTableColumn relationTableColumn = new RelationTableColumn(titles.get(i));

            for (List<AtomSign> value : values) {
                relationTableColumn.addColumnValue(value.get(i));
            }

            columns.add(relationTableColumn);
        }
    }

    public void setRowData(List<AtomSign> titles, List<AtomSign> values) {

        for (int i = 0; i < titles.size(); i++) {
            RelationTableColumn column = getColumnByTitle(titles.get(i));

            if (column == null) {
                column = new RelationTableColumn(titles.get(i));
                columns.add(column);
            }

            column.addColumnValue(values.get(i));
        }
    }

    public RelationTableColumn getColumnByTitle(AtomSign title) {
        for (RelationTableColumn column : columns) {

            if (column.getColumnTitle().equals(title)) {
                return column;
            }
        }

        return null;
    }

    public void addColumn(RelationTableColumn column) {
        columns.add(column);
    }

    public void addColumn(Variable variable, List<AtomSign> constantList) {
        columns.add(new RelationTableColumn(variable, constantList));
    }

    public RelationTableColumn getColumn(int index) {
        return columns.get(index);
    }

    public List<RelationTableColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<RelationTableColumn> columns) {
        this.columns = columns;
    }

    @Override
    public String toString() {
        return columns.toString();
    }

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
}
