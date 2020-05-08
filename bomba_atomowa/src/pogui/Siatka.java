package pogui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Siatka {
	final int dim=100;
	final int uranMass=232;
	int dane[][][];
	final double energiaUran = 100;
	
	private List<Particle> particle; //= new ArrayList<Particle>();
	
	void setAll(int q) {
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
	
	/** Kod ze strony https://javer.org/losowanie-bez-zwracania-java/ Można???
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
	
	void losuj(int nCzastek) { //można ulepszyć mechanizm,
		setAll(0);
		int nX[] = distribute(nCzastek);
		System.out.println("\n");
		for(int i =0;i<dim;i++) {
			int[] nX_Y = distribute(nX[i]);
			for(int j=0;j<dim;j++) {
				int[] randPosition = withoutReturn(nX_Y[j], dim-1, true);
				for(int q=0;q<randPosition.length;q++) {
					if(i > 100 || j>100) System.err.print("Błąd");
					dane[i][j][randPosition[q]]=1;
					particle.add(new Uran(i,j,randPosition[q],100.1));
				}
			}
		}
		}
		
		
	
	public Siatka(int nParticles, List<Particle> particles) {
		this.particle=particles;
		dane = new int[dim][dim][dim];
//		int nParticles = 10000;
		losuj(nParticles);
		
	}

//	public static void main(String[] args) {
//		// test
//		Siatka test = new Siatka(10000);
////		test.printAll();
//		
//
//	}
}
