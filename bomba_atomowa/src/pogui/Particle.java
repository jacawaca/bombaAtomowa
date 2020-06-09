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
	protected double energy;//, dx, dy, dz;
	protected int  x, y, z;
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getZ() {
		return z;
	}
	
	public Particle(int x, int y, int z, double energy) {
		beginLife = new Date();
		this.x=x;
		this.y=y;
		this.z=z;
		this.energy=energy;
	}
	
	void whoAmI() {
		System.out.println("x, y, z: "+x+" "+y+" "+z+". Jestem"+name);
	}
	
	public void death() {
		endLife= new Date();
	}
	private boolean isExplAble;
	public boolean isExplAble() {
		return isExplAble;
	}
	public void setExplAble(boolean isExplAble) {
		this.isExplAble = isExplAble;
	}
	
}
