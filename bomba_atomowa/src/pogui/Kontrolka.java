package pogui;

import java.awt.LayoutManager;

import javax.swing.*;

public class Kontrolka extends JPanel {
	JLabel coMierzy;
	JTextField wartosc;

	public Kontrolka() {
		this.setVisible(true);
		coMierzy = new JLabel("Example");
		wartosc = new JTextField("0");
		this.add(coMierzy);
		this.add(wartosc);
	}
	
	public Kontrolka(String co, double iniIle)
	{
		this.setVisible(true);
		coMierzy = new JLabel(co);
		wartosc = new JTextField(Double.toString(iniIle));
		this.add(coMierzy);
		this.add(wartosc);
	}
	
//	public static void main(String[] args) {
//		// test
//		JFrame okno = new JFrame();
//		okno.setVisible(true);
//		okno.add(new Kontrolka("tt", 4));
//		
//		
//
//	}


}
