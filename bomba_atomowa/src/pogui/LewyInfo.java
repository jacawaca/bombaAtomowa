package pogui;

//Jacek Strza³kowski

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
		
		nAtomow = new Kontrolka("Iloœæ atomów uranu", 0); this.add(nAtomow);
		pRozpadu = new Kontrolka("Prawdopodobieñstwo rozpadu", 0); this.add(pRozpadu);
		nEnergii= new Kontrolka("Iloœæ energii wytwarzanej w czasie rozpadu", 0); this.add(nEnergii);
		nNeutronow= new Kontrolka("Iloœæ neutronów wyrzucanych w czasie rozpadu", 0); this.add(nNeutronow);
		
		
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