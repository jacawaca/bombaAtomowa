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
	private final int showedX = 50, showedYmin = 0, showedYmax = 40,
			showedZmin = 0, showedZmax=40;
	private Centralny centralny;
	private BufferedImage imageSimulation;
	
	public Symulation(Centralny centralny) {
		if(uraniumColor==null)  uraniumColor = Color.RED; //w przyszłości zrobimy lepszy
		if(backgroundColor==null) backgroundColor = Color.WHITE; //mechanizm
		this.centralny=centralny;
	}
	
	private static Color uraniumColor, backgroundColor;
	
//	public enum Type{
//		uran, bar, krypton, neutron;
//	}
	
	void changeBackgroundColor(Color colorBackground) {
		backgroundColor = colorBackground;
//		draw();
	}
	
	
//	
//	void setMove() { //TODO
//		
//	}
//	
//	void explotion() { //TODO cząstka jako arg
//		
//	}
//	
//	void setToExpl() { //TODO
//		
//	}
	
	void draw() {
		imageSimulation = new BufferedImage(centralny.getWidth(),
				centralny.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = imageSimulation.createGraphics();
		g.setColor(backgroundColor);
		g.fillRect(0, 0, imageSimulation.getWidth(), imageSimulation.getHeight());
		for(int y=showedYmin;y<showedYmax;y++) {
			for(int z=showedZmin;z<showedZmax;z++) {
				int ypos = imageSimulation.getWidth()/showedYmax*y;
				int zpos = imageSimulation.getWidth()/showedZmax*z;
				if(siatka.dane[showedX][y][z]==1) {
					g.setColor(uraniumColor);
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

		draw();
		simEnd = new Date();
		return imageSimulation;
	}
	
	protected void done() {
		try {
			centralny.getGraphics().drawImage(get(), 0, 0, centralny);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
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
