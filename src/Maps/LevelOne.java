package Maps;

import Enemies.BugEnemy;
import Enemies.DinosaurEnemy;
import Engine.ImageLoader;
import EnhancedMapTiles.EndLevelBox;
import EnhancedMapTiles.HorizontalMovingPlatform;
import GameObject.Rectangle;
import Level.*;
import NPCs.Walrus;
import Tilesets.CommonTileset;
import Utils.Direction;
import Utils.Point;

import java.util.ArrayList;

import Collectables.*;

public class LevelOne extends Map {

    public LevelOne() {
        super("test_map.txt", new CommonTileset(), new Point(1, 15));
    }

    // TESTING
    
    /*
    public LevelOne() {
        super("test_map.txt", new CommonTileset(), new Point(32, 10));
    }
    */
    

    @Override
    public ArrayList<Enemy> loadEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(new BugEnemy(getPositionByTileIndex(15, 13), Direction.LEFT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(19, 5).addY(2), getPositionByTileIndex(22, 5).addY(2), Direction.RIGHT));
        return enemies;
    }

    // Add Coins to level
    @Override
    public ArrayList<Collectable> loadCollectables() {
        ArrayList<Collectable> collectables = new ArrayList<>();

        collectables.add(new Coin(
            ImageLoader.load("CoinBronze.png"),
            347,
            726
            ));

        collectables.add(new Coin(
            ImageLoader.load("CoinBronze.png"),
            915,
            630
            ));

        collectables.add(new Coin(
            ImageLoader.load("CoinBronze.png"),
            1020,
            503
            ));

        return collectables;
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(24, 8),
                getPositionByTileIndex(27, 8),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,8),
                Direction.RIGHT
        ));

        enhancedMapTiles.add(new EndLevelBox(
                getPositionByTileIndex(32, 11)
        ));

        return enhancedMapTiles;
    }

    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        npcs.add(new Walrus(getPositionByTileIndex(30, 14).subtract(new Point(0, 13)), this));

        return npcs;
    }
}