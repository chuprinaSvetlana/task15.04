import java.util.List;
import java.util.Random;

/**
 * 
 * Class implemented from Entity and describes a monster
 * 
 */
public class Monster extends Entity {

	private int strength;
	private int health;

	public Monster(int strength, int health, int x, int y) {
		this.health = health;
		this.strength = strength;
		this.x = x;
		this.y = y;
		symbol = '#';
		type = "monster";

	}

	public Monster(int strength, int health) {
		this.health = health;
		this.strength = strength;
		symbol = '#';
		type = "monster";

	}

	/**
	 * Override method for moving form Entity based on rules of moving for a monster
	 */
	public void move(List<Entity> list) {

		if (health == 0) {
			return;
		}
		Random random = new Random();
		int newX = random.nextInt(10);
		int newY = random.nextInt(10);
		for (Entity e : list) {
			if (e.getX() == newX && e.getY() == newY) {
				return;
			}
		}
		y = newY;
		x = newX;

	}

	public String toString() {
		String st = "Entity Properties \n";
		st = st + "TYPE:  " + getType() + "\nHealth: " + health
				+ "\nStrength = " + strength;
		return st;
	}

}
