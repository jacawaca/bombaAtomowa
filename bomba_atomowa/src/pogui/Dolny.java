package pogui;

import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Dolny extends JPanel {
	private boolean isPolish;
	final String chColorButtonText_polish = "Zmień kolor tła",
			chColorButtonText_english = "Change color of the background";
//			chLang_polish = "Zmień język", chLang_english="Change ";
	/**
	 *  Jacek Strza�kowski
	 */
	private static final long serialVersionUID = 1L;
	JButton chColorBack, chLang, runButton;
	public Dolny() {
		isPolish = true;
		setLayout(new GridLayout(1, 3));
		chColorBack = new JButton(chColorButtonText_polish); add(chColorBack);
		chLang = new JButton(); add(chLang);
		runButton = new JButton("START/STOP"); add(runButton);
		
		this.setVisible(true);
	}
	void changeLanguage() {
		
	}

	

}
//