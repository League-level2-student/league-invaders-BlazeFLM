import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject {

	public Alien(int x, int y, int width, int height, int speed) {
		super(x, y, width, height, speed);
		speed = 1;
		// TODO Auto-generated constructor stub
	}

	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
	}

	void update() {
		y += speed;
	}
}
