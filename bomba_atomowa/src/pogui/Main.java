package pogui;
// Jacek Strzałkowski
// wyrzuciłem niepotrzebne this., przed wywołaniem metody Frame'a


import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Main extends JFrame {
// dddd
	Centralny centralny;
	public Main() throws HeadlessException {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
	}


	public Main(String title) throws HeadlessException {
		super(title);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
//		setSize(500, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
//		setLayout(new BorderLayout());
		
		
		add(new LewyInfo(), BorderLayout.LINE_START);
		add(new PrawyInfo(), BorderLayout.LINE_END);
		centralny = new Centralny();
		add(centralny, BorderLayout.CENTER);
		add(new Dolny(), BorderLayout.PAGE_END);
		
		setJMenuBar(new MenuBar());
		setVisible(true);
		
		ActionListener simStart = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Symulation symulation = new Symulation(centralny);
				symulation.execute();
			}
		};
	}


	public static void main(String[] args) {
		// test
		Main okienko = new Main("Model bomby atomowej");
		
		

	}

}
//