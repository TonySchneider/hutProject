package generalFrame;
import java.awt.Component;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import temp.Button;
import temp.Frame;
import temp.Panel;
import temp.copyRightPanel;


public class generalFrame extends Frame {
	public generalFrame(){
		Component contents = new Contents().createComponents();
		Component generalButtons = new generalButtons().createComponents();
		Component activeEmployees = new activeEmployees().createComponents();
		Panel pane = new Panel();
		Button exit = new Button("/images/generalButtons/generalExit.png","/images/generalButtons/generalExit2.png");
		exit.setBounds(new Rectangle(new Point(1313, -2),exit.getPreferredSize()));
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		pane.add(exit);
		addComponent(contents);
		addComponent(generalButtons);
		addComponent(pane);
		addComponent(activeEmployees);

	}
	public static void main(String[] args) {
		generalFrame frame = new generalFrame();
	}
	
}
