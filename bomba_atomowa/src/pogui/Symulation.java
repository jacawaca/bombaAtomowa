/**
 * 
 */
package pogui;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
//		siatka = new int[100][100][100];
		int nPart = 10000; //temp
		siatka = new Siatka(nPart, particle);
//		for(int i=0;i<nParticles;i++) {
//			
//		}
		
		simEnd = new Date();
		return null;
	}
//	protected void done() {
//		
//	{
	public static void main(String[] args) {
		ArrayList<Particle> particles = new ArrayList<Particle>();
		int nPart = 10000; //temp
		Siatka siatka = new Siatka(nPart, particles);
		for(Particle p : particles ) {
			p.whoAmI();
		}
//	test.printAll();
	

}
}
