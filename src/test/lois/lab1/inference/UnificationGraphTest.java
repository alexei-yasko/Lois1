package lois.lab1.inference;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import lois.lab1.datastructure.AtomSign;
import lois.lab1.datastructure.Constant;
import lois.lab1.datastructure.Predicate;
import lois.lab1.datastructure.Variable;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;

/**
 * @author Q-YAA
 */
public class UnificationGraphTest {

    @Test
    public void testUnificationGraphIvashSample() {

        Predicate predicate1 = new Predicate("P", Arrays.asList(
            new Variable("X"), new Constant("c"), new Constant("a")
        ));

        Predicate predicate2 = new Predicate("K", Arrays.asList(
            new Variable("V"), new Variable("V"), new Constant("a")
        ));

        UnificationGraph unificationGraph = UnificationGraph.create(predicate1, predicate2);
        Unificator unificator = unificationGraph.buildUnificator();

        Predicate unificatedPredicate1 = unificator.getUnificationFor(predicate1);
        Predicate unificatedPredicate2 = unificator.getUnificationFor(predicate2);

        Assert.assertThat(unificatedPredicate1.getArgumentList().get(0), is((AtomSign) new Constant("c")));
        Assert.assertThat(unificatedPredicate1.getArgumentList().get(1), is((AtomSign) new Constant("c")));
        Assert.assertThat(unificatedPredicate1.getArgumentList().get(2), is((AtomSign) new Constant("a")));

        Assert.assertThat(unificatedPredicate2.getArgumentList().get(0), is((AtomSign) new Constant("c")));
        Assert.assertThat(unificatedPredicate2.getArgumentList().get(1), is((AtomSign) new Constant("c")));
        Assert.assertThat(unificatedPredicate2.getArgumentList().get(2), is((AtomSign) new Constant("a")));
    }

    @Test
    public void testUnificationGraphComplexSample() {

        Predicate predicate1 = new Predicate("P", Arrays.asList(
            new Constant("a"), new Variable("B"), new Variable("C"), new Constant("g"), new Variable("X"),
            new Variable("Y"), new Constant("z"), new Variable("F")
        ));

        Predicate predicate2 = new Predicate("K", Arrays.asList(
            new Variable("V"), new Variable("C"), new Constant("g"), new Constant("g"), new Variable("P"),
            new Variable("V"), new Constant("z")
        ));

        UnificationGraph unificationGraph = UnificationGraph.create(predicate1, predicate2);
        Unificator unificator = unificationGraph.buildUnificator();

        Predicate unificatedPredicate1 = unificator.getUnificationFor(predicate1);
        Predicate unificatedPredicate2 = unificator.getUnificationFor(predicate2);

        Assert.assertThat(unificatedPredicate1.getArgumentList().get(0), is((AtomSign) new Constant("a")));
        Assert.assertThat(unificatedPredicate1.getArgumentList().get(1), is((AtomSign) new Constant("g")));
        Assert.assertThat(unificatedPredicate1.getArgumentList().get(2), is((AtomSign) new Constant("g")));
        Assert.assertThat(unificatedPredicate1.getArgumentList().get(3), is((AtomSign) new Constant("g")));
        Assert.assertThat(unificatedPredicate1.getArgumentList().get(4), is((AtomSign) new Variable("P")));
        Assert.assertThat(unificatedPredicate1.getArgumentList().get(5), is((AtomSign) new Constant("a")));
        Assert.assertThat(unificatedPredicate1.getArgumentList().get(6), is((AtomSign) new Constant("z")));
        Assert.assertThat(unificatedPredicate1.getArgumentList().get(7), is((AtomSign) new Variable("F")));

        Assert.assertThat(unificatedPredicate2.getArgumentList().get(0), is((AtomSign) new Constant("a")));
        Assert.assertThat(unificatedPredicate2.getArgumentList().get(1), is((AtomSign) new Constant("g")));
        Assert.assertThat(unificatedPredicate2.getArgumentList().get(2), is((AtomSign) new Constant("g")));
        Assert.assertThat(unificatedPredicate2.getArgumentList().get(3), is((AtomSign) new Constant("g")));
        Assert.assertThat(unificatedPredicate2.getArgumentList().get(4), is((AtomSign) new Variable("X")));
        Assert.assertThat(unificatedPredicate2.getArgumentList().get(5), is((AtomSign) new Constant("a")));
        Assert.assertThat(unificatedPredicate2.getArgumentList().get(6), is((AtomSign) new Constant("z")));
    }

    @Test
    public void testUnificationUnPossibleFirst() {
        Predicate predicate1 = new Predicate("P", Arrays.asList(
            new Constant("z"), new Constant("c"), new Constant("a")
        ));

        Predicate predicate2 = new Predicate("K", Arrays.asList(
            new Variable("V"), new Variable("V"), new Constant("a")
        ));

        UnificationGraph unificationGraph = UnificationGraph.create(predicate1, predicate2);
        Unificator unificator = unificationGraph.buildUnificator();

        Assert.assertThat(unificator, nullValue());
    }

    @Test
    public void testUnificationUnPossibleSecond() {
        Predicate predicate1 = new Predicate("P", Arrays.asList(
            new Variable("V"), new Constant("c"), new Constant("z")
        ));

        Predicate predicate2 = new Predicate("K", Arrays.asList(
            new Variable("V"), new Variable("V"), new Constant("a")
        ));

        UnificationGraph unificationGraph = UnificationGraph.create(predicate1, predicate2);
        Unificator unificator = unificationGraph.buildUnificator();

        Assert.assertThat(unificator, nullValue());
    }
}
