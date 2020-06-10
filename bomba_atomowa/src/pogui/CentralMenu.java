/**
 * 
 */
package pogui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 * @author Paweł Polak
 *
 */
public class CentralMenu extends JMenuBar{
    JFrame colorFrame;
    JColorChooser colorChooser;
    int panelNumber;
    JPanel centerPanel;
    public JMenuItem chLang, chBackground, drawPlot,
    inItem, outItem, resetItem, resultItem,
    uranColor, deadUranColor, kryptonColor, lic, exi, exitMenu;
    
    private JMenu menuLook, menukolorow, particMenu;
    
    boolean isPolish;
    
    private final String 
	licence_pl = "Licencja",
	licence_eng = "Licence",
	lang_pl = "Zmien jezyk",
	lang_eng = "Switch language",
                wcz_pl = "Wczytaj",
	wcz_eng = "Load",
                zap_pl = "Zapisz",
	zap_eng = "Save",
                ex_pl = "Wyjscie",
	ex_eng = "Exit",
                wyg_pl = "Wyglad",
	wyg_eng = "View",
                part_pl = "Czasteczki",
	part_eng = "Particles",
                chb_pl = "Zmien Tlo",
	chb_eng = "Change Background";
    
    
	public CentralMenu() {
		isPolish=true;
		menuLook = new JMenu("Menu");
		chLang = new JMenuItem("Zmień język");
		menuLook.add(chLang);
		
		drawPlot = new JMenuItem("Narysuj wykres");
		menuLook.add(drawPlot);
		

		
		inItem = new JMenuItem("Wczytaj");
		menuLook.add(inItem);

		outItem = new JMenuItem("Zapisz parametry");
		menuLook.add(outItem);
		
		resultItem = new JMenuItem("Zapisz wyniki");
		menuLook.add(resultItem);

		resetItem = new JMenuItem("Reset");
		menuLook.add(resetItem);
		
		exitMenu = new JMenuItem("Wyjście");
		exitMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		menuLook.add(exitMenu);
		this.add(menuLook);
		
        menukolorow = new JMenu("Wyglad");
		particMenu = new JMenu("Zmień kolor cząsteczki");
		menukolorow.add(particMenu);
//		menukolorow.addSeparator();
		uranColor = new JMenuItem("Uran"); deadUranColor = new JMenuItem("Nieaktywny Uran");
		kryptonColor = new JMenuItem("Krypton");
		particMenu.add(uranColor); particMenu.add(deadUranColor);
		particMenu.add(kryptonColor);

		chBackground = new JMenuItem("Zmień tło na panelu");
//		backMenu.add(chBackground);
		menukolorow.add(chBackground);
		
		lic = new JMenuItem("Licencja");
		lic.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Creative Commons Legal Code, CC0 1.0 Universal");
				
			}
		});

		this.add(menukolorow);
        
		
   
	}
	 void changeLanguage() {
			if(!isPolish) {
				lic.setText(licence_pl);
				chLang.setText(lang_pl);
				inItem.setText(wcz_pl);
                outItem.setText(zap_pl);
                exitMenu.setText(ex_pl);
                menukolorow.setText(wyg_pl);
                particMenu.setText(part_pl);
//                ba.setText(back_pl);
                chBackground.setText(chb_pl);
//				isPolish=false;
			}
			else {
				System.out.println("Nie działa");
				lic.setText(licence_eng);
				chLang.setText(lang_eng);
				inItem.setText(wcz_eng);
                outItem.setText(zap_eng);
                exitMenu.setText(ex_eng);
                menukolorow.setText(wyg_eng);
                particMenu.setText(part_eng);
//                backMenu.setText(back_eng);
                chBackground.setText(chb_eng);
//				isPolish=true;
			}
			isPolish=!isPolish;
		}

    }
