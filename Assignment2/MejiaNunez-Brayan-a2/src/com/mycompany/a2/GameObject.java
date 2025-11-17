package com.mycompany.a2;
import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

public abstract class GameObject {
	
	private int size;
	private Point location;
	private int color;
	
	public GameObject(int size, Point location, int color) {
		this.size = size;
		this.location = location;
		this.color = color;
	}
	
	
	public int getSize() {
		return this.size;
	}
	
	public Point getLocation() {
		return this.location;
	}
	
	public int getColor() {
		return this.color;
	}
	
	public void setLocation(Point newLocation) {
		
		if (newLocation.getX() >= 0.0f && newLocation.getX() <= 1000.0f && newLocation.getY() >= 0.0f && newLocation.getY() <= 1000.0f) {
            this.location = newLocation;
        }
	}
	
	public void setColor(int newColor) {
		this.color = newColor;
	}
	
	@Override
	public String toString() {
		
		double roundedX = Math.round(location.getX() * 10.0) / 10.0;
		double roundedY = Math.round(location.getY() * 10.0) / 10.0;
		
		String colorStr = "color=[" + ColorUtil.red(color) + "," + ColorUtil.green(color) + "," + ColorUtil.blue(color) + "]";
		
		return "loc=" + roundedX + "," + roundedY + " " + colorStr + " " + "size=" + size;
		
	}
	
}
