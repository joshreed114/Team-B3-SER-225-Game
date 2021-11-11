package Maps;

import Enemies.BugEnemy;
import Enemies.DinosaurEnemy;
import Enemies.LawnMowerOfDeath;
import Engine.ImageLoader;
import EnhancedMapTiles.EndLevelBox;
import EnhancedMapTiles.HorizontalMovingPlatform;
import GameObject.Rectangle;
import Level.*;

import NPCs.DashingDuck;
import NPCs.Walrus;
import Tilesets.LevelTwoTileset;

import Utils.Direction;
import Utils.Point;

import java.util.ArrayList;

import Collectables.Coin;

public class LevelTwo extends Map {

        
    public LevelTwo() {
        super("level_two.txt", new LevelTwoTileset(), new Point(2, 18));
    }
    

// TESTING

/*
        public LevelTwo() {
              super("level_two.txt", new LevelTwoTileset(), new Point(121, 10));
        }
        */


    @Override
    public ArrayList<Enemy> loadEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();

        enemies.add(new LawnMowerOfDeath(getPositionByTileIndex(7, 17), Direction.LEFT));

        enemies.add(new BugEnemy(getPositionByTileIndex(21, 18), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(29, 18), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(81, 18), Direction.LEFT));

        enemies.add(new DinosaurEnemy(getPositionByTileIndex(21, 12).addY(2), getPositionByTileIndex(24, 12).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(61, 15).addY(2), getPositionByTileIndex(64, 15).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(113, 18).addY(2), getPositionByTileIndex(117, 18).addY(2), Direction.LEFT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(93, 11).addY(2), getPositionByTileIndex(97, 11).addY(2), Direction.LEFT));
        return enemies;
    }

    // Add Coins to level
    @Override
    public ArrayList<Collectable> loadCollectables() {
        ArrayList<Collectable> collectables = new ArrayList<>();

        collectables.add(new Coin(
                ImageLoader.load("CoinBronze.png"),
                915,
                630
        ));

        collectables.add(new Coin(
                ImageLoader.load("CoinBronze.png"),
                1644,
                845
        ));

        collectables.add(new Coin(
                ImageLoader.load("CoinBronze.png"),
                2500,
                400
        ));

        collectables.add(new Coin(
                ImageLoader.load("CoinBronze.png"),
                4473,
                686
        ));

        collectables.add(new Coin(
                ImageLoader.load("CoinBronze.png"),
                5388,
                1064
        ));

        collectables.add(new Coin(
                ImageLoader.load("CoinBronze.png"),
                5434,
                866
        ));

        return collectables;
    }

        @Override
        public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

                enhancedMapTiles.add(new HorizontalMovingPlatform(
                        ImageLoader.load("GreenPlatform.png"),
                        getPositionByTileIndex(34, 18),
                        getPositionByTileIndex(35, 18),
                        TileType.JUMP_THROUGH_PLATFORM,
                        3,
                        new Rectangle(0, 6,16,4),
                        Direction.RIGHT
                ));

                enhancedMapTiles.add(new HorizontalMovingPlatform(
                        ImageLoader.load("GreenPlatform.png"),
                        getPositionByTileIndex(34, 15),
                        getPositionByTileIndex(35, 15),
                        TileType.JUMP_THROUGH_PLATFORM,
                        3,
                        new Rectangle(0, 6,16,4),
                        Direction.RIGHT
                ));

                enhancedMapTiles.add(new HorizontalMovingPlatform(
                        ImageLoader.load("GreenPlatform.png"),
                        getPositionByTileIndex(35, 13),
                        getPositionByTileIndex(40, 13),
                        TileType.JUMP_THROUGH_PLATFORM,
                        3,
                        new Rectangle(0, 6,16,4),
                        Direction.RIGHT
                ));

                enhancedMapTiles.add(new HorizontalMovingPlatform(
                        ImageLoader.load("GreenPlatform.png"),
                        getPositionByTileIndex(38, 15),
                        getPositionByTileIndex(47, 15),
                        TileType.JUMP_THROUGH_PLATFORM,
                        3,
                        new Rectangle(0, 6,16,4),
                        Direction.RIGHT
                ));

                enhancedMapTiles.add(new HorizontalMovingPlatform(
                        ImageLoader.load("GreenPlatform.png"),
                        getPositionByTileIndex(45,14),
                        getPositionByTileIndex(52,14),
                        TileType.JUMP_THROUGH_PLATFORM,
                        3,
                        new Rectangle(0, 6,16,4),
                        Direction.RIGHT
                ));

                enhancedMapTiles.add(new HorizontalMovingPlatform(
                        ImageLoader.load("GreenPlatform.png"),
                        getPositionByTileIndex(50,13),
                        getPositionByTileIndex(55,13),
                        TileType.JUMP_THROUGH_PLATFORM,
                        3,
                        new Rectangle(0, 6,16,4),
                        Direction.RIGHT
                ));

                enhancedMapTiles.add(new HorizontalMovingPlatform(
                        ImageLoader.load("GreenPlatform.png"),
                        getPositionByTileIndex(53,15),
                        getPositionByTileIndex(60,15),
                        TileType.JUMP_THROUGH_PLATFORM,
                        3,
                        new Rectangle(0, 6,16,4),
                        Direction.RIGHT
                ));

                enhancedMapTiles.add(new HorizontalMovingPlatform(
                        ImageLoader.load("GreenPlatform.png"),
                        getPositionByTileIndex(97,18),
                        getPositionByTileIndex(105,15),
                        TileType.JUMP_THROUGH_PLATFORM,
                        3,
                        new Rectangle(0, 6,16,4),
                        Direction.RIGHT
                ));

                enhancedMapTiles.add(new EndLevelBox(
                        getPositionByTileIndex(121, 15)
                ));

                return enhancedMapTiles;
        }

    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        npcs.add(new DashingDuck(getPositionByTileIndex(10, 15).subtract(new Point(0, 13)), this));

        return npcs;
    }
}
