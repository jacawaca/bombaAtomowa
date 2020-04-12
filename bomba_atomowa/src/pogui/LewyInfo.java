package pogui;

//@author Jacek Strzałkowski

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
		setLayout(new GridLayout(5,1));
		add(new JLabel("Parametry symulacji"));
		
		nAtomow = new Kontrolka("Ilość atomów uranu", 1000,0,1000000);
		add(nAtomow);
		pRozpadu = new Kontrolka("Prawdopodobieństwo rozpadu",5, 0, 10);
		// od 1 -> 10: 
		// przekazana wartość a -> a/10 np. 5 na Sliderze, to 0.5 prawd
		add(pRozpadu);
		nEnergii= new Kontrolka("Ilość energii wytwarzanej w czasie rozpadu", 500,0,10000);
		add(nEnergii);
		nNeutronow= new Kontrolka("Ilość neutronów wyrzucanych w czasie rozpadu", 3,1,8);
		add(nNeutronow);
		
		
	}


}
//