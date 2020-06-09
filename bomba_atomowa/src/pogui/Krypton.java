package pogui;

import java.util.Random;

public class Krypton extends Particle {

	public Krypton(int x, int y, int z, double energy) {
		super(x, y, z, energy);
		setExplAble(false);
		Krypton.name="Krypton";
//		System.out.println("KRY");
		Krypton.mass=83.798;
	}

}
