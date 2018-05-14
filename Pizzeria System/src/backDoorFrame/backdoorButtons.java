package backDoorFrame;
//import Frame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import temp.Panel;
import temp.PressedButton;
import backDoorFrame.listFrame;


public class backdoorButtons {
	public Component createComponents() {
		Panel pane = new Panel();
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
		PressedButton listOfEmployees = new PressedButton("/images/backDoorButtons/ListOfEmployees.png","/images/backDoorButtons/ListOfEmployees2.png");
		listOfEmployees.setMnemonic(KeyEvent.VK_I);
		listOfEmployees.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            		listFrame frame = new listFrame(1050,542);
            		Component contents = new listOfEmployeesContents().createComponents();
                    frame.add(contents, BorderLayout.CENTER);
    		        if (listOfEmployees.isSelected()) {
    		        	listOfEmployees.setIcon(new ImageIcon(this.getClass().getResource("/images/backDoorButtons/ListOfEmployees2.png")));
    		        	frame.setVisible(true);
    		        }
    		        else {
    		        	listOfEmployees.setIcon(new ImageIcon(this.getClass().getResource("/images/backDoorButtons/ListOfEmployees.png")));
    		        	frame.setVisible(false);
    		        }
            }
        });
		listOfEmployees.setBounds(new Rectangle(new Point(centerPoint.x+410, 20),new Dimension(250,150)));
    	pane.add(listOfEmployees);
		return pane;
	}
}
