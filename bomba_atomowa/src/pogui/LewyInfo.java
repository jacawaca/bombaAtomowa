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
	
	boolean isPolish;
	
	final String nAtomow_pl = "Ilość atomów uranu",
			nAtomow_eng = "Number of Uranium particles",
			rozpadu_pl= "Prawdopodobieństwo rozpadu", 
			rozpadu_eng= "Probability of nuclear decay", //radioactive decay -promieniowanie
			energii_pl= "Ilość energii wytwarzanej w czasie rozpadu", 
			energii_eng = "Amount of Energy produced during decay",
			neutronow_pl= "Ilość neutronów wyrzucanych w czasie rozpadu", 
			neutronow_eng = "Number of neutrons which are produceds by decay";
				
	
	
	public LewyInfo() {
		isPolish=true;
		setLayout(new GridLayout(5,1));
		add(new JLabel("Parametry symulacji"));
		
		nAtomow = new Kontrolka(nAtomow_pl, 1000,0,1000000);
		add(nAtomow);
		pRozpadu = new Kontrolka(rozpadu_pl,5, 0, 10);
		// od 1 -> 10: 
		// przekazana wartość a -> a/10 np. 5 na Sliderze, to 0.5 prawd
		add(pRozpadu);
		nEnergii= new Kontrolka(energii_pl, 500,0,10000);
		add(nEnergii);
		nNeutronow= new Kontrolka(neutronow_pl, 3,1,8);
		add(nNeutronow);
		
		
	}
	void changeLanguage() {
		if(isPolish) {
			nAtomow.setName(nAtomow_eng);
			pRozpadu.setName(rozpadu_eng);
			nEnergii.setName(energii_eng);
			nNeutronow.setName(neutronow_eng);
		}
		else {
			nAtomow.setName(nAtomow_pl);
			pRozpadu.setName(rozpadu_pl);
			nEnergii.setName(energii_pl);
			nNeutronow.setName(neutronow_pl);
		}
	}
	


}
//