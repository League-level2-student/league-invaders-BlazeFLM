import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame = new JFrame();
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	
	public LeagueInvaders(JFrame frame) {
		this.frame = frame;
	}
	
	void setup() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		//LeagueInvaders newFrame = new LeagueInvaders(frame);
	}
}
