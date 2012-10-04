package lois.lab1.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Svet
 */
public class Predicate extends AtomSign {

	private List<AtomSign> arguments = new ArrayList<AtomSign>();

    public Predicate(String sign, List<AtomSign> arguments) {
        setSign(sign);
        this.arguments.addAll(arguments);
    }

	@Override
	public AtomSignType getType() {
		return AtomSignType.PREDICATE;
	}

    public void addArgument(AtomSign sign) {
        arguments.add(sign);
    }

    public void addArgumentList(List<AtomSign> signList) {
        arguments.addAll(signList);
    }

    public List<AtomSign> getArgumentList() {
        return arguments;
    }
}