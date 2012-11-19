package lois.lab1.datastructure;

/**
 * Atom sign. General class for each logical element.
 *
 * @author Svet
 */
public abstract class AtomSign {

	private String sign;

	public abstract AtomSignType getType();

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AtomSign)) {
            return false;
        }

        AtomSign sign1 = (AtomSign) o;

        if (sign != null ? !sign.equals(sign1.sign) : sign1.sign != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return sign != null ? sign.hashCode() : 0;
    }
}
