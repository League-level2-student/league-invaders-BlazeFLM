import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titleFont = new Font("Arial", Font.PLAIN, 48);
	Font instructionsFont = new Font("Arial", Font.PLAIN, 30);
	Timer frameDraw;
	Timer alienSpawn;
	Rocketship rocket = new Rocketship(250, 700, 50, 50, 10);
	ObjectManager karen = new ObjectManager(rocket);

	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;

	public GamePanel() {
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();

		if (needImage) {
			loadImage("space.png");
		}

	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}
	}

	void updateMenuState() {
		karen.score = 0;
	}

	void updateGameState() {
		rocket.move();
		karen.update();
		if (rocket.isActive == false) {
			currentState = END;
		}
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 25, 150);
		g.setFont(instructionsFont);
		g.drawString("Press ENTER to start", 100, 300);
		g.drawString("Press SPACE for instructions", 50, 450);
	}

	void drawGameState(Graphics g) {
		if (gotImage) {
			g.drawImage(image, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		}
		karen.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("Game Over", 25, 150);
		g.setFont(instructionsFont);
		g.drawString("You have killed " + karen.getScore() + " enemies", 50, 300);
		g.drawString("Press ENTER to restart", 50, 450);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {
			updateGameState();
		} else if (currentState == END) {
			updateEndState();
		}
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END) {
				rocket = new Rocketship(250, 700, 50, 50, 10);
				karen = new ObjectManager(rocket);
				currentState = MENU;
			} else if (currentState == MENU) {
				currentState++;
				startGame();
			} else if (currentState == GAME) {
				currentState++;
				alienSpawn.stop();
			}
		}
		if (arg0.getKeyCode() == KeyEvent.VK_SPACE) {
			if (currentState == GAME) {
				karen.addProjectile(rocket.getProjectile());
			}
		}
		if (currentState == GAME) {
			if (arg0.getKeyCode() == KeyEvent.VK_UP) {
				//System.out.println("UP");
				rocket.up = true;
				repaint();
			}

			if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
				//System.out.println("DOWN");
				rocket.down = true;
				repaint();

			}
			if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {
				//System.out.println("LEFT");
				rocket.left = true;
				repaint();
			}
			if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
				//System.out.println("RIGHT");
				rocket.right = true;
				repaint();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode() == KeyEvent.VK_UP) {
			rocket.up = false;
		}
		if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
			rocket.down = false;
		}
		if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {
			rocket.left = false;
		}
		if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
			rocket.right = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	void startGame() {
		alienSpawn = new Timer(1000, karen);
		alienSpawn.start();
	}

	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}
}
