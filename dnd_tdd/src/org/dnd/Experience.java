package org.dnd;

import org.dnd.util.Range;

public class Experience {

	private Range experience = new Range(0, 0, Integer.MAX_VALUE);
	
	public Experience(int experience){
		this.experience.setValue(experience);
	}
	
	public int getExperience() {
		return experience.getValue();
	}
}
