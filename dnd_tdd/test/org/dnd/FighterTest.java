package org.dnd;

import static org.junit.Assert.*;

import org.dnd.Class.ClassType;
import org.junit.Test;

public class FighterTest {

	@Test
	public void testForEveryEvenLevelAddOneToRoll_EveryLevel() throws Exception {
		Character me = new Character("", ClassType.FIGHTER);
		assertEquals(11, new CombatSimulator().getModifiedAttackRoll(me, 10));
	}
	
	@Test
	public void testForEveryLevelGains10HPInsteadOf5() throws Exception {
		Character me = new Character("", ClassType.FIGHTER);
		assertEquals(10, me.getHP());
	}
}
