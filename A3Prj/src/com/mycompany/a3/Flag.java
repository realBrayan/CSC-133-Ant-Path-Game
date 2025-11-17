package com.mycompany.a3;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.charts.models.Point;
//import com.codename1.ui.geom.Point;

public class Flag extends Fixed implements IDrawable {
	
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

	public void draw(Graphics g, com.codename1.ui.geom.Point pCmpRelPrnt) {
		// TODO Auto-generated method stub
		int flagSize = this.getSize();
		int halfSize = flagSize / 2;
		
		int centerX = (int)this.getLocation().getX();
		int centerY = (int)this.getLocation().getY();
		
		int p1x = pCmpRelPrnt.getX() + centerX;
		int p1y = pCmpRelPrnt.getY() + centerY - halfSize;
		
		int p2x = pCmpRelPrnt.getX() + centerX - halfSize;
		int p2y = pCmpRelPrnt.getY() + centerY + halfSize;
		
		int p3x = pCmpRelPrnt.getX() + centerX + halfSize;
		int p3y = pCmpRelPrnt.getY() + centerY + halfSize;
		
		// Draw the filled triangle
		g.setColor(this.getColor());
		g.fillTriangle(p1x, p1y, p2x, p2y, p3x, p3y);
				
		// Draw the sequence number
		String seqNum = String.valueOf(this.sequenceNumber);
		g.setColor(ColorUtil.BLACK); // Set text color to contrast
				
		// Center the text on the flag
		int textWidth = g.getFont().stringWidth(seqNum);
		int textHeight = g.getFont().getHeight();
		g.drawString(seqNum, pCmpRelPrnt.getX() + centerX - (textWidth / 2), pCmpRelPrnt.getY() + centerY - (textHeight / 2));
	}
}
