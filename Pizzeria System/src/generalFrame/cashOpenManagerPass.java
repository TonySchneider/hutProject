package generalFrame;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import temp.Panel;
import backDoorFrame.backdoorFrame;

public class cashOpenManagerPass extends JFrame {
	private static int someOpen = 0;
	public cashOpenManagerPass(int x,int y,int weight,int height){
		super("הקש סיסמת מנהל");
		someOpen++;
		Panel pane = new Panel();
		JLabel title = new JLabel();
		title.setText("הקש סיסמת מנהל:");
		title.setFont(new Font("Arial", Font.BOLD, 18));
		title.setBounds(new Rectangle(new Point(140,0),title.getPreferredSize()));
		JPasswordField field = new JPasswordField();
		field.setBounds(new Rectangle(new Point(20,25),new Dimension(250,40)));
		field.setFont(new Font("Arial", Font.BOLD, 30));
		addWindowListener( new WindowAdapter() {
		    public void windowOpened( WindowEvent e ){
		        field.requestFocus();
		    }
		    @Override
            public void windowClosing(WindowEvent e){
		    	someOpen = 0;
            }
		}); 
		JButton submit = new JButton("אישור");
		submit.setBounds(new Rectangle(new Point(110,70),new Dimension(70,30)));
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
     			String passText = new String(field.getPassword());
     			if (passText.equals("205515828")){
     				dispose();
     				//פתיחת פריים קופה
     				someOpen = 0;
     			}
     			else
     				JOptionPane.showMessageDialog(null, "סיסמא שגויה.");
				
			}
			
		});
		getRootPane().setDefaultButton(submit);
		pane.add(submit);
		pane.add(title);
		pane.add(field);
		add(pane);
		setLocation(x,y);
		setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		setIconImage(new ImageIcon(this.getClass().getResource("/images/Ph2016.png")).getImage());
//		setUndecorated(true);
		pack();
		setSize(weight, height);
		if(someOpen < 2)
			setVisible(true);
	}
}
