package zelda.clone;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;

public class Main extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1L;
	private static final int WHIDTH = 1366;
	private static final int HEIGHT = 738;
	
	private Boolean isRunning = true;
	private Thread thread;
	
	public Main() {
		this.setPreferredSize(new Dimension(WHIDTH, HEIGHT));
		initFrame();
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		isRunning = true;
		thread.start();
	}
	
	public synchronized void stop() {
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		isRunning = false;
	}
	
	public static void main(String [] args) {
		Main game = new Main();
		game.start();

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
	while(isRunning) {
		tick();
		render();
	}
	}
	
	public void render() {
				
	}

	private void tick() {
		System.out.println("Looping sendo executado");
		
	}
}
