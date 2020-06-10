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
    public JMenuItem chLang, chBackground;
    
	public CentralMenu() {
		JMenu menuLook = new JMenu("Menu");
		chLang = new JMenuItem("Zmień język");
		menuLook.add(chLang);
		
		JMenu inMenu = new JMenu("Wczytaj");
		menuLook.add(inMenu);
		menuLook.addSeparator();
		
		JMenu outMenu = new JMenu("Zapisz");
		menuLook.add(outMenu);
		menuLook.addSeparator();
		JMenu license = new JMenu("Licencja");
		menuLook.add(license);
		menuLook.addSeparator();
	/*	
		JMenu newMenu = new JMenu("Nowy Plik");
		menuLook.add(newMenu);
		menuLook.addSeparator();
        */        
                JMenu resetMenu = new JMenu("Reset");
		menuLook.add(resetMenu);
		menuLook.addSeparator();
		
		JMenu exitMenu = new JMenu("Wyj�cie");
		exitMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		menuLook.add(resetMenu);
		menuLook.addSeparator();
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
	    if(e.getActionCommand() == "license")
	    {
		    JOptionPane.showMessageDialog("Creative Commons Legal Code

CC0 1.0 Universal

    CREATIVE COMMONS CORPORATION IS NOT A LAW FIRM AND DOES NOT PROVIDE
    LEGAL SERVICES. DISTRIBUTION OF THIS DOCUMENT DOES NOT CREATE AN
    ATTORNEY-CLIENT RELATIONSHIP. CREATIVE COMMONS PROVIDES THIS
    INFORMATION ON AN "AS-IS" BASIS. CREATIVE COMMONS MAKES NO WARRANTIES
    REGARDING THE USE OF THIS DOCUMENT OR THE INFORMATION OR WORKS
    PROVIDED HEREUNDER, AND DISCLAIMS LIABILITY FOR DAMAGES RESULTING FROM
    THE USE OF THIS DOCUMENT OR THE INFORMATION OR WORKS PROVIDED
    HEREUNDER.

Statement of Purpose

The laws of most jurisdictions throughout the world automatically confer
exclusive Copyright and Related Rights (defined below) upon the creator
and subsequent owner(s) (each and all, an "owner") of an original work of
authorship and/or a database (each, a "Work").

Certain owners wish to permanently relinquish those rights to a Work for
the purpose of contributing to a commons of creative, cultural and
scientific works ("Commons") that the public can reliably and without fear
of later claims of infringement build upon, modify, incorporate in other
works, reuse and redistribute as freely as possible in any form whatsoever
and for any purposes, including without limitation commercial purposes.
These owners may contribute to the Commons to promote the ideal of a free
culture and the further production of creative, cultural and scientific
works, or to gain reputation or greater distribution for their Work in
part through the use and efforts of others.

For these and/or other purposes and motivations, and without any
expectation of additional consideration or compensation, the person
associating CC0 with a Work (the "Affirmer"), to the extent that he or she
is an owner of Copyright and Related Rights in the Work, voluntarily
elects to apply CC0 to the Work and publicly distribute the Work under its
terms, with knowledge of his or her Copyright and Related Rights in the
Work and the meaning and intended legal effect of CC0 on those rights.

1. Copyright and Related Rights. A Work made available under CC0 may be
protected by copyright and related or neighboring rights ("Copyright and
Related Rights"). Copyright and Related Rights include, but are not
limited to, the following:

  i. the right to reproduce, adapt, distribute, perform, display,
     communicate, and translate a Work;
 ii. moral rights retained by the original author(s) and/or performer(s);
iii. publicity and privacy rights pertaining to a person's image or
     likeness depicted in a Work;
 iv. rights protecting against unfair competition in regards to a Work,
     subject to the limitations in paragraph 4(a), below;
  v. rights protecting the extraction, dissemination, use and reuse of data
     in a Work;
 vi. database rights (such as those arising under Directive 96/9/EC of the
     European Parliament and of the Council of 11 March 1996 on the legal
     protection of databases, and under any national implementation
     thereof, including any amended or successor version of such
     directive); and
vii. other similar, equivalent or corresponding rights throughout the
     world based on applicable law or treaty, and any national
     implementations thereof.

2. Waiver. To the greatest extent permitted by, but not in contravention
of, applicable law, Affirmer hereby overtly, fully, permanently,
irrevocably and unconditionally waives, abandons, and surrenders all of
Affirmer's Copyright and Related Rights and associated claims and causes
of action, whether now known or unknown (including existing as well as
future claims and causes of action), in the Work (i) in all territories
worldwide, (ii) for the maximum duration provided by applicable law or
treaty (including future time extensions), (iii) in any current or future
medium and for any number of copies, and (iv) for any purpose whatsoever,
including without limitation commercial, advertising or promotional
purposes (the "Waiver"). Affirmer makes the Waiver for the benefit of each
member of the public at large and to the detriment of Affirmer's heirs and
successors, fully intending that such Waiver shall not be subject to
revocation, rescission, cancellation, termination, or any other legal or
equitable action to disrupt the quiet enjoyment of the Work by the public
as contemplated by Affirmer's express Statement of Purpose.

3. Public License Fallback. Should any part of the Waiver for any reason
be judged legally invalid or ineffective under applicable law, then the
Waiver shall be preserved to the maximum extent permitted taking into
account Affirmer's express Statement of Purpose. In addition, to the
extent the Waiver is so judged Affirmer hereby grants to each affected
person a royalty-free, non transferable, non sublicensable, non exclusive,
irrevocable and unconditional license to exercise Affirmer's Copyright and
Related Rights in the Work (i) in all territories worldwide, (ii) for the
maximum duration provided by applicable law or treaty (including future
time extensions), (iii) in any current or future medium and for any number
of copies, and (iv) for any purpose whatsoever, including without
limitation commercial, advertising or promotional purposes (the
"License"). The License shall be deemed effective as of the date CC0 was
applied by Affirmer to the Work. Should any part of the License for any
reason be judged legally invalid or ineffective under applicable law, such
partial invalidity or ineffectiveness shall not invalidate the remainder
of the License, and in such case Affirmer hereby affirms that he or she
will not (i) exercise any of his or her remaining Copyright and Related
Rights in the Work or (ii) assert any associated claims and causes of
action with respect to the Work, in either case contrary to Affirmer's
express Statement of Purpose.

4. Limitations and Disclaimers.

 a. No trademark or patent rights held by Affirmer are waived, abandoned,
    surrendered, licensed or otherwise affected by this document.
 b. Affirmer offers the Work as-is and makes no representations or
    warranties of any kind concerning the Work, express, implied,
    statutory or otherwise, including without limitation warranties of
    title, merchantability, fitness for a particular purpose, non
    infringement, or the absence of latent or other defects, accuracy, or
    the present or absence of errors, whether or not discoverable, all to
    the greatest extent permissible under applicable law.
 c. Affirmer disclaims responsibility for clearing rights of other persons
    that may apply to the Work or any use thereof, including without
    limitation any person's Copyright and Related Rights in the Work.
    Further, Affirmer disclaims responsibility for obtaining any necessary
    consents, permissions or other rights required for any use of the
    Work.
 d. Affirmer understands and acknowledges that Creative Commons is not a
    party to this document and has no duty or obligation with respect to
    this CC0 or use of the Work.");
	    }
    }
    private void setDefaultCloseOperation(int DISPOSE_ON_CLOSE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }
