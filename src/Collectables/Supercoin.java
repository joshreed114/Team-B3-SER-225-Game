package Collectables;

import java.awt.image.*;

import Level.MapEntityStatus;
import Level.Player;

// Extends Coin.java to create new Supercoin (a Coin that is worth 5 instead of 1)
// Resources > "supercoin.png"
// Differs from Coin in that the graphic is just a red-colored version of the coin.png
// Meant to be a coin type that is located in hard-to-reach places, which is why its value is higher than regular Coins

public class Supercoin extends Coin {

    private int value = 5;

    public Supercoin(BufferedImage file, int x, int y) {
        super(file, x, y);
	}

    @Override
    public void initialize() {
        super.initialize();
    }

    @Override
    public void update(Player player) {
        super.update();
        if (intersects(player)) { touchedPlayer(player); }
    }

    @Override
    public void touchedPlayer(Player player) {
        player.addCoin(value);
        this.mapEntityStatus = MapEntityStatus.REMOVED;
    }

}