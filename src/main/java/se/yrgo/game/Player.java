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

    public int increaseHealth(int healthAmount) {
        return health += healthAmount;
    }

    public int decreaseHealth(int healthAmount) {
        return health -= healthAmount;
    }

    public int increaseScore(int scoreAmount) {
        return score += scoreAmount;
    }

    public int decreaseScore(int scoreAmount) {
        return score -= scoreAmount;
    }

    public int damage(int damageAmount) {
        return damageAmount;
    }

    public int wound(int damageAmount) {
        return damageAmount;
    }
}
