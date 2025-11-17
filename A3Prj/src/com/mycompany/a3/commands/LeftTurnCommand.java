package com.mycompany.a3.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class LeftTurnCommand extends Command {
	
	private GameWorld gw;
	
	public LeftTurnCommand(GameWorld gw) {
		super("Left");
		this.gw = gw;
	}
	
	
	@Override 
	public void actionPerformed(ActionEvent evt) {
		gw.turnAntLeft();
		
		System.out.println("Left Turn command invoked.");
	}
	
}
