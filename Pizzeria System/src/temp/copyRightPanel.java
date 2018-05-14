package temp;
import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JLabel;


public class copyRightPanel extends Panel {
	public Component createComponents(){
		JLabel copyright = new JLabel("copyright");
		copyright.setText("Powered by TonySchneider");
		copyright.setForeground(Color.white);
		copyright.setBounds(new Rectangle(new Point(25,735), copyright.getPreferredSize()));
		add(copyright);
		return this;
	}
}
