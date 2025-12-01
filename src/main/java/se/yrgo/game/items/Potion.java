package se.yrgo.game.items;

import se.yrgo.game.player.Player;

public record Potion(String name, int amount) implements Item {
    @Override
    public String pickup(Player player) {
        player.increaseHealth(amount);
        return "You drank a potion and your health has been increased with " + amount + " hp";
    }

    @Override
    public String getName() {
        return "";
    }
}
