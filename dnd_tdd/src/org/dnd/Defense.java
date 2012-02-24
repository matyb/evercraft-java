package org.dnd;

import org.dnd.util.Range;

public class Defense {

	private Range armor = new Range(0, 10, Integer.MAX_VALUE);
	private Range fortitude = new Range(0, 10, Integer.MAX_VALUE);
	private Range reflex = new Range(0, 10, Integer.MAX_VALUE);
	private Range will = new Range(0, 10, Integer.MAX_VALUE);
	
	public int getArmor() {
		return armor.getValue();
	}

	public void setArmor(int armor) {
		this.armor.setValue(armor);
	}

	public Range getFortitude() {
		return fortitude;
	}

	public void setFortitude(Range fortitude) {
		this.fortitude = fortitude;
	}

	public Range getReflex() {
		return reflex;
	}

	public void setReflex(Range reflex) {
		this.reflex = reflex;
	}

	public Range getWill() {
		return will;
	}

	public void setWill(Range will) {
		this.will = will;
	}
}
