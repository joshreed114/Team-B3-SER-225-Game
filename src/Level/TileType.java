package Level;

// Represents different tile types a MapTile or EnhancedMapTile can have, which affects how entities interact with it collision wise
public enum TileType {
    // Added dangerous level tiles (water)
    PASSABLE, NOT_PASSABLE, JUMP_THROUGH_PLATFORM, DANGEROUS
}
