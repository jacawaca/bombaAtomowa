package pogui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Siatka {
	final int dim=100;
	final int uranMass=232;
	byte dane[][][];
	final double energiaUran = 100;
	private Random random;//Każda siatka ma swój własny…
	
	private final double pExplosion=0.01,
			pChangeMove=0.01;
	
	private List<Particle> particles; //= new ArrayList<Particle>();
	
	void setAll(byte q) {
		for(int i=0;i<dim;i++) {
			for(int j=0;j<dim;j++) {
				for(int r=0;r<dim;r++) {
					dane[i][j][r]=q;
				}
			}
		}
	}
	
	void zeroTab(int tab[]) {
		for (int j = 0; j < tab.length; j++) {
			tab[j]=0;
		}
	}
	
	void printAll() { //temp
		for(int i=0;i<dim;i++) {
			for(int j=0;j<dim;j++) {
				for(int r=0;r<dim;r++) {
					System.out.print(dane[i][j][r]+" ");
				}
				System.out.print("\n");
			}
			System.out.print("\n\n");
		}
	}
	
	int[] distribute(int n2distr) {
		int[] nX = new int[dim];
		int nfx = n2distr/dim;
		int extraX = n2distr % dim;
		for(int j=0;j<dim;j++) {
			nX[j] = nfx;
			if(extraX > 0) {
				nX[j]++;
				extraX--;
			}
			
		}
		return nX;
	}
	
	/** Kod ze strony https://javer.org/losowanie-bez-zwracania-java/
     * Zwraca tablicę k liczb wybraych losowo z tablicy od 1 do n liczb bez
     * zwracania (powtórzeń)
     * @param k      int - liczba wybieranych liczb
     * @param n      int - największa liczba
     * @param sorted boolean - określa czy wyjściowa tablica liczb będzie
     *               posortowana czy nie, <code>true</code> oznacza tablicę posortowaną, <code>false</code>
     *               oznacza tablicę nie sortowaną
     * @return int[] - tablica wybranych liczb
     */
    public static int[] withoutReturn(int k, int n, boolean sorted) {
        int[] wynik = new int[k];
        if (k > n) {
            System.out
                    .println("pierwsza liczba nie moze byc wieksza od drugiej");
        } else {
            int[] liczby = new int[n];
            for (int j = 0; j < liczby.length; j++) {
                liczby[j] = j + 1;
            }
            for (int i = 0; i < wynik.length; i++) {
                int l = (int) Math.floor(Math.random() * n);
                wynik[i] = liczby[l];
                liczby[l] = liczby[n - 1];
                n--;
            }
            if (sorted) {
                Arrays.sort(wynik);
            }
        }
        return wynik;
    }
    //Koniec 
//    


    
	
	void losuj(int nCzastek) { //można ulepszyć mechanizm,
		int nX[] = distribute(nCzastek);
		System.out.println("\n");
		for(int i =0;i<dim;i++) {
			int[] nX_Y = distribute(nX[i]);
			for(int j=0;j<dim;j++) {
				int[] randPosition = withoutReturn(nX_Y[j], dim-1, true);
				for(int q=0;q<randPosition.length;q++) {
					if(i > 100 || j>100) System.err.print("Błąd");
					dane[i][j][randPosition[q]]=1;
					particles.add(new Uran(i,j,randPosition[q],100.1));
				}
			}
		}
		}
		
	void actualize() {
		for(Particle p: particles) {
			if(p instanceof Uran) {
				if(p.isExplAble()) dane[p.getX()][p.getY()][p.getZ()]=1;
				else dane[p.getX()][p.getY()][p.getZ()]=4;
			}
			else if(p instanceof Krypton) {
				dane[p.getX()][p.getY()][p.getZ()]=2;
			}
			else if (p instanceof Bar) {
				dane[p.getX()][p.getY()][p.getZ()]=3;
			}
		}
		

	}
		
	
	public Siatka(int nParticles, List<Particle> particles) {
		this.particles=particles;
		dane = new byte[dim][dim][dim];
		if(particles.isEmpty()) {
			losuj(nParticles);
		}
		else {
//			System.out.println("MYK");
			actualize();
		}
		
		random = new Random();
		
//		int nParticles = 10000;
		
		
	}

//	public static void main(String[] args) {
//		// test
//		Siatka test = new Siatka(10000);
////		test.printAll();
//		
//
//	}
}
