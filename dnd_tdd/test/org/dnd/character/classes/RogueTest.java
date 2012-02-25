package org.dnd.character.classes;

import static org.junit.Assert.assertEquals;

import org.dnd.CombatSimulator;
import org.dnd.character.Character;
import org.dnd.character.classes.Class.ClassType;
import org.dnd.character.races.Race.RaceType;
import org.junit.Test;

public class RogueTest {

	@Test
	public void testThatCriticalHitsDeal3xDamage() throws Exception {
		Character me = new Character("", ClassType.ROGUE, RaceType.DEFAULT);
		assertEquals(15, new CombatSimulator().getModifiedDamage(me, 5, true));
	}
}
