package lois.lab1.datastructure;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * @author Q-YAA
 */
public class RelationTableTest {

    @Test
    public void testProjectTo() {
        List<Variable> titlesList1 = Arrays.asList(
            new Variable("A"),
            new Variable("B"),
            new Variable("C"),
            new Variable("D")
        );

        List<List<AtomSign>> valuesList1 = Arrays.asList(
            Arrays.<AtomSign>asList(new Constant("g"), new Constant("f"), new Constant("k"), new Constant("h")),
            Arrays.<AtomSign>asList(new Constant("f"), new Constant("f"), new Constant("h"), new Constant("h")),
            Arrays.<AtomSign>asList(new Constant("h"), new Constant("j"), new Constant("g"), new Constant("n"))
        );

        RelationTable relationTable = new RelationTable(titlesList1, valuesList1);

        RelationTable resultRelationTable = relationTable.projectTo(Arrays.asList(new Variable("B"), new Variable("D")));

        Assert.assertThat(resultRelationTable.getTitleList().size(), is(2));
        Assert.assertThat(resultRelationTable.getTitleList().get(0), is((AtomSign) new Variable("B")));
        Assert.assertThat(resultRelationTable.getTitleList().get(1), is((AtomSign) new Variable("D")));
    }

    @Test
    public void testJoin() {
        List<Variable> titlesList1 = Arrays.asList(
            new Variable("A"),
            new Variable("B"),
            new Variable("C"),
            new Variable("D")
        );

        List<List<AtomSign>> valuesList1 = Arrays.asList(
            Arrays.<AtomSign>asList(new Constant("g"), new Constant("f"), new Constant("k"), new Constant("h")),
            Arrays.<AtomSign>asList(new Constant("f"), new Constant("f"), new Constant("h"), new Constant("h")),
            Arrays.<AtomSign>asList(new Constant("h"), new Constant("j"), new Constant("g"), new Constant("n"))
        );

        RelationTable relationTable1 = new RelationTable(titlesList1, valuesList1);

        List<Variable> titlesList2 = Arrays.asList(
            new Variable("B"),
            new Variable("E"),
            new Variable("K"),
            new Variable("D")
        );

        List<List<AtomSign>> valuesList2 = Arrays.asList(
            Arrays.<AtomSign>asList(new Constant("f"), new Constant("f"), new Constant("k"), new Constant("h")),
            Arrays.<AtomSign>asList(new Constant("f"), new Constant("t"), new Constant("h"), new Constant("k")),
            Arrays.<AtomSign>asList(new Constant("f"), new Constant("j"), new Constant("g"), new Constant("h"))
        );

        RelationTable relationTable2 = new RelationTable(titlesList2, valuesList2);

        RelationTable resultRelationTable = relationTable1.join(relationTable2);

        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("A")).getColumnValueList().get(0),
            is((AtomSign) new Constant("g"))
        );
        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("A")).getColumnValueList().get(1),
            is((AtomSign) new Constant("g"))
        );
        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("A")).getColumnValueList().get(2),
            is((AtomSign) new Constant("f"))
        );
        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("A")).getColumnValueList().get(3),
            is((AtomSign) new Constant("f"))
        );

        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("B")).getColumnValueList().get(0),
            is((AtomSign) new Constant("f"))
        );
        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("B")).getColumnValueList().get(1),
            is((AtomSign) new Constant("f"))
        );
        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("B")).getColumnValueList().get(2),
            is((AtomSign) new Constant("f"))
        );
        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("B")).getColumnValueList().get(3),
            is((AtomSign) new Constant("f"))
        );

        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("C")).getColumnValueList().get(0),
            is((AtomSign) new Constant("k"))
        );
        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("C")).getColumnValueList().get(1),
            is((AtomSign) new Constant("k"))
        );
        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("C")).getColumnValueList().get(2),
            is((AtomSign) new Constant("h"))
        );
        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("C")).getColumnValueList().get(3),
            is((AtomSign) new Constant("h"))
        );

        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("D")).getColumnValueList().get(0),
            is((AtomSign) new Constant("h"))
        );
        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("D")).getColumnValueList().get(1),
            is((AtomSign) new Constant("h"))
        );
        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("D")).getColumnValueList().get(2),
            is((AtomSign) new Constant("h"))
        );
        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("D")).getColumnValueList().get(3),
            is((AtomSign) new Constant("h"))
        );

        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("E")).getColumnValueList().get(0),
            is((AtomSign) new Constant("f"))
        );
        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("E")).getColumnValueList().get(1),
            is((AtomSign) new Constant("j"))
        );
        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("E")).getColumnValueList().get(2),
            is((AtomSign) new Constant("f"))
        );
        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("E")).getColumnValueList().get(3),
            is((AtomSign) new Constant("j"))
        );

        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("K")).getColumnValueList().get(0),
            is((AtomSign) new Constant("k"))
        );
        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("K")).getColumnValueList().get(1),
            is((AtomSign) new Constant("g"))
        );
        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("K")).getColumnValueList().get(2),
            is((AtomSign) new Constant("k"))
        );
        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("K")).getColumnValueList().get(3),
            is((AtomSign) new Constant("g"))
        );
    }

    @Test
    public void testUnion() {
        List<Variable> titlesList1 = Arrays.asList(
            new Variable("A"),
            new Variable("B"),
            new Variable("C"),
            new Variable("D")
        );

        List<List<AtomSign>> valuesList1 = Arrays.asList(
            Arrays.<AtomSign>asList(new Constant("g"), new Constant("f"), new Constant("k"), new Constant("h")),
            Arrays.<AtomSign>asList(new Constant("f"), new Constant("g"), new Constant("h"), new Constant("k")),
            Arrays.<AtomSign>asList(new Constant("h"), new Constant("j"), new Constant("g"), new Constant("n"))
        );

        RelationTable relationTable1 = new RelationTable(titlesList1, valuesList1);

        List<Variable> titlesList2 = Arrays.asList(
            new Variable("B"),
            new Variable("E"),
            new Variable("K"),
            new Variable("D")
        );

        List<List<AtomSign>> valuesList2 = Arrays.asList(
            Arrays.<AtomSign>asList(new Constant("e"), new Constant("f"), new Constant("k"), new Constant("u")),
            Arrays.<AtomSign>asList(new Constant("f"), new Constant("t"), new Constant("h"), new Constant("k")),
            Arrays.<AtomSign>asList(new Constant("h"), new Constant("j"), new Constant("g"), new Constant("n"))
        );

        RelationTable relationTable2 = new RelationTable(titlesList2, valuesList2);

        RelationTable resultRelationTable = relationTable1.union(Arrays.asList(
            new Variable("A"), new Variable("B"), new Variable("C"), new Variable("D")
        ), relationTable2);

        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("A")).getColumnValueList().get(0),
            is((AtomSign) new Constant("g"))
        );
        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("A")).getColumnValueList().get(1),
            is((AtomSign) new Constant("f"))
        );
        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("A")).getColumnValueList().get(2),
            is((AtomSign) new Constant("h"))
        );
        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("A")).getColumnValueList().get(3),
            is((AtomSign) new Constant("e"))
        );
        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("A")).getColumnValueList().get(4),
            is((AtomSign) new Constant("f"))
        );
        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("A")).getColumnValueList().get(5),
            is((AtomSign) new Constant("h"))
        );

        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("B")).getColumnValueList().get(0),
            is((AtomSign) new Constant("f"))
        );
        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("B")).getColumnValueList().get(1),
            is((AtomSign) new Constant("g"))
        );
        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("B")).getColumnValueList().get(2),
            is((AtomSign) new Constant("j"))
        );
        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("B")).getColumnValueList().get(3),
            is((AtomSign) new Constant("f"))
        );
        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("B")).getColumnValueList().get(4),
            is((AtomSign) new Constant("t"))
        );
        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("B")).getColumnValueList().get(5),
            is((AtomSign) new Constant("j"))
        );

        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("C")).getColumnValueList().get(0),
            is((AtomSign) new Constant("k"))
        );
        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("C")).getColumnValueList().get(1),
            is((AtomSign) new Constant("h"))
        );
        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("C")).getColumnValueList().get(2),
            is((AtomSign) new Constant("g"))
        );
        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("C")).getColumnValueList().get(3),
            is((AtomSign) new Constant("k"))
        );
        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("C")).getColumnValueList().get(4),
            is((AtomSign) new Constant("h"))
        );
        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("C")).getColumnValueList().get(5),
            is((AtomSign) new Constant("g"))
        );

        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("D")).getColumnValueList().get(0),
            is((AtomSign) new Constant("h"))
        );
        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("D")).getColumnValueList().get(1),
            is((AtomSign) new Constant("k"))
        );
        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("D")).getColumnValueList().get(2),
            is((AtomSign) new Constant("n"))
        );
        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("D")).getColumnValueList().get(3),
            is((AtomSign) new Constant("u"))
        );
        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("D")).getColumnValueList().get(4),
            is((AtomSign) new Constant("k"))
        );
        Assert.assertThat(
            resultRelationTable.getColumnByTitle(new Variable("D")).getColumnValueList().get(5),
            is((AtomSign) new Constant("n"))
        );
    }
}
