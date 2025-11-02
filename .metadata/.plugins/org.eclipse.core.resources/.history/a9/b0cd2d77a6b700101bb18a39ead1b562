package com.mycompany.a1;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class HelpCommand extends Command {
	
	public HelpCommand() {
        super("Help");
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String helpInfo = "Key Bindings:\n\n" +
                          "  a   -  Accelerate\n" +
                          "  b   -  Brake\n" +
                          "  l   -  Turn Left\n" +
                          "  r   -  Turn Right\n" +
                          "  f   -  Collide with Food Station\n" +
                          "  g   -  Collide with Spider\n" +
                          "  t   -  Tick Game Clock";
        
        Dialog.show("Help", helpInfo, "Ok", null);
        System.out.println("Help command invoked.");
    }
}
