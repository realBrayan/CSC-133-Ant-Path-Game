package com.mycompany.a1;

import java.util.Random;
import com.codename1.charts.util.ColorUtil;

public class FoodStation extends Fixed {

	private int capacity;
	private boolean empty;
		
	public FoodStation() {
		// TODO Auto-generated constructor stub
		
		Random rand = new Random();
		
		int randomSize = 10 + rand.nextInt(40);
		
		this.setSize(randomSize);
		capacity = this.getSize() * 10;
		
		this.setColor(ColorUtil.GREEN);
		
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void setCapacity(int eaten) {
		capacity -= eaten;
	}
	
	public boolean isEmpty() {
		return empty;
	}
	
	public void setEmpty() {
		empty = true;
	}
	
}
