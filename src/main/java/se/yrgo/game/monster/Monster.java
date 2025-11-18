package se.yrgo.game.monster;

import se.yrgo.game.Player;

public interface Monster {
//    String doBattle(Player player);

    String getName();

    int getHealth();

    void wound(int hitPoints);

    int getStrength();
}
