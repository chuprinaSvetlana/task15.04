/**
 * 
 * Class implemented from Entity and describes an obstacle
 *
 */
public class Obstacle extends Entity {

	public Obstacle(int x, int y) {
		this.x = x;
		this.y = y;
		symbol = 'O';
		type = "obstacle";
	}

	public Obstacle() {
		symbol = 'O';
		type = "obstacle";
	}

}
