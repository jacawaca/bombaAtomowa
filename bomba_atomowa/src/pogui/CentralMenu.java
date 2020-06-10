/**
 * 
 */
package pogui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
/**
 * @author Paweł Polak
 *
 */
public class CentralMenu extends JMenuBar implements ActionListener{
    private JMenuItem backMenu;
    JFrame colorFrame;
    JColorChooser colorChooser;
    int panelNumber;
    JPanel centerPanel;
    public JMenuItem chLang, chBackground, lic, resetMenu, inMenu, outMenu, exitMenu, particMenu;
    public JMenu menukolorow;
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
                        back_pl = "Tlo",
			back_eng = "Background",
                        chb_pl = "Zmien Tlo",
			chb_eng = "Change Background";
    
	public CentralMenu() {
		JMenu menuLook = new JMenu("Menu");
		chLang = new JMenuItem("Zmień język");
		menuLook.add(chLang);
		
		//JMenu inMenu = new JMenu("Wczytaj");
		//menuLook.add(inMenu);
                inMenu = new JMenuItem("Wczytaj");
		menuLook.add(inMenu);
		menuLook.addSeparator();
		
		//JMenu outMenu = new JMenu("Zapisz");
		//menuLook.add(outMenu);
                outMenu = new JMenuItem("Zapisz");
		menuLook.add(outMenu);
		menuLook.addSeparator();
		//JMenu license = new JMenu("Licencja");
		//menuLook.add(license);
	/*	
		JMenu newMenu = new JMenu("Nowy Plik");
		menuLook.add(newMenu);
		menuLook.addSeparator();
        */        
            //    JMenu resetMenu = new JMenu("Reset");
	//	menuLook.add(resetMenu);
                resetMenu = new JMenuItem("Reset");
		menuLook.add(resetMenu);
		menuLook.addSeparator();
                
                lic = new JMenuItem("Licencja");
		menuLook.add(lic);
		
                exitMenu = new JMenuItem("Wyjscie");
		
		//JMenu exitMenu = new JMenu("Wyj�cie");
		exitMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
                menuLook.add(resetMenu);
		menuLook.add(exitMenu);
                menuLook.addSeparator();
                
		this.add(menuLook);
		
                menukolorow = new JMenu("Wyglad");
		//menuLook.add(lic);
		//JMenu particMenu = new JMenu("Czasteczki");
                particMenu = new JMenuItem("Czasteczki");
		menukolorow.add(particMenu);
		menukolorow.addSeparator();
		
		backMenu = new JMenuItem("Tlo");
//                backMenu.setActionCommand("tlo");
//                backMenu.addActionListener(this);
		menukolorow.add(backMenu);
		menukolorow.addSeparator();
//		
		chBackground = new JMenuItem("Zmień tło");
//		backMenu.add(chBackground);
		menukolorow.add(chBackground);
	/*	
		JMenu newMenu = new JMenu("Nowy Plik");
		menuLook.add(newMenu);
		menuLook.addSeparator();
               
                JMenu resetMenu = new JMenu("Reset");
		menukolorow.add(resetMenu);
		menukolorow.addSeparator();
		
		
		menukolorow.add(resetMenu);
		menukolorow.addSeparator();
 */
                lic.setActionCommand("licencja");
                lic.addActionListener(this);
		this.add(menukolorow);
        
		
   
	}
        
        void changeLanguage() {
		if(isPolish) {
			lic.setText(licence_pl);
			chLang.setText(lang_pl);
			inMenu.setText(wcz_pl);
                        outMenu.setText(zap_pl);
                        exitMenu.setText(ex_pl);
                        menukolorow.setText(wyg_pl);
                        particMenu.setText(part_pl);
                        backMenu.setText(back_pl);
                        chBackground.setText(chb_pl);
			isPolish=false;
		}
		else {
			lic.setText(licence_eng);
			chLang.setText(lang_eng);
			inMenu.setText(wcz_eng);
                        outMenu.setText(zap_eng);
                        exitMenu.setText(ex_eng);
                        menukolorow.setText(wyg_eng);
                        particMenu.setText(part_eng);
                        backMenu.setText(back_eng);
                        chBackground.setText(chb_eng);
			isPolish=true;
		}
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        if(e.getActionCommand() == "tlo")
//{
//                setSize(1000, 640);
//		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//		
//		//color chooser
//		colorFrame = new JFrame();
//                colorFrame.setVisible(true);
//		colorFrame.setSize(640, 480);
//		colorFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//		colorChooser = new JColorChooser();
//		colorFrame.add(colorChooser, BorderLayout.CENTER);
//		JButton ok = new JButton("OK");
//		//panelNumber = 2;
//		ActionListener okListener = new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//                            
//					centerPanel.setBackground(colorChooser.getColor());
//					colorFrame.dispose();
//                                    }
//				
//			};
//		ok.addActionListener(okListener);
//		colorFrame.add(ok, BorderLayout.PAGE_END);
//                centerPanel = new JPanel();
//                add(centerPanel, BorderLayout.CENTER);
//}
	    if(e.getActionCommand() == "licencja")
	    {
		    JOptionPane.showMessageDialog(null,"Creative Commons Legal Code, CC0 1.0 Universal");
	    }
    }
    private void setDefaultCloseOperation(int DISPOSE_ON_CLOSE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }

