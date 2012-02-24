package org.dnd.character.classes;

import static org.junit.Assert.*;

import org.dnd.CombatSimulator;
import org.dnd.character.Character;
import org.dnd.character.classes.Class.ClassType;
import org.dnd.character.races.Race.RaceType;
import org.junit.Test;

public class FighterTest {

	@Test
	public void testSkillToAbilityMap() throws Exception {
		Character me = new Character("", ClassType.FIGHTER, RaceType.DEFAULT);
		assertEquals(7, me.getClassType().getSkillToAbilityMap().size());
	}
	
	@Test
	public void testForEveryEvenLevelAddOneToRoll_EveryLevel() throws Exception {
		Character me = new Character("", ClassType.FIGHTER, RaceType.DEFAULT);
		assertEquals(11, new CombatSimulator().getModifiedAttackRoll(me, 10));
	}
	
	@Test
	public void testForEveryLevelGains10HPInsteadOf5() throws Exception {
		Character me = new Character("", ClassType.FIGHTER, RaceType.DEFAULT);
		assertEquals(10, me.getHP());
	}
}
