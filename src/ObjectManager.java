import java.util.ArrayList;
import java.util.Random;

public class ObjectManager{

	Rocketship rocket;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	Random random = new Random();

	public ObjectManager(Rocketship rocket) {
		this.rocket = rocket;
	}

	void addProjectile(Projectile p) {
		projectiles.add(p);
	}

	void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
	}

	void update() {
		for(Alien alien : aliens) {
			alien.update();
			if(alien.y < 0 || alien.y > LeagueInvaders.HEIGHT) {
				alien.isActive = false;
			}
		}
		for(Projectile proj : projectiles) {
			proj.update();
			if(proj.y < 0 || proj.y > LeagueInvaders.HEIGHT) {
				proj.isActive = false;
			}
					
		}
	}
}
