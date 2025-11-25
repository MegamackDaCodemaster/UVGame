package se.yrgo.game.monster;

public interface Monster {
//    String doBattle(Player player);

    String getMonsterType();

    String getPresentation();

    int getRewardPoints();

    int getHealth();

    int getStrength();

    void wound(int hitPoints);

}
