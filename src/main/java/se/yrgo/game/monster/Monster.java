package se.yrgo.game.monster;

public interface Monster {
//    String doBattle(Player player);

    String getName();

    int getHealth();

    void wound(int hitPoints);

    int getStrength();
}
