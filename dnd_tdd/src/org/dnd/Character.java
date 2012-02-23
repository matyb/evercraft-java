package org.dnd;

import org.dnd.util.Range;

public class Character {

	private String name;
	private Range hitPoints;
	private Armor armor;
	private Experience xp;
	private Alignment alignment;
	private Abilities abilities;

	public Character(){
		this("");
	};
	
	public Character(String name) {
		this.setName(name);
		this.setArmor(new Armor());
		this.alignment = new Alignment(0);
		this.hitPoints = new Range(0, getHPModifier(), Integer.MAX_VALUE);
		this.abilities = new Abilities(10);
		this.xp = new Experience(0);
	}
	
	protected int getHPModifier() {
		return 5;
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
	
	public int getCurrentXP() {
		return xp.getCurrentExperience();
	}
	
	public void addExperience(int points) {
		int oldLevel = getLevel();
		
		xp.addToExperience(points);
		
		int levelsGained = getLevel() - oldLevel;
		for(int level = 0; level < levelsGained; level++) { // only if level gained
			levelGained();
		}
	}
	
	protected void levelGained(){
		hitPoints.add(getHPModifier() + abilities.getModifier(getConstitution()));
	}

	public int attack(int roll, Character opposingCharacter) {
		int damageDone = 0;
		if(isAttackSuccessful(getModifiedRoll(roll), opposingCharacter)){			
			// A "Natural" Roll of 20 is a Critical Hit
			if(roll == 20) {
				damageDone += getModifiedDamage(2, true);
			} else {
				damageDone += getModifiedDamage(1, false);
			}
			addExperience(10);
		}
		opposingCharacter.decrementHP(damageDone);
		return damageDone;
	}

	private boolean isAttackSuccessful(int roll, Character opposingCharacter) {
		return roll >= opposingCharacter.getDefense();
	}

	public int getModifiedDamage(int damage, boolean crit) {
		damage += abilities.getModifier(abilities.getStrength());
		damage *= crit ? getCritMultiplier() : 1;
		return Math.max(1, damage);
	}
	
	public int getCritMultiplier() {
		return 2;
	}

	public int getModifiedRoll(int roll) {
		int modifiedRoll = roll + abilities.getModifier(abilities.getStrength());
		
		if(modifiedRoll > 0) {
			modifiedRoll = Math.min(modifiedRoll, 20);
		} else {
			modifiedRoll = 0;
		}
		
		modifiedRoll += getRollModifier();
		
		return modifiedRoll;
	}
	
	public int getRollModifier()
	{
		return (int) Math.floor(getLevel() / 2);
	}

	public int getLevel() {
		return xp.getLevel();
	}

	private void decrementHP(int hp) {
		hitPoints.add(-hp);
	}

	public int getDefense() {
		return Math.max(0, armor.getDefense() + abilities.getModifier(abilities.getDexterity()));
	}

	public void setDefense(int defense) {
		armor.setDefense(defense);
	}
	
	public void setArmor(Armor armor) {
		this.armor = armor;
	}

	public void setHP(int hitPoints) {
		this.hitPoints.setValue(hitPoints);
	}

	public int getHP() {
		
		if(hitPoints.getValue() == 0) {
			return 0;
		}
		
		int constitutionModifier = abilities.getModifier(abilities.getConstitution());		
		if(hitPoints.getValue() + constitutionModifier < 1) {
			return 1;
		}
		
		return hitPoints.getValue() + constitutionModifier;
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

	public void setStrength(int strength) {
		abilities.setStrength(strength);		
	}

	public void setDexterity(int dexterity) {
		abilities.setDexterity(dexterity);
	}

	public void setConstitution(int constitution) {
		abilities.setConstitution(constitution);
	}
}
