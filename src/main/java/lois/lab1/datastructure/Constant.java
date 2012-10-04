package lois.lab1.datastructure;

/**
 * @author Svet
 */
public class Constant extends AtomSign {

    public Constant(String sign) {
        setSign(sign);
    }

	@Override
	public AtomSignType getType() {
		return AtomSignType.CONST;
	}
}
