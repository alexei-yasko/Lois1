package lois.lab1.inference;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import lois.lab1.datastructure.AtomSign;
import lois.lab1.datastructure.Constant;
import lois.lab1.datastructure.Pair;
import lois.lab1.datastructure.Predicate;
import lois.lab1.datastructure.Variable;

import static org.hamcrest.core.Is.is;

/**
 * @author Q-YAA
 */
public class UnificatorTest {

    @Test
    public void testUnificatorFromIvashSample() {
        Predicate predicate1 = new Predicate("P", Arrays.asList(
            new Variable("X"), new Constant("c"), new Constant("a")
        ));

        Predicate predicate2 = new Predicate("K", Arrays.asList(
            new Variable("V"), new Variable("V"), new Constant("a")
        ));

        List<Pair<AtomSign, AtomSign>> unificatorElementList = Arrays.asList(
            new Pair<AtomSign, AtomSign>(new Variable("X"), new Constant("c")),
            new Pair<AtomSign, AtomSign>(new Variable("V"), new Constant("c")),
            new Pair<AtomSign, AtomSign>(new Constant("c"), new Constant("c")),
            new Pair<AtomSign, AtomSign>(new Constant("a"), new Constant("a"))
        );

        Unificator unificator = new Unificator(unificatorElementList);

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
    public void testUnificationComplex() {
        Predicate predicate1 = new Predicate("P", Arrays.asList(
            new Constant("a"), new Variable("B"), new Variable("C"), new Constant("g"), new Variable("X"),
            new Variable("Y"), new Constant("z"), new Variable("F")
        ));

        Predicate predicate2 = new Predicate("K", Arrays.asList(
            new Variable("V"), new Variable("C"), new Constant("g"), new Constant("g"), new Variable("P"),
            new Variable("V"), new Constant("z")
        ));

        List<Pair<AtomSign, AtomSign>> unificatorElementList = Arrays.asList(
            new Pair<AtomSign, AtomSign>(new Constant("a"), new Variable("V")),
            new Pair<AtomSign, AtomSign>(new Variable("B"), new Constant("g")),
            new Pair<AtomSign, AtomSign>(new Variable("C"), new Constant("g")),
            new Pair<AtomSign, AtomSign>(new Constant("g"), new Constant("g")),
            new Pair<AtomSign, AtomSign>(new Variable("X"), new Variable("P")),
            new Pair<AtomSign, AtomSign>(new Variable("Y"), new Constant("a")),
            new Pair<AtomSign, AtomSign>(new Constant("Y"), new Constant("a")),
            new Pair<AtomSign, AtomSign>(new Constant("a"), new Constant("a"))
        );

        Unificator unificator = new Unificator(unificatorElementList);

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
}
