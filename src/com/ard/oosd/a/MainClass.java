/**
 * 
 */
package com.ard.oosd.a;

import java.awt.EventQueue;

import com.ard.oosd.r.WindowMain;

/**
 * @author Arko
 *
 */
public class MainClass {

	/**
	 * @param args
	 * This class is only for my personal testing purpose.
	 * TODO remove once there is a different path of execution
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowMain window = new WindowMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
