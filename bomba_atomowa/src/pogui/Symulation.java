/**
 * 
 */
package pogui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
//import java.lang.FdLibm.Pow;
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
	
	private final double activeRadius = 5;
	
	private final int nNeutronow=5;
	
	private final int showedX = 50, showedYmin = 0, showedYmax = 40,
			showedZmin = 0, showedZmax=40;
	private Centralny centralny;
	private BufferedImage imageSimulation;
	
	private final double pExplosion=0.01,
			pChangeMove=0.3, pSelfExplosion=0.01;
	
	private boolean isRunning;
	public boolean isRunning() {
		return isRunning;
	}
	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
	
	public Symulation(Centralny centralny) {
		isRunning = false;
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
//		System.out.println("RUCH");
		for(Neutron n: neutrons) {
			if(Math.random()<pChangeMove) {
				double vTotal = 10;
				double xShare = Math.random(), yShare = Math.random()*xShare,
						zShare = 1-xShare-yShare;
				n.setDirection(vTotal*xShare, vTotal*yShare, zShare*vTotal);
			}
			if(n.getX()>dim || n.getX()<0) {n.setDx(-n.getDx());};
			if(n.getY()>dim || n.getY()<0) {n.setDy(-n.getDy());
			if(n.getZ()>dim || n.getZ()<0) {n.setDz(-n.getDz());
			}
			}
			//Przesuwanie się !!!
			n.move();
		}
	}
	
	void explosion(Particle uran, List<Particle> addParticles) {
		if(particles==null) {System.exit(1);}
		uran.death();
		Krypton krypton = new Krypton(uran.x, uran.y, uran.z, 0.1);
//		uran = new Krypton(uran.x, uran.y, uran.z, 0.1);
//		particles.remove(uran);
//		particles.add(uran);
//		particles.add(krypton);//ENERGIA!!
//		Bar bar = new Bar(uran.x+1, uran.y+1, uran.z+1, 0.1);
//		particles.add(bar); 
		addParticles.add(krypton); //addParticles.add(bar);
		for(int i=0;i<3;i++) {
			Neutron neutron = new Neutron(uran.x, uran.y, uran.z, 0.1);
			neutron.setDirection(i, i+1, i-1); //Los na razie
			neutrons.add(neutron);
		}
	}
//	
	void selfExplosion(Uran uran) {
		uran.setExplAble(false);
		for(int i=0;i<nNeutronow;i++) {
			Neutron neutron = new Neutron(uran.x, uran.y, uran.z, 0.1);
			neutron.setDirection(i, i+1, i-1); //Los na razie
			neutrons.add(neutron);
		}
//		System.out.println("DUPA");
	}
//	
	boolean isSurrounded(Particle p) {
		for(Neutron n: neutrons) {
			double rx = n.getX()-p.getX(),
					ry = n.getY() - p.getY(),
					rz = n.getZ() - p.getZ();
			if(Math.sqrt(
					Math.pow(rx, 2)+Math.pow(ry, 2)+Math.pow(rz, 2))<activeRadius)
				return true;
		}
		return false;
	}
	
	void setToExpl() { //TODO
		List<Particle> addParticles = new ArrayList<Particle>();
		List<Particle> toRemoveUranium = new ArrayList<Particle>();
		for(Particle p: particles) {	
			if(p.isExplAble() && Math.random()<pExplosion && isSurrounded(p) )  {
					toRemoveUranium.add(p);
					explosion(p, addParticles);
				}
			}
		particles.removeAll(toRemoveUranium);
		particles.addAll(addParticles);
	}
	
	void setToSelfExplosion() {
		for(Particle p: particles) {
			if(p.isExplAble() &&  Math.random()<pSelfExplosion)  {
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
		else if(danaP==4) {
			g.setColor(deadUraniumColor);
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
//		System.out.println("JESTEM RYSOWANY na "+n.getX()+
//				" i "+n.getY());
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
	
	void info() {
		int doRozpadu=0, nBar=0, nDeadUran=0, nKrypton=0;
		for(Particle p : particles) {
			if(p.isExplAble()) doRozpadu++;
			else if(p instanceof Bar) nBar++;
			else if(p instanceof Uran) nDeadUran++;
			else if(p instanceof Krypton) nKrypton++;
		}
		System.out.println("Żywe urany: "+doRozpadu+" Bar: "+nBar
				+ " Krypton"+nKrypton+" DEAN URAN "+nDeadUran);
	}
	
	@Override
	protected BufferedImage doInBackground() throws Exception {
		System.out.println("Myk działa");
		isRunning=true;
		if(particles ==null || simBegin ==null || neutrons ==null) {
			particles = new ArrayList<Particle>();
			neutrons = new ArrayList<Neutron>();
			simBegin = new Date();
		}
		int nPart = 10000; //temp
		while(isRunning) {
			TimeUnit.MILLISECONDS.sleep(10);
			setMove();
			setToSelfExplosion();
			setToExpl();
			siatka = new Siatka(nPart, particles);
			draw();
			publish(imageSimulation);
			info();
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
