package se.yrgo.game.monster;

import se.yrgo.game.Player;

import java.util.Objects;

public final class Troll implements Monster{
    private final String name;
    private int health;
    private final int rewardScore;
    private final int strength;

    public Troll() {
        this("Troll", 30, 100, 25);
    }

    public Troll(String name, int rewardScore, int health, int strength) {
        Objects.requireNonNull(name, "The parameter 'name' is required for this constructor");

        if (health <= 0) {
            throw new IllegalArgumentException("The health value need to be more than 0.");
        }

        if (strength <= 0) {
            throw new IllegalArgumentException("The strength value need to be more than 0.");
        }

        this.name = name;
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
    public String getName() {
        return name;
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
