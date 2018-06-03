package orderFrame;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import temp.Panel;
import temp.PressedButton;
import temp.TextField;

public class orderContents {
	private static Panel pane;
	public Component createComponents(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screenSize.getWidth();
		int height = (int)screenSize.getHeight();
		pane = new Panel();
		TextField choosingItem = new TextField((int)(width/3.5),3,480,37);
		choosingItem.setEditable(false);
		ButtonGroup group = new ButtonGroup();
		PressedButton pizzes = new PressedButton("/images/orderFrame/pizzes.png","/images/orderFrame/pizzes2.png");
		pizzes.setBounds(new Rectangle(new Point(width-(int)(pizzes.getWidth()*1.3),height-pizzes.getWidth()*3),pizzes.getPreferredSize()));
		group.add(pizzes);
		PressedButton salads = new PressedButton("/images/orderFrame/salads.png","/images/orderFrame/salads2.png");
		salads.setBounds(new Rectangle(new Point(width-(int)(salads.getWidth()*1.3),height/2-salads.getWidth()/3),salads.getPreferredSize()));
		group.add(salads);
		PressedButton deserts = new PressedButton("/images/orderFrame/deserts.png","/images/orderFrame/deserts2.png");
		deserts.setBounds(new Rectangle(new Point(width-(int)(deserts.getWidth()*1.3),height-deserts.getWidth()),deserts.getPreferredSize()));
		group.add(deserts);
		PressedButton dishes = new PressedButton("/images/orderFrame/dishes.png","/images/orderFrame/dishes2.png");
		dishes.setBounds(new Rectangle(new Point(width-(int)(dishes.getWidth()*1.3),height-dishes.getWidth()),dishes.getPreferredSize()));
		group.add(dishes);
		pizzes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//            		employeesPanel.setBounds(new Rectangle(new Point(width/2-(int)(employeesPanel.getPreferredSize().height/1.5),250),employeesPanel.getPreferredSize()));
//            		add(employeesPanel);
//            		employeesPanel.refreshPane();
    		        if (pizzes.isSelected()) {
//    		        	remove(costumersPanel);
//    		        	refreshPane();
//    		        	listOfCostumers.setIcon(new ImageIcon(this.getClass().getResource("/images/backDoorButtons/ListOfCostumers.png")));
    		        	pizzes.setIcon(new ImageIcon(this.getClass().getResource("/images/orderFrame/pizzes2.png")));
    		        	salads.setIcon(new ImageIcon(this.getClass().getResource("/images/orderFrame/salads.png")));
    		        	deserts.setIcon(new ImageIcon(this.getClass().getResource("/images/orderFrame/deserts.png")));
    		        	dishes.setIcon(new ImageIcon(this.getClass().getResource("/images/orderFrame/dishes.png")));
    		        	}
            }
        });
		salads.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//            		employeesPanel.setBounds(new Rectangle(new Point(width/2-(int)(employeesPanel.getPreferredSize().height/1.5),250),employeesPanel.getPreferredSize()));
//            		add(employeesPanel);
//            		employeesPanel.refreshPane();
    		        if (salads.isSelected()) {
//    		        	remove(costumersPanel);
//    		        	refreshPane();
//    		        	listOfCostumers.setIcon(new ImageIcon(this.getClass().getResource("/images/backDoorButtons/ListOfCostumers.png")));
    		        	salads.setIcon(new ImageIcon(this.getClass().getResource("/images/orderFrame/salads2.png")));
    		        	pizzes.setIcon(new ImageIcon(this.getClass().getResource("/images/orderFrame/pizzes.png")));
    		        	deserts.setIcon(new ImageIcon(this.getClass().getResource("/images/orderFrame/deserts.png")));
    		        	dishes.setIcon(new ImageIcon(this.getClass().getResource("/images/orderFrame/dishes.png")));
    		        	}
            }
        });
		deserts.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//            		employeesPanel.setBounds(new Rectangle(new Point(width/2-(int)(employeesPanel.getPreferredSize().height/1.5),250),employeesPanel.getPreferredSize()));
//            		add(employeesPanel);
//            		employeesPanel.refreshPane();
    		        if (deserts.isSelected()) {
//    		        	remove(costumersPanel);
//    		        	refreshPane();
//    		        	listOfCostumers.setIcon(new ImageIcon(this.getClass().getResource("/images/backDoorButtons/ListOfCostumers.png")));
    		        	deserts.setIcon(new ImageIcon(this.getClass().getResource("/images/orderFrame/deserts2.png")));
    		        	pizzes.setIcon(new ImageIcon(this.getClass().getResource("/images/orderFrame/pizzes.png")));
    		        	salads.setIcon(new ImageIcon(this.getClass().getResource("/images/orderFrame/salads.png")));
    		        	dishes.setIcon(new ImageIcon(this.getClass().getResource("/images/orderFrame/dishes.png")));
    		        	}
            }
        });
		dishes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//            		employeesPanel.setBounds(new Rectangle(new Point(width/2-(int)(employeesPanel.getPreferredSize().height/1.5),250),employeesPanel.getPreferredSize()));
//            		add(employeesPanel);
//            		employeesPanel.refreshPane();
    		        if (dishes.isSelected()) {
//    		        	remove(costumersPanel);
//    		        	refreshPane();
//    		        	listOfCostumers.setIcon(new ImageIcon(this.getClass().getResource("/images/backDoorButtons/ListOfCostumers.png")));
    		        	dishes.setIcon(new ImageIcon(this.getClass().getResource("/images/orderFrame/dishes2.png")));
    		        	pizzes.setIcon(new ImageIcon(this.getClass().getResource("/images/orderFrame/pizzes.png")));
    		        	salads.setIcon(new ImageIcon(this.getClass().getResource("/images/orderFrame/salads.png")));
    		        	deserts.setIcon(new ImageIcon(this.getClass().getResource("/images/orderFrame/deserts.png")));
    		        	}
            }
        });
		pane.add(pizzes);
		pane.add(salads);
		pane.add(deserts);
		pane.add(dishes);
		pane.add(choosingItem);
		return pane;
	}
}
