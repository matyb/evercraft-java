package org.dnd;
import static org.junit.Assert.*;

import org.dnd.Character;
import org.dnd.CombatSimulator;
import org.junit.Test;


public class CombatSimulatorTest {
	
	@Test
	public void testStrengthModifierAddsToAttackRoll() throws Exception {
		Character questCharacter = new Character();
		questCharacter.setStrength(20);
		int roll = 10;
		assertEquals(roll + 5, new CombatSimulator().getModifiedAttackRoll(questCharacter, roll));
	}
	
	@Test
	public void testStrengthModifierCantMakeAttackRollGreaterThan20() throws Exception {
		Character questCharacter = new Character();
		questCharacter.setStrength(20);
		int roll = 16;
		assertEquals(20, new CombatSimulator().getModifiedAttackRoll(questCharacter, roll));
	}
	
	@Test
	public void testStrengthModifierCantMakeAttackRollLowerThan0() throws Exception {
		Character questCharacter = new Character();
		questCharacter.setStrength(1);
		int roll = 4;
		assertEquals(0, new CombatSimulator().getModifiedAttackRoll(questCharacter, roll));
	}
	
	@Test
	public void testForEveryEvenLevelAddOneToAttackRoll_EvenLevel() throws Exception {
		Character questCharacter = new Character();
		questCharacter.addExperience(1000);
		assertEquals(11, new CombatSimulator().getModifiedAttackRoll(questCharacter, 10));
	}
	
	@Test
	public void testForEveryEvenLevelAddOneToAttackRoll_OddLevel() throws Exception {
		Character questCharacter = new Character();
		questCharacter.addExperience(2000);
		assertEquals(11, new CombatSimulator().getModifiedAttackRoll(questCharacter, 10));
	}
}
