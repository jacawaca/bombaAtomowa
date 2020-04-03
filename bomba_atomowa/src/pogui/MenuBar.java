/**
 * 
 */
package pogui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 * @author Pawe³ Polak
 *
 */
public class MenuBar extends JMenuBar {
	public MenuBar() {
		JMenu menuLook = new JMenu("Menu");
		JMenu inMenu = new JMenu("Wczytaj");
		menuLook.add(inMenu);
		menuLook.addSeparator();
		
		JMenu outMenu = new JMenu("Zapisz");
		menuLook.add(outMenu);
		menuLook.addSeparator();
		
		JMenu newMenu = new JMenu("Nowy Plik");
		menuLook.add(newMenu);
		menuLook.addSeparator();
		
		JMenu exitMenu = new JMenu("Wyjœcie");
		exitMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		menuLook.add(newMenu);
		menuLook.addSeparator();
		this.add(menuLook);
		
		
	}

}
