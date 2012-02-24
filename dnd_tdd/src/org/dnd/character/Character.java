package org.dnd.character;

import org.dnd.CombatSimulator;
import org.dnd.character.classes.Class;
import org.dnd.character.classes.Class.ClassType;
import org.dnd.character.classes.Fighter;
import org.dnd.character.classes.Rogue;
import org.dnd.character.races.Human;
import org.dnd.character.races.Race;
import org.dnd.character.races.Race.RaceType;
import org.dnd.util.Dice;
import org.dnd.util.Range;

public class Character {

	private static enum Gender { MALE, FEMALE };
	
	private Gender gender;
	private int weight; // lbs
	private int height; // inches
	private int age;
	private Class classType;
	private Race raceType;
	private String name;
	private Range hitPoints;
	private Defense armor;
	private Experience xp;
	private Alignment alignment;
	private Abilities abilities;

	public Abilities getAbilities() {
		return abilities;
	}

	public void setAbilities(Abilities abilities) {
		this.abilities = abilities;
	}

	public Character(){
		this("");
	};
	
	public Character(String name) {
		this(name, ClassType.DEFAULT, RaceType.DEFAULT);
	}

	public Character(String name, ClassType classType, RaceType raceType) {
		this.setName(name);
		this.setArmor(new Defense());
		this.classType = Class.getClassFromMap(classType);
		this.raceType  = Race.getRaceFromMap(raceType);
		this.alignment = new Alignment(0);
		this.hitPoints = new Range(0, this.classType.getHPModifier(), Integer.MAX_VALUE);
		this.abilities = new Abilities(10);
		this.xp = new Experience(0);
		this.setAge(generateAge());
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
		hitPoints.add(classType.getHPModifier() + abilities.getModifier(getConstitution()));
	}

	public int attack(int attackRoll, Character opposingCharacter) {
		return new CombatSimulator().fight(this, opposingCharacter, attackRoll);
	}

	public int getLevel() {
		return xp.getLevel();
	}

	public void decrementHP(int hp) {
		hitPoints.add(-hp);
	}

	public int getArmor() {
		//return 10 + armorBonus + shieldBonus + abilities.getModifier(abilities.getDexterity()) + sizeModifier;
		return Math.max(0, armor.getArmor() + abilities.getModifier(abilities.getDexterity()));
	}

	public void setDefense(int defense) {
		armor.setArmor(defense);
	}
	
	public void setArmor(Defense armor) {
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
	
	private int generateAge() {
		if(raceType.getClass() == Human.class && classType.getClass() == Rogue.class) {
			return Dice.roll(1, 4, 15);
		} else if(raceType.getClass() == Human.class && classType.getClass() == Fighter.class) {
			return Dice.roll(1, 6, 15);
		}
		return 0 ;
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

	public Class getClassType() {
		return classType;
	}

	public void setClassType(Class classType) {
		this.classType = classType;
	}

	public Race getRaceType() {
		return raceType;
	}

	public void setRaceType(Race raceType) {
		this.raceType = raceType;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
