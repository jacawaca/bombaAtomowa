package pogui;
// Paweł Polak Jacek Strzałkowski

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;

public class Main extends JFrame implements ChangeListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Centralny centralny;
	private Dolny dolny;
	private LewyInfo lewy;
	private PrawyInfo prawy;
	private CentralMenu menu;
	private Symulation curSymulation;
//	private M

	public Main() throws HeadlessException {
		super("Model bomby atomowej");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
//		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
//		setLayout(new BorderLayout());
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
				dolny.changeLanguage();
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
				JFileChooser chooser = new JFileChooser();
				int result = chooser.showDialog(null, "Wybierz plik do zapisania parametrów");
				if(JFileChooser.APPROVE_OPTION == result) {
					try {
						PrintWriter writer = new PrintWriter(chooser.getSelectedFile());
						writer.println("Parametry Symulacji Wybuchu Bomby Atomowej");
						writer.println("Prawdopodobieństwo samoistnego rozpadu Uranu: "+curSymulation.getpSelfExplosion()+"\n"
								+ "Prawdopodobieństwo rozpadu z wychwytu neutronu: "+curSymulation.getpExplosion()+"\n"
										+ "Ilość neutronów wyrzucana z samoistnego rozpadu: "+curSymulation.getnNeutronow()+""
												+ "Ilość atomów Uranu: "+curSymulation.getnParticles());
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Nie wybrano pliku");
					System.exit(1);
				}
			}
		});
		
	}

		

	
	ActionListener chBackground = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) { //TODO check
			Color changeBackgroundColor = JColorChooser.showDialog(null, "Wybierz kolor tła",
					centralny.getForeground());
			if(changeBackgroundColor!=null) {
				curSymulation.changeBackgroundColor(changeBackgroundColor);
				curSymulation = new Symulation(centralny, prawy);
				centralny.repaint();
				centralny.revalidate();
				curSymulation.execute();

			}
		}
	};
//	ActionListener chUraniumColor = new ActionListener() {
//		
//		@Override
//		public void actionPerformed(ActionEvent arg0) {
//			
//			
//		}
//	};
	
	
	public static void main(String[] args) {
		// test
		Main okienko = new Main();
	

	}
	@Override
	public void stateChanged(ChangeEvent e) {
	if(curSymulation!=null) {
		if(e.getSource() == lewy.pRozpadu.getValueSlider()) {
//			if(!((JSlider) e.getSource()).getValueIsAdjusting()) 
			curSymulation.setpExplosion((double)lewy.pRozpadu.getValue()/1000);
			lewy.pRozpadu.setText();
		}
		if(e.getSource() == lewy.nNeutronow.getValueSlider()) {
//			if(!((JSlider) e.getSource()).getValueIsAdjusting()) 
				curSymulation.setnNeutronow(lewy.nNeutronow.getValue() );
				lewy.nNeutronow.setText();
			
		}
		if(e.getSource() == lewy.nAtomow.getValueSlider()) {
//			if(!((JSlider) e.getSource()).getValueIsAdjusting()) 
			curSymulation.setnParticles(lewy.nAtomow.getValue());
			lewy.nAtomow.setText();
		}
	}
		
	}

}
//