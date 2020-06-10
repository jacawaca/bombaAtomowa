// @author Jacek Strzałkowski
package pogui;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//import com.sun.org.apache.xerces.internal.parsers.IntegratedParserConfiguration;

public class PrawyInfo extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 53862670099238588L;
	private JTextField fieldPower, timeField;
	private RunButton runButtom;
	JLabel infoLabel, timeLabel;
	boolean isPolish;
	
	private long diffInSec;
	
	private final String 
			time_pl = "Czas trwania symulacji",
			time_eng = "Time of simlation",
			info_pl = "Wydzielona moc",
			info_eng = "Produced power";

	void changeLanguage() {
		if(isPolish) {
			timeField.setText(time_eng);
			infoLabel.setText(info_eng);
			timeLabel.setText(time_eng);
			isPolish=false;
		}
		else {
			timeField.setText(time_pl);
			infoLabel.setText(info_pl);
			timeLabel.setText(time_pl);
			isPolish=true;
		}
	}
	
	void setEnergy(double energy) {
		fieldPower.setText(Double.toString(energy/diffInSec));
	}
	
	void setTime(Date curDate, Date startDate) {
		diffInSec = (curDate.getTime()-startDate.getTime())/1000;
		timeField.setText(Long.toString(diffInSec));
	}
	
	
	public PrawyInfo() {
		isPolish=true;
		setLayout(new GridLayout(5, 1));
		infoLabel = new JLabel(info_pl);
		add(infoLabel);
		double curPower=0;
		fieldPower = new JTextField(Double.toString(curPower));
		add(fieldPower);
		
		timeLabel = new JLabel(time_pl); add(timeLabel);
//		timeField = new TimeTextField();
		timeField = new JTextField("0");
		add(timeField);

	}

	

}
//