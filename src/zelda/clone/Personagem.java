package zelda.clone;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Personagem {
	
	private BufferedImage personagem;
	
	public Personagem(String path) {
		try {
			personagem = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public BufferedImage render(int x, int y, int whidth, int height) {
		return personagem.getSubimage(x, y, whidth, height);
	}

}
