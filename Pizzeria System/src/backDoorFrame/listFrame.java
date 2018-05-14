package backDoorFrame;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import temp.BackGroundPanel;

public class listFrame extends JFrame {
	private BackGroundPanel background;
	public listFrame(int x,int y){
		background = new BackGroundPanel(new BorderLayout(),"/images/backDoorButtons/backgroundLists.png");
		setLocation(300,200);
		setIconImage(new ImageIcon(this.getClass().getResource("/images/Ph2016.png")).getImage());
		setContentPane(background);
		setUndecorated(true);
		pack();
		setSize(x, y);
	}
	public void addComponent(Component contents){
		revalidate();
		repaint();
		add(contents,BorderLayout.CENTER);
		revalidate();
		repaint();
	}
}
