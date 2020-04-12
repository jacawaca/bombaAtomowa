package pogui;
//@author Jacek Strzalkowski

import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.*;

public class Kontrolka extends JPanel {
	private JLabel obserLabel;
	private JSlider valueSlider;
	
	public Kontrolka(String co, int iniIle, int sliderMin, int sliderMax)
	{
		setVisible(true);
		obserLabel = new JLabel(co);
		valueSlider = new JSlider(sliderMin, sliderMax, iniIle);
		add(obserLabel);
		add(valueSlider);
		setLayout(new GridLayout(2, 1));
	}


}
