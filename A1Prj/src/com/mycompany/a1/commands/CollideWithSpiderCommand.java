package com.mycompany.a1.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a1.GameWorld;

public class CollideWithSpiderCommand extends Command {

	private GameWorld gw;
	
	public CollideWithSpiderCommand(GameWorld gw) {
	    super("Collide with Spider");
	    this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
	    //gw.collideWithSpider();
	    gw.pretendSpiderCollision();
		
	    System.out.println("Collide with Spider command invoked.");
	}
}