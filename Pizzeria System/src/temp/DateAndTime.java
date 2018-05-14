package temp;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.Timer;

public class DateAndTime extends Panel {
	public Component createComponents() {
		JLabel dateTime = new JLabel();
		dateTime.setText(DateFormat.getDateTimeInstance().format(new Date()));
		dateTime.setFont(new Font("Arial", Font.BOLD, 24));
		Timer timer = new Timer(500, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dateTime.setText(DateFormat.getDateTimeInstance().format(new Date()));
            	dateTime.setFont(new Font("Arial", Font.BOLD, 24));
            }
        });
		timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.setInitialDelay(0);
        timer.start();
        dateTime.setBounds(new Rectangle(new Point(0,0), dateTime.getPreferredSize()));
        dateTime.setForeground(Color.white);
        add(dateTime);
        return this;
	}
}
