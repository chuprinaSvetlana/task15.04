/*
 * Class that stores the positions of all the entities
 * Methods to add entities, display the room, display information are not implemented
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 
 * @author Arantza
 */
public class Room {
	// List with all the entities
	private ArrayList<Entity> entities = new ArrayList<Entity>();
	private Random random = new Random();

	/**
	 * Set up a new room with entities in random places first the room, must be
	 * clear of entities
	 */
	public void resetRoom() {
		clearRoom();
	}

	/**
	 * method that adds a new entity into a position PRE: position (x,y) must be
	 * empty
	 * 
	 * @param e
	 *            The entity 0<=x<=9 and 0<=y<=9
	 * 
	 */
	public boolean addNewEntityinRoom(Entity e, int x, int y) {
		if (x > 9 || x < 0 || y > 9 || y < 0) {
			return false;
		}
		if (isFree(x, y)) {
			e.setPosition(x, y);
			entities.add(e);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Empty the list of entities
	 */
	public void clearRoom() {
		entities.clear();
	}

	/**
	 * Method that tell us if a cell is occupied by an entity
	 * 
	 * @param x
	 *            row 0 <= x <= 9
	 * @param y
	 *            column 0 <= y <= 9
	 * @return true is cell free
	 */
	public boolean isFree(int x, int y) {
		if (x > 9 || x < 0 || y > 9 || y < 0) {
			return false;
		}
		for (Entity e : entities) {
			if (e.getX() == x && e.getY() == y) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Method that returns the position in the arrayList occupied by an entity
	 * given its coordinates
	 * 
	 * @param x
	 *            row 0 <= x <= 9
	 * @param y
	 *            column 0 <= y <= 9
	 * @return position in the list or -1 if the cell is free
	 */
	private int getPosition(int x, int y) {
		for (Entity e : entities) {
			if (e.getX() == x && e.getY() == y) {
				return entities.indexOf(e);
			}
		}
		return -1;
	}

	/**
	 * Display all the properties of an entity that occupies a particular cell
	 * PRE: Cell must not be empty
	 * 
	 * @param x
	 *            row 0<= x <=9
	 * @param y
	 *            column 0<=y<=9
	 * @return String with the properties of the entity or
	 * 
	 */
	public String displayEntity(int x, int y) {
		if (x > 9 || x < 0 || y > 9 || y < 0) {
			return "No entity on this pisition";
		}
		for (Entity e : entities) {
			if (e.getX() == x && e.getY() == y) {
				return e.toString();
			}
		}
		return "No entity on this pisition";
	}

	/**
	 * method that moves all the entities that are animated on the room
	 */
	public void move() {
		for (Entity e : entities) {
			e.move(entities);
		}
	}

	/**
	 * Display the room
	 */

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("  0 1 2 3 4 5 6 7 8 9");
		boolean isEmpty = true;
		for (int i = 0; i < 10; i++) {
			builder.append("\n" + i + " ");
			for (int j = 0; j < 10; j++) {
				for (Entity e : entities) {
					if (e.getX() == i && e.getY() == j) {
						builder.append(e.getSymbol() + " ");
						isEmpty = false;
						break;
					}
				}
				if (isEmpty) {
					builder.append(". ");
				} else {
					isEmpty = true;
				}

			}
		}
		return builder.toString();
	}

	/**
	 * Generate an initial state of room. The initial state of the game should
	 * con 2 treasure chests, 4 obstacles, 2 monsters and 3 humans placed
	 * randomly in the room
	 */
	public void initialState() {

		addNewEntityinRoom(new Obstacle(), random.nextInt(10),
				random.nextInt(10));
		/**
		 * Coordinate generation for the entity until the coordinates are not different from the previous 
		 */
		while (!addNewEntityinRoom(new Obstacle(), random.nextInt(10),
				random.nextInt(10))) {}
		while (!addNewEntityinRoom(new Obstacle(), random.nextInt(10),
				random.nextInt(10))) {}
		while (!addNewEntityinRoom(new Obstacle(), random.nextInt(10),
				random.nextInt(10))) {}

		while (!addNewEntityinRoom(new TreasureChest(), random.nextInt(10),
				random.nextInt(10))) {}
		while (!addNewEntityinRoom(new TreasureChest(), random.nextInt(10),
				random.nextInt(10))) {}

		while (!addNewEntityinRoom(
				new Monster(random.nextInt(10), random.nextInt(100)),
				random.nextInt(10), random.nextInt(10))) {}
		while (!addNewEntityinRoom(
				new Monster(random.nextInt(10), random.nextInt(100)),
				random.nextInt(10), random.nextInt(10))) {}

		while (!addNewEntityinRoom(new Human("Harold", 100),
				random.nextInt(10), random.nextInt(10))) {}
		while (!addNewEntityinRoom(new Human("David", 100), random.nextInt(10),
				random.nextInt(10))) {}
		while (!addNewEntityinRoom(new Human("Clare", 100), random.nextInt(10),
				random.nextInt(10))) {}
	}

	/**
	 * Method for getting a list, that contains entities of this room
	 */
	public List<Entity> getList() {
		return (List<Entity>) entities.clone();
	}

}
