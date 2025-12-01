package se.yrgo.game.player;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    Player player;

    @BeforeEach
    void setUp() {
        player = new Player("Bosse", 50, 500, 20);
    }

    @Test
    void increaseHealth() {
        int updatedHealthLevel = 70;
        int healthLevelIncrease = 20;
        player.increaseHealth(healthLevelIncrease);
        assertEquals(updatedHealthLevel, player.getHealth());
    }

    @Test
    void increaseHealthToMax() {
        int updatedHealthLevel = 100;
        int healthLevelIncrease = 50;
        player.increaseHealth(healthLevelIncrease);
        assertEquals(updatedHealthLevel, player.getHealth());
    }

    @Test
    void increaseHealthNotPassMaxLimit() {
        player.increaseHealth(1);
        assertNotEquals(101, player.getHealth());
    }
}
