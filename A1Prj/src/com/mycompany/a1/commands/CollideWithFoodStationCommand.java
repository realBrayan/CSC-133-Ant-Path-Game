package com.mycompany.a1.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a1.GameWorld;

public class CollideWithFoodStationCommand extends Command {
	
	private GameWorld gw;

    public CollideWithFoodStationCommand(GameWorld gw) {
        super("Collide with Food Station");
        this.gw = gw;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        //gw.collideWithFoodStation();
        gw.pretendFoodCollision();
        
        System.out.println("Collide with Food Station command invoked.");
    }
	
}
