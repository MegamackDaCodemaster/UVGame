package se.yrgo.game.items;

import se.yrgo.game.player.Player;

public interface Item {
    String pickup(Player player);
    String getName();
}
