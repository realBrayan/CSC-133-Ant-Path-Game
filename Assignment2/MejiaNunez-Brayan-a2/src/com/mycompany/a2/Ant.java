package com.mycompany.a2;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.models.Point;

public class Ant extends Moveable implements IFoodie {
	
	private int maximumSpeed; 
	private int foodConsumptionRate;
	private int healthLevel;
	private int lastFlagReached;
	private int foodLevel;
	
	private static final int ANT_COLOR = ColorUtil.rgb(255, 0, 0);
	private static final int INITIAL_SPEED = 5;
	
	private static Ant theAnt;
	
	private Ant() {
		super(100, new Point(100.0f, 100.0f), ANT_COLOR, 0, INITIAL_SPEED);
		
		this.maximumSpeed = 50;
		this.foodLevel = 10;
		this.healthLevel = 10;
		this.foodConsumptionRate = 2;
		this.lastFlagReached = 1;
		
	}
	
	public static Ant getInstance() {
		if (theAnt == null) {
			theAnt = new Ant();
		}
		
		return theAnt;
	}
	
	/*
	public Ant(Point startLocation, int size, int maxSpeed, int consumptionRate) {
		
		super(size, startLocation, ANT_COLOR, 0, INITIAL_SPEED);
		
		this.maximumSpeed = maxSpeed; // should be set to something like 50
		this.foodConsumptionRate = consumptionRate; // probably set it to something low, like 2 or 3
		this.healthLevel = 10;
		this.lastFlagReached = 1;	
	}
	*/
	
	public int getMaximumSpeed () {
		return this.maximumSpeed;
	}	
	
	public int getHealthLevel() {
		return this.healthLevel;
	}
	
	public int getLastFlagReached() {
		return this.lastFlagReached;
	}
	
	public int getFoodConsumptionRate() {
		return this.foodConsumptionRate;
	}
	
	public int getFoodLevel() {
		return this.foodLevel;
	}
	
	
	@Override
	public void setSpeed(int speed) {
		
		double healthPercentage = (double) this.healthLevel / 10.0;
		
		double currentMaxSpeed = this.maximumSpeed * healthPercentage;
		
		if (speed >= 0 && speed <= currentMaxSpeed) {
			
			super.setSpeed(speed);
			
		} else if (speed > currentMaxSpeed) {
			super.setSpeed((int)currentMaxSpeed);
		}
	}
	
	@Override
	public void setFoodConsumption(int rate) {
		if (rate >= 0) {
			this.foodConsumptionRate = rate;
		}
		else {
			System.out.println("Warning: Attempted to set negative food consumption rate.");
			System.out.println("New rate was ignored. Rate is still: " + this.getFoodConsumptionRate());
		}
	}
	
	public void fadeColor() {
		int currentRed = ColorUtil.red(this.getColor());
		int newRed = Math.max(0,  currentRed - 15);
		this.setColor(ColorUtil.rgb(newRed, 0, 0));
	}
	
	public void setHealthLevel(int newHealthLevel) {
		if (newHealthLevel >= 0 && newHealthLevel <= 10) {
			healthLevel = newHealthLevel;
			
			if (this.getSpeed() > this.maximumSpeed * (this.healthLevel / 10.0)) {
				setSpeed((int)(this.maximumSpeed * (this.healthLevel / 10.0)));
			}
		}
	}
	
	public void setLastFlagReached(int flag) {
		if ( flag > 0 && flag == lastFlagReached + 1) {
			lastFlagReached = flag;
		}
	}
	
	@Override
	public void setFoodLevel(int newFoodLevel) {
		this.foodLevel = Math.max(0,  newFoodLevel);
		if (this.foodLevel == 0) {
			setSpeed(0);
		}
	}
	
	// --- Ant Actions moved in from GameWorld ---
	
	public void accelerate() {
		if (foodLevel > 0 && healthLevel > 0) {
			
			int currSpeed = theAnt.getSpeed();
			theAnt.setSpeed(currSpeed + 5);
			System.out.println("Accelerating the Ant.");
		}
	}
	
	public void brake() {
		int currSpeed = theAnt.getSpeed();
		int newSpeed = Math.max(0, currSpeed - 5);
		theAnt.setSpeed(newSpeed);
		System.out.println("Braking the Ant.");
	}
	
	public void turnLeft() {
		int currHeading = theAnt.getHeading();
		theAnt.setHeading(currHeading - 5);
		System.out.println("Turning left.");
	}
	
	public void turnRight() {
		int currHeading = theAnt.getHeading();
		theAnt.setHeading(currHeading + 5);
		System.out.println("Turning right.");
	}
	
	public void collideWithFlag(int flagSequenceNumber) {
		theAnt.setLastFlagReached(flagSequenceNumber);
	}
	
	private void updateStateAfterMove() {
		setFoodLevel(theAnt.foodLevel - theAnt.foodConsumptionRate);
		
		if (foodLevel <= 0) {
			setSpeed(0);
		}
	}
	
	
	@Override
	public void move() { // might need to take in world boundaries to make sure ant doesn't run away here.
		if (healthLevel <= 0 || foodLevel <= 0) {
			if(getSpeed() != 0) {
				super.setSpeed(0);
			}
			return;
		}
		
		super.move();
		updateStateAfterMove();
	}
	
	
	@Override
	public String toString() {
		String parentString = super.toString();
		String myString = " maxSpeed=" + maximumSpeed +
						  " foodConsumptionRate=" + foodConsumptionRate + 
						  " healthLevel=" + healthLevel +
						  " lastFlagReached=" + lastFlagReached +
						  " foodLevel=" + foodLevel;
		return "Ant: " + parentString + myString;
	}
	
}
