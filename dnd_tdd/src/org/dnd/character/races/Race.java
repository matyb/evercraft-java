package org.dnd.character.races;

import java.util.HashMap;
import java.util.Map;

public class Race {

	public static enum Size { SMALL, MEDIUM };	

	public static enum RaceType { DEFAULT, HUMAN, DWARF, ELF, GNOME, HALFELF, HALFORC, HALFLING };	
	
	private static Map<RaceType, Race> typeToRaceMap;
	static {
		typeToRaceMap = new HashMap<RaceType, Race>();
		typeToRaceMap.put(RaceType.DEFAULT, new Race());
		typeToRaceMap.put(RaceType.HUMAN, new Human());
		typeToRaceMap.put(RaceType.DWARF, new Dwarf());
		typeToRaceMap.put(RaceType.ELF, new Elf());
		typeToRaceMap.put(RaceType.GNOME, new Gnome());
		typeToRaceMap.put(RaceType.HALFELF, new HalfElf());
		typeToRaceMap.put(RaceType.HALFORC, new HalfOrc());
		typeToRaceMap.put(RaceType.HALFLING, new Halfling());
	};
	
	public static Race getRaceFromMap(RaceType type) {
		return typeToRaceMap.get(type);
	}
	
	private Size size;

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}
}
