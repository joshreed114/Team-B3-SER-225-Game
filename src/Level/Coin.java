package Level;

import java.awt.image.*;

// Implements Coin ("coin.png" > Resources) entities (does so in the same way as the game implements Enemies and Power Ups)
// This file is a modified Enemy.java replication
// Interactions: Player.java, Camera.java, and Map.java

public class Coin extends MapEntity {

    //TODO: add scaling option (adjust constructor and code in scaling factor)
    public Coin(BufferedImage file, int x, int y) {
        super(file, (float) x, (float) y); // Casting integer arguments to floats here helped me create new instances more easily during testing
        //TODO: convert integer parameters to floats
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