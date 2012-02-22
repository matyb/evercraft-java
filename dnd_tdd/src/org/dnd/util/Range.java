package org.dnd.util;

public class Range {

	private int min, value, max;
	
	public Range(int min, int value, int max){
		this.min = Math.min(min, max);
		this.max = Math.max(min, max);
		setValue(value);
	}
	
	public int getValue(){
		return value;
	}
	
	public int getMaximum(){
		return max;
	}
	
	public int getMinimum(){
		return min;
	}
	
	public void setValue(int value){
		this.value = Math.min(getMaximum(), Math.max(getMinimum(), value));
	}

	public void add(int integer) {
		setValue(getValue() + integer);
	}
	
	@Override
	public String toString() {
		return new StringBuilder("Range [min=").append(min).append(", value=")
				.append(value).append(", max=").append(max).append("]").toString();
	}
	
	
}
