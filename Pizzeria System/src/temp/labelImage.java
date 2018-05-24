package temp;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class labelImage extends JLabel {
	private ImageIcon image;
	public labelImage(String path){
		setIcon(new ImageIcon(this.getClass().getResource(path)));
		image = new ImageIcon(this.getClass().getResource(path));
	}
	public int getWidth(){return image.getIconWidth();}
	public int getHeight(){return image.getIconHeight();}
}
