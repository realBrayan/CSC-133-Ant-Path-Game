package com.mycompany.a3;

import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;

import com.codename1.ui.Toolbar;
import com.codename1.ui.Container;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.plaf.Border;

import com.mycompany.a3.commands.*;

@SuppressWarnings("unused")
public class Game extends Form{
	
	// --- MVC Components ---
	private GameWorld gw; 
	private MapView mv;
	private ScoreView sv;
	
	// --- Command Objects ---
	private AccelerateCommand accelCmd;
    private BrakeCommand brakeCmd;
    private LeftTurnCommand leftCmd;
    private RightTurnCommand rightCmd;
    private CollideWithFlagCommand flagCmd;
    private CollideWithFoodStationCommand foodCmd;
    private CollideWithSpiderCommand spiderCmd;
    private TickCommand tickCmd;
    private FoodConsumptionCommand foodConsumeCmd;
    private SoundCommand soundCmd;
    private AboutCommand aboutCmd;
    private HelpCommand helpCmd;
    private ExitCommand exitCmd;
	
	
	public Game() {
		//gw = new GameWorld();
		//gw.init();
		//play();
		
		this.setLayout(new BorderLayout());
		
		gw = new GameWorld();
		mv = new MapView();
		sv = new ScoreView();
		gw.addObserver(mv);
		gw.addObserver(sv);
		
		// --- Instantiate Commands ---
		accelCmd = new AccelerateCommand(gw);
        brakeCmd = new BrakeCommand(gw);
        leftCmd = new LeftTurnCommand(gw);
        rightCmd = new RightTurnCommand(gw);
        flagCmd = new CollideWithFlagCommand(gw);
        foodCmd = new CollideWithFoodStationCommand(gw);
        spiderCmd = new CollideWithSpiderCommand(gw);
        tickCmd = new TickCommand(gw);
        foodConsumeCmd = new FoodConsumptionCommand(gw);
        soundCmd = new SoundCommand(gw);
		aboutCmd = new AboutCommand();
		helpCmd = new HelpCommand();
		exitCmd = new ExitCommand();
		
		// --- Build GUI ---

        // -- Toolbar (Side Menu & Right Bar) --
        Toolbar tb = this.getToolbar();
        tb.setTitle("Ant-Path Game");

        // Side Menu: Add commands
        tb.addCommandToSideMenu(accelCmd);

        // Side Menu: Sound CheckBox
        CheckBox soundCheck = new CheckBox("Sound");
        soundCheck.getAllStyles().setBgTransparency(255);
        soundCheck.getAllStyles().setBgColor(ColorUtil.LTGRAY);
        soundCheck.setSelected(gw.isSoundOn()); // Set initial state
        soundCheck.setCommand(soundCmd); // Attach the command
        tb.addComponentToSideMenu(soundCheck); // Add the CheckBox component

        tb.addCommandToSideMenu(aboutCmd);
        tb.addCommandToSideMenu(exitCmd);

        // Right Bar: Add Help command
        tb.addCommandToRightBar(helpCmd);


        // -- Button Containers (WEST, EAST, SOUTH) --

        // WEST Container
        Container westContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        westContainer.getAllStyles().setBorder(Border.createLineBorder(1, ColorUtil.BLACK));
        
        Button accelButton = new Button("Accelerate");
        accelButton.setCommand(accelCmd); // Attach command instance
        westContainer.add(accelButton);
        
        Button leftButton = new Button("Left");
        leftButton.setCommand(leftCmd); // Attach command instance
        westContainer.add(leftButton);

        // EAST Container
        Container eastContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        eastContainer.getAllStyles().setBorder(Border.createLineBorder(1, ColorUtil.BLACK));

        Button brakeButton = new Button("Brake");
        brakeButton.setCommand(brakeCmd); // Attach command instance
        eastContainer.add(brakeButton);

        Button rightButton = new Button("Right");
        rightButton.setCommand(rightCmd); // Attach command instance
        eastContainer.add(rightButton);

        // SOUTH Container
        Container southContainer = new Container(new FlowLayout(CENTER));
        southContainer.getAllStyles().setBorder(Border.createLineBorder(1, ColorUtil.BLACK));
        
        Button flagButton = new Button("Collide with Flag");
        flagButton.setCommand(flagCmd); // Attach command instance
        southContainer.add(flagButton);
        
        Button spiderButton = new Button("Collide with Spider");
        spiderButton.setCommand(spiderCmd); // Attach command instance
        southContainer.add(spiderButton);
        
        Button foodButton = new Button("Collide with Food");
        foodButton.setCommand(foodCmd); // Attach command instance
        southContainer.add(foodButton);
        
        Button tickButton = new Button("Tick");
        tickButton.setCommand(tickCmd); // Attach command instance
        southContainer.add(tickButton);
        
        // --- Button Styling ---
        styleButton(accelButton);
        styleButton(leftButton);
        styleButton(brakeButton);
        styleButton(rightButton);
        styleButton(flagButton);
        styleButton(spiderButton);
        styleButton(foodButton);
        styleButton(tickButton);
        
        
        // -- Add Containers and Views to Form --
        this.add(BorderLayout.NORTH, sv);  // ScoreView goes at the top
        this.add(BorderLayout.CENTER, mv); // MapView goes in the middle
        this.add(BorderLayout.WEST, westContainer);  // West buttons
        this.add(BorderLayout.EAST, eastContainer);  // East buttons
        this.add(BorderLayout.SOUTH, southContainer); // South buttons


        // -- Key Bindings --
        this.addKeyListener('a', accelCmd);
        this.addKeyListener('b', brakeCmd);
        this.addKeyListener('l', leftCmd);
        this.addKeyListener('r', rightCmd);
        this.addKeyListener('f', foodCmd);
        this.addKeyListener('g', spiderCmd);
        this.addKeyListener('t', tickCmd);
        this.addKeyListener('c', foodConsumeCmd);
        this.addKeyListener('x', exitCmd); 


        this.show();

        // Set GameWorld size based on MapView's actual size 
        gw.setWorldSize(mv.getWidth(), mv.getHeight());

        gw.init();
		
	}
	
	private void styleButton(Button b) {
        b.getAllStyles().setBgTransparency(255); 
        b.getAllStyles().setBgColor(ColorUtil.BLUE); 
        b.getAllStyles().setFgColor(ColorUtil.WHITE); 
        b.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK)); 
        b.getAllStyles().setPadding(3, 3, 3, 3); 
    }
}

