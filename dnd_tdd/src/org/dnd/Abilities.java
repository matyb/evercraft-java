package org.dnd;

import org.dnd.util.Range;

public class Abilities {

	private Range strength, dexterity, constitution, wisdom, intelligence, charisma;

	public Abilities(int defaultValue){
		strength = new Range(0, defaultValue, Integer.MAX_VALUE);
		dexterity = new Range(0, defaultValue, Integer.MAX_VALUE); 
		constitution = new Range(0, defaultValue, Integer.MAX_VALUE);
		wisdom = new Range(0, defaultValue, Integer.MAX_VALUE);
		intelligence = new Range(0, defaultValue, Integer.MAX_VALUE);
		charisma = new Range(0, defaultValue, Integer.MAX_VALUE);
	}
	
	public int getStrength() {
		return strength.getValue();
	}

	public void setStrength(int strength) {
		this.strength.setValue(strength);
	}

	public int getDexterity() {
		return dexterity.getValue();
	}

	public void setDexterity(int dexterity) {
		this.dexterity.setValue(dexterity);
	}

	public int getConstitution() {
		return constitution.getValue();
	}

	public void setConstitution(int constitution) {
		this.constitution.setValue(constitution);
	}

	public int getWisdom() {
		return wisdom.getValue();
	}

	public void setWisdom(int wisdom) {
		this.wisdom.setValue(wisdom);
	}

	public int getIntelligence() {
		return intelligence.getValue();
	}

	public void setIntelligence(int intelligence) {
		this.intelligence.setValue(intelligence);
	}

	public int getCharisma() {
		return charisma.getValue();
	}

	public void setCharisma(int charisma) {
		this.charisma.setValue(charisma);
	}

	public int getModifier(int value) {
		int minusTen = value - 10;
		if(minusTen != 1){
			minusTen += minusTen < 0 ? -1 : 1;
		}
		return (minusTen) / 2;
	}

}
