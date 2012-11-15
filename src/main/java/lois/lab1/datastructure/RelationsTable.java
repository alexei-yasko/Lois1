package lois.lab1.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Q-YAA
 */
public class RelationsTable {

    private List<RelationTableColumn> columns = new ArrayList<RelationTableColumn>();

    public RelationsTable() {
    }

    public RelationsTable(List<AtomSign> titles, List<List<AtomSign>> rowList) {
        addRowList(titles, rowList);
    }

    public RelationsTable join(RelationsTable that) {
        RelationsTable resultTable = new RelationsTable();

        for (RelationTableColumn column : columns) {
            RelationTableColumn sameColumn = that.getColumnByTitle(column.getColumnTitle());
            if (sameColumn == null) {
                resultTable.addColumn(column);
            }
            else {
                resultTable.addColumn(column.join(sameColumn));
                that.removeColumn(sameColumn.getColumnTitle());
            }
        }

        for (RelationTableColumn column : that.getColumns()) {
            resultTable.addColumn(column);
        }

        return resultTable;
    }

    public RelationsTable union(RelationsTable that) {
        if (columns.size() != that.getColumns().size()) {
            throw new IllegalStateException("not equal column size in the tables!");
        }

        RelationsTable resultTable = new RelationsTable();
        resultTable.addRowList(getTitleList(), getAllRows());
        resultTable.addRowList(getTitleList(), that.getAllRows());

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

        for (int i = 0; i < columns.get(0).getColumnValueList().size(); i++) {
            rowList.add(getRow(i));
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
}
