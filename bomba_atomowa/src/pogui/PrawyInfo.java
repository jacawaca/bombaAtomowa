package pogui;

import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//import com.sun.org.apache.xerces.internal.parsers.IntegratedParserConfiguration;

public class PrawyInfo extends JPanel {
	JTextField fieldPower;

	public PrawyInfo() {
		this.setLayout(new GridLayout(4, 1));
		this.add(new JLabel("Wydzielona moc"));
		int curPower=0;
		// Jak b�dziemy robi� fizyk�, to zapewne zrobimy osobn� paczk�/klas�
		// np. "Symulacja", kt�rej parametry b�d� wczytywane do guzik�w
		fieldPower = new JTextField(Integer.toString(curPower));
		add(fieldPower);
	}

	

}
//