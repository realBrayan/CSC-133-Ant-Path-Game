package com.mycompany.a1.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a1.GameWorld;

public class FoodConsumptionCommand extends Command {
    private GameWorld gw; 

    public FoodConsumptionCommand(GameWorld gw) {
        super("Set Food Consumption");
        this.gw = gw;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        gw.changeAntConsumptionRate(); 
        
        System.out.println("Food Consumption command invoked.");
    }
}