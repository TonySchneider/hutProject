package generalFrame;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import temp.Panel;

public class activeEmployees {
	private Connection myConn;
	private Statement myStmt = null;
	private ResultSet myRs = null;
	private String[] columnNames = {"שם פרטי","שם משפחה","תפקיד"};
	private Object[][] data;
//	List<Label> activeEmployees = new ArrayList<Label>();
	public Component createComponents(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screenSize.getWidth();
		int height = (int)screenSize.getHeight();
		Panel pane = new Panel();
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
			myRs = myStmt.executeQuery("SELECT E.ID AS ID, E.firstName AS firstName, E.lastName AS lastName,E.Role AS Role FROM employee E INNER JOIN activeemployees A ON E.ID = A.IDnumber");
			while (myRs.next()) {
				model.addRow(new Object[]{myRs.getString("firstName"),myRs.getString("lastName"),myRs.getString("Role")});
			}
			Timer timer = new Timer(500, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					model.setRowCount(0);
					try{
						myRs = myStmt.executeQuery("SELECT E.ID AS ID, E.firstName AS firstName, E.lastName AS lastName,E.Role AS Role FROM employee E INNER JOIN activeemployees A ON E.ID = A.IDnumber");
						while (myRs.next()) {
							model.addRow(new Object[]{myRs.getString("firstName"),myRs.getString("lastName"),myRs.getString("Role")});
						}
					}catch(Exception e2){
						JOptionPane.showMessageDialog(null, e2.getMessage());
					}
			    }
			});
			timer.setRepeats(true);
			timer.setCoalesce(true);
			timer.setInitialDelay(0);
			timer.start();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
//		table.setShowHorizontalLines(false);
//		table.setShowVerticalLines(false);
//		table.setShowGrid(false);
		table.setModel(model);
		table.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		table.setFillsViewportHeight(true);
		table.setBounds(new Rectangle(new Point(width/2+40,height/3+40),new Dimension(310,400)));
//		table.setOpaque(false);
		table.getTableHeader().setBackground(new Color(0,0,0,0.6f));
		table.getTableHeader().setForeground(Color.white);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(table.getBounds());
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		for (int i=0;i<3;i++) table.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
		pane.add(scrollPane);
		return pane;
	}
	
	
	public static void Connect(long ID){
		Date startDate = new Date();
		Date endDate = new Date();
		double hours;
		try{
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tonydb?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","1234");
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("select * from activeemployees");
			int check = 0;
			while (myRs.next()) 
				if (Long.parseLong(myRs.getString("IDnumber")) == ID){
					check = 1;
					break;
					}
			if (check == 1){
				DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
				startDate = df.parse(myRs.getString("start_date"));
				String str = "delete from activeemployees where IDnumber="+ID;
				myStmt.executeUpdate(str);
				Calendar calendar = GregorianCalendar.getInstance();
				calendar.setTime(startDate);
				Calendar calendar2 = GregorianCalendar.getInstance();
				calendar2.setTime(endDate);
				hours = calendar2.get(Calendar.HOUR_OF_DAY)+(calendar2.get(Calendar.MINUTE)/60) - calendar.get(Calendar.HOUR_OF_DAY)+(calendar.get(Calendar.MINUTE)/60);
				System.out.println(hours);
				String sql = "  UPDATE employee SET workHours = workHours + "+hours+" WHERE ID = "+ID;
        		myStmt.executeUpdate(sql);
			}
			else{
        		String sql = "insert into activeemployees " + " (IDnumber, start_date)"
        				+ " values ('"+ID+"', '"+startDate+"')";
        		myStmt.executeUpdate(sql);
			}
		}catch(Exception e5){
			JOptionPane.showMessageDialog(null, e5.getMessage());
		}
	}
}
