package temp;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class simpleFrame extends JFrame {
	public simpleFrame(int x,int y,int weight,int height){
		setLocation(x,y);
		applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
//		setLayout(null);
		setIconImage(new ImageIcon(this.getClass().getResource("/images/Ph2016.png")).getImage());
//		setUndecorated(true);
//		setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		pack();
		setSize(weight, height);
		setVisible(true);
	}
	public void addComponent(Component contents){
		revalidate();
		repaint();
		add(contents,BorderLayout.CENTER);
		revalidate();
		repaint();
	}
}
