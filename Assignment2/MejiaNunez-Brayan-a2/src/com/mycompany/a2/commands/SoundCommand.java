package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.CheckBox;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class SoundCommand extends Command {
	
	private GameWorld gw;

    public SoundCommand(GameWorld gw) {
        super("Sound");
        this.gw = gw;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        
    	// We get the source of the event, which should be the CheckBox
        if (evt.getComponent() instanceof CheckBox) {
            CheckBox chk = (CheckBox) evt.getComponent();
            
            // Set the sound in GameWorld based on the CheckBox's state
            boolean isSoundOn = chk.isSelected();
            gw.setSound(isSoundOn);
            
            System.out.println("Sound command invoked. Sound is now " + (isSoundOn ? "ON" : "OFF"));
        }
    }
}
