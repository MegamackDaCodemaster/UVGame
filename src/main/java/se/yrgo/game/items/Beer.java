package se.yrgo.game.items;

import se.yrgo.game.player.Player;

public record Beer(String name, int amount) implements Item {
    @Override
    public String pickup(Player player) {
        player.decreaseHealth(amount);
        return "You drank " + getName() + " and lost " + amount + " hp";
    }

    @Override
    public String getName() {
        return name;
    }
    //
}
