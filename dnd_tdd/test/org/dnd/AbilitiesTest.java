package test.org.dnd;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import src.org.dnd.Abilities;
import src.org.dnd.Character;


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
	public void testStrengthModifierAddsToRoll() throws Exception {
		Character questCharacter = new Character();
		questCharacter.setStrength(20);
		int roll = 10;
		assertEquals(roll + 5, questCharacter.getModifiedRoll(roll));
	}
	
	@Test
	public void testStrengthModifierCantMakeRollGreaterThan20() throws Exception {
		Character questCharacter = new Character();
		questCharacter.setStrength(20);
		int roll = 16;
		assertEquals(20, questCharacter.getModifiedRoll(roll));
	}
	
	@Test
	public void testStrengthModifierCantMakeRollLowerThan0() throws Exception {
		Character questCharacter = new Character();
		questCharacter.setStrength(1);
		int roll = 4;
		assertEquals(0, questCharacter.getModifiedRoll(roll));
	}

	@Test
	public void testStrengthModifierAddsToDamageDealt() throws Exception {
		Character me = new Character();
		Character you = new Character();
		me.setStrength(20);
		int roll = 16;
		assertEquals(6, me.attack(roll, you));
	}
}
