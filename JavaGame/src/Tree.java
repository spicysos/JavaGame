
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tree extends Obstacles {
	public static final int SIZE = 200;
	public static final String IMG_FILE = "tree.png";
	public static BufferedImage img;

	public Tree(int px, int py, int width, int height) {
		super(px, py, width, height);
		try {
			if (img == null) {
				img = ImageIO.read(new File(IMG_FILE));
			}
		} catch (IOException e) {
			System.out.println("Internal Error:" + e.getMessage());
		}
	}

	@Override
	public void draw(Graphics g) {
		if (this.getPx() >= 0) {
			int curX = this.getPx();
			this.setPx(curX -= getVx());
		}
		g.drawImage(img, this.getPx(), this.getPy(), this.getWidth(), this.getHeight(), null);
	}

	@Override
	public boolean isInstance(Obstacles o) {
		return (o instanceof Tree);
	}

	@Override
	public void effects(GameCourt c) {
		c.poll();
		c.add();
	}
}