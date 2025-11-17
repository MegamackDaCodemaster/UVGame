package se.yrgo.game.monster;

import se.yrgo.game.Player;

import java.util.Objects;

public final class Troll implements Monster{
    private final String name;
    private int health;
    private final int rewardScore;

    public Troll() {
        this("An ugly troll", 30, 100);
    }

    public Troll(String name, int rewardScore, int health) {
        Objects.requireNonNull(name, "The parameter 'name' is required for this constructor");

        if (health <= 0) {
            throw new IllegalArgumentException("The health value need to be more than 0.");
        }

        this.name = name;
        this.rewardScore = rewardScore;
        this.health = health;
    }

    @Override
    public String doBattle(Player player) {
        //player.getStrength


        return "";
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public int getHealth() {
        return 0;
    }

    @Override
    public void wound(int hitPoints) {
        if (health > 0) {
            health -= hitPoints;
        }
    }


}
