package org.dnd.character;

import org.dnd.util.Range;

public class Experience {

	private final int XP_IN_LEVEL = 1000;
	private Range totalExperience = new Range(0, 0, Integer.MAX_VALUE);
	
	public Experience(int experience){
		this.totalExperience.setValue(experience);
	}
	
	public int getCurrentExperience() {
		return totalExperience.getValue() % XP_IN_LEVEL;
	}
	
	public void addToExperience(int value) {
		totalExperience.add(value);
	}

	public int getTotalExperience() {
		return totalExperience.getValue();
	}
	
	public int getLevel(){
		return totalExperience.getValue() / XP_IN_LEVEL + 1;
	}
}
