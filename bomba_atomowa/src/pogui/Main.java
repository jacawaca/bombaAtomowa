package pogui;
// Paweł Polak Jacek Strzałkowski

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;

public class Main extends JFrame implements ChangeListener{
	/**
	 *  Nie udało się zaimplementować
	 *  + energii jako sumy 
	 */
	private static final long serialVersionUID = 1L;
	private Centralny centralny;
	private Dolny dolny;
	private LewyInfo lewy;
	private PrawyInfo prawy;
	private CentralMenu menu;
	private Symulation curSymulation;

	public Main() throws HeadlessException {
		super("Model bomby atomowej");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		lewy = new LewyInfo();
		prawy = new PrawyInfo();
		
		add(lewy, BorderLayout.LINE_START);
		add(prawy, BorderLayout.LINE_END);
		centralny = new Centralny();
		add(centralny, BorderLayout.CENTER);
		dolny = new Dolny();
		add(dolny, BorderLayout.PAGE_END);
		
		menu = new CentralMenu();
		setJMenuBar(menu);
		setVisible(true);
		ActionListener simStart = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(curSymulation ==null) {
					curSymulation = new Symulation(centralny, prawy);
					
					curSymulation.setnNeutronow(lewy.nNeutronow.getValue() );
					curSymulation.setpExplosion((double)lewy.pRozpadu.getValue()/1000);
					curSymulation.setnParticles(lewy.nAtomow.getValue());
					curSymulation.execute();
				}
				else {
					if(!curSymulation.isRunning()) {
						System.out.println("Pauza");
					curSymulation.setRunning(true);
					curSymulation.execute();
					}
					else {
						curSymulation.setRunning(false);
					}
				}
			}
		};
		dolny.runButton.addActionListener(simStart);
		
		ActionListener chLanguage = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				lewy.changeLanguage(); prawy.changeLanguage();
				dolny.changeLanguage(); menu.changeLanguage();
			}
		};
		menu.chLang.addActionListener(chLanguage);
		
		menu.chBackground.addActionListener(chBackground);
		
		lewy.pRozpadu.setListener(this);
		lewy.nNeutronow.setListener(this);
		lewy.nAtomow.setListener(this);
		
		menu.drawPlot.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(curSymulation == null) {
					JOptionPane.showMessageDialog(null, "Nie rozpoczęto symulacji, zatem nie ma na czym rysować wykresu.");
					return ;
				}
				else {
					curSymulation.setRunning(true);
					XYSeriesCollection dataset = new XYSeriesCollection();
					dataset.addSeries(curSymulation.getTimevsPowerSeries());
					JFreeChart chart = ChartFactory.createXYAreaChart(
						"Wykres Mocy reakcji jądrowej",//Tytul
						"Czas (s)", // opisy osi
						"Moc wybuchu", 
						dataset, // Dane 
						PlotOrientation.VERTICAL, // Orjentacja wykresu /HORIZONTAL
						true, // legenda
						true, // tooltips
						false
					);
					//Dodanie wykresu do okna
					ChartFrame chartFrame=new ChartFrame("Wykres mocy",chart);
					chartFrame.setVisible(true);
					chartFrame.setSize(500,400);
					curSymulation.setRunning(false);
				}
				
			}
		});
		
		menu.resetItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				curSymulation.setStopped(true);
				curSymulation = new Symulation(centralny, prawy);
				
				curSymulation.setnNeutronow(lewy.nNeutronow.getValue() );
				curSymulation.setpExplosion((double)lewy.pRozpadu.getValue()/1000);
				curSymulation.setnParticles(lewy.nAtomow.getValue());
				curSymulation.execute();
			}
		});
		
		menu.outItem.addActionListener(new ActionListener() { //Wypisuje parametry
			@Override
			public void actionPerformed(ActionEvent e) {
				curSymulation.setRunning(false);
				if(curSymulation==null) { JOptionPane.showMessageDialog(null, "Brak Symulacji"); System.exit(ABORT);}
				JFileChooser chooser = new JFileChooser();
				int result = chooser.showDialog(null, "Wybierz plik do zapisania parametrów");
				if(JFileChooser.APPROVE_OPTION == result) {
					try {
						PrintWriter writer = new PrintWriter(chooser.getSelectedFile());
						writer.println("Parametry Symulacji Wybuchu Bomby Atomowej");
						writer.println("Prawdopodobieństwo samoistnego rozpadu Uranu:\n"+curSymulation.getpSelfExplosion()+"\n"
								+ "Prawdopodobieństwo rozpadu z wychwytu neutronu:\n"+curSymulation.getpExplosion()+"\n"
										+ "Ilość neutronów wyrzucana z samoistnego rozpadu:\n"+curSymulation.getnNeutronow()+"\n"
												+ "Ilość atomów Uranu:\n"+curSymulation.getnParticles());
						writer.close();
						JOptionPane.showMessageDialog(null, "Zapisano do pliku "+chooser.getSelectedFile().getAbsolutePath());
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Nie wybrano pliku");
					System.exit(1);
				}
				curSymulation.setRunning(true);
			}
		});
		
		menu.inItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { //Biedne ale działa :(
				curSymulation.setRunning(false); //zatrzymujemy symulację
				JFileChooser chooser = new JFileChooser(); 
				int result = chooser.showDialog(null, "Wybierz plik z którego chcesz wczytać parametry");
				if(JFileChooser.APPROVE_OPTION==result) {
					try {
						BufferedReader reader = new BufferedReader(new FileReader(chooser.getSelectedFile()));
						String st = reader.readLine(); reader.readLine();
						st = reader.readLine();
						double gotPWybuchu = Double.parseDouble(st); reader.readLine(); st=reader.readLine(); //samoistnego
						double gotPReakcja = Double.parseDouble(st); reader.readLine(); st=reader.readLine();
						int gotnNeutronow = Integer.parseInt(st); reader.readLine(); st=reader.readLine();
						int gotnUranow = Integer.parseInt(st); reader.readLine(); st=reader.readLine();
						reader.close();
						JOptionPane.showMessageDialog(null, "Wczytano+"+gotPWybuchu+" "+gotPReakcja+" "+gotnNeutronow+" "+gotnUranow);
						if(gotPWybuchu*100>=lewy.pRozpadu.getValueSlider().getMinimum() && gotPWybuchu*100<=lewy.pRozpadu.getValueSlider().getMaximum()) {
							lewy.pRozpadu.setValue((int)gotPWybuchu*100);
						} else System.exit(1);
						if(gotnNeutronow >= lewy.nNeutronow.getValueSlider().getMinimum() && gotnNeutronow <= lewy.nNeutronow.getValueSlider().getMaximum()) {
							lewy.nNeutronow.getValueSlider().setValue(gotnUranow);
						} else System.exit(1);
						if(gotnUranow >= lewy.nAtomow.getValueSlider().getMinimum() && 
								gotnUranow <= lewy.nAtomow.getValueSlider().getMaximum()) {
							lewy.nAtomow.getValueSlider().setValue(gotnUranow);
						} else System.exit(1);
						//Resetowanie symulacji
						curSymulation.setStopped(true);
						curSymulation = new Symulation(centralny, prawy);
						
						curSymulation.setnNeutronow(lewy.nNeutronow.getValue() );
						curSymulation.setpExplosion((double)lewy.pRozpadu.getValue()/1000);
						curSymulation.setnParticles(lewy.nAtomow.getValue());
						curSymulation.execute();
						
						
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			curSymulation.setRunning(true); //wznawiamy symulację	
			}
		});
		menu.resultItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				curSymulation.setRunning(false);
				JFileChooser chooser = new JFileChooser(); 
				int result = chooser.showDialog(null, "Zapisz plik z wynikiem symulacji");
				if(JFileChooser.APPROVE_OPTION==result) {
					try {
						PrintWriter writer = new PrintWriter(chooser.getSelectedFile());
						for(String i: curSymulation.getInfoLines()) {
							writer.println(i);
						}
						writer.close();
						JOptionPane.showMessageDialog(null, "Zapisano do pliku "+chooser.getSelectedFile().getAbsolutePath());
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
				}
				curSymulation.setRunning(true);
				
			}
		});
		menu.uranColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Color changeUranium = JColorChooser.showDialog(null, "Wybierz kolor tła",
						Symulation.getUraniumColor());
				if(changeUranium!=null) {
					Symulation.setUraniumColor(changeUranium);
				}
				
			}
		});
		menu.deadUranColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Color changeDeadUranium = JColorChooser.showDialog(null, "Wybierz kolor tła",
						Symulation.getDeadUraniumColor());
				if(changeDeadUranium!=null) {
					Symulation.setDeadUraniumColor(changeDeadUranium);
				}
				
			}
		});
		menu.kryptonColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Color changeKrypton = JColorChooser.showDialog(null, "Wybierz kolor tła",
						Symulation.getCryptonColor());
				if(changeKrypton!=null) {
					Symulation.setCryptonColor(changeKrypton);
				}
				
			}
		});
		
	}

		

	
	ActionListener chBackground = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) { //TODO check
			Color changeBackgroundColor = JColorChooser.showDialog(null, "Wybierz kolor tła",
					Symulation.getBackgroundColor());
			if(changeBackgroundColor!=null) {
				Symulation.setBackgroundColor(changeBackgroundColor);
			}
		}
	};
	
	
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Main okienko = new Main();
	

	}
	@Override
	public void stateChanged(ChangeEvent e) {
	if(curSymulation!=null) {
		if(e.getSource() == lewy.pRozpadu.getValueSlider()) {
			curSymulation.setpExplosion((double)lewy.pRozpadu.getValue()/1000);
			lewy.pRozpadu.setText();
		}
		if(e.getSource() == lewy.nNeutronow.getValueSlider()) {
				curSymulation.setnNeutronow(lewy.nNeutronow.getValue() );
				lewy.nNeutronow.setText();
			
		}
		if(e.getSource() == lewy.nAtomow.getValueSlider()) {
			curSymulation.setnParticles(lewy.nAtomow.getValue());
			lewy.nAtomow.setText();
		}
	}
		
	}

}
//