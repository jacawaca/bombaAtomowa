package pogui;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;

public class Frame extends JFrame {

	public Frame() throws HeadlessException {
		this.setVisible(true);
	}

	public Frame(GraphicsConfiguration gc) {
		super(gc);
		this.setVisible(true);
	}

	public Frame(String title) throws HeadlessException {
		super(title);
		this.setVisible(true);
	}

	public Frame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
//