/**
 * 
 */
package pogui;

import java.util.Date;
import java.util.Random;


//import jdk.nashorn.internal.objects.annotations.Getter;

/**
 * @author "Jacek Strzałkowski"
 *
 */
public abstract class Particle {
	protected static double mass;
	protected static String name;
	protected Date beginLife, endLife; //Rejestr życia cząsteczki -> odtworzenie animacji
	protected double energy, x, y, z;//, dx, dy, dz;

	
	public Particle(double x, double y, double z, double energy, Random generator) {
		beginLife = new Date();
		this.x=x;
		this.y=y;
		this.z=z;
		this.energy=energy;
	}
	
	public void death() {
		endLife= new Date();
	}
	
	
}
