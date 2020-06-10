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
    public JMenuItem chLang, chBackground, drawPlot,
    inItem, outItem, resetItem;
    
	public CentralMenu() {
		JMenu menuLook = new JMenu("Menu");
		chLang = new JMenuItem("Zmień język");
		menuLook.add(chLang);
		
		drawPlot = new JMenuItem("Narysuj wykres");
		menuLook.add(drawPlot);
		
//		JMenu inMenu = new JMenu("Wczytaj");
//		menuLook.add(inMenu);
//		menuLook.addSeparator();
		
		inItem = new JMenuItem("Wczytaj");
		menuLook.add(inItem);
		
//		JMenu outMenu = new JMenu("Zapisz");
//		menuLook.add(outMenu);
//		menuLook.addSeparator();
		outItem = new JMenuItem("Zapisz");
		menuLook.add(outItem);
		/*	
		JMenu newMenu = new JMenu("Nowy Plik");
		menuLook.add(newMenu);
		menuLook.addSeparator();
        */
		
//                JMenu resetMenu = new JMenu("Reset");
//		menuLook.add(resetMenu);
//		menuLook.addSeparator();
		resetItem = new JMenuItem("Reset");
		menuLook.add(resetItem);
		
		JMenuItem exitMenu = new JMenuItem("Wyjście");
		exitMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		menuLook.add(exitMenu);
//		menuLook.addSeparator();
		this.add(menuLook);
		
                JMenu menukolorow = new JMenu("Wyglad");
		JMenu particMenu = new JMenu("Czasteczki");
		menukolorow.add(particMenu);
		menukolorow.addSeparator();
		
		backMenu = new JMenuItem("Tlo");
//                backMenu.setActionCommand("tlo");
//                backMenu.addActionListener(this);
		menukolorow.add(backMenu);
		menukolorow.addSeparator();
//		
		chBackground = new JMenuItem("Zmień tło na panelu");
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
		this.add(menukolorow);
        
		
   
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
    }
    private void setDefaultCloseOperation(int DISPOSE_ON_CLOSE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }
