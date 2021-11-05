package Collectables;

import java.awt.image.*;

import Level.Collectable;
import Level.MapEntityStatus;
import Level.Player;

public class Invincibility extends Collectable {

    public Invincibility(BufferedImage file, int x, int y)
    {
        super(file, x, y, 0.3f);
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
    }

}