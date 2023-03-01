import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame = new JFrame();
	GamePanel panel = new GamePanel();

	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;

	LeagueInvaders() {
		this.frame = new JFrame();
		this.panel = new GamePanel();
	}

	void setup() {
		frame.add(panel);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(panel);
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		LeagueInvaders newFrame = new LeagueInvaders();
		newFrame.setup();
	}
}
