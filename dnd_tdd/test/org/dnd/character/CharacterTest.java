package org.dnd.character;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.dnd.character.Character;
import org.dnd.character.classes.Class.ClassType;
import org.dnd.character.races.Race.RaceType;
import org.junit.Test;

public class CharacterTest {

	@Test
	public void testCharacterConstruction() {
		new Character("");
	}

	@Test
	public void testCharacterConstructerSetsName() throws Exception {
		assertEquals ("Name", new Character("Name").getName());
	}
	
	@Test
	public void testCharacterHasTheNameSetOnIt() throws Exception {
		Character character = new Character();
		character.setName("Name");
		assertEquals ("Name", character.getName());
	}
	
	@Test
	public void testSettingAlignment() throws Exception {
		Character character = new Character();
		character.setAlignment(-2);
		assertEquals(-2l, character.getAlignment());
	}

	@Test
	public void testNewCharacterIsNeutral() throws Exception {
		assertTrue(new Character().isNuetral());
	}
	
	@Test
	public void testNewCharacterIsNeutral_lowerBoundary() throws Exception {
		Character questCharacter = new Character();
		questCharacter.setAlignment(-100);
		assertTrue(questCharacter.isNuetral());
	}
	
	@Test
	public void testNewCharacterIsNeutral_upperBoundary() throws Exception {
		Character questCharacter = new Character();
		questCharacter.setAlignment(100);
		assertTrue(questCharacter.isNuetral());
	}
	
	@Test
	public void testNewCharacterIsNotNeutral_lowerBoundaryMinusOne() throws Exception {
		Character questCharacter = new Character();
		questCharacter.setAlignment(-101);
		assertFalse(questCharacter.isNuetral());
	}
	
	@Test
	public void testNewCharacterIsNotNeutral_lowerBoundaryPlusOne() throws Exception {
		Character questCharacter = new Character();
		questCharacter.setAlignment(101);
		assertFalse(questCharacter.isNuetral());
	}
	
	@Test
	public void testCharacterWithLowAlignmentIsEvil() throws Exception {
		Character questCharacter = new Character();
		questCharacter.setAlignment(-101);
		assertTrue(questCharacter.isEvil());
	}
	
	@Test
	public void testCharacterWithHighAlignmentIsGood() throws Exception {
		Character questCharacter = new Character();
		questCharacter.setAlignment(101);
		assertTrue(questCharacter.isGood());
	}
	
	@Test
	public void testNewCharacterHasFiveHP() throws Exception {
		assertEquals(5, new Character().getHP());
	}
	
	@Test
	public void testWhenHPIsLessThanOneCharacterIsDead() throws Exception {
		Character questCharacter = new Character();
		questCharacter.setHP(0);
		assertTrue(questCharacter.isDead());
	}
	
	@Test
	public void testWhenHPIsLessThanZeroCharacterIsDead() throws Exception {
		Character questCharacter = new Character();
		questCharacter.setHP(-1);
		assertTrue(questCharacter.isDead());
	}
	
	@Test
	public void testWhenHPIsGreaterThanZeroCharacterIsAlive() throws Exception {
		Character questCharacter = new Character();
		questCharacter.setHP(1);
		assertFalse(questCharacter.isDead());
	}
	
	@Test
	public void testAbilityDefaultValue_strength() throws Exception {
		assertEquals(10, new Character().getStrength());
	}
	
	@Test
	public void testAbilityDesfaultValue_dexterity() throws Exception {
		assertEquals(10, new Character().getDexterity());
	}
	
	@Test
	public void testAbilityDesfaultValue_constitution() throws Exception {
		assertEquals(10, new Character().getConstitution());
	}
	
	@Test
	public void testAbilityDesfaultValue_Wisdom() throws Exception {
		assertEquals(10, new Character().getWisdom());
	}
	
	@Test
	public void testAbilityDesfaultValue_Intelligence() throws Exception {
		assertEquals(10, new Character().getIntelligence());
	}
	
	@Test
	public void testAbilityDesfaultValue_Charisma() throws Exception {
		assertEquals(10, new Character().getCharisma());
	}
	
	@Test
	public void testNewCharacterDefaultsToLevel1() throws Exception {
		Character me = new Character();
		assertEquals(1, me.getLevel());
	}
	
	@Test
	public void testEvery1000HitPointsLevelsUpCharacter() throws Exception {
		Character me = new Character();
		me.addExperience(2000);
		assertEquals(3, me.getLevel());
	}
	
	@Test
	public void testEveryLevelIncreasesBaseHPBy5() throws Exception {
		Character me = new Character();
		me.addExperience(2000);
		assertEquals(15, me.getHP());
	}
	
	@Test
	public void testHumanRoguesAgeIsBetween16and19() throws Exception {
		int age = new Character("", ClassType.ROGUE, RaceType.HUMAN).getAge();
		assertTrue(age >= 16 && age <= 19);
	}
	
	@Test
	public void testHumanFightersAgeIsBetween16and19() throws Exception {
		int age = new Character("", ClassType.FIGHTER, RaceType.HUMAN).getAge();
		assertTrue(age >= 16 && age <= 21);
	}
}
