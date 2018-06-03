package temp;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToggleButton;

public class PressedButton extends JToggleButton {
	private ImageIcon image;
	public PressedButton(String image,String rolloverImage){
		setIcon(new ImageIcon(this.getClass().getResource(image)));
		setRolloverIcon(new ImageIcon(this.getClass().getResource(rolloverImage)));
		setBorder(BorderFactory.createEmptyBorder());
		setContentAreaFilled(false);
		this.image = new ImageIcon(this.getClass().getResource(image));
	}
	public int getWidth(){
		return image.getIconWidth();
	}
	public int getHeight(){
		return image.getIconHeight();
	}
}
