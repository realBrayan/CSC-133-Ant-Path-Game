package com.mycompany.a1;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import java.lang.String;

public class Game extends Form{
	private GameWorld gw;
	
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
				if(sCommand.length() != 0)
					
					command = sCommand.charAt(0);
				
					switch (command) {
					case 'a':
						gw.accelerate();
						break; 
					case 'b':
						// do b
						break;
					case 'i':
						// do i
						break;
					case 'r': 
						// do r
						break;
					case 'c':
						// do c
						break;
					case '1':
		            case '2':
		            case '3':
		            case '4':
		            case '5':
		            case '6':
		            case '7':
		            case '8':
		            case '9': 
		            	// do nums
		            	break;
		            case 'f':
		            	//do f
		            	break;
		            case 'g':
		            	// do g
		            	break;
		            case 't':
		            	// do t
		            	break;
		            case 'd':
		            	// do d
		            	break;
		            case 'm':
		            	// do m
		            	break;
		            case 'x':
		            	// do m
		            	break;
		            case 'y':
		            	// do m
		            	break;
		            case 'n':
		            	// do m
		            	break;
					} // switch
			}// actionPerformed
		}	// new ActionLestener()
		);	// addActionListener
	} 		// play
}
