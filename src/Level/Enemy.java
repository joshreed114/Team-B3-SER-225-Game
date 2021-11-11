package Level;

import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.Rectangle;
import GameObject.SpriteSheet;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

// This class is a base class for all enemies in the game -- all enemies should extend from it
public class Enemy extends MapEntity {
	public static float dB;
    public Enemy(float x, float y, SpriteSheet spriteSheet, String startingAnimation) {
        super(x, y, spriteSheet, startingAnimation);
    }

    public Enemy(float x, float y, HashMap<String, Frame[]> animations, String startingAnimation) {
        super(x, y, animations, startingAnimation);
    }

    public Enemy(BufferedImage image, float x, float y, String startingAnimation) {
        super(image, x, y, startingAnimation);
    }

    public Enemy(BufferedImage image, float x, float y) {
        super(image, x, y);
    }

    public Enemy(BufferedImage image, float x, float y, float scale) {
        super(image, x, y, scale);
    }

    public Enemy(BufferedImage image, float x, float y, float scale, ImageEffect imageEffect) {
        super(image, x, y, scale, imageEffect);
    }

    public Enemy(BufferedImage image, float x, float y, float scale, ImageEffect imageEffect, Rectangle bounds) {
        super(image, x, y, scale, imageEffect, bounds);
    }

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
        //If player is above the enemy, hurt the enemy
        if(player.getY() + 10 < this.getY()) {
            this.hurtEnemy(this);
        	File killenemy = new File("Resources/enemydeath.wav");
			PlaySound(killenemy,2);
        }
        //Otherwise, hurt the player
        else
            player.hurtPlayer(this);
    }

    public void touchedEnemy(Enemy enemy) {
        enemy.hurtEnemy(this);
    }

    //extend enemy class.
    public void hurtEnemy(MapEntity mapEntity) {
        if (mapEntity instanceof PowerUp) {
            this.mapEntityStatus = MapEntityStatus.REMOVED;
        }
        else if(mapEntity instanceof Enemy) {
                this.mapEntityStatus = MapEntityStatus.REMOVED;
        }
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
