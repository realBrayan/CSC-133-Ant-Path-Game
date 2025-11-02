package com.mycompany.a2;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.models.Point;

public class Flag extends Fixed {
	
	private int sequenceNumber;
	
	private static final int FLAG_SIZE = 10;
	private static final int FLAG_COLOR = ColorUtil.BLUE;
	
	public Flag(int sequenceNumber, Point location) {
		
		super(FLAG_SIZE, location, FLAG_COLOR);
		
		this.sequenceNumber = sequenceNumber;
	}

	public int getSequenceNumber() {
		return this.sequenceNumber;
	}
	
	@Override
	public void setColor(int color) {
		// do nothing.
		System.out.println("Cannot change the Flag's colors.");
	}
	
	@Override
	public String toString() {
		String parentString = super.toString();
		String myString = " seqNum=" + this.sequenceNumber;
		return "Flag: " + parentString + myString;
	}
}
