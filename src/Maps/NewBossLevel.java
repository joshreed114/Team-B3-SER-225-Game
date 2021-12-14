package Maps;

import Collectables.Coin;
import Collectables.Megacoin;
import Collectables.Invincibility;
import Collectables.SpeedBoost;
import Enemies.BossMouse;
import Enemies.BugEnemy;
import Enemies.DinosaurEnemy;
import Enemies.LawnMowerOfDeath;
import Engine.ImageLoader;
import EnhancedMapTiles.EndLevelBox;
import EnhancedMapTiles.HorizontalMovingPlatform;
import GameObject.Rectangle;
import Level.*;
import Tilesets.CommonTileset;
import Tilesets.LevelTwoTileset;
import Tilesets.MasterMapTileset;
import Utils.Direction;
import Utils.Point;

import java.util.ArrayList;

public class NewBossLevel extends Map {

    public NewBossLevel() {
        super("boss_Level2.txt", new LevelTwoTileset(), new Point(6, 14));
    }
    /*
    //TESTING
    public NewBossLevel() {
        super("boss_Level2.txt", new LevelTwoTileset(), new Point(76, 35));
    }
    */
    //TODO: Add functionaltiy to the moving platforms
    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(34, 29),
                getPositionByTileIndex(36, 29),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(34, 29,24,8),
                Direction.RIGHT
        ));

        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(47, 29),
                getPositionByTileIndex(49, 29),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(47, 29,24,8),
                Direction.RIGHT
        ));

        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(38, 29),
                getPositionByTileIndex(40, 29),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(38, 29,24,8),
                Direction.RIGHT
        ));

        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(43, 29),
                getPositionByTileIndex(45, 29),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(43, 29,24,8),
                Direction.RIGHT
        ));

        enhancedMapTiles.add(new EndLevelBox(
                getPositionByTileIndex(101, 32)
        ));

        return enhancedMapTiles;
    }

    // Adds Coins and potions to level
    @Override
    public ArrayList<Collectable> loadCollectables() {
        ArrayList<Collectable> collectables = new ArrayList<>();

        collectables.add(new Coin(
                ImageLoader.load("CoinBronze.png"), getPositionByTileIndex(22, 26)));

        collectables.add(new Coin(
                ImageLoader.load("CoinBronze.png"), getPositionByTileIndex(63, 40)));
        /*
        collectables.add(new Coin(
                ImageLoader.load("CoinBronze.png", getPositionByTileIndex(34, 28)));

        collectables.add(new Coin(
                ImageLoader.load("CoinBronze.png", getPositionByTileIndex(38, 28)));

        collectables.add(new Coin(
                ImageLoader.load("CoinBronze.png", getPositionByTileIndex(43, 28)));

        collectables.add(new Coin(
                ImageLoader.load("CoinBronze.png", getPositionByTileIndex(47, 28)));
        */
        collectables.add(new Megacoin(
                ImageLoader.load("CoinGold.png"), getPositionByTileIndex(81, 39)));

        collectables.add(new Invincibility(
                ImageLoader.load("InvincibilityCollectable.png"), getPositionByTileIndex(68, 39)));

        //Test for invincibility potion at start of level one
        /*
        collectables.add(new Invincibility(
                ImageLoader.load("InvincibilityCollectable.png"),
                390,
                725
        ));
        */
        return collectables;
    }
    @Override
    public ArrayList<Enemy> loadEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();

        enemies.add(new BugEnemy(getPositionByTileIndex(26, 30), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(55, 32), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(65, 40), Direction.LEFT));

        enemies.add(new DinosaurEnemy(getPositionByTileIndex(66, 39).addY(2), getPositionByTileIndex(69, 12).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(78, 40).addY(2), getPositionByTileIndex(84, 15).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(87, 40).addY(2), getPositionByTileIndex(91, 18).addY(2), Direction.LEFT));
        
        enemies.add(new BossMouse(getPositionByTileIndex(81, 37), Direction.LEFT));
		
        return enemies;
    }
}
