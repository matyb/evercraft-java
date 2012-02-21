package org.dnd;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExperienceTest {

	@Test
	public void testNewCharacterHasZeroXP() throws Exception {
		Character me = new Character();
		assertEquals(0, me.getCurrentXP());
	}

	@Test
	public void testWhenAttackIsSuccessful_Gain10XP() throws Exception {
		Character me = new Character();
		Character you = new Character();
		me.attack(20, you);
		assertEquals(10, me.getCurrentXP());
	}

	@Test
	public void testWhenAttackFails_Gain0XP() throws Exception {
		Character me = new Character();
		Character you = new Character();
		me.attack(1, you);
		assertEquals(0, me.getCurrentXP());
	}
}
