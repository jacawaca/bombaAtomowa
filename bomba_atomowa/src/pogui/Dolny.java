package pogui;

import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Dolny extends JPanel {
	JButton chColorBack, chLang, runButton;
	public Dolny() {
		
		this.setLayout(new GridLayout(1, 3));
		chColorBack = new JButton("Zmieñ kolor t³a"); add(chColorBack);
		chLang = new JButton("Zmieñ jêzyk"); add(chLang);
		runButton = new JButton("START/STOP"); add(runButton);
		
		this.setVisible(true);
	}

	

}
//