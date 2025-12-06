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
    void increaseHealthTest() {
        int updatedHealthLevel = 70;
        int healthLevelIncrease = 20;
        player.increaseHealth(healthLevelIncrease);
        assertEquals(updatedHealthLevel, player.getHealth());
    }

    @Test
    void increaseHealthToMaxTest() {
        int updatedHealthLevel = 100;
        int healthLevelIncrease = 50;
        player.increaseHealth(healthLevelIncrease);
        assertEquals(updatedHealthLevel, player.getHealth());
    }

    @Test
    void increaseHealthNotPassMaxLimitTest() {
        int healthLevelIncrease = 51;
        int updatedHealthLevel = 101;
        player.increaseHealth(1);
        assertNotEquals(updatedHealthLevel, player.getHealth());
    }

    @Test
    void decreaseHealthTest() {
        int updatedHealthLevel = 30;
        int healthLevelDecrease = 20;
        player.decreaseHealth(healthLevelDecrease);
        assertEquals(updatedHealthLevel, player.getHealth());
    }

    @Test
    void decreaseHealthToMinTest() {
        int updatedHealthLevel = 0;
        int healthLevelDecrease = 50;
        player.decreaseHealth(healthLevelDecrease);
        assertEquals(updatedHealthLevel, player.getHealth());
    }

    @Test
    void decreaseHealthNotPassMinLimitTest() {
        int updatedHealthLevel = -1;
        int healthLevelDecrease = 51;
        player.decreaseHealth(healthLevelDecrease);
        assertNotEquals(updatedHealthLevel, player.getHealth());
    }

    @Test
    void increaseScoreTest() {
        int updatedScore = 600;
        int scoreAmountIncrease = 100;
        player.increaseScore(scoreAmountIncrease);
        assertEquals(updatedScore, player.getScore());
    }

    @Test
    void decreaseScoreTest() {
        int updatedScore = 400;
        int scoreAmountDecrease = 100;
        player.decreaseScore(scoreAmountDecrease);
        assertEquals(updatedScore, player.getScore());
    }

    //@Test
    //void attackDamageTest() {
        //int damageAmount = 20
    //}
}
