package orderFrame;

import generalFrame.Contents;
import generalFrame.generalFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JPanel;

import temp.BackGroundPanel;
import temp.Frame;
import temp.Panel;

public class orderFrame{
	private static Frame frame;
	public orderFrame(){
		frame = new Frame();
		BackGroundPanel background = new BackGroundPanel(new BorderLayout(),"/images/ORDERBACKGROUND.png");
		frame.setContentPane(background);
		
		Component contents = new orderContents().createComponents();
		frame.addComponent(contents);
	}
	public static void unVisible(){
		frame.setVisible(false);
	}
	public static void disable(){
		frame.setEnabled(false);
	}
	public static void enable(){
		frame.setEnabled(true);
	}
}
