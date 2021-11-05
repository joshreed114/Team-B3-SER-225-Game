package Collectables;

import java.awt.image.*;

import Level.Collectable;
import Level.MapEntityStatus;
import Level.Player;

public class SpeedBoost extends Collectable {

    public SpeedBoost(BufferedImage file, int x, int y)
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
        player.setSpeed((float) (player.getSpeed() * 1.7));
        this.mapEntityStatus = MapEntityStatus.REMOVED;
    }

}