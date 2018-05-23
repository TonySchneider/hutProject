package login;

import generalFrame.activeEmployees;
import generalFrame.generalFrame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import temp.BackGroundPanel;
import temp.Button;
import temp.Panel;
import temp.simpleFrame;

public class loginFrame extends JFrame {
	private static int someOpen = 0;
	private static int check = 0;
	public loginFrame(int x,int y,int weight,int height){
		generalFrame.disable();
		someOpen++;
		Panel pane = new Panel();
		JPasswordField field = new JPasswordField();
		field.setBounds(new Rectangle(new Point(13,58),new Dimension(250,40)));
		field.setFont(new Font("Arial", Font.BOLD, 30));
		addWindowListener( new WindowAdapter() {
		    public void windowOpened( WindowEvent e ){
		        field.requestFocus();
		    }
		}); 
		numberButton b0 = new numberButton(168,342,"/images/loginNumbers/0.png","/images/loginNumbers/00.png");
		b0.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String pass = String.valueOf(field.getPassword());
				field.setText(pass+"0");
			}
		});
		numberButton b1 = new numberButton(16, 105,"/images/loginNumbers/1.png","/images/loginNumbers/11.png");
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String pass = String.valueOf(field.getPassword());
				field.setText(pass+"1");
			}
		});
		numberButton b2 = new numberButton(168, 105,"/images/loginNumbers/2.png","/images/loginNumbers/22.png");
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String pass = String.valueOf(field.getPassword());
				field.setText(pass+"2");
			}
		});
		numberButton b3 = new numberButton(330, 105,"/images/loginNumbers/3.png","/images/loginNumbers/33.png");
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String pass = String.valueOf(field.getPassword());
				field.setText(pass+"3");
			}
		});
		numberButton b4 = new numberButton(16, 184,"/images/loginNumbers/4.png","/images/loginNumbers/44.png");
		b4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String pass = String.valueOf(field.getPassword());
				field.setText(pass+"4");
			}
		});
		numberButton b5 = new numberButton(168, 184,"/images/loginNumbers/5.png","/images/loginNumbers/55.png");
		b5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String pass = String.valueOf(field.getPassword());
				field.setText(pass+"5");
			}
		});
		numberButton b6 = new numberButton(330, 184,"/images/loginNumbers/6.png","/images/loginNumbers/66.png");
		b6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String pass = String.valueOf(field.getPassword());
				field.setText(pass+"6");
			}
		});
		numberButton b7 = new numberButton(16, 263,"/images/loginNumbers/7.png","/images/loginNumbers/77.png");
		b7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String pass = String.valueOf(field.getPassword());
				field.setText(pass+"7");
			}
		});
		numberButton b8 = new numberButton(168, 263,"/images/loginNumbers/8.png","/images/loginNumbers/88.png");
		b8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String pass = String.valueOf(field.getPassword());
				field.setText(pass+"8");
			}
		});
		numberButton b9 = new numberButton(330, 263,"/images/loginNumbers/9.png","/images/loginNumbers/99.png");
		b9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String pass = String.valueOf(field.getPassword());
				field.setText(pass+"9");
			}
		});
		numberButton removeb = new numberButton(16, 342,"/images/loginNumbers/remove.png","/images/loginNumbers/remove2.png");
		removeb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String pass = String.valueOf(field.getPassword());
				field.setText(pass.substring(0, pass.length() - 1));
			}
		});
		numberButton removeallb = new numberButton(330, 342,"/images/loginNumbers/removeAll.png","/images/loginNumbers/removeAll2.png");
		removeallb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				field.setText("");
			}
		});
		Button submit = new Button("/images/loginin.png","/images/loginin2.png");
		submit.setBounds(new Rectangle(new Point(160, 430),new Dimension(180,61)));
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				long ID = Long.parseLong(String.valueOf(field.getPassword()));
				try{
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tonydb?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","1234");
					Statement myStmt = myConn.createStatement();
					ResultSet myRs = myStmt.executeQuery("select * from employee");
					while (myRs.next()) 
						if (Long.parseLong(myRs.getString("ID")) == ID)
							check = 1;
					if (check == 1){
						activeEmployees.Connect(ID);
						someOpen = 0;
						generalFrame.enable();
						setVisible(false);
						check = 0;
					}
					else
						JOptionPane.showMessageDialog(null, "שמואל");
				}catch(Exception e5){
					JOptionPane.showMessageDialog(null, e5.getMessage());
				}
				field.setText("");
			}
		});
		getRootPane().setDefaultButton(submit);
    	Button exit = new Button("/images/exitSmall.png","/images/exitSmall2.png");
		exit.setBounds(new Rectangle(new Point(440, 0),exit.getPreferredSize()));
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				someOpen = 0;
				dispose();
			}
		});
		
		pane.add(exit);
		BackGroundPanel background = new BackGroundPanel(new BorderLayout(),"/images/keyBoardNumber.png");
		setContentPane(background);
		
		pane.add(submit);
		pane.add(field);
		pane.add(b1);
		pane.add(b2);
		pane.add(b3);
		pane.add(b4);
		pane.add(b5);
		pane.add(b6);
		pane.add(b7);
		pane.add(b8);
		pane.add(b9);
		pane.add(removeallb);
		pane.add(b0);
		pane.add(removeb);
		add(pane);
		setLocation(x,y);
		applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		setIconImage(new ImageIcon(this.getClass().getResource("/images/Ph2016.png")).getImage());
		setUndecorated(true);
		pack();
		setSize(weight, height);
		if(someOpen < 2)
			setVisible(true);
	}
//	public int getCheck(){ return check;}
	public void addComponent(Component contents){
		revalidate();
		repaint();
		add(contents,BorderLayout.CENTER);
		revalidate();
		repaint();
	}
}
