package lois.lab1.datastructure;

/**
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
}
