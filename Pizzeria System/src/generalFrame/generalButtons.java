package generalFrame;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import orderFrame.orderFrame;
import login.loginFrame;
import temp.*;
import backDoorFrame.backDoorManagerPass;
public class generalButtons {
	public Component createComponents() {
		Panel pane = new Panel();
		pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
//		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//        Point centerPoint = ge.getCenterPoint();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screenSize.getWidth();
		int height = (int)screenSize.getHeight();
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
		SearchOrderButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
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
		TakeAwayButton.setBounds(new Rectangle(new Point(width-300-TakeAwayButton.getWidth(), 70),TakeAwayButton.getPreferredSize()));
		TakeAwayPlaceButton.setBounds(new Rectangle(new Point(width-20-TakeAwayButton.getWidth(), 70),TakeAwayPlaceButton.getPreferredSize()));
		ShipOrdersButton.setBounds(new Rectangle(new Point(300, 70),ShipOrdersButton.getPreferredSize()));
		PlaceOrdersButton.setBounds(new Rectangle(new Point(20, 70),PlaceOrdersButton.getPreferredSize()));
		LoginButton.setBounds(new Rectangle(new Point(width-20-LoginButton.getWidth(), height/2-LoginButton.getHeight()/2),LoginButton.getPreferredSize()));
		BackDoorButton.setBounds(new Rectangle(new Point(20, height-BackDoorButton.getHeight()-50),BackDoorButton.getPreferredSize()));
		OpenChashButton.setBounds(new Rectangle(new Point(width-20-OpenChashButton.getWidth(), height-OpenChashButton.getHeight()-50),OpenChashButton.getPreferredSize()));
		SearchOrderButton.setBounds(new Rectangle(new Point(20, height/2-SearchOrderButton.getHeight()/2),SearchOrderButton.getPreferredSize()));
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
