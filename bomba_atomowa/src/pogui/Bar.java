package pogui;

import java.util.Random;

public class Bar extends Particle {

	public Bar(int x,int  y,int  z, double energy) {
		super(x, y, z, energy);
		setExplAble(false);
		Bar.name="Bar";
		Bar.mass=137.327;
	}

}
