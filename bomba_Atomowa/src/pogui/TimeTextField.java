/**
 * 
 */
package pogui;

import javax.swing.JTextField;

/**
 * @author "Jacek Strzałkowski"
 *
 */
public class TimeTextField extends JTextField implements Runnable {
	/**
	 * 
	 */
	private long startTime;
	private boolean isRunning;
	public void setisRunning(boolean isR){
		this.isRunning=isR;
	}
	
	public void setStartTime(long startTime) {
		this.startTime=startTime;
	}
	private static final long serialVersionUID = 1L;
	public TimeTextField() {
		super("0,00 s");
		
	}
	@Override
	public void run() {
		while(isRunning) {
			long dt = System.currentTimeMillis() - startTime;
			setText(Long.toString(dt/1000,0) + " s");
		}
		setText("0,00 s");
	}

}
