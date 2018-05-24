package generalFrame;
import java.awt.Component;
import temp.Frame;

public class generalFrame {
	private static Frame frame;
	public generalFrame(){
		frame = new Frame();
		Component contents = new Contents().createComponents();
		Component generalButtons = new generalButtons().createComponents();
		Component activeEmployees = new activeEmployees().createComponents();
		frame.addComponent(contents);
		frame.addComponent(generalButtons);
		frame.addComponent(activeEmployees);

	}
	public static void unVisible(){
		frame.setVisible(false);
	}
	public static void main(String[] args) {
		generalFrame frame = new generalFrame();
	}
	public static void disable(){
		frame.setEnabled(false);
	}
	public static void enable(){
		frame.setEnabled(true);
	}
}
