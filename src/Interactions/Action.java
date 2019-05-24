package Interactions;

import Characters.Character;
import Characters.Snake;
import Equipments.Equipment;

public class Action
{
    public static void goToNewFloor(Character player) {
        Floor floor = new Floor();
        System.out.println(floor);

        if(floor.snake != null) {
            Character snake = floor.snake;
            switch (Interact.fightingOptions()) {
                case 1:
                    fight(player, snake);
                    System.out.println(floor.attack);
                    if (floor.attack && snake.getHealth() <=0 ) {
                        lootFloor(player);
                    }
                    break;
                case 2:
                    runAway();
                    break;
            }
        }

    }

    private static void fight(Character player, Character enemy) {
        boolean fighting = true;
        do {
            // Se défendre
            int blocked = player.getEquipedDefense().getResistance();
            int enemyAttack = enemy.getStrength() - blocked;
            int hitPoints;
            if (enemyAttack > 0) {
                blocked = player.getEquipedDefense().getResistance();
                hitPoints = (int) (Math.random() * (enemyAttack + 1));
                blocked += enemyAttack - hitPoints;
                System.out.println(player.getEquipedDefense().getName() + " a bloqué " + blocked +
                        " points d'attaque, vous avez perdu " + hitPoints + " points de vie.");
                player.setHealth(player.getHealth() - hitPoints);
                if (player.getHealth() <= 0) {
                    System.out.println(enemy.getName() + " vous a tué !");
                    fighting = false;
                }
            } else {
                System.out.println("Vous n'avez pas subit de dégats");
            }

            if (fighting) {
                // Attaquer
                int playerAttack = player.getEquipedAttack().getPower();
                int playerHit = (int) (Math.random() * ((100 + player.getStrength()) / 100) * playerAttack);
                if (playerHit < enemy.getHealth()) {
                    enemy.setHealth(enemy.getHealth() - playerHit);
                    System.out.println("Vous infligez " + playerHit + " dommages, il lui reste " + enemy.getHealth() + " points de vie.");
                } else {
                    enemy.setHealth(0);
                    System.out.println(
                            "Vous infligez " + playerHit + " dommages, le " + enemy.getName() + " est mort !"
                    );
                    fighting = false;
                }
            }

        } while(fighting);
    }

    private static void runAway() {

    }

    private static void lootFloor(Character player) {
        Equipment loot = player.getRandomWeapon();
        switch (Interact.equipOrNot(player, loot)) {
            case 1:
                player.setEquipedAttack();
                break;
        };
    }


}
