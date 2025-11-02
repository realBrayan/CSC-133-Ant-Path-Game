package com.mycompany.a1;

import com.codename1.ui.Container;
import com.codename1.ui.plaf.Border; 
import com.codename1.charts.util.ColorUtil; 
import java.util.Observer;
import java.util.Observable;


public class MapView extends Container implements Observer{

	public MapView() {
		this.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.rgb(255,  0,  0)));
	}
	
	
	
	
	@Override
	public void update(Observable observable, Object data) {
		if (observable instanceof GameWorld) {
			GameWorld gw = (GameWorld) observable;
			
			gw.outputMap();
		}
		
	}

}
