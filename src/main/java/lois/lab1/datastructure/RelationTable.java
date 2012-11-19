package lois.lab1.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * Relation table.
 *
 * @author Q-YAA
 */
public class RelationTable {

    /**
     * List of the columns of the relation table.
     */
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

    /**
     * Creates visual representation of the relation table.
     *
     * @return String visual representation of the relation table
     */
    public String printRelationTable() {
        StringBuilder result = new StringBuilder();

        List<AtomSign> titleList = getTitleList();
        StringBuilder titleString = new StringBuilder();
        StringBuilder separatorString = new StringBuilder();
        for (int i = 0; i < titleList.size(); i++) {
            titleString.append(" ").append(titleList.get(i).getSign()).append(" ");
            separatorString.append("---");
        }
        result.append(titleString).append("\n");
        result.append(separatorString).append("\n");

        for (List<AtomSign> row : getAllRows()) {
            StringBuilder rowString = new StringBuilder();
            for (AtomSign element : row) {
                rowString.append(" ").append(element.getSign()).append(" ");
            }
            result.append(rowString).append("\n");
        }

        return result.toString();
    }

    /**
     * Joins this table with the given relation table.
     *
     * @param that relation table to join with
     * @return result table
     */
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

    /**
     * Project table to the given relation schema.
     *
     * @param schema schema to project
     * @return result relation table
     */
    public RelationTable projectTo(List<AtomSign> schema) {
        RelationTable resultRelationTable = new RelationTable(schema);

        for (AtomSign title : schema) {
            RelationTableColumn column = getColumnByTitle(title);

            if (column != null) {
                resultRelationTable.addColumnValueList(title, column.getColumnValueList());
            }
        }

        return removeRepeatingRow(resultRelationTable);
    }

    /**
     * Unites this table with the given relation table.
     *
     * @param that relation table to unites with
     * @return result table
     */
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

    /**
     * Add row to the relation table.
     *
     * <p> If column for the given title doesn't exist, create it. </p>
     *
     * @param titles list of the values title
     * @param values list of the values to add
     */
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

    /**
     * Add row list to the relation table.
     *
     * @param titles list of the values title
     * @param rowList list of the row
     */
    public void addRowList(List<AtomSign> titles, List<List<AtomSign>> rowList) {

        for (List<AtomSign> row : rowList) {
            addRow(titles, row);
        }
    }

    /**
     * Simply adds value list sequentially to the created rows.
     *
     * @param values values to add
     */
    public void addRow(List<AtomSign> values) {
        if (getTitleList().size() != values.size()) {
            throw new IllegalStateException("not equal columns and titles size!");
        }

        for (int i = 0; i < getTitleList().size(); i++) {
            RelationTableColumn column = getColumns().get(i);
            column.addColumnValue(values.get(i));
        }
    }

    /**
     * Return row with the given index.
     *
     * @param index row index
     * @return found row
     */
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

    /**
     * Return all rows from the relation table.
     *
     * @return list of the rows
     */
    public List<List<AtomSign>> getAllRows() {
        List<List<AtomSign>> rowList = new ArrayList<List<AtomSign>>();

        if (columns.size() > 0) {

            for (int i = 0; i < columns.get(0).getColumnValueList().size(); i++) {
                rowList.add(getRow(i));
            }
        }

        return rowList;
    }

    /**
     * Returns column with the given title from the relation table.
     *
     * @param title title to find column
     * @return found column
     */
    public RelationTableColumn getColumnByTitle(AtomSign title) {
        for (RelationTableColumn column : columns) {

            if (column.getColumnTitle().equals(title)) {
                return column;
            }
        }

        return null;
    }

    /**
     * Add column to the relation table
     *
     * @param column column to add
     */
    public void addColumn(RelationTableColumn column) {
        columns.add(column);
    }

    /**
     * Adds values to the column with the given name.
     *
     * @param title column title
     * @param values value list to add
     */
    public void addColumnValueList(AtomSign title, List<AtomSign> values) {
        RelationTableColumn column = getColumnByTitle(title);
        column.addColumnValueList(values);
    }

    /**
     * Return all columns from the relation table.
     *
     * @return column list
     */
    public List<RelationTableColumn> getColumns() {
        return columns;
    }

    /**
     * Return all column titles of the relation table.
     *
     * @return list of the column titles
     */
    public List<AtomSign> getTitleList() {
        List<AtomSign> titleList = new ArrayList<AtomSign>();

        for (RelationTableColumn column : columns) {
            titleList.add(column.getColumnTitle());
        }

        return titleList;
    }

    @Override
    public String toString() {
        return columns.toString();
    }

    /**
     * Remove repeating row from the relation table.
     *
     * @param relationTable relation table
     * @return result relation table
     */
    private RelationTable removeRepeatingRow(RelationTable relationTable) {
        RelationTable newRelationTable = new RelationTable(relationTable.getTitleList());

        for (List<AtomSign> row : relationTable.getAllRows()) {

            if (!newRelationTable.getAllRows().contains(row)) {
                newRelationTable.addRow(row);
            }
        }

        return newRelationTable;
    }

    /**
     * Join one row with the second row.
     *
     * @param titles1 titles of the first row
     * @param values1 values of the first row
     * @param titles2 titles of the second row
     * @param values2 values of the second row
     * @return result row
     */
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
