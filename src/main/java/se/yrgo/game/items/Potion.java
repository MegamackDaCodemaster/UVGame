package se.yrgo.game.items;

import se.yrgo.game.player.Player;

public record Potion(String name, int amount) implements Item {
    @Override
    public void pickup(Player player) {
        player.increaseHealth(amount);
    }
}
