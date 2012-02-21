package src.org.dnd;

import src.org.dnd.util.Range;

public class Alignment {

	private Range alignment = new Range(-300, 0, 300);
	
	public Alignment(int alignment){
		this.alignment.setValue(alignment);
	}

	public long getAlignment() {
		return alignment.getValue();
	}

	public void setAlignment(int alignment) {
		this.alignment.setValue(alignment);
	}

	public boolean isNeutral() {
		return alignment.getValue() >= -100 && alignment.getValue() <= 100;
	}
	
	public boolean isEvil() {
		return alignment.getValue() < -100;
	}

	public boolean isGood() {
		return alignment.getValue() > 100;
	}
}
