package backDoorFrame;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import temp.Button;
import temp.Frame;
import temp.Panel;

public class backdoorFrame extends Frame {
	public backdoorFrame(){
		Component contents = new backdoorButtons().createComponents();
		Panel pane = new Panel();
		Button returnButton = new Button("/images/backDoorButtons/return.png","/images/backDoorButtons/return2.png");
    	returnButton.setMnemonic(KeyEvent.VK_I);
    	returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dispose();
            }
        });
    	returnButton.setBounds(new Rectangle(new Point(20, 520),new Dimension(250,150)));
    	pane.add(returnButton);
    	add(pane);
		addComponent(contents);
	}
}
