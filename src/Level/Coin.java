package Level;

import java.awt.image.*;

/* COIN NOTES
*/

//
//

/*
********
* Add coin counter to top right of screen -- Just add "[graphic] - [player.getCoins()]" and make sure scales appropriately
* Add "Coins Collected: X [graphic]" to end of level screen
* Test aspect ratio scaling for both implementations
********
* Create supercoin graphic
* Add new COIN_TYPE class that stores "COIN", "SUPERCOIN"
* if (COIN_TYPE == COIN) ADD 1 to addCoin() else if SUPERCOIN, 5 (use TextMaze format)

    example:

            public static final char
			WALL = '#',
			EMPTY = ' ',
			GOAL = 'G',
			START = 'S',
			PATH = 'P',
			VISITED = '.';

* Adjust Player addCoin() method
* Implement supercoin logic (Supercoin extends Coin)
* Add 1 supercoin to level three and 2 supercoins to level four
* Add rest of coins to rest of levels
********
* Find sound file for coin & supercoin pick-up
* Implement new sound files
* If player dies, lose all coins collected during that previous level
********
*/

// Implements Coin ("coin.png" > Resources) entities (does so in the same way as the game implements Enemies and Power Ups)
// This file is a modified Enemy.java replication
// Interactions: Player.java, Camera.java, and Map.java

public class Coin extends MapEntity {

    public Coin(BufferedImage file, int x, int y) {
        super(file, (float) x, (float) y, (float) 0.4); // Casting integer arguments to floats here helped me create new instances more easily during testing
        // Also, I put in 0.4 as the scaling ratio because it seemed to look most appropriate compared to the size of the player's avatar
	}

    @Override
    public void initialize() {
        super.initialize();
    }

    public void update(Player player) {
        super.update();
        if (intersects(player)) {
            touchedPlayer(player);
        }
    }

    // A subclass can override this method to specify what it does when it touches the player
    public void touchedPlayer(Player player) {
        player.addCoin(); // Calls method in Player class to increment number of coins the player has collected by 1
        this.mapEntityStatus = MapEntityStatus.REMOVED;
    }

}