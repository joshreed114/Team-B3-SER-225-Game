package Level;

import java.awt.image.*;

// Implements collectables (as opposed to PowerUps, which have not yet been created at time of Collectable implementation)
// NOTE: Collectables interact with player while PowerUps are meant to interact with enemies
// When creating new instances of Collectable, pass an Image Loader as the first argument

// Note: Use CoinBronze.png for Coin, CoinSilver.png for Supercoin, CoinGold.png reserved for new coin type (which is not yet created as of Collectable implementation)
// TODO: Store the references to these image paths elsewhere, so that when creating instances the exact file name is not needed

public class Collectable extends MapEntity {

    public Collectable(BufferedImage file, int x, int y, float z)
    {
        super(file, (float) x, (float) y, z); // Casting integer arguments to floats here helped me create new instances more easily during testing...
        // When creating instances of Collectable subclasses, constructor arguments should be type [int]
        // What this means is that it's easier logically to pass parameters,
        // but the precision with which these entities can be placed on the map is reduced by a factor
	}

    @Override
    public void initialize() {
        super.initialize();
    }

    public void update(Player player) {
        super.update();
        if (intersects(player)) { touchedPlayer(player); }
    }

    // A subclass can override this method to specify what it does when it touches the player
    public void touchedPlayer(Player player) {
        this.mapEntityStatus = MapEntityStatus.REMOVED;
    }

}