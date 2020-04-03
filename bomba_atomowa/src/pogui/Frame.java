package pogui;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;

public class Frame extends JFrame {

	public Frame() throws HeadlessException {
		this.setVisible(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	public Frame(GraphicsConfiguration gc) {
		super(gc);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
	}

	public Frame(String title) throws HeadlessException {
		super(title);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setSize(500, 500);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.add(new LewyInfo(), BorderLayout.PAGE_START);
		this.add(new PrawyInfo(), BorderLayout.PAGE_END);
		this.add(new Centralny(), BorderLayout.CENTER);
		this.add(new Dolny(), BorderLayout.LINE_END);
		
	}

	public Frame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		// test
		Frame okienko = new Frame("Model bomby atomowej");
		
		

	}

}
//