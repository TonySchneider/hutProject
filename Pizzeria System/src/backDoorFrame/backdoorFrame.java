package backDoorFrame;
import generalFrame.Contents;
import generalFrame.activeEmployees;
import generalFrame.generalButtons;

import java.awt.BorderLayout;
import java.awt.Component;

import temp.BackGroundPanel;
import temp.DateAndTime;
import temp.Frame;

public class backdoorFrame {
	private static Frame frame;
	public backdoorFrame(){
		frame = new Frame();
		BackGroundPanel background = new BackGroundPanel(new BorderLayout(),"/images/BDbackground.png");
		backdoorContents generalPanel = new backdoorContents();
		frame.setContentPane(background);
		frame.addComponent(new DateAndTime().createComponents());
    	frame.addComponent(generalPanel);
	}
	public static void unVisible(){
		frame.dispose();
	}
}
