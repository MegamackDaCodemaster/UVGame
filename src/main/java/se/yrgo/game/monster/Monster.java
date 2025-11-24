package se.yrgo.game.monster;

public interface Monster {
//    String doBattle(Player player);

    String getMonsterType();

    String getPresentation();

    int getHealth();

    void wound(int hitPoints);

    int getStrength();
}
