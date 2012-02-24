package org.dnd;

import static org.junit.Assert.assertEquals;

import org.dnd.Class.ClassType;
import org.junit.Test;

public class RogueTest {

	@Test
	public void testThatCriticalHitsDeal3xDamage() throws Exception {
		Character me = new Character("", ClassType.ROGUE);
		assertEquals(15, new CombatSimulator().getModifiedDamage(me, 5, true));
	}
	
}
