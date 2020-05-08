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
	JLabel parametry;
	
	boolean isPolish;
	
	final String nAtomow_pl = "Ilość atomów uranu",
			nAtomow_eng = "Number of Uranium particles",
			rozpadu_pl= "Prawdopodobieństwo rozpadu", 
			rozpadu_eng= "Probability of nuclear decay", //radioactive decay -promieniowanie
			energii_pl= "Ilość energii wytwarzanej w czasie rozpadu", 
			energii_eng = "Amount of Energy produced during decay",
			neutronow_pl= "Ilość neutronów wyrzucanych w czasie rozpadu", 
			neutronow_eng = "Number of neutrons which are produceds by decay",
			parametry_pl = "Parametry Symulacji",
			parametry_eng = "Parametrics of simulation";
				
	
	
	public LewyInfo() {
		isPolish=true;
		setLayout(new GridLayout(5,1));
		parametry = new JLabel(parametry_pl); add(parametry);
		
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
			nAtomow.setText(nAtomow_eng);
			pRozpadu.setText(rozpadu_eng);
			nEnergii.setText(energii_eng);
			nNeutronow.setText(neutronow_eng);
			parametry.setText(parametry_eng);
			isPolish=false;
		}
		else {
			nAtomow.setText(nAtomow_pl);
			pRozpadu.setText(rozpadu_pl);
			nEnergii.setText(energii_pl);
			nNeutronow.setText(neutronow_pl);
			parametry.setText(parametry_pl);
			isPolish=true;
		}
	}
	


}
//