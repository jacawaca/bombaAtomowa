/**
 * 
 */
package pogui;

import java.awt.image.BufferedImage;
import java.util.Date;

import javax.swing.SwingWorker;
/**
 * @author "Jacek Strzałkowski"
 * Klasa w której będzie się odbywać symulacja
 */
public class Symulation extends SwingWorker<BufferedImage, Void> {
	private Date simBegin, simEnd;
	private int siatka[][][];
	private double allMasa;
	
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
		simBegin = new Date();
		siatka = new int[100][100][100];
		allMasa=10000; //temp
		
//		for(int i=0;i<nParticles;i++) {
//			
//		}
		
		simEnd = new Date();
		return null;
	}
//	protected void done() {
//		
//	{
}
