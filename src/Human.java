import java.util.List;

/**
 * 
 * Class implemented from Entity and describes a human
 * 
 */
public class Human extends Entity {

	private String name;
	private int health;
	private int coins;

	public Human(String name, int health, int x, int y) {
		this.health = health;
		this.name = name;
		this.x = x;
		this.y = y;
		symbol = '@';
		type = "human";
	}

	public Human(String name, int health) {
		this.health = health;
		this.name = name;
		symbol = '@';
		type = "human";
	}

	/**
	 * Override method for moving form Entity based on rules of moving for a
	 * human
	 */
	public void move(List<Entity> list) {
		int newY = -1;
		int newX = -1;
		if (health == 0 || (x == 9 && y == 9)) {
			return;
		}
		if (y == 9) {
			newY = 0;
			newX = x + 1;

		} else {
			newY = y + 1;
			newX = x;
		}
		for (Entity e : list) {
			if (e.getX() == newX && e.getY() == newY) {
				return;
			}
		}
		y = newY;
		x = newX;
		health--;
	}

	public String toString() {
		String st = "Entity Properties \n";
		st = st + "TYPE:  " + getType() + "\nName: " + name + "\nHealth: "
				+ health;
		return st;
	}
}
