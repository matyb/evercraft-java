package org.dnd.character.races;

import static org.junit.Assert.assertEquals;

import org.dnd.character.races.Race.RaceType;
import org.junit.Test;

public class RaceTest {
	@Test
	public void testConstructorHuman() throws Exception {
		assertEquals(Human.class, Race.getRaceFromMap(RaceType.HUMAN).getClass());
	}

}
