package org.dnd;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class ArmorTest {

	@Test
	public void testDefaultArmorClass() throws Exception {
		assertEquals(10, new Armor().getDefense());
	}
	
}
