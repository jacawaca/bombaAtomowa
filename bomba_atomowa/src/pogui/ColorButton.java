/**
 * 
 */
package pogui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;

/**
 * @author Jacek Strza�kowski
 *
 */
public class ColorButton extends JButton {
	public ColorButton(Color kolor)
	{
		super("Zmie� kolor");
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	
	public ColorButton()
	{
		
	}
	

}
