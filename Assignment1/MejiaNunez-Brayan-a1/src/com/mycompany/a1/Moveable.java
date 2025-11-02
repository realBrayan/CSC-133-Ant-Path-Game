package com.mycompany.a1;
import com.codename1.charts.models.Point;

public class Moveable extends GameObject {
	
	private int heading;
	private int speed;
	private int foodLevel;
	
	public Moveable(int size, Point location,int color, int heading, int speed) {
		
		super(size, location, color);
		
		this.heading = (heading % 360 + 360) % 360;
		this.speed = speed;
		this.foodLevel = 20; // default starting food. Test this and chage if needed
		
	}
	
	public int getHeading() {
		return heading;
	}

	public int getSpeed() {
		return speed;
	}
	
	public int getFoodLevel() {
		return foodLevel;
	}
	
	public void setHeading(int heading) {
		// added logic hear to handle negative numbers and numbers over 360
		this.heading = (heading % 360 + 360) % 360;

	}
	
	public void setSpeed(int speed) {
		if (speed >= 0) {
			this.speed = speed;
		}
	}
	
	public void setFoodLevel(int foodLevel) {
		if (foodLevel >= 0) {
			this.foodLevel = foodLevel;
			
			if (foodLevel == 0) {
				this.speed = 0;
			}
		}
	}
	
	public void move() {
		// do math to make it's point move
		
		double angle = Math.toRadians(90 - this.heading);
		float deltaX = (float) (Math.cos(angle) * this.speed);
		float deltaY = (float) (Math.sin(angle) * this.speed);
		
		Point newLocation = new Point(
				this.getLocation().getX() + deltaX,
				this.getLocation().getY() + deltaY
				);
		
		this.setLocation(newLocation);
				
	}
	
	@Override
	public String toString() {
		String parentString = super.toString();
		String myString = " heading=" + heading + " speed=" + speed;
		return parentString + myString;
	}
}
