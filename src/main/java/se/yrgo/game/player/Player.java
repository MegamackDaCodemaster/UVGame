package se.yrgo.game.player;

public class Player {
    private String name;
    private int health;
    private int score;
    private int attackDamage;

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
        health += healthAmount;
        if (health == 100) {
            health = 100;
            return health;
        }
        return health;
    }

    public int decreaseHealth(int healthAmount) {
        health -= healthAmount;
        if (health == 0) {
            health = 0;
            return health;
        }
        return health;
    }

    public int increaseScore(int scoreAmount) {
        return score += scoreAmount;
    }

    public int decreaseScore(int scoreAmount) {
        return score -= scoreAmount;
    }

    public int attack(int damageAmount) {
        return damageAmount;
    }

    public int wound(int damageAmount) {
        return damageAmount;
    }

    public int getAttackDamage() {
        return attackDamage;
    }
}
