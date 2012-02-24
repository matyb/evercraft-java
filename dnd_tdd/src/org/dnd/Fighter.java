package org.dnd;

public class Fighter extends Class {

	@Override
	public int getLevelBonusToRoll(int level) {
		return level;
	}
	
	@Override
	protected int getHPModifier() {
		return 10;
	}
	
}
