package generalFrame;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import temp.Button;
import temp.Panel;


public class Contents extends JFrame {
	public Panel pane;
	public Component createComponents() {
		pane = new Panel();
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
		JLabel HutLogo = new JLabel();
		HutLogo.setIcon(new ImageIcon(this.getClass().getResource("/images/Pizza_Hut.png")));
		HutLogo.setBounds(new Rectangle(new Point(centerPoint.x-130,0), new Dimension(250,255)));
		JLabel background2 = new JLabel();
		background2.setIcon(new ImageIcon(this.getClass().getResource("/images/background2.png")));
		background2.setBounds(new Rectangle(new Point(320,260), new Dimension(737,460)));
		Button exit = new Button("/images/generalButtons/generalExit.png","/images/generalButtons/generalExit2.png");
		exit.setBounds(new Rectangle(new Point(1313, -2),exit.getPreferredSize()));
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				generalFrame.unVisible();
			}
		});
		pane.add(exit);
		pane.add(background2);
		pane.add(HutLogo);
		return pane;
	}
}
