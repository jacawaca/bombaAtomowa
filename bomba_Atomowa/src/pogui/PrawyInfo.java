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
	JTextField fieldPower;
	TimeTextField timeField;
	RunButton runButtom;

	public PrawyInfo() {
		setLayout(new GridLayout(5, 1));
		add(new JLabel("Wydzielona moc"));
		int curPower=0;
		// Jak b�dziemy robi� fizyk�, to zapewne zrobimy osobn� paczk�/klas�
		// np. "Symulacja", kt�rej parametry b�d� wczytywane do guzik�w
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