package pogui;

//Jacek Strza�kowski

import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class LewyInfo extends JPanel {
	Kontrolka nAtomow;
	Kontrolka pRozpadu;
	Kontrolka nEnergii;
	Kontrolka nNeutronow;
	
	public LewyInfo() {
		this.setLayout(new GridLayout(5,1));
		this.add(new JLabel("Parametry symulacji"));
		
		nAtomow = new Kontrolka("Ilo�� atom�w uranu", 0); this.add(nAtomow);
		pRozpadu = new Kontrolka("Prawdopodobie�stwo rozpadu", 0); this.add(pRozpadu);
		nEnergii= new Kontrolka("Ilo�� energii wytwarzanej w czasie rozpadu", 0); this.add(nEnergii);
		nNeutronow= new Kontrolka("Ilo�� neutron�w wyrzucanych w czasie rozpadu", 0); this.add(nNeutronow);
		
		
	}

	public LewyInfo(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public LewyInfo(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public LewyInfo(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

}
//