package orderFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JPanel;

import temp.Frame;
import temp.Panel;

public class orderFrame extends Frame {
	public orderFrame(){
		Panel pane = new Panel();
		JPanel whitePane = new JPanel();
		whitePane.setBackground(Color.white);
		whitePane.setBounds(new Rectangle(new Point(0,0),new Dimension(500,770)));
		pane.add(whitePane);
		add(pane);
	}
}
