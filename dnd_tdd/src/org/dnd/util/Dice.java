package org.dnd.util;

public class Dice {
	
	public static int roll(int sides) {
		return (int)(Math.random()*sides) + 1;
	}
	
	public static int roll(int numberOfDice, int sides) {
		return roll(numberOfDice, sides, 0);
	}
	
	public static int roll(int numberOfDice, int sides, int extra) {
		int roll = 0;
		for(int die = 1; die <= numberOfDice; die++) {
			roll += roll(sides);
		}
		return roll + extra;
	}
}
