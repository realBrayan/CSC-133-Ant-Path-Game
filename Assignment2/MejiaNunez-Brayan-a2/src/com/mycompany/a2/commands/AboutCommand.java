package com.mycompany.a2.commands;

import com.codename1.ui.Command;import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class AboutCommand extends Command {
	
	public AboutCommand() {
        super("About");
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String aboutInfo = "Ant Game\n" +
                           "Author: Brayan Mejia Nunez\n" +
                           "Course: CSC 133, Fall 2025\n" +
                           "Version: 0.2";
        
        Dialog.show("About", aboutInfo, "Ok", null);
        System.out.println("About command invoked.");
    }
}
