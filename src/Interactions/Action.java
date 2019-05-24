package Interactions;

import Characters.Character;
import Characters.Snake;

public class Action
{

    public static void goToNewFloor(Character player) {
        Floor.current = new Floor();
        System.out.println(Floor.current);

        if(Floor.current.snake != null) {
            Character snake = Floor.current.snake;
            switch (Interact.fightingOptions()) {
                case 1:
                    fight(player, snake);
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
}
