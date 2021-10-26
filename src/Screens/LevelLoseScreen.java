package Screens;

import Engine.*;
import SpriteFont.SpriteFont;

import java.awt.*;

// This is the class for the level lose screen
public class LevelLoseScreen extends Screen {
    private SpriteFont loseMessage;
    private SpriteFont instructions;
    protected KeyLocker keyLocker = new KeyLocker();
    protected PlayLevelScreen playLevelScreen;
    private Config config;
    private PlayLevelScreen playlevel;
    private int x, y = 0;

    public LevelLoseScreen(PlayLevelScreen playLevelScreen) {
        this.playLevelScreen = playLevelScreen;
    }


    @Override
    public void initialize() {							// changed coordinates to take config and subtract
        loseMessage = new SpriteFont("You lose!", config.WIDTHS - 465, config.HEIGHTS - 350, "Comic Sans", 30, Color.white);
        instructions = new SpriteFont("Press Space to try again or Escape to go back to the main menu", config.WIDTHS - 710, config.HEIGHTS - 300,"Comic Sans", 20, Color.white);
        keyLocker.lockKey(Key.SPACE);
        keyLocker.lockKey(Key.ESC);

    }



    @Override
    public void update() {
        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }
        if (Keyboard.isKeyUp(Key.ESC)) {
            keyLocker.unlockKey(Key.ESC);
        }

        // if space is pressed, reset level. if escape is pressed, go back to main menu
        if (Keyboard.isKeyDown(Key.SPACE)) {
            playLevelScreen.resetLevel();
        } else if (Keyboard.isKeyDown(Key.ESC)) {
            playLevelScreen.goBackToMenu();
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        graphicsHandler.drawFilledRectangle(0, 0, config.WIDTH, config.HEIGHT, Color.black);
        loseMessage.draw(graphicsHandler);		// changed coordinates to take config
        instructions.draw(graphicsHandler);
    }
}