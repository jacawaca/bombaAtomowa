package pogui;

import java.util.Random;

public class Bar extends Particle {

	public Bar(double x, double y, double z, double energy, Random generator) {
		super(x, y, z, energy, generator);
		Bar.name="Bar";
		Bar.mass=137.327;
	}

}
