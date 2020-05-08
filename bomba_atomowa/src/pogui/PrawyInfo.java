// @author Jacek Strzałkowski
package pogui;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JTextField fieldPower;
	private TimeTextField timeField;
	private RunButton runButtom;
	JLabel infoLabel;
	boolean isPolish;
	
	private final String 
			time_pl = "Czas trwania symulacji",
			time_eng = "Time of simlation",
			info_pl = "Wydzielona moc",
			info_eng = "Produced power";

	void changeLanguage() {
		if(isPolish) {
			timeField.setText(time_eng);
			infoLabel.setText(info_eng);
		}
		else {
			timeField.setText(time_pl);
			infoLabel.setText(info_pl);
		}
	}
	
	public PrawyInfo() {
		isPolish=true;
		setLayout(new GridLayout(5, 1));
		infoLabel = new JLabel(info_pl);
		add(infoLabel);
		int curPower=0;
		fieldPower = new JTextField(Integer.toString(curPower));
		add(fieldPower);
		
		add(new JLabel("Czas trwania symulacji"));
		timeField = new TimeTextField();
		add(timeField);
		
		runButtom = new RunButton(); add(runButtom); //Dodany runButtom
		runButtom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				runButtom.setRunning(!runButtom.isRunning());
				runButtom.setStartTime();
				timeField.setStartTime(runButtom.getStartTime());
				Thread runThread = new Thread(timeField);
				timeField.setisRunning(runButtom.isRunning());
				runThread.start();
				
			}
		});
	}

	

}
//