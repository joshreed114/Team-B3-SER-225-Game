package Maps;

import Enemies.BugEnemy;
import Enemies.DinosaurEnemy;
import Enemies.LawnMowerOfDeath;
import Engine.ImageLoader;
import EnhancedMapTiles.EndLevelBox;
import EnhancedMapTiles.HorizontalMovingPlatform;
import GameObject.Rectangle;
import Level.Enemy;
import Level.EnhancedMapTile;
import Level.Map;
import Level.TileType;
import Tilesets.CommonTileset;
import Tilesets.LevelTwoTileset;
import Tilesets.MasterMapTileset;
import Utils.Direction;
import Utils.Point;

import java.util.ArrayList;

public class NewBossLevel extends Map {
    public NewBossLevel() {
        super("boss_Level2.txt", new LevelTwoTileset(), new Point(1, 11));
    }
    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(34, 29),
                getPositionByTileIndex(36, 29),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(34, 29,16,4),
                Direction.RIGHT
        ));

        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(47, 29),
                getPositionByTileIndex(49, 29),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(47, 29,16,4),
                Direction.RIGHT
        ));

        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(38, 29),
                getPositionByTileIndex(40, 29),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(38, 29,16,4),
                Direction.RIGHT
        ));

        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(43, 29),
                getPositionByTileIndex(45, 29),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(43, 29,16,4),
                Direction.RIGHT
        ));

        enhancedMapTiles.add(new EndLevelBox(
                getPositionByTileIndex(101, 32)
        ));

        return enhancedMapTiles;
    }

    @Override
    public ArrayList<Enemy> loadEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();

        enemies.add(new BugEnemy(getPositionByTileIndex(26, 22), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(55, 32), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(58, 34), Direction.LEFT));

        enemies.add(new DinosaurEnemy(getPositionByTileIndex(67, 39).addY(2), getPositionByTileIndex(72, 12).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(79, 40).addY(2), getPositionByTileIndex(84, 15).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(82, 40).addY(2), getPositionByTileIndex(87, 18).addY(2), Direction.LEFT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(92, 38).addY(2), getPositionByTileIndex(122, 11).addY(2), Direction.LEFT));
        return enemies;
    }
}
