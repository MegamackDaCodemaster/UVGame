package se.yrgo.game.monster;

import java.util.Objects;

public final class Troll implements Monster{
    private final String monsterType;
    private final String presentation;
    private int health;
    private final int rewardScore;
    private final int strength;

    public Troll() {
        this("troll","A hideous troll", 30, 100, 25);
    }

    public Troll(String monsterType, String presentation, int rewardScore, int health, int strength) {
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
        this.rewardScore = rewardScore;
        this.health = health;
        this.strength = strength;
    }

//    @Override
//    public String doBattle(Player player) {
//        int damage = player.getAttackDamage();
//        wound(damage);
//
//        if (health <= 0) {
//            return "You killed the troll!";
//        }
//
//
//
//        return "";
//    }

    @Override
    public String getMonsterType() {
        return monsterType;
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
