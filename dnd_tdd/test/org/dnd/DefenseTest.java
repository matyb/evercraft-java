package org.dnd;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class DefenseTest {

	@Test
	public void testBaseAmountOfArmor() throws Exception {
		assertEquals(10, new Defense().getArmor());
	}
	
}
