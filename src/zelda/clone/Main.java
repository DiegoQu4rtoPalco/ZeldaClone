package zelda.clone;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Main extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	private static final int WHIDTH = 1366;
	private static final int HEIGHT = 738;

	private Boolean isRunning = true;
	private Thread thread;
	private BufferedImage fundo;
	private Personagem personagem;

	public Main() {
		personagem = new Personagem("/personagem.png");
		this.setPreferredSize(new Dimension(WHIDTH, HEIGHT));
		initFrame();
		fundo = new BufferedImage(WHIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
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

	public static void main(String[] args) {
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
		
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;		
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int frames = 0;
		double timer = System.currentTimeMillis();
		
		
		while(isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if(delta >= 1) {
				tick();
				render();
				frames++;
				delta--;
			}
			if(System.currentTimeMillis() - timer >= 1000) {
				System.out.println("FPS: " + frames);
				frames = 0;
				timer+=1000;
			}
		}
		stop();
	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = fundo.getGraphics();
		g = bs.getDrawGraphics();
		g.drawImage(fundo, 0, 0, 100, 100, null);
		g.setColor(new Color(190, 190, 190));
		g.fillOval(90, 90, 100, 100);
		g.dispose();
		bs.show();
	}

	private void tick() {

	}
}
