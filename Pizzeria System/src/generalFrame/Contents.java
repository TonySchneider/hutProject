package generalFrame;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import temp.Button;
import temp.Panel;
import temp.labelImage;


public class Contents {
	public Panel pane;
	public Component createComponents() {
		pane = new Panel();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screenSize.getWidth();
		int height = (int)screenSize.getHeight();
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
//        labelImage HutLogo = new labelImage("/images/Pizza_Hut.png");
//		HutLogo.setBounds(new Rectangle(new Point(width/2-HutLogo.getWidth()/2,0), HutLogo.getPreferredSize()));
//		labelImage background2 = new labelImage("/images/background2.png");
//		background2.setBounds(new Rectangle(new Point(width/2-background2.getWidth()/2,height/3), background2.getPreferredSize()));
		Button exit = new Button("/images/generalButtons/generalExit.png","/images/generalButtons/generalExit2.png");
		exit.setBounds(new Rectangle(new Point(width-exit.getWidth(), 0),exit.getPreferredSize()));
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//int result = JOptionPane.showConfirmDialog(null, "האם אתה בטוח שברצונך לצאת?", null, JOptionPane.YES_NO_OPTION,null,options,null);
				Object[] options = { "כן", "לא" };
				JOptionPane dialog = new JOptionPane();
				int result = dialog.showOptionDialog(null, "האם אתה בטוח שברצונך לצאת?", null,JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
				dialog.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				//int result = JOptionPane.showOptionDialog(null, "האם אתה בטוח שברצונך לצאת?", null,JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
				if(result == JOptionPane.YES_OPTION){
					generalFrame.unVisible();
				}
			}
		});
		pane.add(exit);
//		pane.add(background2);
//		pane.add(HutLogo);
		return pane;
	}
}
