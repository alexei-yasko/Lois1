package lois.lab1.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Q-YAA
 */
public class RelationTable {

    private List<RelationTableColumn> columns = new ArrayList<RelationTableColumn>();

    public RelationTable() {
    }

    public RelationTable(List<Variable> schema, List<List<AtomSign>> rowList) {
        addRowList(schema, rowList);
    }

    public RelationTable(List<Variable> schema) {
        for (Variable title : schema) {
            addColumn(new RelationTableColumn(title));
        }
    }

    public boolean isEmpty() {
        for (RelationTableColumn column : columns) {

            if (!column.getColumnValueList().isEmpty()) {
                return false;
            }
        }

        return true;
    }

    public RelationTable join(RelationTable that) {
        RelationTable resultTable = new RelationTable();

        for (List<AtomSign> firstRow : getAllRows()) {

            for (List<AtomSign> secondRow : that.getAllRows()) {

                Pair<List<Variable>, List<AtomSign>> newRowWithTitles =
                    joinRow(getTitleList(), firstRow, that.getTitleList(), secondRow);

                if (newRowWithTitles != null) {
                    resultTable.addRow(newRowWithTitles.getFirst(), newRowWithTitles.getSecond());
                }
            }
        }

        return resultTable;
    }

    public RelationTable projectTo(List<Variable> schema) {
        RelationTable resultRelationTable = new RelationTable(schema);

        for (Variable title : schema) {
            RelationTableColumn column = getColumnByTitle(title);

            if (column != null) {
                resultRelationTable.addColumnValueList(title, column.getColumnValueList());
            }
        }

        return resultRelationTable;
    }

    public RelationTable union(List<Variable> titles, RelationTable that) {
        if (columns.size() != that.getColumns().size()) {
            throw new IllegalStateException("not equal column size in the tables!");
        }

        RelationTable resultTable = new RelationTable(titles);
        resultTable.addRowList(getAllRows());
        resultTable.addRowList(that.getAllRows());

        return resultTable;
    }

    public void addRow(List<Variable> titles, List<AtomSign> values) {
        if (titles.size() != values.size()) {
            throw new IllegalStateException("not equal columns and titles size!");
        }

        for (int i = 0; i < titles.size(); i++) {
            RelationTableColumn column = getColumnByTitle(titles.get(i));

            if (column == null) {
                column = new RelationTableColumn(titles.get(i));
                columns.add(column);
            }

            column.addColumnValue(values.get(i));
        }
    }

    public void addRowList(List<Variable> titles, List<List<AtomSign>> rowList) {

        for (List<AtomSign> row : rowList) {
            addRow(titles, row);
        }
    }

    public void addRow(List<AtomSign> values) {
        if (getTitleList().size() != values.size()) {
            throw new IllegalStateException("not equal columns and titles size!");
        }

        for (int i = 0; i < getTitleList().size(); i++) {
            RelationTableColumn column = getColumns().get(i);
            column.addColumnValue(values.get(i));
        }
    }

    public void addRowList(List<List<AtomSign>> rowList) {

        for (List<AtomSign> row : rowList) {
            addRow(row);
        }
    }

    public List<AtomSign> getRow(int index) {
        if (index >= columns.get(0).getColumnValueList().size()) {
            throw new IllegalStateException("Row with the given index doesn't exist!");
        }

        List<AtomSign> row = new ArrayList<AtomSign>();
        for (RelationTableColumn column : columns) {
            row.add(column.getColumnValue(index));
        }

        return row;
    }

    public List<List<AtomSign>> getAllRows() {
        List<List<AtomSign>> rowList = new ArrayList<List<AtomSign>>();

        if (columns.size() > 0) {

            for (int i = 0; i < columns.get(0).getColumnValueList().size(); i++) {
                rowList.add(getRow(i));
            }
        }

        return rowList;
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

    public void addColumnValueList(Variable title, List<AtomSign> values) {
        RelationTableColumn column = getColumnByTitle(title);
        column.addColumnValueList(values);
    }

    public List<RelationTableColumn> getColumns() {
        return columns;
    }

    public List<Variable> getTitleList() {
        List<Variable> titleList = new ArrayList<Variable>();

        for (RelationTableColumn column : columns) {
            titleList.add(column.getColumnTitle());
        }

        return titleList;
    }

    public void removeColumn(AtomSign title) {
        for (int i = 0; i < columns.size(); i++) {

            if (columns.get(i).getColumnTitle().equals(title)) {
                columns.remove(i);
            }
        }
    }

    @Override
    public String toString() {
        return columns.toString();
    }

    private Pair<List<Variable>, List<AtomSign>> joinRow(
        List<Variable> titles1, List<AtomSign> values1, List<Variable> titles2, List<AtomSign> values2) {

        List<Variable> newTitles = new ArrayList<Variable>();
        List<AtomSign> newValues = new ArrayList<AtomSign>();

        for (int i = 0; i < titles1.size(); i++) {
            Variable title = titles1.get(i);

            AtomSign value;
            if (titles2.contains(title)) {
                int index = titles2.indexOf(title);
                value = values2.get(index);

                values2.remove(index);
                titles2.remove(index);
            }
            else {
                value = values1.get(i);
            }

            if (!value.equals(values1.get(i))) {
                return null;
            }

            newTitles.add(title);
            newValues.add(value);
        }

        for (int i = 0; i < titles2.size(); i++) {
            newTitles.add(titles2.get(i));
            newValues.add(values2.get(i));
        }

        return new Pair<List<Variable>, List<AtomSign>>(newTitles, newValues);
    }

}
