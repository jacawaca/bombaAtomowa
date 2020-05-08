package pogui;

import java.util.Random;

public class Siatka {
	final int dim=100;
	int dane[][][];
	
	void setAll(int q) {
		for(int i=0;i<dim;i++) {
			for(int j=0;j<dim;j++) {
				for(int r=0;r<dim;r++) {
					dane[i][j][r]=q;
				}
			}
		}
	}
	
	int[] distribute(int n2distr) {
		int[] nX = new int[dim];
		int nfx = n2distr/dim;
		int extraX = n2distr % dim;
		for(int j=0;j<dim;j++) {
			nX[j] = nfx;
			if(extraX != 0) {
				nX[j]++;
				extraX--;
			}
			
		}
		return nX;
	}
	
	void losuj(int nCzastek) { //można ulepszyć mechanizm,
		setAll(0);
		for(int i =0;i<=nCzastek;i++) {
			int nX[] = new int[dim];
			int nfX = nCzastek/dim; //number for particular X
			int extraX = nCzastek % dim;
			for(int j=0;j<dim;j++) {
				nX[j] = nfX;
				if(extraX != 0) {
					nX[j]++;
					extraX--;
				}
				
			}
		}
		setAll(0);
		
	}
	
	public Siatka(double allMasa) {
		int nParticles = (int) ((int) allMasa/Uran.mass);
		
	}

}
