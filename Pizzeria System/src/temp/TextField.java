package temp;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JTextField;

public class TextField extends JTextField {
	public TextField(int x,int y,int weight, int height){
		setBounds(new Rectangle(new Point(x, y),new Dimension(weight,height)));
    	setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	}
}	
