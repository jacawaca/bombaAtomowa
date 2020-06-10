/**
 * 
 */
package pogui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
//import java.lang.FdLibm.Pow;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.swing.SwingWorker;

import org.jfree.data.time.TimeSeries;
import org.jfree.data.xy.XYSeries;
/**
 * @author "Jacek Strzałkowski"
 * Klasa w której będzie się odbywać symulacja
 */
public class Symulation extends SwingWorker<BufferedImage, BufferedImage> {

	private Date simBegin, simEnd;
	private Siatka siatka;
	private List<Particle> particles;// = new ArrayList<Particle>();
	private List<Neutron> neutrons;
//	private double allMasa;
	private final int dim=100; //Wymiar SIATKI
	
	private final double reactionEnergy = 10,
			selfExplosionEnergy = 20;
	
	private double totalEnergy;
	
	private final double activeRadius = 5;
	
	
	private final int showedX = 50, showedYmin = 0, showedYmax = 40,
			showedZmin = 0, showedZmax=40;
	private Centralny centralny;
	private PrawyInfo prawy;
	
	private BufferedImage imageSimulation;
	
	private static double pExplosion=0.01;
	private final double pChangeMove=0.3, pSelfExplosion=0.01;

	public double getpSelfExplosion() {
		return pSelfExplosion;
	}
	
	public double getpChangeMove() {
		return pChangeMove;
	}

	public double getpExplosion() {
		return pExplosion;
	}
	
	public void setpExplosion(double pExplosion) {
		Symulation.pExplosion = pExplosion;
	}
	
	private static int nNeutronow = 4;
	public int getnNeutronow() {
		return nNeutronow;
	}
	public void setnNeutronow(int nNeutronow) {
		Symulation.nNeutronow = nNeutronow;
	}
	
	private boolean isRunning;
	public boolean isRunning() {
		return isRunning;
	}
	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	private boolean is2Stop;
	public boolean isStopped() {
		return is2Stop;
	}

	public void setStopped(boolean isStopped) {
		this.is2Stop = isStopped;
	}
	
	private XYSeries timevsPowerSeries;
	public XYSeries getTimevsPowerSeries() {
		return timevsPowerSeries;
	}
	

	private List<String> infoLines;
	public List<String> getInfoLines() {
		return infoLines;
	}
	
	//KONSTRUKTO
	public Symulation(Centralny centralny, PrawyInfo prawy) {
		isRunning = false;
		if(getUraniumColor()==null)  setUraniumColor(Color.RED); //w przyszłości zrobimy lepszy
		if(getBackgroundColor()==null) setBackgroundColor(Color.WHITE); //mechanizm
		if(getBarColor() ==null) setBarColor(Color.GREEN);
		if(getCryptonColor() ==null) setCryptonColor(Color.CYAN);
		if(getDeadUraniumColor() ==null) setDeadUraniumColor(Color.BLACK);
		this.centralny=centralny;
		totalEnergy=0;
		this.prawy = prawy;
		timevsPowerSeries = new XYSeries("Pomiar Mocy");
		infoLines = new ArrayList<String>();
	}
	
	
	
	
	
	void changeBackgroundColor(Color colorBackground) {
		setBackgroundColor(colorBackground);
//		draw();
	}
	
	
	
	void setMove() { //TODO
		for(Neutron n: neutrons) {
			if(Math.random()<getpChangeMove()) {
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
			n.move();
		}
	}
	
	void explosion(Particle uran, List<Particle> addParticles) {
		if(particles==null) {System.exit(1);}
		uran.death();
		Krypton krypton = new Krypton(uran.x, uran.y, uran.z, 0.1);
		totalEnergy+=reactionEnergy;
//		uran = new Krypton(uran.x, uran.y, uran.z, 0.1);
//		particles.remove(uran);
//		particles.add(uran);
//		particles.add(krypton);//ENERGIA!!
//		Bar bar = new Bar(uran.x+1, uran.y+1, uran.z+1, 0.1);
//		particles.add(bar); 
		addParticles.add(krypton); //addParticles.add(bar);
		for(int i=0;i<nNeutronow;i++) {
			Neutron neutron = new Neutron(uran.x, uran.y, uran.z, 0.1);
			neutron.setDirection(i, i+1, i-1); //Los na razie
			neutrons.add(neutron);
		}
	}
//	
	void selfExplosion(Uran uran) {
		uran.setExplAble(false);
		totalEnergy+=selfExplosionEnergy;
		for(int i=0;i<getnNeutronow();i++) {
			Neutron neutron = new Neutron(uran.x, uran.y, uran.z, 0.1);
			neutron.setDirection(i, i+1, i-1); //Los na razie
			neutrons.add(neutron);
		}
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
			if(p.isExplAble() &&  Math.random()<getpSelfExplosion())  {
					selfExplosion((Uran) p);
				}
			}
	}
	
