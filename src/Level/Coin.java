package Level;

import java.util.HashMap;

import Builders.FrameBuilder;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.Player;

// import java.awt.image.BufferedImage;

import Engine.ImageLoader;
import GameObject.SpriteSheet;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

// Implements Coin ("coin.png") entities
// This file is a modified Enemy.java replication
public class Coin extends MapEntity {

    public Coin(BufferedImage file, int x, int y) {
        super(file, (float) x, (float) y);
	}

    /*
    // https://stackoverflow.com/questions/13605248/java-converting-image-to-bufferedimage
    try
    {
        Image img = ImageIO.read(new File("coin.png"));
        BufferedImage image = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = image.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();
    }
    catch (IOException  e) { System.out.println(e); }
    */

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
        player.addCoin();
        this.mapEntityStatus = MapEntityStatus.REMOVED;
    }

}