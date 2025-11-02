package com.mycompany.a1;
import com.codename1.charts.models.Point;
import java.util.Random;
import com.codename1.charts.util.ColorUtil;

public class FoodStation extends Fixed {

	private int capacity;
	private static final Random rand = new Random();
		
	public FoodStation() {
		
		super(generateRandomSize(), generateRandomLocation(), ColorUtil.GREEN);
		
		this.capacity = this.getSize();
	}
	
	private static int generateRandomSize() {
		return 10 + rand.nextInt(41); 
	}
	
	private static Point generateRandomLocation() {
		
		float x = rand.nextFloat() * 1000.0f;
		float y = rand.nextFloat() * 1000.0f;
		
		return new Point(x,y);
	}
	
	
	public int getCapacity() {
		return this.capacity;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	@Override
	public String toString() {
		
		String parentString = super.toString();
		String myString = " capacity=" + this.capacity;
		
		return "FoodStation: " + parentString + myString;
	}
	
}
