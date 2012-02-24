package org.dnd;

import java.util.HashMap;
import java.util.Map;

public class Class {

	static enum ClassType { DEFAULT, FIGHTER, ROGUE };
	
	private static Map<ClassType, Class> typeToClassMap;
	static {
		typeToClassMap = new HashMap<ClassType, Class>();
		typeToClassMap.put(ClassType.DEFAULT, new Class());
		typeToClassMap.put(ClassType.FIGHTER, new Fighter());
		typeToClassMap.put(ClassType.ROGUE, new Rogue());
	};
	
	public static Class getClassFromMap(ClassType type) {
		return typeToClassMap.get(type);
	}
	
	protected int getHPModifier() {
		return 5;
	}
	
	protected int getCritMultiplier() {
		return 2;
	}
	
	protected int getLevelBonusToRoll(int level) {
		return (int) Math.floor(level / 2);
	}
}
