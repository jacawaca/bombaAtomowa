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
		// Jak bêdziemy robiæ fizykê, to zapewne zrobimy osobn¹ paczkê/klasê
		// np. "Symulacja", której parametry bêd¹ wczytywane do guzików
		fieldPower = new JTextField(Integer.toString(curPower));
		add(fieldPower);
	}

	

}
//