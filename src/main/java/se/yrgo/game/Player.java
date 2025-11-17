package se.yrgo.game;

public class Player {
    private String name;
    private int health;
    private int score;

    public Player(String name, int health, int score) {
        this.name = name;
        this.health = health;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getScore() {
        return score;
    }
}
