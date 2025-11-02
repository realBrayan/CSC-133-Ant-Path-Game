package com.mycompany.a1;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;

public class Game extends Form{
	private GameWorld gw;
	private boolean isExitConfirmed = false;
	
	public Game() {
		gw = new GameWorld();
		gw.init();
		play();
		
	}
	
	private void play() {
		// code here to accept and 
		// execute user commands that
		// operate on the game world
		// (refer to "Appendix - CN1
		// Notes " Below for accepting
		// keyboard commands via a text
		// field located on the form
		
		Label myLabel = new Label("Enter a Command");
		this.addComponent(myLabel);
		final TextField myTextField = new TextField();
		this.addComponent(myTextField);
		this.show();
		
		myTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				String sCommand = myTextField.getText().toString();
				myTextField.clear();
				
				if (sCommand.length() == 0) {
					return;
				}
				
				if (isExitConfirmed) {
                    if (sCommand.equalsIgnoreCase("y")) {
                        gw.exitGame();
                    } else if (sCommand.equalsIgnoreCase("n")) {
                        isExitConfirmed = false;
                        System.out.println("Exit cancelled.");
                    } else {
                        System.out.println("Invalid confirmation. Please enter 'y' or 'n'.");
                    }
                    return; 
                }
				
				char commandChar = sCommand.charAt(0);
			
				switch (commandChar) {
					case 'a':
						gw.accelerateAnt();
						break; 
					case 'b':
						gw.brakeAnt();
						break;
					case 'l':
						gw.turnAntLeft();
						break;
					case 'r': 
						gw.turnAntRight();
						break;
					case 'c':
						gw.changeAntConsumptionRate();
						break;
		            case 'f':
		            	gw.pretendFoodCollision();		            	break;
		            case 'g':
		            	gw.pretendSpiderCollision();
		            	break;
		            case 't':
		            	gw.tickClock();
		            	break;
		            case 'd':
		            	gw.displayGameState();
		            	break;
		            case 'm':
		            	gw.outputMap();
		            	break;
		            case 'x':
		            	isExitConfirmed = true;
		            	System.out.println("Are you sure you want to exit? (y/n)");
		            	break;
		            default:
		            	// check if the command is a digit 1-9
		            	if (Character.isDigit(commandChar)) {
		            		
		            		String numStr = String.valueOf(commandChar);
		            		int flagNum = Integer.parseInt(numStr);
		            		
                            if (flagNum >= 1 && flagNum <= 9) {
                                gw.pretendFlagCollision(flagNum);
                            } else {
                                System.out.println("Error: Invalid command.");
                            }
                        } else {
                            System.out.println("Error: Invalid command.");
                        }
                        break;
				} // Switch
			} // actionPerformed
		});	// addActionListener
	} // play
}

