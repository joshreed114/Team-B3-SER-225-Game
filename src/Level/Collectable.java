package Level;

import java.awt.image.*;

// Implements collectables (as opposed to PowerUps)

public class Collectable extends MapEntity {

    public Collectable(BufferedImage file, int x, int y, float z)
    {
        super(file, (float) x, (float) y, z); // Casting integer arguments to floats here helped me create new instances more easily during testing
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