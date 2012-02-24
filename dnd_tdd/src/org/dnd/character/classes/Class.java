package org.dnd.character.classes;

import java.util.HashMap;
import java.util.Map;

import org.dnd.character.Abilities.AbilityType;

public class Class {

	public static enum ClassType { DEFAULT, BARBARIAN, BARD, CLERIC, DRUID, FIGHTER, MONK, PALADIN, RANGER, ROGUE, SORCERER, WIZARD };
	
	static enum ClassSkills { CLIMB, CRAFT, HANDLE_ANIMAL, INTIMIDATE, JUMP, RIDE, SWIM };
	
	private Map<ClassSkills, AbilityType> skillToAbilityMap = new HashMap<ClassSkills, AbilityType>();
	
	private static Map<ClassType, Class> typeToClassMap;
	static {
		typeToClassMap = new HashMap<ClassType, Class>();
		typeToClassMap.put(ClassType.DEFAULT, new Class());
		typeToClassMap.put(ClassType.BARBARIAN, new Barbarian());
		typeToClassMap.put(ClassType.BARD, new Bard());
		typeToClassMap.put(ClassType.CLERIC, new Cleric());
		typeToClassMap.put(ClassType.DRUID, new Druid());
		typeToClassMap.put(ClassType.FIGHTER, new Fighter());
		typeToClassMap.put(ClassType.MONK, new Monk());
		typeToClassMap.put(ClassType.PALADIN, new Paladin());
		typeToClassMap.put(ClassType.RANGER, new Ranger());
		typeToClassMap.put(ClassType.ROGUE, new Rogue());
		typeToClassMap.put(ClassType.SORCERER, new Sorcerer());
		typeToClassMap.put(ClassType.WIZARD, new Wizard());
	};
	
	public static Class getClassFromMap(ClassType type) {
		return typeToClassMap.get(type);
	}
	
	public int getHPModifier() {
		return 5;
	}
	
	public int getCritMultiplier() {
		return 2;
	}
	
	public int getLevelBonusToRoll(int level) {
		return (int) Math.floor(level / 2);
	}

	public Map<ClassSkills, AbilityType> getSkillToAbilityMap() {
		return skillToAbilityMap;
	}

	public void setSkillToAbilityMap(Map<ClassSkills, AbilityType> skillToAbilityMap) {
		this.skillToAbilityMap = skillToAbilityMap;
	}
}
