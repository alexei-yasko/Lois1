package lois.lab1.datastructure;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * @author Q-YAA
 */
public class RelationsTableTest {

    @Test
    public void testJoin() {
        List<AtomSign> titlesList1 = Arrays.<AtomSign>asList(
            new Variable("A"),
            new Variable("B"),
            new Variable("C"),
            new Variable("D"),
            new Variable("E")
        );

        List<List<AtomSign>> valuesList1 = Arrays.asList(
            Arrays.<AtomSign>asList(
                new Constant("g"),
                new Constant("f"),
                new Constant("k"),
                new Constant("h"),
                new Constant("m")
            ),
            Arrays.<AtomSign>asList(
                new Constant("f"),
                new Constant("g"),
                new Constant("h"),
                new Constant("k"),
                new Constant("l")
            ),
            Arrays.<AtomSign>asList(
                new Constant("h"),
                new Constant("j"),
                new Constant("g"),
                new Constant("n"),
                new Constant("t")
            )
        );

        RelationsTable relationsTable1 = new RelationsTable(titlesList1, valuesList1);

        List<AtomSign> titlesList2 = Arrays.<AtomSign>asList(
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

        RelationsTable relationsTable2 = new RelationsTable(titlesList2, valuesList2);

        RelationsTable resultRelationsTable = relationsTable1.join(relationsTable2);

        Assert.assertThat(
            resultRelationsTable.getColumnByTitle(new Variable("A")).getColumnValueList().get(0),
            is((AtomSign) new Constant("g"))
        );
        Assert.assertThat(
            resultRelationsTable.getColumnByTitle(new Variable("A")).getColumnValueList().get(1),
            is((AtomSign) new Constant("f"))
        );
        Assert.assertThat(
            resultRelationsTable.getColumnByTitle(new Variable("A")).getColumnValueList().get(2),
            is((AtomSign) new Constant("h"))
        );

        Assert.assertThat(
            resultRelationsTable.getColumnByTitle(new Variable("B")).getColumnValueList().get(0),
            is((AtomSign) new Constant("f"))
        );

        Assert.assertThat(
            resultRelationsTable.getColumnByTitle(new Variable("C")).getColumnValueList().get(0),
            is((AtomSign) new Constant("k"))
        );
        Assert.assertThat(
            resultRelationsTable.getColumnByTitle(new Variable("C")).getColumnValueList().get(1),
            is((AtomSign) new Constant("h"))
        );
        Assert.assertThat(
            resultRelationsTable.getColumnByTitle(new Variable("C")).getColumnValueList().get(2),
            is((AtomSign) new Constant("g"))
        );

        Assert.assertThat(
            resultRelationsTable.getColumnByTitle(new Variable("D")).getColumnValueList().get(0),
            is((AtomSign) new Constant("k"))
        );
        Assert.assertThat(
            resultRelationsTable.getColumnByTitle(new Variable("D")).getColumnValueList().get(1),
            is((AtomSign) new Constant("n"))
        );

        Assert.assertThat(
            resultRelationsTable.getColumnByTitle(new Variable("E")).getColumnValueList().get(0),
            is((AtomSign) new Constant("t"))
        );

        Assert.assertThat(
            resultRelationsTable.getColumnByTitle(new Variable("K")).getColumnValueList().get(0),
            is((AtomSign) new Constant("k"))
        );
        Assert.assertThat(
            resultRelationsTable.getColumnByTitle(new Variable("K")).getColumnValueList().get(1),
            is((AtomSign) new Constant("h"))
        );
        Assert.assertThat(
            resultRelationsTable.getColumnByTitle(new Variable("K")).getColumnValueList().get(2),
            is((AtomSign) new Constant("g"))
        );
    }

    @Test
    public void testUnion() {
        List<AtomSign> titlesList1 = Arrays.<AtomSign>asList(
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

        RelationsTable relationsTable1 = new RelationsTable(titlesList1, valuesList1);

        List<AtomSign> titlesList2 = Arrays.<AtomSign>asList(
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

        RelationsTable relationsTable2 = new RelationsTable(titlesList2, valuesList2);

        RelationsTable resultRelationsTable = relationsTable1.union(relationsTable2);

        Assert.assertThat(
            resultRelationsTable.getColumnByTitle(new Variable("A")).getColumnValueList().get(0),
            is((AtomSign) new Constant("g"))
        );
        Assert.assertThat(
            resultRelationsTable.getColumnByTitle(new Variable("A")).getColumnValueList().get(1),
            is((AtomSign) new Constant("f"))
        );
        Assert.assertThat(
            resultRelationsTable.getColumnByTitle(new Variable("A")).getColumnValueList().get(2),
            is((AtomSign) new Constant("h"))
        );
        Assert.assertThat(
            resultRelationsTable.getColumnByTitle(new Variable("A")).getColumnValueList().get(3),
            is((AtomSign) new Constant("e"))
        );
        Assert.assertThat(
            resultRelationsTable.getColumnByTitle(new Variable("A")).getColumnValueList().get(4),
            is((AtomSign) new Constant("f"))
        );
        Assert.assertThat(
            resultRelationsTable.getColumnByTitle(new Variable("A")).getColumnValueList().get(5),
            is((AtomSign) new Constant("h"))
        );

        Assert.assertThat(
            resultRelationsTable.getColumnByTitle(new Variable("B")).getColumnValueList().get(0),
            is((AtomSign) new Constant("f"))
        );
        Assert.assertThat(
            resultRelationsTable.getColumnByTitle(new Variable("B")).getColumnValueList().get(1),
            is((AtomSign) new Constant("g"))
        );
        Assert.assertThat(
            resultRelationsTable.getColumnByTitle(new Variable("B")).getColumnValueList().get(2),
            is((AtomSign) new Constant("j"))
        );
        Assert.assertThat(
            resultRelationsTable.getColumnByTitle(new Variable("B")).getColumnValueList().get(3),
            is((AtomSign) new Constant("f"))
        );
        Assert.assertThat(
            resultRelationsTable.getColumnByTitle(new Variable("B")).getColumnValueList().get(4),
            is((AtomSign) new Constant("t"))
        );
        Assert.assertThat(
            resultRelationsTable.getColumnByTitle(new Variable("B")).getColumnValueList().get(5),
            is((AtomSign) new Constant("j"))
        );

        Assert.assertThat(
            resultRelationsTable.getColumnByTitle(new Variable("C")).getColumnValueList().get(0),
            is((AtomSign) new Constant("k"))
        );
        Assert.assertThat(
            resultRelationsTable.getColumnByTitle(new Variable("C")).getColumnValueList().get(1),
            is((AtomSign) new Constant("h"))
        );
        Assert.assertThat(
            resultRelationsTable.getColumnByTitle(new Variable("C")).getColumnValueList().get(2),
            is((AtomSign) new Constant("g"))
        );
        Assert.assertThat(
            resultRelationsTable.getColumnByTitle(new Variable("C")).getColumnValueList().get(3),
            is((AtomSign) new Constant("k"))
        );
        Assert.assertThat(
            resultRelationsTable.getColumnByTitle(new Variable("C")).getColumnValueList().get(4),
            is((AtomSign) new Constant("h"))
        );
        Assert.assertThat(
            resultRelationsTable.getColumnByTitle(new Variable("C")).getColumnValueList().get(5),
            is((AtomSign) new Constant("g"))
        );

        Assert.assertThat(
            resultRelationsTable.getColumnByTitle(new Variable("D")).getColumnValueList().get(0),
            is((AtomSign) new Constant("h"))
        );
        Assert.assertThat(
            resultRelationsTable.getColumnByTitle(new Variable("D")).getColumnValueList().get(1),
            is((AtomSign) new Constant("k"))
        );
        Assert.assertThat(
            resultRelationsTable.getColumnByTitle(new Variable("D")).getColumnValueList().get(2),
            is((AtomSign) new Constant("n"))
        );
        Assert.assertThat(
            resultRelationsTable.getColumnByTitle(new Variable("D")).getColumnValueList().get(3),
            is((AtomSign) new Constant("u"))
        );
        Assert.assertThat(
            resultRelationsTable.getColumnByTitle(new Variable("D")).getColumnValueList().get(4),
            is((AtomSign) new Constant("k"))
        );
        Assert.assertThat(
            resultRelationsTable.getColumnByTitle(new Variable("D")).getColumnValueList().get(5),
            is((AtomSign) new Constant("n"))
        );
    }
}
