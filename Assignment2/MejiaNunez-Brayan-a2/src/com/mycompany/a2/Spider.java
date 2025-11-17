package com.mycompany.a2;
import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import java.util.Random; 

public class Spider extends Moveable {
	
	private static final Random rand = new Random();
	
	public Spider() {
		
		super(generateRandomSize(), generateRandomLocation(), ColorUtil.BLACK, rand.nextInt(360), 5 + rand.nextInt(11));
		
	}
	
	private static int generateRandomSize() {
		return 10 + rand.nextInt(41);
	}
	
	private static Point generateRandomLocation() {
		float x = rand.nextFloat() * 1000.0f;
		float y = rand.nextFloat() * 1000.0f;
		return new Point(x, y);
	}
	
	
	@Override
	public void setFoodLevel(int foodLevel) {
		// dont update. Spiders aren't foodies so they cannot update foodlevels.
		System.out.println("Spiders cannot update their food levels.");
	}
	
	@Override
	public void setColor(int color) {
		// set to black no matter what c is.
		super.setColor(ColorUtil.BLACK);
	}	
	
	@Override
	public void move() {
		
        int headingChange = (rand.nextInt(11) - 5); // -5 to +5 degrees
        this.setHeading(this.getHeading() + headingChange);

        double angle = Math.toRadians(90 - this.getHeading());
        float deltaX = (float) (Math.cos(angle) * this.getSpeed());
        float deltaY = (float) (Math.sin(angle) * this.getSpeed());
        
        float newX = this.getLocation().getX() + deltaX;
        float newY = this.getLocation().getY() + deltaY;

       // Check for world boundaries. If out of bounds, change direction.
        if (newX < 0 || newX > 1000 || newY < 0 || newY > 1000) {
          
            this.setHeading(this.getHeading() + 180);
        } else {
            
            super.move();
        }
		
	}
	
	@Override
	public String toString() {
		return "Spider: " + super.toString();
	}
}
