/*
 * Main template class with the menu with all the options
 * 
 */

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * @author Arantza
 */
public class GameController {

	static void menu() {

		System.out.println("\nEnter an option");
		System.out.println(" 1: Display level");
		System.out.println(" 2: Move animated entities");
		System.out.println(" 3: Display the properties of an entity");
		System.out.println(" 4: Add an Entity");
		System.out.println(" 5: Reset the room");
		System.out.println(" 0: Exit");
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {

		Room crashWorldRoom = new Room();
		crashWorldRoom.initialState();

		System.out.println(crashWorldRoom.toString());

		Scanner kb = new Scanner(System.in);
		String option;

		do {

			menu();

			option = kb.next();

			int x, y, strng, hlth;
			String name;
			switch (option) {
			case "1":
				System.out.println("\nYour room:");
				System.out.println(crashWorldRoom);
				break;
			case "2":
				System.out.println("\nAll of the entities was moved!");
				crashWorldRoom.move();
				break;
			case "3":
				System.out
						.println("\nEnter the position of the entity, that you want to display: ");

				x = kb.nextInt();
				y = kb.nextInt();

				System.out.println(crashWorldRoom.displayEntity(x, y));
				break;
			case "4":
				System.out
						.println("\nWhat type of entity you want to add?\n1 - obstacle\n2 - tresure chest\n"
								+ "3 - monster\n4 - human ");

				String type = kb.next();
				switch (type) {
				/**
				 * Different sequence of actions to create entity
				 */
				case "1":
					System.out
							.println("\nEnter coordinate x and y of your obstacle:");
					try {
						x = kb.nextInt();
						y = kb.nextInt();
						if (crashWorldRoom.addNewEntityinRoom(new Obstacle(),
								x, y)) {
							System.out.println("New obstacle was added");
						} else {
							System.out
									.println("Sorry, but this position is occuped");
						}
					} catch (InputMismatchException e) {
						System.out.println("Sorry wrong option");
					}
					break;
				case "2":
					System.out
							.println("\nEnter coordinate x and y of your tresure chest:");
					try {
						x = kb.nextInt();
						y = kb.nextInt();
						if (crashWorldRoom.addNewEntityinRoom(
								new TreasureChest(), x, y)) {
							System.out.println("New treasure chest was added");
						} else {
							System.out
									.println("Sorry, but this position is occuped");
						}
					} catch (InputMismatchException e) {
						System.out.println("Sorry wrong option");
					}
					break;
				case "3":
					System.out
							.println("\nEnter coordinate x and y of your monster:");
					try {
						x = kb.nextInt();
						y = kb.nextInt();
						System.out.println("Enter strength of yours monster:");
						strng = kb.nextInt();
						System.out.println("Enter health of yours monster:");
						hlth = kb.nextInt();
						if (crashWorldRoom.addNewEntityinRoom(new Monster(
								strng, hlth), x, y)) {
							System.out.println("New monster was added");
						} else {
							System.out
									.println("Sorry, but this position is occuped");
						}
					} catch (InputMismatchException e) {
						System.out.println("Sorry wrong option");
					}
					break;
				case "4":
					System.out
							.println("\nEnter coordinate x and y of your human:");
					try {
						x = kb.nextInt();
						y = kb.nextInt();
						System.out.println("Enter name of yours human:");
						name = kb.next();
						System.out.println("Enter health of yours human:");
						hlth = kb.nextInt();
						if (crashWorldRoom.addNewEntityinRoom(new Human(name,
								hlth), x, y)) {
							System.out.println("New human was added");
						} else {
							System.out
									.println("Sorry, but this position is occuped");
						}
					} catch (InputMismatchException e) {
						System.out.println("Sorry wrong option");
					}
					break;
				default:
					System.out.println("Sorry wrong option");
				}

				break;
			case "5":
				System.out.println("\nRoom state was reseted:");
				crashWorldRoom.resetRoom();
				break;
			case "0":
				System.out.println("Good bye");
				break;

			default:
				System.out.println("Sorry wrong option");
			}

		} while (!option.equals("0"));

	}
}
