/**
 * 
 */
package pogui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Dimension2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.SwingWorker;
/**
 * @author "Jacek Strzałkowski"
 * Klasa w której będzie się odbywać symulacja
 */
public class Symulation extends SwingWorker<BufferedImage, Void> {
	private Date simBegin, simEnd;
	private Siatka siatka;
	private List<Particle> particle;// = new ArrayList<Particle>();
	private double allMasa;
	private final int dim=100;
	private final int showedX = 50, showedYmin = 0, showedYmax = 40,
			showedZmin = 0, showedZmax=40;
	private Centralny centralny;
	
	public Symulation(Centralny centralny) {
		this.centralny=centralny;
	}
	
//	public enum Type{
//		uran, bar, krypton, neutron;
//	}
	
	void setMove() { //TODO
		
	}
	
	void explotion() { //TODO cząstka jako arg
		
	}
	
	void setToExpl() { //TODO
		
	}
	
	void draw(BufferedImage img) {
		Graphics2D g = img.createGraphics();
		for(int y=showedYmin;y<showedYmax;y++) {
			for(int z=showedZmin;z<showedZmax;z++) {
				int ypos = img.getWidth()/showedYmax*y;
				int zpos = img.getWidth()/showedZmax*z;
				if(siatka.dane[showedX][y][z]==1) {
					g.setColor(Color.BLACK);
					g.fillOval(ypos, zpos, 10, 10);
				}
			}
		}
	}
	
	@Override
	protected BufferedImage doInBackground() throws Exception {
		particle = new ArrayList<Particle>();
		simBegin = new Date();
		int nPart = 10000; //temp
		siatka = new Siatka(nPart, particle);	
//
		BufferedImage img = new BufferedImage(centralny.getWidth(), centralny.getHeight(), BufferedImage.TYPE_INT_ARGB);
//		Graphics2D g = img.createGraphics();
//		g.setColor(Color.WHITE);
//		g.drawRect(0, 0, img.getWidth(), img.getHeight());
//		g.fillRect(0, 0, img.getWidth(), img.getHeight());
//		int dx = img.getWidth(), dy=img.getHeight();
		// Animacja oddaje losową warstwę na X i kwadrat 1-40x1-40 YxZ
//		for(int x=0;x<img.getWidth();x+=img.getWidth()/40) {
//			for(int y=0;y<img.getWidth();y+=img.getWidth()/40) {
////				g.drawRect(x, y, width, height);
//				
//				g.setColor(Color.BLACK);
//				g.fillOval(x, y, 10, 10);
//			}
//		}
//		for(int x=0;x<40;x++) {
//			for(int y=0;y<40;y++) {
//				int xpos = img.getWidth()/40*x;
//				int ypos = img.getWidth()/40*y;
//				if(siatka.dane[50][x][y]==1) {
//					g.setColor(Color.BLACK);
//					g.fillOval(xpos, ypos, 10, 10);
//				}
//			}
//		}
		draw(img);
		simEnd = new Date();
		return img;
	}
	
	protected void done() {
		try {
//			centralny.paint(get().getGraphics());
//			centralny.paintComponent(get().getGraphics());
			centralny.getGraphics().drawImage(get(), 0, 0, centralny);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	public static void main(String[] args) {
//		ArrayList<Particle> particles = new ArrayList<Particle>();
//		int nPart = 10000; //temp
//		Siatka siatka = new Siatka(nPart, particles);
//		for(Particle p : particles ) {
//			p.whoAmI();
//		}
//	test.printAll();
	

//}
}
