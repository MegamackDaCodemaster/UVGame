package se.yrgo.game.items;

import se.yrgo.game.player.Player;

public record Potion(String name, int amount) implements Item {
    @Override
    public String pickup(Player player) {
        player.increaseHealth(amount);
        return "You drank " + getName() + " and gained " + amount + " hp";
    }

    @Override
    public String getName() {
        return name;
    }
}
