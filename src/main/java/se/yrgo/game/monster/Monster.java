package se.yrgo.game.monster;

import java.util.Random;

public interface Monster {

    String getMonsterName();

    String getDescription();

    int getRewardPoints();

    int getHealth();

    int getStrength();

    void wound(int hitPoints);

    default int getRandomAttack(){
        Random random = new Random();
        return random.nextInt(1, getStrength() + 1);
    }
}
