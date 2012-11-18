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

    public RelationTable(List<AtomSign> schema, List<List<AtomSign>> rowList) {
        addRowList(schema, rowList);
    }

    public RelationTable(List<AtomSign> schema) {
        for (AtomSign title : schema) {
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

                Pair<List<AtomSign>, List<AtomSign>> newRowWithTitles =
                    joinRow(getTitleList(), firstRow, that.getTitleList(), secondRow);

                if (newRowWithTitles != null) {
                    resultTable.addRow(newRowWithTitles.getFirst(), newRowWithTitles.getSecond());
                }
            }
        }

        return resultTable;
    }

    public RelationTable projectTo(List<AtomSign> schema) {
        RelationTable resultRelationTable = new RelationTable(schema);

        for (AtomSign title : schema) {
            RelationTableColumn column = getColumnByTitle(title);

            if (column != null) {
                resultRelationTable.addColumnValueList(title, column.getColumnValueList());
            }
        }

        return resultRelationTable;
    }

    public RelationTable union(RelationTable that) {
        RelationTable resultTable = new RelationTable();

        for (RelationTableColumn column : getColumns()) {
            RelationTableColumn sameColumn = that.getColumnByTitle(column.getColumnTitle());
            if (sameColumn == null) {
                resultTable.addColumn(column);
            }
            else {
                List<AtomSign> columnsValues = new ArrayList<AtomSign>(column.getColumnValueList());
                columnsValues.addAll(sameColumn.getColumnValueList());
                resultTable.addColumn(new RelationTableColumn(column.getColumnTitle(), columnsValues));
            }
        }

        for (RelationTableColumn column : that.getColumns()) {
            RelationTableColumn sameColumn = getColumnByTitle(column.getColumnTitle());
            if (sameColumn == null) {
                resultTable.addColumn(column);
            }
        }

        return resultTable;
    }

    public void addRow(List<AtomSign> titles, List<AtomSign> values) {
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

    public void addRowList(List<AtomSign> titles, List<List<AtomSign>> rowList) {

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

    public void addColumnValueList(AtomSign title, List<AtomSign> values) {
        RelationTableColumn column = getColumnByTitle(title);
        column.addColumnValueList(values);
    }

    public List<RelationTableColumn> getColumns() {
        return columns;
    }

    public List<AtomSign> getTitleList() {
        List<AtomSign> titleList = new ArrayList<AtomSign>();

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

    private Pair<List<AtomSign>, List<AtomSign>> joinRow(
        List<AtomSign> titles1, List<AtomSign> values1, List<AtomSign> titles2, List<AtomSign> values2) {

        List<AtomSign> newTitles = new ArrayList<AtomSign>();
        List<AtomSign> newValues = new ArrayList<AtomSign>();

        for (int i = 0; i < titles1.size(); i++) {
            AtomSign title = titles1.get(i);

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

        return new Pair<List<AtomSign>, List<AtomSign>>(newTitles, newValues);
    }

}
