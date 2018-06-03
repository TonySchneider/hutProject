package temp;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class backGroundSimplePanel extends JPanel {
	public String imageFile;
	public backGroundSimplePanel(LayoutManager l,String imageFile) {
		super.setLayout(l);
		this.imageFile = imageFile;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image image = new ImageIcon(this.getClass().getResource(imageFile)).getImage();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//		int width = (int)screenSize.getWidth();
//		int height = (int)screenSize.getHeight();
		int width = getSize().width;
		int height = getSize().height;

		g.drawImage(image, 0, 0, width, height, null);
	}

}
