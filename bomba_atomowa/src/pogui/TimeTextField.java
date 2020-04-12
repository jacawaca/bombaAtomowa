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
	public void setStartTime(long startTime) {
		this.startTime=startTime;
	}
	private static final long serialVersionUID = 1L;
	public TimeTextField() {
		super("0");
		
	}
	@Override
	public void run() {
		while(isRunning) {
			long dt = System.currentTimeMillis() - startTime;
			setText(Long.toString(dt));
		}
	}

}
