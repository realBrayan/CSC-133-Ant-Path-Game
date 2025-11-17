package com.mycompany.a3;

import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.charts.util.ColorUtil;
import java.util.Observer;
import java.util.Observable;

public class ScoreView extends Container implements Observer {
	
	private Label timeLabel;
	private Label livesLabel;
	private Label lastFlagLabel;
    private Label foodLevelLabel;
    private Label healthLevelLabel;
    private Label soundLabel;
    
    public ScoreView() {
    	this.setLayout(new FlowLayout(CENTER));
    	
    	timeLabel = new Label("Time: 0");
    	livesLabel = new Label("Lives: 3"); // Assuming 3 initial lives
        lastFlagLabel = new Label("Last Flag Reached: 1"); // Assuming start at flag 1
        foodLevelLabel = new Label("Food Level: 10"); // Assuming 10 initial food level
        healthLevelLabel = new Label("Health Level: 10"); // Assuming 10 initial health
        soundLabel = new Label("Sound: OFF"); // Sound starts OFF 
    	
        int textColor = ColorUtil.BLUE;
        timeLabel.getAllStyles().setFgColor(textColor);
        livesLabel.getAllStyles().setFgColor(textColor);
        lastFlagLabel.getAllStyles().setFgColor(textColor);
        foodLevelLabel.getAllStyles().setFgColor(textColor);
        healthLevelLabel.getAllStyles().setFgColor(textColor);
        soundLabel.getAllStyles().setFgColor(textColor);
        
        timeLabel.getAllStyles().setPaddingRight(2);
        livesLabel.getAllStyles().setPaddingRight(2);
        lastFlagLabel.getAllStyles().setPaddingRight(2);
        foodLevelLabel.getAllStyles().setPaddingRight(2);
        healthLevelLabel.getAllStyles().setPaddingRight(2);
        
        this.add(timeLabel);
        this.add(livesLabel);
        this.add(lastFlagLabel);
        this.add(foodLevelLabel);
        this.add(healthLevelLabel);
        this.add(soundLabel);
    }
    
    
    
	
	@Override
	public void update(Observable observable, Object arg) {
		
		if (observable instanceof GameWorld) {
			GameWorld gw = (GameWorld) observable;
			
			int time = gw.getClock();
            int lives = gw.getLives();
            int lastFlag = gw.getAntLastFlagReached();
            int foodLevel = gw.getAntFoodLevel();
            int healthLevel = gw.getAntHealthLevel();
            boolean soundState = gw.isSoundOn();
            
            timeLabel.setText("Time: " + time);
            livesLabel.setText("Lives: " + lives);
            lastFlagLabel.setText("Last Flag Reached: " + lastFlag);
            foodLevelLabel.setText("Food Level: " + foodLevel);
            healthLevelLabel.setText("Health Level: " + healthLevel);
            soundLabel.setText("Sound: " + (soundState ? "ON" : "OFF"));
            
            this.revalidate();
		}
		
	}

}
