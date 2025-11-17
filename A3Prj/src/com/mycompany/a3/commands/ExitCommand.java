package com.mycompany.a3.commands;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.events.ActionEvent;

public class ExitCommand extends Command {

    public ExitCommand() {
        super("Exit");
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
    	
        Command okCommand = new Command("Ok");
        Command cancelCommand = new Command("Cancel");
        
        Command result = Dialog.show("Confirm Exit", "Are you sure you want to exit?", okCommand, cancelCommand);

        // If the user clicked "Ok"
        if (result == okCommand) {
            System.out.println("Exit command invoked. Exiting application.");
            Display.getInstance().exitApplication(); 
        } else {
            System.out.println("Exit command cancelled.");
        }
    }
}
