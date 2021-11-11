package Level;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import GameObject.SpriteSheet;

/*
TODO: might delete cause isnt needed if powerup doesnt work as an enemy
 */
public class PowerUp extends MapEntity {
	public static float dB;

	public PowerUp(float x, float y, SpriteSheet spriteSheet, String startingAnimation) {
		super(x, y, spriteSheet, startingAnimation);
	}

	public void initialize() {
		super.initialize();
	}

	public void update(Enemy enemy) {
		super.update();
		if (intersects(enemy)) {
			touchedEnemy(enemy);
		}
	}

	public void touchedEnemy(Enemy enemy) {
		enemy.hurtEnemy(this);

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
