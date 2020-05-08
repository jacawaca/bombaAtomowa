package pogui;

import java.util.Random;

public class Neutron extends Particle {
	private double dx, dy, dz;
	public Neutron(double x, double y, double z, double energy) {
		super(x, y, z, energy);
		Neutron.name="Neutron";
		Neutron.mass=1;
	}
	
	void setDirection(double dx,double  dy,double  dz) {
		this.dx=dx;
		this.dy=dy;
		this.dz=dz;
	}
	double getX() { return x;}
	double getY() { return y;}
	double getZ() { return z;}

}
