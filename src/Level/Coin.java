package Level;

import java.awt.image.*;

// Implements Coin ("coin.png" > Resources) entities (does so in the same way as the game implements Enemies and Power Ups)
// This file is a modified Enemy.java replication
// Interactions: Player.java, Camera.java, and Map.java

public class Coin extends MapEntity {

    //TODO: add scaling option (adjust constructor and code in scaling factor)
    public Coin(BufferedImage file, int x, int y) {
        super(file, (float) x, (float) y); // Casting integer arguments to floats here helped me create new instances more easily during testing
        //TODO: convert integer parameters to floats
	}

    @Override
    public void initialize() {
        super.initialize();
    }

    public void update(Player player) {
        super.update();
        if (intersects(player)) {
            touchedPlayer(player);
        }
    }

    // A subclass can override this method to specify what it does when it touches the player
    public void touchedPlayer(Player player) {
        player.addCoin(); // Calls method in Player class to increment number of coins the player has collected by 1
        this.mapEntityStatus = MapEntityStatus.REMOVED;
    }

}

//
// DEBUGGING
// * Player cannot move after interacting with Coin

/*

// DEBUGGING errors caused when Player interacts with Coin

Exception in thread "AWT-EventQueue-0" java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
        at java.base/java.util.Objects.checkIndex(Objects.java:359)
        at java.base/java.util.ArrayList.remove(ArrayList.java:504)
        at Level.Camera.loadActiveCoins(Camera.java:174)
        at Level.Camera.updateMapEntities(Camera.java:76)
        at Level.Camera.update(Camera.java:55)
        at Level.Map.update(Map.java:366)
        at Screens.PlayLevelScreen.update(PlayLevelScreen.java:178)
        at Game.ScreenCoordinator.update(ScreenCoordinator.java:78)
        at Engine.ScreenManager.update(ScreenManager.java:27)
        at Engine.GamePanel.update(GamePanel.java:72)
        at Engine.GamePanel$1.actionPerformed(GamePanel.java:47)
        at java.desktop/javax.swing.Timer.fireActionPerformed(Timer.java:310)
        at java.desktop/javax.swing.Timer$DoPostEvent.run(Timer.java:242)
        at java.desktop/java.awt.event.InvocationEvent.dispatch(InvocationEvent.java:316)
        at java.desktop/java.awt.EventQueue.dispatchEventImpl(EventQueue.java:770)
        at java.desktop/java.awt.EventQueue$4.run(EventQueue.java:721)
        at java.desktop/java.awt.EventQueue$4.run(EventQueue.java:715)
        at java.base/java.security.AccessController.doPrivileged(AccessController.java:391)
        at java.base/java.security.ProtectionDomain$JavaSecurityAccessImpl.doIntersectionPrivilege(ProtectionDomain.java:85)
        at java.desktop/java.awt.EventQueue.dispatchEvent(EventQueue.java:740)
        at java.desktop/java.awt.EventDispatchThread.pumpOneEventForFilters(EventDispatchThread.java:203)       
        at java.desktop/java.awt.EventDispatchThread.pumpEventsForFilter(EventDispatchThread.java:124)
        at java.desktop/java.awt.EventDispatchThread.pumpEventsForHierarchy(EventDispatchThread.java:113)       
        at java.desktop/java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:109)
        at java.desktop/java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:101)
        at java.desktop/java.awt.EventDispatchThread.run(EventDispatchThread.java:90)

*/