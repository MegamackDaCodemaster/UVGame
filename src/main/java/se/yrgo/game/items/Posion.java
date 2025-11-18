package se.yrgo.game.items;

import se.yrgo.game.Player;

public record Posion (String name, int amount) implements Item {
    @Override
    public void pickup(Player player) {
        player.increaseHealth(amount);
    }
}
