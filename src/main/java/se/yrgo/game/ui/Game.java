package se.yrgo.game.ui;

import se.yrgo.game.Player;
import se.yrgo.game.monster.Monster;

public class Game {

    public static void runGame() {

    }

    public void doBattle(Player player, Monster monster) {
        int damage = player.attack();
        monster.wound(damage);

        System.out.printf("You inflicted %d points of damage to the %s!%n", monster.getName());
        if (monster.getHealth() <= 0) {
            System.out.printf( "You killed the %s!%n", monster.getName());
        }

        player.decreaseHealth(monster.getStrength());
        System.out.printf("The %s does %d points of damage to you!", monster.getName(), monster.getStrength());

        if (player.getHealth() <= 0) {
            //Game over
        }

    }
}
