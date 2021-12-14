package Collectables;

import java.awt.image.*;
import java.util.Timer;
import java.util.TimerTask;

import Level.Collectable;
import Level.MapEntityStatus;
import Level.Player;
import Utils.Point;

// Could change Invincibility to a water-proof potion type thing that player can equip using a key and has an amount of time attached to it

public class Invincibility extends Collectable {

    protected Timer tmr;

    public Invincibility(BufferedImage file, int x, int y)
    {
        super(file, x, y, 0.3f); // Since not subclass of Coin, needs to directly pass scaling factor float argument to parent
	}

    // Can use tile location instead of pixel location when creating
    public Invincibility(BufferedImage file, Point location)
    {
        super(file, (int) location.x, (int) location.y, 0.3f);
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
        player.setInvincible(true);
        this.mapEntityStatus = MapEntityStatus.REMOVED;
        tmr = new Timer();
        tmr.schedule(new TimerTask() {
            @Override
            public void run() {
                player.setInvincible(false);
            }
        }, 10000);
    }

}