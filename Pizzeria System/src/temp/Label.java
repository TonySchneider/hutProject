package temp;

import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JLabel;

public class Label extends JLabel {
	public Label(String text,int x,int y){
		setText(text);
    	setBounds(new Rectangle(new Point(x, y),this.getPreferredSize()));
	}
}
