package Screens;

import Engine.Config;
import Engine.GraphicsHandler;
import Engine.Screen;
import Engine.ScreenManager;
import SpriteFont.SpriteFont;

import java.awt.*;

// This class is for the level cleared screen
public class LevelClearedScreen extends Screen {
    protected SpriteFont winMessage;
    private Config config;

    public LevelClearedScreen() {
    }

    @Override
    public void initialize() {						// changed coordinates to take config and subtract
        winMessage = new SpriteFont("Level Cleared", config.WIDTHS - 500, config.HEIGHTS - 350, "Comic Sans", 30, Color.white);
    }

    @Override
    public void update() {

    }

    public void draw(GraphicsHandler graphicsHandler) {
        // paint entire screen black and dislpay level cleared text
        graphicsHandler.drawFilledRectangle(0, 0, config.WIDTH, config.HEIGHT, Color.black);
        winMessage.draw(graphicsHandler);          //changed coordinate to accept config
    }
}