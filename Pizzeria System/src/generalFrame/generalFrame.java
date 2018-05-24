package generalFrame;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import temp.BackGroundPanel;
import temp.Button;
import temp.DateAndTime;
import temp.Frame;
import temp.Panel;
import temp.copyRightPanel;


public class generalFrame {
	private static Frame frame;
	public generalFrame(){
		frame = new Frame();
		BackGroundPanel background = new BackGroundPanel(new BorderLayout(),"/images/background.png");
		frame.setContentPane(background);
		Component contents = new Contents().createComponents();
		Component generalButtons = new generalButtons().createComponents();
		Component activeEmployees = new activeEmployees().createComponents();
		frame.addComponent(contents);
		frame.addComponent(generalButtons);
		frame.addComponent(activeEmployees);
		frame.addComponent(new DateAndTime().createComponents());
	}
	public static void unVisible(){
		frame.setVisible(false);
	}
	public static void main(String[] args) {
		generalFrame frame = new generalFrame();
	}
	public static void disable(){
		frame.setEnabled(false);
	}
	public static void enable(){
		frame.setEnabled(true);
	}
}
