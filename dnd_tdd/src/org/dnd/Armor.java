package org.dnd;

import org.dnd.util.Range;

public class Armor {

	private Range defense = new Range(0, 10, Integer.MAX_VALUE);
	
	public int getDefense() {
		return defense.getValue();
	}

	public void setDefense(int defense) {
		this.defense.setValue(defense);
	}
}
