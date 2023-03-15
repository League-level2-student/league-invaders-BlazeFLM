import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject{

	public Projectile(int x, int y, int width, int height, int speed) {
		super(x, y, width, height, speed);
		// TODO Auto-generated constructor stub
		speed = 10;
	}
	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
	}
	void update() {
		y -= speed;
	}
	
}
