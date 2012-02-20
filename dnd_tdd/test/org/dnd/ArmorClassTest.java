package org.dnd;
import static org.junit.Assert.assertEquals;

import org.dnd.Armor;
import org.junit.Test;


public class ArmorClassTest {

	@Test
	public void testDefaultArmorClass() throws Exception {
		assertEquals(10, new Armor().getDefense());
	}
	
}
