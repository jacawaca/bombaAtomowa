/**
 * 
 */
package pogui;

import java.awt.Color;
import java.awt.Graphics2D;
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
	private Centralny centralny;
	
	public Symulation(Centralny centralny) {
		this.centralny=centralny;
	}
	
	public enum Type{
		uran, bar, krypton, neutron;
	}
	
	void setMove() {
		
	}
	
	void explotion() { //TODO cząstka jako arg
		
	}
	
	void setToExpl() {
		
	}
	
	@Override
	protected BufferedImage doInBackground() throws Exception {
		particle = new ArrayList<Particle>();
		simBegin = new Date();
		int nPart = 10000; //temp
		siatka = new Siatka(nPart, particle);	

		BufferedImage img = new BufferedImage(centralny.getWidth(), centralny.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D g = img.createGraphics();
//		for(int x=0;x<20;x++) {
//			for(int y=0;y<20;y++) {
//				g.drawRect(x, y, width, height);
//			}
//		}
		g.setColor(Color.black);
		g.drawRect(100, 100, 10, 10);
		
		simEnd = new Date();
		return img;
	}
	
	protected void done() {
		try {
			centralny.paint(get().getGraphics());
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
