package src.org.dnd;

import src.org.dnd.util.Range;

public class Armor {

	private Range defense = new Range(0, 10, Integer.MAX_VALUE);
	
	public int getDefense() {
		return defense.getValue();
	}

}
