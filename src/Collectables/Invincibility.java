package Collectables;

import java.awt.image.*;

import Level.Collectable;
import Level.MapEntityStatus;
import Level.Player;

// Could change Invincibility to a water-proof potion type thing that player can equip using a key and has an amount of time attached to it

public class Invincibility extends Collectable {

    public Invincibility(BufferedImage file, int x, int y)
    {
        super(file, x, y, 0.3f); // Since not subclass of Coin, needs to directly pass scaling factor float argument to parent
	}

    @Override
    public void initialize() {
        super.initialize();
    }

    public void update(Player player) {
        super.update();
        if (intersects(player)) { touchedPlayer(player); }
    }

    public void touchedPlayer(Player player) {
        player.setInvincible(true); // WORKING
        // Need to add some stuff here that sets the player's god-mode back to false after some duration
        // Think we can use the Stopwatch.java class in Utils to run a Thread but I'm not sure, haven't looked all that much
        this.mapEntityStatus = MapEntityStatus.REMOVED;
    }

}