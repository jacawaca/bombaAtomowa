package pogui;
// Jacek Strza³kowski



import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;

public class Frame extends JFrame {

	public Frame() throws HeadlessException {
		this.setVisible(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}


	public Frame(String title) throws HeadlessException {
		super(title);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		this.setSize(500, 500);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		
		
		this.add(new LewyInfo(), BorderLayout.LINE_START);
		this.add(new PrawyInfo(), BorderLayout.LINE_END);
		this.add(new Centralny(), BorderLayout.CENTER);
		this.add(new Dolny(), BorderLayout.PAGE_END);
		
		this.setJMenuBar(new MenuBar());
		
	}


	public static void main(String[] args) {
		// test
		Frame okienko = new Frame("Model bomby atomowej");
		
		

	}

}
//