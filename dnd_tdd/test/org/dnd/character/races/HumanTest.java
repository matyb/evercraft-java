package org.dnd.character.races;

import static org.junit.Assert.assertEquals;

import org.dnd.character.races.Race.RaceType;
import org.dnd.character.races.Race.Size;
import org.junit.Test;

public class HumanTest {

	@Test
	public void testHumanIsMediumSized() throws Exception {
		assertEquals(Size.MEDIUM, Race.getRaceFromMap(RaceType.HUMAN).getSize());
	} 

}
