package pogui;
// Jacek Strzałkowski
// wyrzuciłem niepotrzebne this., przed wywołaniem metody Frame'a


import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;

public class Frame extends JFrame {

	public Frame() throws HeadlessException {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
	}


	public Frame(String title) throws HeadlessException {
		super(title);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
//		setSize(500, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
//		setLayout(new BorderLayout());
		
		
		add(new LewyInfo(), BorderLayout.LINE_START);
		add(new PrawyInfo(), BorderLayout.LINE_END);
		add(new Centralny(), BorderLayout.CENTER);
		add(new Dolny(), BorderLayout.PAGE_END);
		
		setJMenuBar(new MenuBar());
		setVisible(true);
		
	}


	public static void main(String[] args) {
		// test
		Frame okienko = new Frame("Model bomby atomowej");
		
		

	}

}
//