package pogui;

import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Dolny extends JPanel {
	JButton chColorBack, chLang, runButton;
	public Dolny() {
		
		this.setLayout(new GridLayout(1, 3));
		chColorBack = new JButton("Zmie� kolor t�a"); add(chColorBack);
		chLang = new JButton("Zmie� j�zyk"); add(chLang);
		runButton = new JButton("START/STOP"); add(runButton);
		
		this.setVisible(true);
	}

	

}
//