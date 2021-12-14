package Collectables;

import java.awt.image.*;
import java.io.File;

import Level.MapEntityStatus;
import Level.Player;

import Utils.Point;

// Extends Coin.java to create new Megacoin (a Coin that is worth 10 instead of 1)
// Resources > "CoinGold.png"
// Meant to be a coin type that is located in extremely hard-to-reach places, which is why its value is higher than Supercoin

public class Megacoin extends Coin {

    private int value = 10;

    public Megacoin(BufferedImage file, int x, int y) {
        super(file, x, y);
	}

    public Megacoin(BufferedImage file, Point location) {
        super(file, (int) location.x, (int) location.y);
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
        File coinsound = new File("Resources/coinsound.wav");
        PlaySound(coinsound,2);
    }

}