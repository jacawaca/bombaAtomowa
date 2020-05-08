package pogui;

import java.util.Random;

public class Neutron extends Particle {
	private double dx, dy, dz;
	public Neutron(double x, double y, double z, double energy, Random generator) {
		super(x, y, z, energy, generator);
		Neutron.name="Neutron";
		Neutron.mass=1;
	}
	
	void setDirection(double dx,double  dy,double  dz) {
		this.dx=dx;
		this.dy=dy;
		this.dz=dz;
	}

}
