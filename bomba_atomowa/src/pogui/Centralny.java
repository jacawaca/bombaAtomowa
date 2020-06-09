package pogui;
// @author Jacek Strzałkowski
import java.awt.Color;
//import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Centralny extends JPanel {
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(img, 0, 0,this);
	}
	
	private BufferedImage img;
	
	//	private BufferedImage img;
//	private Symulation symulation;
	void chBackground(Color color) {
		setBackground(color);
	}

	public BufferedImage getImg() {
		return img;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	}
	
	
	
//	public Centralny(BufferedImage img) {
//		this.img=img;
//		this.setBackground(Color.blue);
//		
//	}
//	public Centralny()
	
//	public void paintComponent(Graphics g) {
//		Graphics2D g2d = (Graphics2D) g;
//		g2d.drawImage(img, 0, 0, this);
//	}

	

}
//