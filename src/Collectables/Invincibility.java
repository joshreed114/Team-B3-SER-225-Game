package Collectables;

import java.awt.image.*;

import Level.Collectable;
import Level.MapEntityStatus;
import Level.Player;

// Implements collectables (as opposed to PowerUps)
// NOTE: Collectables interact with players while PowerUps are meant to interact with enemies

public class Invincibility extends Collectable {

    public Invincibility(BufferedImage file, int x, int y, float z)
    {
        super(file, x, y, z); // Casting integer arguments to floats here helped me create new instances more easily during testing
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