package org.dnd;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.dnd.QuestCharacter;
import org.junit.Test;


public class CharacterTest {

	@Test
	public void testCharacterConstruction() {
		new QuestCharacter("");
	}

	@Test
	public void testCharacterConstructerSetsName() throws Exception {
		assertEquals ("Name", new QuestCharacter("Name").getName());
	}
	
	@Test
	public void testCharacterHasTheNameSetOnIt() throws Exception {
		QuestCharacter character = new QuestCharacter();
		character.setName("Name");
		assertEquals ("Name", character.getName());
	}
	
	@Test
	public void testSettingAlignment() throws Exception {
		QuestCharacter character = new QuestCharacter();
		character.setAlignment(-2);
		assertEquals(-2l, character.getAlignment());
	}

	@Test
	public void testNewCharacterIsNeutral() throws Exception {
		assertTrue(new QuestCharacter().isNuetral());
	}
	
	@Test
	public void testNewCharacterIsNeutral_lowerBoundary() throws Exception {
		QuestCharacter questCharacter = new QuestCharacter();
		questCharacter.setAlignment(-100);
		assertTrue(questCharacter.isNuetral());
	}
	
	@Test
	public void testNewCharacterIsNeutral_upperBoundary() throws Exception {
		QuestCharacter questCharacter = new QuestCharacter();
		questCharacter.setAlignment(100);
		assertTrue(questCharacter.isNuetral());
	}
	
	@Test
	public void testNewCharacterIsNotNeutral_lowerBoundaryMinusOne() throws Exception {
		QuestCharacter questCharacter = new QuestCharacter();
		questCharacter.setAlignment(-101);
		assertFalse(questCharacter.isNuetral());
	}
	
	@Test
	public void testNewCharacterIsNotNeutral_lowerBoundaryPlusOne() throws Exception {
		QuestCharacter questCharacter = new QuestCharacter();
		questCharacter.setAlignment(101);
		assertFalse(questCharacter.isNuetral());
	}
	
	@Test
	public void testCharacterWithLowAlignmentIsEvil() throws Exception {
		QuestCharacter questCharacter = new QuestCharacter();
		questCharacter.setAlignment(-101);
		assertTrue(questCharacter.isEvil());
	}
	
	@Test
	public void testCharacterWithHighAlignmentIsGood() throws Exception {
		QuestCharacter questCharacter = new QuestCharacter();
		questCharacter.setAlignment(101);
		assertTrue(questCharacter.isGood());
	}
	
	@Test
	public void testNewCharacterHasFiveHP() throws Exception {
		assertEquals(5, new QuestCharacter().getHP());
	}
	
	@Test
	public void testCharacterAttackSucceeds_withRollExceedingArmorValue(){
		QuestCharacter questCharacter = new QuestCharacter();
		int roll = questCharacter.getArmor().getDefense() + 1;
		assertTrue(questCharacter.attack(roll, new QuestCharacter()));
	}
	
	@Test
	public void testCharacterAttackSucceeds_withRollMeetingArmorValue(){
		QuestCharacter questCharacter = new QuestCharacter();
		int roll = questCharacter.getArmor().getDefense();
		assertTrue(questCharacter.attack(roll, new QuestCharacter()));
	}
	
	@Test
	public void testCharacterAttackFails_withRollLessThanArmorValue(){
		QuestCharacter questCharacter = new QuestCharacter();
		int roll = questCharacter.getArmor().getDefense() - 1;
		assertFalse(questCharacter.attack(roll, new QuestCharacter()));
	}
	
	@Test
	public void testCharacterAttackSucceeds_withHighRoll(){
		assertTrue(new QuestCharacter().attack(20, new QuestCharacter()));
	}
	
	@Test
	public void testCharacterAttackSucceedsAndDefendersHpIsDecrementedByOne() throws Exception {
		QuestCharacter you = new QuestCharacter();
		new QuestCharacter().attack(19, you);
		assertEquals(4, you.getHP());
	}
	
	@Test
	public void testCharacterAttackDoesntSucceedDefendersHpIsNotDecremented() throws Exception {
		QuestCharacter you = new QuestCharacter();
		new QuestCharacter().attack(0, you);
		assertEquals(5, you.getHP());
	}
	
	@Test
	public void testNaturalTwentyDealsDoubleDamage() throws Exception {
		QuestCharacter you = new QuestCharacter();
		new QuestCharacter().attack(20, you);
		assertEquals(3, you.getHP());
	}
	
	@Test
	public void testWhenHPIsLessThanOneCharacterIsDead() throws Exception {
		QuestCharacter questCharacter = new QuestCharacter();
		questCharacter.setHP(0);
		assertTrue(questCharacter.isDead());
	}
	
	@Test
	public void testWhenHPIsLessThanZeroCharacterIsDead() throws Exception {
		QuestCharacter questCharacter = new QuestCharacter();
		questCharacter.setHP(-1);
		assertTrue(questCharacter.isDead());
	}
	
	@Test
	public void testWhenHPIsGreaterThanZeroCharacterIsAlive() throws Exception {
		QuestCharacter questCharacter = new QuestCharacter();
		questCharacter.setHP(1);
		assertFalse(questCharacter.isDead());
	}
	
	@Test
	public void testAbilityDefaultValue_strength() throws Exception {
		assertEquals(10, new QuestCharacter().getStrength());
	}
	
	@Test
	public void testAbilityDesfaultValue_dexterity() throws Exception {
		assertEquals(10, new QuestCharacter().getDexterity());
	}
	
	@Test
	public void testAbilityDesfaultValue_constitution() throws Exception {
		assertEquals(10, new QuestCharacter().getConstitution());
	}
	
	@Test
	public void testAbilityDesfaultValue_Wisdom() throws Exception {
		assertEquals(10, new QuestCharacter().getWisdom());
	}
	
	@Test
	public void testAbilityDesfaultValue_Intelligence() throws Exception {
		assertEquals(10, new QuestCharacter().getIntelligence());
	}
	
	@Test
	public void testAbilityDesfaultValue_Charisma() throws Exception {
		assertEquals(10, new QuestCharacter().getCharisma());
	}
}
