package src.org.dnd;

import src.org.dnd.util.Range;

public class Abilities {

	private Range strength, dexterity, constitution, wisdom, intelligence, charisma;

	public static int MINIMUM_ABILITY_VALUE = 1;
	public static int MAXIMUM_ABILITY_VALUE = 20;
	
	public Abilities(int defaultValue){
		strength = createAbility(defaultValue);
		dexterity = createAbility(defaultValue); 
		constitution = createAbility(defaultValue);
		wisdom = createAbility(defaultValue);
		intelligence = createAbility(defaultValue);
		charisma = createAbility(defaultValue);
	}

	protected Range createAbility(int defaultValue) {
		return new Range(MINIMUM_ABILITY_VALUE, defaultValue, MAXIMUM_ABILITY_VALUE);
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
		return value/2 - 5;
	}

}
