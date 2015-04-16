import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class RoomTest {

	Room room;
	
	@Before
	public final void setup() {
		room = new Room();
	}
	
	@Test
	public void testWrongCoordinate() {
		room.addNewEntityinRoom(new Obstacle(), -1, -1);
		assertTrue(room.getList().size() == 0);
	}
	@Test
	public void testSameCoordinatesForTwoEntities() {
		room.addNewEntityinRoom(new Obstacle(), 0, 0);
		assertFalse(room.addNewEntityinRoom(new TreasureChest(), 0, 0));
	}
	
	@Test
	public void testIsFree() {
		room.addNewEntityinRoom(new Obstacle(), 0, 0);
		assertFalse(room.isFree(0, 0));
		assertTrue(room.isFree(1, 1));
		assertFalse(room.isFree(-1, 10));
	}
	@Test
	public void testDisplayEntity() {
		room.addNewEntityinRoom(new Obstacle(), 0, 0);
		assertTrue(room.displayEntity(1, 1).equals("No entity on this pisition"));
	}
	@Test
	public void testResetRoom() {
		room.addNewEntityinRoom(new Obstacle(), 0, 0);
		room.resetRoom();
		assertTrue(room.getList().size() == 0);
	}
	@Test
	public void test() {
		room.addNewEntityinRoom(new Obstacle(), 0, 1);
		Human h = new Human("TestHuman", 100);
		room.addNewEntityinRoom(h, 0, 0);
		room.move();
		assertTrue(h.getX() == 0 && h.getY() == 0);
	}
}
