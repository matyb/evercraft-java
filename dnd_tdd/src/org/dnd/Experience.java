package org.dnd;

import org.dnd.util.Range;

public class Experience {

	private Range currentExperience = new Range(0, 0, 1000);
	private Range totalExperience   = new Range(0, 0, Integer.MAX_VALUE);
	
	public Experience(int experience){
		this.currentExperience.setValue(experience);
		this.totalExperience.setValue(experience);
	}
	
	public int getCurrentExperience() {
		return currentExperience.getValue();
	}
	
	public void setCurrentExperience(int value) {
		currentExperience.setValue(value % 1000);
		totalExperience.setValue(totalExperience.getValue() + value);
	}

	public int getTotalExperience() {
		return totalExperience.getValue();
	}
}
