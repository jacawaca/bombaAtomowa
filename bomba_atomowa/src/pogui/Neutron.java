package pogui;

import java.util.Random;

public class Neutron{
	public Neutron(double x, double y, double z, double energy) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.energy = energy;
//		System.out.print("Jestem neutronem na"+x+"  "+y+"  "+z+"\n");
	}
	protected final double mass=1;
	protected final String name="Neutron";
	private double dx, dy, dz;
	private double x,y,z, energy;
	
	
	void setDirection(double dx,double  dy,double  dz) {
		this.dx=dx;
		this.dy=dy;
		this.dz=dz;
	}
	double getX() { return x;}
	double getY() { return y;}
	double getZ() { return z;}

}
