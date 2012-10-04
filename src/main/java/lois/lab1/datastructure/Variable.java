package lois.lab1.datastructure;

/**
 * @author Svet
 */
public class Variable extends AtomSign {

    public Variable(String sign) {
        setSign(sign);
    }

	@Override
	public AtomSignType getType() {
		return AtomSignType.VAR;
	}
}
