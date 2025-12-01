package se.yrgo.game.monster;

import java.util.Objects;
import java.util.Random;

public class Slime implements Monster{
    private final String monsterName;
    private final String description;
    private int health;
    private final int rewardPoints;
    private final int strength;
    private final Random random;

    /**
     * Constructs a default {@code Slime} with pre-defined stats.
     */
    public Slime() {
        this("Slime", "the almighty Slime", 40, 65, 20);
    }

    public Slime(String monsterName, String description, int rewardPoints, int health, int strength) {
        Objects.requireNonNull(monsterName, "The parameter 'monsterName' is required for this constructor");
        Objects.requireNonNull(description, "The parameter 'description' is required for this constructor");

        if (health <= 0) {
            throw new IllegalArgumentException("The health value need to be more than 0.");
        }

        if (strength <= 0) {
            throw new IllegalArgumentException("The strength value need to be more than 0.");
        }

        this.monsterName = monsterName;
        this.description = description;
        this.rewardPoints = rewardPoints;
        this.health = health;
        this.strength = strength;
        this.random = new Random();
    }


    @Override
    public String getMonsterName() {
        return monsterName;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getRewardPoints() {
        return rewardPoints;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public void wound(int hitPoints) {
        if (health > 0 && hitPoints > 0) {
            health -= hitPoints;
        }
    }
}
