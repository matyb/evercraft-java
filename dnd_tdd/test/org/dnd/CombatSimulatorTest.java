package org.dnd;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class CombatSimulatorTest {
	
	@Test
	public void testAttackSucceeds_withRollExceedingArmorValue(){
		Character questCharacter = new Character();
		int roll = questCharacter.getArmor() + 1;
		assertEquals(1, new CombatSimulator().fight(questCharacter, new Character(), roll));
	}
	
	@Test
	public void testAttackSucceeds_withRollMeetingArmorValue(){
		Character questCharacter = new Character();
		int roll = questCharacter.getArmor();
		assertEquals(1, new CombatSimulator().fight(questCharacter, new Character(), roll));
	}
	
	@Test
	public void testAttackFails_withRollLessThanArmorValue(){
		Character questCharacter = new Character();
		int roll = questCharacter.getArmor() - 1;
		assertEquals(0, new CombatSimulator().fight(questCharacter, new Character(), roll));
	}
	
	@Test
	public void testAttackAlwaysSucceeds_withNatural20(){
		Character opponent = new Character();
		opponent.setDefense(100);
		assertEquals(4, new CombatSimulator().fight(new Character(), opponent , 20));
	}
	
	@Test
	public void testAttackSucceedsAndDefendersHpIsDecrementedByOne() throws Exception {
		Character opponent = new Character();
		new CombatSimulator().fight(new Character(), opponent, 19);
		assertEquals(4, opponent.getHP());
	}
	
	@Test
	public void testAttackDoesntSucceedDefendersHpIsNotDecremented() throws Exception {
		Character opponent = new Character();
		new CombatSimulator().fight(new Character(), opponent, 2);
		assertEquals(5, opponent.getHP());
	}
	
	@Test
	public void testNaturalTwentyDealsDoubleDamage() throws Exception {
		Character opponent = new Character();
		new CombatSimulator().fight(new Character(), opponent, 20);
		assertEquals(1, opponent.getHP());
	}
	
	@Test
	public void testNaturalOneIsAMiss() throws Exception {
		assertEquals(0, new CombatSimulator().fight(new Character(), new Character(), 1));
	}
	
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
