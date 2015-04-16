/**
 * 
 * Class implemented from Entity and describes a treasure chest
 *
 */
public class TreasureChest extends Entity {

	/** 
	 * Treasure chests contain 100 gold coins.
	 */
	private int coins;

	public TreasureChest(int x, int y) {
		this.x = x;
		this.y = y;
		symbol = '*';
		type = "treasure chest";
		coins = 100;
	}

	public TreasureChest() {
		symbol = '*';
		type = "treasure chest";
		coins = 100;
	}

}
