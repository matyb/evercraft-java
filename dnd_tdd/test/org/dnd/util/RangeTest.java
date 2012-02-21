package test.org.dnd.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.org.dnd.util.Range;

public class RangeTest {

	@Test
	public void testGetters() throws Exception {
		Range range = new Range(-2, 1, 2);
		assertEquals(-2, range.getMinimum());
		assertEquals(1, range.getValue());
		assertEquals(2, range.getMaximum());
	}
	
	@Test
	public void testSetValueLessThanMin() throws Exception {
		Range range = new Range(-2, 0, 2);
		range.setValue(-3);
		assertEquals(-2, range.getValue());
	}
	
	@Test
	public void testSetValueMoreThanMax() throws Exception {
		Range range = new Range(-2, 0, 2);
		range.setValue(3);
		assertEquals(2, range.getValue());
	}
	
}
