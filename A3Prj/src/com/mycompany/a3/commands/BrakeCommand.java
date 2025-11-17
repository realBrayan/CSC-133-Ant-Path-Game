package com.mycompany.a3.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class BrakeCommand extends Command {
	
	private GameWorld gw;
	
	public BrakeCommand(GameWorld gw) {
		super("Brake");
		this.gw = gw;
	}	
	
	@Override 
	public void actionPerformed(ActionEvent evt) {
		gw.brakeAnt();;
		
		System.out.println("Brake command invoked.");
	}
}
