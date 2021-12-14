package Maps;

import Collectables.SpeedBoost;
import Level.Map;
import Level.NPC;
import Tilesets.CommonTileset;
import Utils.Point;
import Enemies.BossMouse;
import Enemies.BugEnemy;
import Enemies.DinosaurEnemy;
import Enemies.LawnMowerOfDeath;
import Engine.ImageLoader;
import EnhancedMapTiles.EndLevelBox;
import EnhancedMapTiles.HorizontalMovingPlatform;
import GameObject.Rectangle;
import Level.Collectable;
import Level.Enemy;
import Level.EnhancedMapTile;
import Level.Map;
import Level.TileType;
import NPCs.TutorialCrab;
import NPCs.TutorialCrab2;
import NPCs.TutorialDuck;
import NPCs.TutorialDuck2;
import NPCs.TutorialWalrus;
import NPCs.TutorialWalrus2;
import NPCs.TutorialWalrus3;
import NPCs.TutorialWalrus4;
import NPCs.Walrus;
import Tilesets.CommonTileset;
import Tilesets.LevelTwoTileset;
import Tilesets.MasterMapTileset;
import Utils.Direction;
import Utils.Point;
import java.util.ArrayList;

import Collectables.Coin;

public class TutorialLevel extends Map {

    public TutorialLevel () {
		super("Tutorial.txt", new LevelTwoTileset(), new Point(2, 13));
	}
	//75
	/*
    //Testing
    public TutorialLevel () {
        super("Tutorial.txt", new LevelTwoTileset(), new Point(173, 11));
    }
    */

	@Override
	public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(78, 13),
                getPositionByTileIndex(85, 13),
                TileType.NOT_PASSABLE,
                3,
                new Rectangle(78, 13 ,24,8),
                Direction.RIGHT
        ));
        
        enhancedMapTiles.add(new EndLevelBox(
                getPositionByTileIndex(173, 13)
        ));

        return enhancedMapTiles;
	}

    // Adds Coins and potions to level
    @Override
    public ArrayList<Collectable> loadCollectables() {
        ArrayList<Collectable> collectables = new ArrayList<>();

        collectables.add(new Coin(
                ImageLoader.load("CoinBronze.png"), getPositionByTileIndex(151, 13)));

        return collectables;
    }

	@Override
	public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        npcs.add(new TutorialWalrus(getPositionByTileIndex(7, 13).subtract(new Point(0, 13)), this));
        npcs.add(new TutorialWalrus2(getPositionByTileIndex(107, 4).subtract(new Point(0, 13)), this));
        npcs.add(new TutorialWalrus3(getPositionByTileIndex(142, 13).subtract(new Point(0, 13)), this));
        npcs.add(new TutorialWalrus4(getPositionByTileIndex(168, 15).subtract(new Point(0, 13)), this));
        
        npcs.add(new TutorialCrab(getPositionByTileIndex(31, 12).subtract(new Point(0, 13)), this));
        npcs.add(new TutorialCrab2(getPositionByTileIndex(43, 13).subtract(new Point(0, 13)), this));
        
        npcs.add(new TutorialDuck(getPositionByTileIndex(58, 13).subtract(new Point(0, 13)), this));
        npcs.add(new TutorialDuck2(getPositionByTileIndex(73, 13).subtract(new Point(0, 13)), this));
        return npcs;
    }
	
	@Override
	public ArrayList<Enemy> loadEnemies() {
		ArrayList<Enemy> enemies = new ArrayList<>();
		enemies.add(new BugEnemy(getPositionByTileIndex(111, 5), Direction.LEFT));
		enemies.add(new DinosaurEnemy(getPositionByTileIndex(119, 5).addY(2), getPositionByTileIndex(125, 5).addY(2), Direction.RIGHT));
		return enemies;
	}
	
	 // @Override
	 //   public ArrayList<Collectable> loadCollectables() {
	 //       ArrayList<Collectable> collectables = new ArrayList<>();

	 //       collectables.add(new Coin(
	 //           ImageLoader.load("CoinBronze.png"),
	 //           1510,
	 //           120
	 //           ));
	 //       return collectables;
	 //   }
}
