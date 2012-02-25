package org.dnd.character.classes;

import static org.junit.Assert.*;

import org.dnd.character.classes.Class;
import org.dnd.character.classes.Fighter;
import org.dnd.character.classes.Rogue;
import org.dnd.character.classes.Class.ClassType;
import org.junit.Test;

public class ClassTest {

	@Test
	public void testConstructorFighter() throws Exception {
		assertEquals(Fighter.class, Class.getClassFromMap(ClassType.FIGHTER).getClass());
	}

	@Test
	public void testConstructorRogue() throws Exception {
		assertEquals(Rogue.class, Class.getClassFromMap(ClassType.ROGUE).getClass());
	}
	
	@Test
	public void testDefaultClassSkillToAbilityMapEmpty() throws Exception {
		assertEquals(0, new Class().getSkillToAbilityMap().size());
	}
}
