package pogui;
// Paweł Polak

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

public class Main extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Centralny centralny;
	private Dolny dolny;
	private LewyInfo lewy;
	private PrawyInfo prawy;
	private CentralMenu menu;
//	private M

	public Main() throws HeadlessException {
		super("Model bomby atomowej");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
//		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
//		setLayout(new BorderLayout());
		lewy = new LewyInfo();
		prawy = new PrawyInfo();
		
		add(lewy, BorderLayout.LINE_START);
		add(prawy, BorderLayout.LINE_END);
		centralny = new Centralny();
		add(centralny, BorderLayout.CENTER);
		dolny = new Dolny();
		add(dolny, BorderLayout.PAGE_END);
		
		menu = new CentralMenu();
		setJMenuBar(menu);
		setVisible(true);
		ActionListener simStart = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Symulation symulation = new Symulation(centralny);
				centralny.repaint();
				centralny.revalidate();
				symulation.execute();
			}
		};
		dolny.runButton.addActionListener(simStart);
		
		ActionListener chLanguage = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				lewy.changeLanguage(); prawy.changeLanguage();
				dolny.changeLanguage();
			}
		};
		menu.chLang.addActionListener(chLanguage);
		
		menu.chBackground.addActionListener(chBackground);
	}
	
	ActionListener chBackground = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JColorChooser chooser = new JColorChooser(centralny.getForeground());
			centralny.setBackground(chooser.getColor());
		}
	};
	ActionListener chUraniumColor = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			
		}
	};
	
	
	public static void main(String[] args) {
		// test
		Main okienko = new Main();
		
		

	}

}
//