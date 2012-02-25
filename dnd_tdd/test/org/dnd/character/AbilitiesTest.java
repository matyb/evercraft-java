package org.dnd.character;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.dnd.character.Abilities;
import org.dnd.character.Character;
import org.junit.Test;


public class AbilitiesTest {
	
	Map<Integer, Integer> scoreModifierMap = new HashMap<Integer, Integer>();
	{
		scoreModifierMap.put(1, -5);
		scoreModifierMap.put(2, -4);
		scoreModifierMap.put(3, -4);
		scoreModifierMap.put(4, -3);
		scoreModifierMap.put(5, -3);
		scoreModifierMap.put(6, -2);
		scoreModifierMap.put(7, -2);
		scoreModifierMap.put(8, -1);
		scoreModifierMap.put(9, -1);
		scoreModifierMap.put(10, 0);
		scoreModifierMap.put(11, 0);
		scoreModifierMap.put(12, 1);
		scoreModifierMap.put(13, 1);
		scoreModifierMap.put(14, 2);
		scoreModifierMap.put(15, 2);
		scoreModifierMap.put(16, 3);
		scoreModifierMap.put(17, 3);
		scoreModifierMap.put(18, 4);
		scoreModifierMap.put(19, 4);
		scoreModifierMap.put(20, 5);
	}

	@Test
	public void testScoreModifierTable() throws Exception {
		Abilities abilities = new Abilities(10);
		for(Entry<Integer, Integer> scoreModifier : scoreModifierMap.entrySet()){
			assertEquals("Expected: "+scoreModifier.getValue()+" for a score of: "+scoreModifier.getKey(),
					scoreModifier.getValue(), (Integer)abilities.getModifier(scoreModifier.getKey()));
		}
	}

	@Test
	public void testStrengthModifierAddsToDamageDealt() throws Exception {
		Character me = new Character();
		Character you = new Character();
		me.setStrength(20);
		int roll = 16;
		assertEquals(6, me.attack(roll, you));
	}
	
	@Test
	public void testStrengthModifierCantMakeDamageLessThan1() throws Exception {
		Character me = new Character();
		Character you = new Character();
		me.setStrength(1);
		assertEquals(1, me.attack(19, you));
	}
	
	@Test
	public void testStrengthModifierCantMakeDamageLessThan1EvenOnCrit() throws Exception {
		Character me = new Character();
		Character you = new Character();
		me.setStrength(1);
		assertEquals(1, me.attack(20, you));
	}
	
	@Test
	public void testDexterityModifierAddedToArmorClass_DefaultNoBonus() throws Exception {
		Character me = new Character();
		assertEquals(10, me.getArmor());
	}
	
	@Test
	public void testDexterityModifierAddedToArmorClass_HighBound() throws Exception {
		Character me = new Character();
		me.setDexterity(20);
		assertEquals(15, me.getArmor());
	}
	
	@Test
	public void testDexterityModifierAddedToArmorClass_LowBound() throws Exception {
		Character me = new Character();
		me.setDexterity(1);
		assertEquals(5, me.getArmor());
	}
	
	@Test
	public void testDexterityModifierAddedToArmorClass_GreaterThanOrEqual0() throws Exception {
		Character me = new Character();
		me.setDefense(1);
		me.setDexterity(1);
		assertEquals(0, me.getArmor());
	}
	
	@Test
	public void testConstitutionModifierAddedToHP_HighBound() throws Exception {
		Character me = new Character();
		me.setConstitution(20);
		assertEquals(10, me.getHP());
	}
	
	@Test
	public void testConstitutionModifierAddedToHP_LowBound() throws Exception {
		Character me = new Character();
		me.setConstitution(1);
		assertEquals(1, me.getHP());
	}
}
