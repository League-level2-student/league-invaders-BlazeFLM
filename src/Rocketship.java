import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	boolean up = false;
	boolean down = false;
	boolean left = false;
	boolean right = false;

	public Rocketship(int x, int y, int width, int height, int speed) {
		super(x, y, width, height, speed);
		// TODO Auto-generated constructor stub
	}

	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}

	public void move() {
		if (up) {
			y -= speed;
		}
		if (down) {
			y += speed;
		}
		if (left) {
			x -= speed;
		}
		if (right) {
			x += speed;
		}
	}
}
