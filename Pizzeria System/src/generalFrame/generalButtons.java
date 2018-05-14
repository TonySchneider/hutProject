package generalFrame;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.Timer;

import orderFrame.orderFrame;
import login.loginFrame;
import temp.*;
import backDoorFrame.backDoorManagerPass;
import backDoorFrame.backdoorFrame;
public class generalButtons {
	public Component createComponents() {
		Panel pane = new Panel();
		pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
		Button TakeAwayButton = new Button("/images/generalButtons/TakeAwayButton.png","/images/generalButtons/TakeAwayButton2.png");
		TakeAwayButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				orderFrame orderframe = new orderFrame();
				
			}
		});
		Button TakeAwayPlaceButton = new Button("/images/generalButtons/TakeAwayPlace.png","/images/generalButtons/TakeAwayPlace2.png");
		Button ShipOrdersButton = new Button("/images/generalButtons/ShipOrders.png","/images/generalButtons/ShipOrders2.png");
		Button PlaceOrdersButton = new Button("/images/generalButtons/PlaceOrders.png","/images/generalButtons/PlaceOrders2.png");
		Button SearchOrderButton = new Button("/images/generalButtons/SearchOrder.png","/images/generalButtons/SearchOrder2.png");
		Button OpenChashButton = new Button("/images/generalButtons/OpenCash.png","/images/generalButtons/OpenCash2.png");
		OpenChashButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cashOpenManagerPass pass = new cashOpenManagerPass(530,200,300,150);
				pass.setAlwaysOnTop(true);
			}
		});
		Button LoginButton = new Button("/images/generalButtons/login.png","/images/generalButtons/login2.png");
		LoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	loginFrame frame = new loginFrame(430,200,500,500);
            	frame.setAlwaysOnTop(true);
            }
        });
		Button BackDoorButton = new Button("/images/generalButtons/BackDoor.png","/images/generalButtons/BackDoor2.png");
		BackDoorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	backDoorManagerPass pass = new backDoorManagerPass(530,200,300,150);
            	pass.setAlwaysOnTop(true);
            }
        });
		TakeAwayButton.setBounds(new Rectangle(new Point(centerPoint.x+130, 70),new Dimension(250,150)));
		TakeAwayPlaceButton.setBounds(new Rectangle(new Point(centerPoint.x+410, 70),new Dimension(250,150)));
		ShipOrdersButton.setBounds(new Rectangle(new Point(300, 70),new Dimension(250,150)));
		PlaceOrdersButton.setBounds(new Rectangle(new Point(20, 70),new Dimension(250,150)));
		LoginButton.setBounds(new Rectangle(new Point(centerPoint.x+410, 280),new Dimension(250,150)));
		BackDoorButton.setBounds(new Rectangle(new Point(20, 520),new Dimension(250,150)));
		OpenChashButton.setBounds(new Rectangle(new Point(centerPoint.x+410, 520),new Dimension(250,150)));
		SearchOrderButton.setBounds(new Rectangle(new Point(20, 280),new Dimension(250,150)));
		pane.add(TakeAwayPlaceButton);
		pane.add(TakeAwayButton);
		pane.add(ShipOrdersButton);
		pane.add(PlaceOrdersButton);
		pane.add(LoginButton);
		pane.add(BackDoorButton);
		pane.add(OpenChashButton);
		pane.add(SearchOrderButton);
		return pane;
	}
	
}
