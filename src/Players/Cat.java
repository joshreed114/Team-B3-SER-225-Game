package Players;

import java.util.HashMap;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import Engine.Key;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.Player;

/*
NOTES
* The game (in Settings [a.k.a PlayLevelScreen]) updates the Player's [Cat's] "skin" by calling a "new"
* method called setAnimations in AnimatedSprite.java [public], which allows PlayLevelScreen to update
* which SpriteSheet the game is drawing for the Player WITHOUT having to instantiate a new Player.

TODO: In Settings, draw Skin on screen instead of "Orange", "Brown", etc.

* The front-end implementation of cosmetics is commented out throughout the codebase
* (see classes spelled out above to know in which classes the comments are)
* But, the back-end is created and can be used pretty easily. Start here with Cat.java, then head over to
* PlayLevelScreen to view the front-end implementation. Note: some imports, constructors, methods, etc.
* are all commented out, so if there is a multi-line comment in one of the concerned classes, it probably
* has something to do with the cosmetics implementation

*/

// This is the class for the Cat player character
// basically just sets some values for physics and then defines animations
public class Cat extends Player {

	//TODO: Create New Constructor that accepts string for player's skin

	// Image argument should be a .png file in Resources (such as BrownCat.png or OrangeCat.png)
	// Image argument gets passed up to Screencoordinator, PlayLevelScreen
	public Cat(float x, float y) {
		super(new SpriteSheet(ImageLoader.load("Cat.png"), 24, 24), x, y, "STAND_RIGHT");
		gravity = .5f;
		terminalVelocityY = 6f;
		jumpHeight = 14.5f;
		jumpDegrade = .5f;
		walkSpeed = 2.1f;
		momentumYIncrease = .5f;
		JUMP_KEY = Key.UP;
		MOVE_LEFT_KEY = Key.LEFT;
		MOVE_RIGHT_KEY = Key.RIGHT;
		CROUCH_KEY = Key.DOWN;
		POWERUP_ONE_KEY = Key.ONE;
	}

	@Override
	public void update() {
		super.update();
	}
	

	@Override
	public void draw(GraphicsHandler graphicsHandler) {
		super.draw(graphicsHandler);
		// drawBounds(graphicsHandler, new Color(255, 0, 0, 170));
	}

	@Override
	public HashMap<String, Frame[]> getAnimations(SpriteSheet spriteSheet) {
		return new HashMap<String, Frame[]>() {
			{
				put("STAND_RIGHT", new Frame[] {
						new FrameBuilder(spriteSheet.getSprite(0, 0), 0).withScale(3).withBounds(8, 9, 8, 9).build() });

				put("STAND_LEFT", new Frame[] { new FrameBuilder(spriteSheet.getSprite(0, 0), 0).withScale(3)
						.withImageEffect(ImageEffect.FLIP_HORIZONTAL).withBounds(8, 9, 8, 9).build() });

				put("WALK_RIGHT", new Frame[] {
						new FrameBuilder(spriteSheet.getSprite(1, 0), 200).withScale(3).withBounds(8, 9, 8, 9).build(),
						new FrameBuilder(spriteSheet.getSprite(1, 1), 200).withScale(3).withBounds(8, 9, 8, 9).build(),
						new FrameBuilder(spriteSheet.getSprite(1, 2), 200).withScale(3).withBounds(8, 9, 8, 9).build(),
						new FrameBuilder(spriteSheet.getSprite(1, 3), 200).withScale(3).withBounds(8, 9, 8, 9)
								.build() });

				put("WALK_LEFT",
						new Frame[] {
								new FrameBuilder(spriteSheet.getSprite(1, 0), 200).withScale(3)
										.withImageEffect(ImageEffect.FLIP_HORIZONTAL).withBounds(8, 9, 8, 9).build(),
								new FrameBuilder(spriteSheet.getSprite(1, 1), 200).withScale(3)
										.withImageEffect(ImageEffect.FLIP_HORIZONTAL).withBounds(8, 9, 8, 9).build(),
								new FrameBuilder(spriteSheet.getSprite(1, 2), 200).withScale(3)
										.withImageEffect(ImageEffect.FLIP_HORIZONTAL).withBounds(8, 9, 8, 9).build(),
								new FrameBuilder(spriteSheet.getSprite(1, 3), 200).withScale(3)
										.withImageEffect(ImageEffect.FLIP_HORIZONTAL).withBounds(8, 9, 8, 9).build() });

				put("JUMP_RIGHT", new Frame[] {
						new FrameBuilder(spriteSheet.getSprite(2, 0), 0).withScale(3).withBounds(8, 9, 8, 9).build() });

				put("JUMP_LEFT", new Frame[] { new FrameBuilder(spriteSheet.getSprite(2, 0), 0).withScale(3)
						.withImageEffect(ImageEffect.FLIP_HORIZONTAL).withBounds(8, 9, 8, 9).build() });

				put("FALL_RIGHT", new Frame[] {
						new FrameBuilder(spriteSheet.getSprite(3, 0), 0).withScale(3).withBounds(8, 9, 8, 9).build() });

				put("FALL_LEFT", new Frame[] { new FrameBuilder(spriteSheet.getSprite(3, 0), 0).withScale(3)
						.withImageEffect(ImageEffect.FLIP_HORIZONTAL).withBounds(8, 9, 8, 9).build() });

				put("CROUCH_RIGHT", new Frame[] { new FrameBuilder(spriteSheet.getSprite(4, 0), 0).withScale(3)
						.withBounds(8, 12, 8, 6).build() });

				put("CROUCH_LEFT", new Frame[] { new FrameBuilder(spriteSheet.getSprite(4, 0), 0).withScale(3)
						.withImageEffect(ImageEffect.FLIP_HORIZONTAL).withBounds(8, 12, 8, 6).build() });

				put("DEATH_RIGHT",
						new Frame[] { new FrameBuilder(spriteSheet.getSprite(5, 0), 100).withScale(3).build(),
								new FrameBuilder(spriteSheet.getSprite(5, 1), 100).withScale(3).build(),
								new FrameBuilder(spriteSheet.getSprite(5, 2), -1).withScale(3).build() });

				put("DEATH_LEFT",
						new Frame[] {
								new FrameBuilder(spriteSheet.getSprite(5, 0), 100).withScale(3)
										.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build(),
								new FrameBuilder(spriteSheet.getSprite(5, 1), 100).withScale(3)
										.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build(),
								new FrameBuilder(spriteSheet.getSprite(5, 2), -1).withScale(3)
										.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build() });
			}
		};
	}
}