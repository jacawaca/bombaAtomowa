package pogui;
// @author Jacek Strzałkowski
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Dolny extends JPanel {
	private boolean isPolish;
	final String runButton_pl = "Zacznij/Przerwij",
			runButton_eng = "Start/Stop";
	JTextField infoSimulation;
	final String infoDisplay_pl = "Symulacja pokazuje komórki: ", 
			infoDisplay_eng="The Simulation shows the cells: ";
	
			
	/**
	 *  Jacek Strza�kowski
	 */
	private static final long serialVersionUID = 1L;
	JButton chColorBack, chLang, runButton;
	public Dolny() {
		isPolish = true;
		setLayout(new GridLayout(1, 3));
//		chColorBack = new JButton(chColorButtonText_polish); add(chColorBack);
//		chLang = new JButton(chColo); add(chLang);
		runButton = new JButton(runButton_pl); add(runButton);
		infoSimulation= new JTextField(infoDisplay_pl); add(infoSimulation);
		
		this.setVisible(true);
	}
	void changeLanguage() {
		if(isPolish) {
			runButton.setText(runButton_eng);
			infoSimulation.setText(infoDisplay_eng);
			isPolish=false;
		}
		else {
				runButton.setText(runButton_pl);
				infoSimulation.setText(infoDisplay_pl);
				isPolish=true;
		}
	}

	

}
//