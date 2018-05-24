package backDoorFrame;
import generalFrame.Contents;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import temp.BackGroundPanel;
import temp.Label;
import temp.Panel;
import temp.TextField;
import temp.simpleFrame;

import java.sql.*;
public class listOfEmployeesPane extends Panel {
	private Connection myConn;
	private Statement myStmt = null;
	private ResultSet myRs = null;
	private String[] columnNames = {"מספר עובד","שם פרטי","שם משפחה","תעודת זהות","שעות עבודה","תפקיד"};
	private Object[][] data;
	public listOfEmployeesPane(){
		setPreferredSize(new Dimension(1050,542));
//		setOpaque(true);
//		JLabel backgroundLists = new JLabel();
//		backgroundLists.setIcon(new ImageIcon(this.getClass().getResource("/images/backDoorButtons/backgroundLists.png")));
//		backgroundLists.setBounds(new Rectangle(new Point(300,200), new Dimension(1050,542)));
//		add(backgroundLists);
		JTable table = new JTable();
		DefaultTableModel model = new DefaultTableModel(data, columnNames) {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		try{
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tonydb?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","1234");
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select * from employee");
			while (myRs.next()) {
				model.addRow(new Object[]{myRs.getString("idemployee"),myRs.getString("firstName"),myRs.getString("lastName"),myRs.getString("ID"),myRs.getString("workHours"),myRs.getString("Role")});
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		JLabel title = new JLabel();
		title.setText("רשימת עובדים");
		title.setFont(new Font("Arial", Font.BOLD, 24));
		title.setBounds(new Rectangle(new Point(820,10),new Dimension(150,50)));
		JButton addButton = new JButton("הוסף עובד חדש");
		addButton.setBounds(new Rectangle(new Point(800, 380),new Dimension(130,35)));
		addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	simpleFrame frame = new simpleFrame(320,200,500,500);
        		String[] roleStrings = { "מנהל", "שליח", "עובד פנים" };
        		Panel pane2 = new Panel();
            	Label idLabel = new Label("תעודת זהות:",350,10);
            	TextField id = new TextField(200,10,130,30);
            	Label firstNameLabel = new Label("שם פרטי:",350,70);
            	TextField firstName = new TextField(200,70,130,30);
            	Label lastNameLabel = new Label("שם משפחה:",350,140);
            	TextField lastName = new TextField(200,140,130,30);
            	Label RoleLabel = new Label("תפקיד:",350,210);
            	JComboBox Role = new JComboBox(roleStrings);
            	Role.setBounds(new Rectangle(new Point(250, 210),Role.getPreferredSize()));
            	JButton addButton2 = new JButton("הוסף");
            	addButton2.setBounds(new Rectangle(new Point(250, 280),new Dimension(130,35)));
        		addButton2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                		String sql = "insert into employee " + " (ID, firstName, lastName,workHours,Role)"
                				+ " values ('"+id.getText()+"', '"+firstName.getText()+"', '"+lastName.getText()+"','0', '"+Role.getSelectedItem()+"')";
                		int check = 0;
                		try{
                			myRs = myStmt.executeQuery("select * from employee");
        					while (myRs.next()) 
        						if (Long.parseLong(myRs.getString("ID")) == Long.parseLong(id.getText()))
        							check = 1;
        					if (check != 1)
        						myStmt.executeUpdate(sql);
        					else 
        						JOptionPane.showMessageDialog(null, "עובד עם מספר תעודת זהות זהה קיים במערכת.");
                			myRs = myStmt.executeQuery("select * from employee");
                			model.setRowCount(0);
                			while(myRs.next()){
                				model.addRow(new Object[]{myRs.getString("idemployee"),myRs.getString("firstName"),myRs.getString("lastName"),myRs.getString("ID"),myRs.getString("workHours"),myRs.getString("Role")});
                				}
                		}catch(Exception e2){
                			JOptionPane.showMessageDialog(null, e2.getMessage());
                		}
                		frame.setVisible(false);
                    }
                });
            	pane2.add(idLabel);
            	pane2.add(id);
            	pane2.add(firstNameLabel);
            	pane2.add(firstName);
            	pane2.add(lastNameLabel);
            	pane2.add(lastName);
            	pane2.add(RoleLabel);
            	pane2.add(Role);
            	pane2.add(addButton2);
            	frame.add(pane2);
            }
        });
		JButton removeButton = new JButton("מחק");
		removeButton.setBounds(new Rectangle(new Point(600, 380),new Dimension(130,35)));
		removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					String str = "delete from employee where idemployee="+(table.getSelectedRow()+1);
					myStmt.executeUpdate(str);
				}catch(Exception e4){
					JOptionPane.showMessageDialog(null, e4.getMessage());
				}
				model.removeRow(table.getSelectedRow());
			}
		});
		table.setModel(model);
		table.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		table.setFillsViewportHeight(true);
		table.setBounds(new Rectangle(new Point(300, 70),new Dimension(700,300)));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(table.getBounds());
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		for (int i=0;i<6;i++) table.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
		add(title);
		add(scrollPane);
		add(addButton);
		add(removeButton);
	}
	public void refreshPane(){
		setVisible(false);
		setVisible(true);
	}
//	public static void disable(){
//		
//	}
}
