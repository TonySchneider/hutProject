package temp;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JFormattedTextField;
import javax.swing.text.NumberFormatter;

public class FormattedTextField extends JFormattedTextField {
	public FormattedTextField(NumberFormatter z,int x,int y,int weight, int height){
		super(z);
		setBounds(new Rectangle(new Point(x, y),new Dimension(weight,height)));
    	setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	}
}
