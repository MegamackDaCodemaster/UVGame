package se.yrgo.game.monster;

public interface Monster {
//    String doBattle(Player player);

    String getMonsterType(); //Todo: Rename

    String getPresentation();

    int getRewardPoints();

    int getHealth();

    int getAttackDamage();

    void wound(int hitPoints);

}
