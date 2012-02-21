package org.dnd;

import org.dnd.util.Range;

public class QuestCharacter {

	private String name;
	private Range hitPoints;
	private Armor armor;
	private Alignment alignment;
	private Abilities abilities;

	public QuestCharacter(){
		this("");
	};
	
	public QuestCharacter(String name) {
		this.setName(name);
		this.setArmor(new Armor());
		this.alignment = new Alignment(0);
		this.hitPoints = new Range(0, 5, Integer.MAX_VALUE);
		this.abilities = new Abilities(10);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public long getAlignment() {
		return alignment.getAlignment();
	}

	public void setAlignment(int alignment) {
		this.alignment.setAlignment(alignment);
	}

	public boolean isNuetral() {
		return alignment.isNeutral();
	}

	public boolean isEvil() {
		return alignment.isEvil();
	}

	public boolean isGood() {
		return alignment.isGood();
	}

	public boolean attack(int roll, QuestCharacter questCharacter) {
		if(doesAttackSucceed(getModifiedRoll(roll), questCharacter)){
			questCharacter.decrementHP(1);
			if(getModifiedRoll(roll) == 20) {
				questCharacter.decrementHP(1);
			}
			return true;
		}
		return false;
	}

	private boolean doesAttackSucceed(int roll, QuestCharacter questCharacter) {
		return getModifiedRoll(roll) >= questCharacter.getArmor().getDefense();
	}

	private int getModifiedRoll(int roll) {
		return roll + abilities.getModifier(abilities.getStrength());
	}

	private void decrementHP(int i) {
		hitPoints.setValue(hitPoints.getValue() - 1);
	}

	public Armor getArmor() {
		return armor;
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}

	public void setHP(int hitPoints) {
		this.hitPoints.setValue(hitPoints);
	}

	public int getHP() {
		return hitPoints.getValue();
	}
	
	public boolean isDead() {
		return getHP() <= 0;
	}

	public int getStrength() {
		return abilities.getStrength();
	}

	public int getDexterity() {
		return abilities.getDexterity();
	}

	public int getConstitution() {
		return abilities.getConstitution();
	}

	public int getWisdom() {
		return abilities.getWisdom();
	}

	public int getIntelligence() {
		return abilities.getIntelligence();
	}

	public int getCharisma() {
		return abilities.getCharisma();
	}
	
}
