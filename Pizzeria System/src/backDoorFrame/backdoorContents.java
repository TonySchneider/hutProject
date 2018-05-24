package backDoorFrame;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import temp.Button;
import temp.Panel;
import temp.PressedButton;


public class backdoorContents extends Panel {
	ButtonGroup group;
	public backdoorContents(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screenSize.getWidth();
		int height = (int)screenSize.getHeight();
		group = new ButtonGroup();
		PressedButton listOfEmployees = new PressedButton("/images/backDoorButtons/ListOfEmployees.png","/images/backDoorButtons/ListOfEmployees2.png");
		group.add(listOfEmployees);
		listOfEmployees.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            		listOfEmployeesPane employeesPanel = new listOfEmployeesPane();
            		employeesPanel.setBounds(new Rectangle(new Point(width/2-(int)(employeesPanel.getPreferredSize().height/1.5),250),employeesPanel.getPreferredSize()));
            		add(employeesPanel);
            		employeesPanel.refreshPane();
    		        if (listOfEmployees.isSelected()) {
    		        	listOfEmployees.setIcon(new ImageIcon(this.getClass().getResource("/images/backDoorButtons/ListOfEmployees2.png")));
    		        	}
    		        else {
    		        	listOfEmployees.setIcon(new ImageIcon(this.getClass().getResource("/images/backDoorButtons/ListOfEmployees.png")));
    		        	}
            }
        });
		listOfEmployees.setBounds(new Rectangle(new Point(width-20-listOfEmployees.getWidth(), 40),listOfEmployees.getPreferredSize()));
		Button returnButton = new Button("/images/backDoorButtons/return.png","/images/backDoorButtons/return2.png");
    	returnButton.setMnemonic(KeyEvent.VK_I);
    	returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	backdoorFrame.unVisible();
            }
        });
    	returnButton.setBounds(new Rectangle(new Point(20, height-returnButton.getHeight()-50),returnButton.getPreferredSize()));
    	add(returnButton);
    	add(listOfEmployees);
	}
	public void refreshPane(){
		setVisible(false);
		setVisible(true);
	}
	public void refreshRemove(){
		removeAll();
	}
}
