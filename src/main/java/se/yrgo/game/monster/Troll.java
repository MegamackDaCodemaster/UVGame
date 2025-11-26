package se.yrgo.game.monster;

import java.util.Objects;
import java.util.Random;

public final class Troll implements Monster {
    private final String monsterType;
    private final String presentation;
    private int health;
    private final int rewardPoints;
    private final int strength;
    private final Random random;

    //Todo: Fix randomized damage infliction
    public Troll() {
        this("troll", "A hideous troll", 30, 100, 25);
    }

    public Troll(String monsterType, String presentation, int rewardPoints, int health, int strength) {
        Objects.requireNonNull(monsterType, "The parameter 'monsterType' is required for this constructor");
        Objects.requireNonNull(presentation, "The parameter 'presentation' is required for this constructor");

        if (health <= 0) {
            throw new IllegalArgumentException("The health value need to be more than 0.");
        }

        if (strength <= 0) {
            throw new IllegalArgumentException("The strength value need to be more than 0.");
        }

        this.monsterType = monsterType;
        this.presentation = presentation;
        this.rewardPoints = rewardPoints;
        this.health = health;
        this.strength = strength;
        this.random = new Random();
    }


    @Override
    public String getMonsterType() {
        return monsterType;
    }

    @Override
    public String getPresentation() {
        return presentation;
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
    public int getRandomAttack() {
        return random.nextInt(1, strength + 1);
    }

    @Override
    public void wound(int hitPoints) {
        if (health > 0 && hitPoints > 0) {
            health -= hitPoints;
        }
    }

}
