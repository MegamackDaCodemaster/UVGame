package se.yrgo.game.items;

import se.yrgo.game.player.Player;

public record Beer(String name, int amount) implements Item {
    @Override
    public String pickup(Player player) {
        player.decreaseHealth(amount);
        return "You drank a beer and your health has been decreased with " + amount + " hp";
    }

    @Override
    public String getName() {
        return name;
    }
    //
}
