package lois.lab1.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Svet
 */
public class Predicat extends AtomSign {

	protected List<AtomSign> arguments = new ArrayList<AtomSign>();

	@Override
	public AtomSignType getType() {
		return AtomSignType.PREDICAT;
	}
}