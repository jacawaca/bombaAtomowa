package pogui;

import java.util.Random;

public class Neutron{
	public Neutron(double x, double y, double z, double energy) {
		this.setX(x);
		this.setY(y);
		this.setZ(z);
		this.energy = energy;
//		System.out.print("Jestem neutronem na"+x+"  "+y+"  "+z+"\n");
	}
	protected final double mass=1;
	protected final String name="Neutron";
	private double dx, dy, dz;
	private double x,y,z, energy;
	
	
	void setDirection(double dx,double  dy,double  dz) {
		this.setDx(dx);
		this.setDy(dy);
		this.setDz(dz);
	}
	double getX() { return x;}
	double getY() { return y;}
	double getZ() { return z;}
//	void setX(double x) {this.x=x;};
//	void setY(double y) {this.y=y;};
//	void setZ(double z) {this.z=z;};
//	
	void move() {
		setX(getX() + getDx());
		setY(getY() + getDy());
		setZ(getZ() + getDz());
	}
	public double getDx() {
		return dx;
	}
	public void setDx(double dx) {
		this.dx = dx;
	}
	public double getDy() {
		return dy;
	}
	public void setDy(double dy) {
		this.dy = dy;
	}
	public double getDz() {
		return dz;
	}
	public void setDz(double dz) {
		this.dz = dz;
	}
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	public void setZ(double z) {
		this.z = z;
	}

}
