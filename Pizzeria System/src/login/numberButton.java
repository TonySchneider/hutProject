package login;

import java.awt.Point;
import java.awt.Rectangle;
import temp.Button;;

public class numberButton extends Button {
	public numberButton(int x,int y,String image,String rolloverImage){
		super(image,rolloverImage);
		setBounds(new Rectangle(new Point(x, y),this.getPreferredSize()));
	}
}