	void drawParticle(byte danaP, Graphics2D g, int zpos, int ypos) {
		if(danaP==1) {
			g.setColor(getUraniumColor());
		}
		else if(danaP==2) {
			g.setColor(getCryptonColor());
		}
		else if(danaP==3) {
			g.setColor(getBarColor());
		}
		else if(danaP==4) {
			g.setColor(getDeadUraniumColor());
		}
		else {
			return;
		}
		g.fillOval(ypos, zpos, 15, 15);
	}
	
	void drawNeutron(Graphics2D g, Neutron n) {
		g.setColor(Color.BLUE);
		int ypos = (int) (imageSimulation.getWidth()/(showedYmax-showedYmin)*n.getY());
		int zpos = (int) (imageSimulation.getWidth()/(showedZmax-showedZmin)*n.getZ());
		g.fillOval(
				ypos,
				zpos
				, 5, 5);
	}
	
	
	void draw() {
		imageSimulation = new BufferedImage(centralny.getWidth(),
				centralny.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = imageSimulation.createGraphics();
		g.setColor(getBackgroundColor());
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
//		Fi
//		System.out.println("Żywe urany: "+doRozpadu+" Bar: "+nBar
//				+ " Krypton"+nKrypton+" DEAN URAN "+nDeadUran);
		Date curDate = new Date();
		String str2Write = "Żywe urany: "+doRozpadu+" Bar: "+nBar
				+ " Krypton"+nKrypton+" DEAN URAN "+nDeadUran+" "+curDate.toString();
		getInfoLines().add(str2Write);
	}
	
	
	@Override
	protected BufferedImage doInBackground() throws Exception {
		System.out.println("Myk działa");
		isRunning=true; is2Stop=false;
		if(particles ==null || simBegin ==null || neutrons ==null) {
			particles = new ArrayList<Particle>();
			neutrons = new ArrayList<Neutron>();
			simBegin = new Date();
		}
		nParticles = 50000; //temp
		while(isRunning && !is2Stop) {
			TimeUnit.MILLISECONDS.sleep(10);
			setMove();
			setToSelfExplosion();
			setToExpl();
			siatka = new Siatka(nParticles, particles);
			draw();
			publish(imageSimulation);
			info();
			while(!isRunning) {
				TimeUnit.MILLISECONDS.sleep(100);
			}
		}
		return imageSimulation;
	}
	
	protected void done() {
		try {
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
		for(BufferedImage img : chunks) {
			centralny.setImg(img);
			centralny.repaint();
			Date curDate = new Date();
			double timeSinceStart = curDate.getTime()-simBegin.getTime();
			prawy.setTime(curDate, simBegin);
			double curPower;
			if(timeSinceStart ==0) curPower=0;
			else curPower = totalEnergy/timeSinceStart;
			prawy.setEnergy(curPower);
			getTimevsPowerSeries().add(
					timeSinceStart,curPower);
		}
	}
	
	private static int nParticles;
	public int getnParticles() {
		return nParticles;
	}
	public void setnParticles(int nParticles) {
		Symulation.nParticles = nParticles;
	}
	
	//Kolory
	private static Color uraniumColor, deadUraniumColor, backgroundColor, barColor, cryptonColor;
	public static Color getUraniumColor() {
		return uraniumColor;
	}

	public static void setUraniumColor(Color uraniumColor) {
		Symulation.uraniumColor = uraniumColor;
	}

	public static Color getDeadUraniumColor() {
		return deadUraniumColor;
	}

	public static void setDeadUraniumColor(Color deadUraniumColor) {
		Symulation.deadUraniumColor = deadUraniumColor;
	}

	public static Color getBackgroundColor() {
		return backgroundColor;
	}

	public static void setBackgroundColor(Color backgroundColor) {
		Symulation.backgroundColor = backgroundColor;
	}

	public static Color getBarColor() {
		return barColor;
	}

	public static void setBarColor(Color barColor) {
		Symulation.barColor = barColor;
	}

	public static Color getCryptonColor() {
		return cryptonColor;
	}

	public static void setCryptonColor(Color cryptonColor) {
		Symulation.cryptonColor = cryptonColor;
	}






}
