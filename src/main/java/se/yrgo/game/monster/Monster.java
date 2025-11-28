package se.yrgo.game.monster;

public interface Monster {

    String getMonsterName();

    String getDescription();

    int getRewardPoints();

    int getHealth();

    int getStrength();

    int getRandomAttack();

    void wound(int hitPoints);

}
