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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AtomSign atomSign = (AtomSign) o;

        if (getSign() != null ? !getSign().equals(atomSign.getSign()) : atomSign.getSign() != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return getSign() != null ? getSign().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Constant: " + getSign();
    }
}
