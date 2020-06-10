package pogui;
//@author Jacek Strzalkowski

import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Kontrolka extends JPanel {
	private JLabel obserLabel;
	private JSlider valueSlider;
	private String polishLabel, englishLabel;
	boolean isPolish;
	
	
	public Kontrolka(int iniIle, int sliderMin, int sliderMax, String polishLString, String engString, boolean isPolish)
	{
		this.polishLabel=polishLString;
		this.englishLabel=engString;
		this.isPolish=isPolish;
		setVisible(true);
		obserLabel = new JLabel();
		valueSlider = new JSlider(sliderMin, sliderMax, iniIle);
		setText();
		add(obserLabel);
		add(getValueSlider());
		setLayout(new GridLayout(2, 1));
	}
	void setText(String txt){
		obserLabel.setText(txt);
	}
	void setText() {
		if(isPolish) {
			obserLabel.setText(polishLabel+" : "+valueSlider.getValue());
		}
		else {
			obserLabel.setText(englishLabel+" : "+valueSlider.getValue());
		}
	}
	
	void chLanguage(boolean isPolish) {
		this.isPolish=isPolish;
		setText();
	}
	
	void setListener(ChangeListener chList) {
		getValueSlider().addChangeListener(chList);
	}
	
	void setValue(int value) {
		valueSlider.setValue(value);
	}
	
	int getValue() {
		return getValueSlider().getValue();
	}
	public JSlider getValueSlider() {
		return valueSlider;
	}
	
}
