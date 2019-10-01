package zelda.clone;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Main extends Canvas implements Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int WHIDTH = 1366;
	private static final int HEIGHT = 738;
	
	public Main() {
		this.setPreferredSize(new Dimension(WHIDTH, HEIGHT));
		initFrame();
	}
	
	public static void main(String [] args) {
		Main game = new Main();

	}
	
	public void initFrame() {
		JFrame frame = new JFrame();
		
		frame.add(this);
		frame.setResizable(false);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	

	@Override
	public void run() {
		
		
	}
}
