package Collectables;

import java.awt.image.*;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import Level.Collectable;
import Level.MapEntityStatus;
import Level.Player;

import Utils.Point;

import java.lang.Integer;

// Implements Coin ("CoinBronze.png" > Resources) entities (does so in the same way as the game implements Enemies and Power Ups)
// This file is a modified Enemy.java replication
// Interactions: Player.java, Camera.java, and Map.java

public class Coin extends Collectable {

	public static float dB;
	
    private int value = 1; // Incrementation value for numCoins in Player [value of this coin type]

    public Coin(BufferedImage file, int x, int y)
    {
        super(file, x, y, 0.3f); // Coin subclasses do not need to pass a float argument for the scaling factor since 0.3f is hard-coded here

        // Also, I put in 0.3 as the scaling ratio because it seemed to look most appropriate compared to the size of the player's avatar
        // The scaling factor should probably be stored in a variable elsewhere instead of directly in the constructor,
            // But since it's the constructor (invoking explicitly in constructor is problematic),
            // I didn't want to spend the time figuring out how to implement that yet [not even sure if possible]
            
	}
    // updated constructor that allows you to use tile locations instead of pixel locations to add coins
    public Coin(BufferedImage file, Point location) {
        super(file, (int) location.x, (int) location.y, 0.3f);
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
        player.addCoin(value); // Calls method in Player class to increment number of coins the player has collected
        this.mapEntityStatus = MapEntityStatus.REMOVED; // Stop drawing graphic (here: "coin.png") on-screen
        File coinsound = new File("Resources/coinsound.wav");
        PlaySound(coinsound,1);
        
    }

    public static void PlaySound(File Sound, double vol) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Sound));
			clip.getLevel();
			setVol(vol, clip);
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void setVol(double vol, Clip clip) {
		FloatControl gain = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		dB = (float) (Math.log(vol) / (Math.log(10)) * 20);
		gain.setValue(dB);
	}
}