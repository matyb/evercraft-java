package org.dnd.character;
import static org.junit.Assert.assertEquals;

import org.dnd.character.Defense;
import org.junit.Test;


public class DefenseTest {

	@Test
	public void testBaseAmountOfArmor() throws Exception {
		assertEquals(10, new Defense().getArmor());
	}
	
}
