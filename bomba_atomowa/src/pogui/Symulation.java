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
import java.util.concurrent.TimeUnit;

import javax.swing.SwingWorker;
/**
 * @author "Jacek Strzałkowski"
 * Klasa w której będzie się odbywać symulacja
 */
public class Symulation extends SwingWorker<BufferedImage, BufferedImage> {

	private Date simBegin, simEnd;
	private Siatka siatka;
	private List<Particle> particles;// = new ArrayList<Particle>();
	private List<Neutron> neutrons;
	private double allMasa;
	private final int dim=100;
	
	private final int nNeutronow=5;
	
	private final int showedX = 50, showedYmin = 0, showedYmax = 40,
			showedZmin = 0, showedZmax=40;
	private Centralny centralny;
	private BufferedImage imageSimulation;
	
	private final double pExplosion=0.01,
			pChangeMove=0.01, pSelfExplosion=0.01;
	
	private boolean isRunning;
	public boolean isRunning() {
		return isRunning;
	}
	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
	
	public Symulation(Centralny centralny) {
		if(uraniumColor==null)  uraniumColor = Color.RED; //w przyszłości zrobimy lepszy
		if(backgroundColor==null) backgroundColor = Color.WHITE; //mechanizm
		if(barColor ==null) barColor = Color.GREEN;
		if(cryptonColor ==null) cryptonColor = Color.CYAN;
		if(deadUraniumColor ==null) deadUraniumColor = Color.BLACK;
		this.centralny=centralny;
	}
	
	private static Color uraniumColor, deadUraniumColor, backgroundColor, barColor, cryptonColor;
	
//	public enum Type{
//		uran, bar, krypton, neutron;
//	}
	
	void changeBackgroundColor(Color colorBackground) {
		backgroundColor = colorBackground;
//		draw();
	}
	
	
	
	void setMove() { //TODO
		for(Neutron n: neutrons) {
			if(Math.random()<pChangeMove) {
				double vTotal = 1;
				double xShare = Math.random(), yShare = Math.random()*xShare,
						zShare = 1-xShare-yShare;
				n.setDirection(vTotal*xShare, vTotal*yShare, zShare*vTotal);
			}
		}
	}
	
	void explosion(Uran uran) {
		Krypton krypton = new Krypton(uran.x, uran.y, uran.z, 0.1); //ENERGIA!!
		Bar bar = new Bar(uran.x+1, uran.y+1, uran.z+1, 0.1);
		particles.add(bar); particles.add(krypton);
		for(int i=0;i<3;i++) {
			Neutron neutron = new Neutron(uran.x, uran.y, uran.z, 0.1);
			neutron.setDirection(i, i+1, i-1); //Los na razie
			neutrons.add(neutron);
		}
	}
//	
	void selfExplosion(Uran uran) { //TODO cząstka jako arg
		uran.setExplAble(false);
		for(int i=0;i<nNeutronow;i++) {
			Neutron neutron = new Neutron(uran.x, uran.y, uran.z, 0.1);
			neutron.setDirection(i, i+1, i-1); //Los na razie
			neutrons.add(neutron);
		}
		
	}
//	
	void setToExpl() { //TODO
		for(Particle p: particles) {
			if(p.getClass()==Uran.class && Math.random()<pExplosion )  {
					explosion((Uran) p);
				}
			}
	}
	
	void setToSelfExplosion() {
		for(Particle p: particles) {
			if(p.isExplAble() &&  Math.random()<pExplosion )  {
					selfExplosion((Uran) p);
				}
			}
	}
	
	void drawParticle(byte danaP, Graphics2D g, int zpos, int ypos) {
		if(danaP==1) {
			g.setColor(uraniumColor);
		}
		else if(danaP==2) {
			g.setColor(cryptonColor);
		}
		else if(danaP==3) {
			g.setColor(barColor);
		}
		else {
			return;
		}
		g.fillOval(ypos, zpos, 10, 10);
	}
	
	void drawNeutron(Graphics2D g, Neutron n) {
		g.setColor(Color.BLUE);
		int ypos = (int) (imageSimulation.getWidth()/(showedYmax-showedYmin)*n.getY());
		int zpos = (int) (imageSimulation.getWidth()/(showedZmax-showedZmin)*n.getZ());
		System.out.println("JESTEM RYSOWANY na "+n.getX()+
				" i "+n.getY());
		g.fillOval(
				ypos,
				zpos
				, 5, 5);
	}
	
	
	void draw() {
		imageSimulation = new BufferedImage(centralny.getWidth(),
				centralny.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = imageSimulation.createGraphics();
		g.setColor(backgroundColor);
		g.fillRect(0, 0, imageSimulation.getWidth(), imageSimulation.getHeight());
		for(int y=showedYmin;y<showedYmax;y++) {
			for(int z=showedZmin;z<showedZmax;z++) {
				int ypos = imageSimulation.getWidth()/(showedYmax-showedYmin)*y;
				int zpos = imageSimulation.getWidth()/(showedZmax-showedZmin)*z;
				drawParticle(siatka.dane[showedX][y][z], g, zpos, ypos);
			}
		}
		for(Neutron n: neutrons) {
			if(n.getX()>showedX-2 && n.getX()<showedX+2 &&
					n.getY()>showedYmin-1 && n.getY()<showedYmax+1 &&
					n.getZ()>showedZmin-1 && n.getZ()<showedZmax+1) {
					drawNeutron(g, n);
			}
		}
	}
	
	@Override
	protected BufferedImage doInBackground() throws Exception {
		if(particles ==null || simBegin ==null || neutrons ==null) {
			particles = new ArrayList<Particle>();
			neutrons = new ArrayList<Neutron>();
			simBegin = new Date();
		}
		int nPart = 10000; //temp
		for(int i=0;i<10000000;i++) {
			TimeUnit.MILLISECONDS.sleep(10);
			setToSelfExplosion();
			siatka = new Siatka(nPart, particles);
//			System.out.println("D");
			draw();
			publish(imageSimulation);
		}	
		return imageSimulation;
	}
	
	protected void done() {
		try {
//			centralny.getGraphics().drawImage(get(), 0, 0, centralny);
			simEnd = new Date();
			centralny.setImg(get());
			centralny.repaint();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void process(List<BufferedImage> chunks) {
		// TODO Auto-generated method stub
//		super.process(chunks);
		for(BufferedImage img : chunks) {
//			centralny.getGraphics().clearRect(0, 0, centralny.getWidth(), centralny.getHeight());
//			centralny.getGraphics().
//			centralny.getGraphics().drawImage(img, 0, 0, centralny);
			centralny.setImg(img);
			centralny.repaint();
//			centralny.revalidate();
//			centralny.repaint();
//			centralny.revalidate();
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
