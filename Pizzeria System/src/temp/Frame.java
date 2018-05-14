package temp;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;


public class Frame extends JFrame {
		private BackGroundPanel background;
		public Frame(){
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			setMaximumSize(new Dimension(dim.width,dim.height));
			setLayout(null);
	    	background = new BackGroundPanel(new BorderLayout(),"/images/BACKGROUND.png");
//	    	Image image = new ImageIcon(this.getClass().getResource("/images/BACKGROUND.png")).getImage();
			setIconImage(new ImageIcon(this.getClass().getResource("/images/Ph2016.png")).getImage());
			setContentPane(background);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setUndecorated(true);
			pack();
			setExtendedState(JFrame.MAXIMIZED_BOTH); 
			setSize(600, 400);
			setVisible(true);
			addComponent(new DateAndTime().createComponents());
			addComponent(new copyRightPanel().createComponents());
		}
	public void addComponent(Component contents){
		revalidate();
		repaint();
		add(contents);
		revalidate();
		repaint();
	}
//	public Component createComponents() {
//		Panel pane = new Panel();
//		JLabel copyright = new JLabel("copyright");
//		copyright.setText("Powered by TonySchneider");
//		copyright.setForeground(Color.white);
//		copyright.setBounds(new Rectangle(new Point(25,735), copyright.getPreferredSize()));
//		pane.add(copyright);
//		return pane;
//	}
}
