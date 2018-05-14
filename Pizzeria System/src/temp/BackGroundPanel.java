package temp;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BackGroundPanel extends JPanel {
	public String imageFile;
	public BackGroundPanel(LayoutManager l,String imageFile) {
		super.setLayout(l);
		this.imageFile = imageFile;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image image = new ImageIcon(this.getClass().getResource(imageFile)).getImage();
		int baslangicX = 0;
		int baslangicY = 0;

		int bitisX = getSize().width;
		int bitisY = getSize().height;

		g.drawImage(image, baslangicX, baslangicY, bitisX, bitisY, null);
	}

}
