/**
 * 
 */
package pogui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * @author "Jacek Strzałkowski"
 *
 */
//Umieszczony na prawym panelu
public class RunButton extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2189911255542923920L;
	private long startTime=0;
	private boolean isRunning;

	public boolean isRunning() {
		return isRunning;
	}
	/**
	 * @param isRunning the isRunning to set
	 */
	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
		if(this.isRunning==true) this.setText("Stop");
		else this.setText("Start");
	}
	public RunButton() {
		super("START");
		
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime() {
		this.startTime = System.currentTimeMillis();
	}
}
