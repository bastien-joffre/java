package Interactions;

import Characters.Character;
import Characters.Snake;
import Equipments.Equipment;

import java.util.Scanner;

public class Action
{
    private Scanner input = new Scanner(System.in);

    public void goToNewFloor(Character player) {
        Floor floor = new Floor();
        System.out.println(floor);

        if(floor.snake != null) {
            Character snake = floor.snake;
            switch (this.fightingOptions()) {
                case 1:
                    fight(player, snake);
                    if (floor.attack && snake.getHealth() <=0 ) {
                        lootFloorAttack(player);
                    }
                    if (floor.defense && snake.getHealth() <=0 ) {
                        lootFloorDefense(player);
                    }
                    break;
                case 2:
                    runAway();
                    break;
            }
        }

    }

    private void fight(Character player, Character enemy) {
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
                int playerHit = (int) (Math.random() * ((((100 + player.getStrength()) / 100) * (playerAttack * 2)) + 1));
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

    private void runAway() {

    }

    private void lootFloorAttack(Character player) {
        Equipment loot = player.getRandomWeapon();
        if (this.equipOrNot(player, loot, "attack")) player.setEquipedAttack(loot);
    }

    private void lootFloorDefense(Character player) {
        Equipment loot = player.getRandomDefense();
        if (this.equipOrNot(player, loot, "defense")) player.setEquipedDefense(loot);
    }

    public int fightingOptions() {
        System.out.println(
                "\n  ___ OPTIONS DE COMBAT _______________________  \n"+
                "/                                              \\\n"+
                "|     [1] Attaquer                             |\n"+
                "|     [2] Fuir comme un lâche                  |\n"+
                "\\______________________________________________/\n"
        );
        int option = Interact.parseInt(this.input.nextLine());
        while (option < 1 || option > 2) {
            System.out.println("Nous n'avons pas compris votre choix... Tappez 1, 2 ou 3.");
            option = Interact.parseInt(this.input.nextLine());
        }
        return option;
    }

    public boolean equipOrNot(Character player, Equipment equipment, String attOrDef) {
        if (attOrDef.equals("attack")) attOrDef = player.getEquipedAttack().toString(); else attOrDef = player.getEquipedDefense().toString();
        System.out.println("\nVous avez trouvé " + equipment.getCategory() + " :\n" +
                equipment + "\n Actuellement, vous possedez :\n" + attOrDef +
                "  ___ QUE SOUHAITEZ-VOUS FAIRE ? _____________\n"+
                "/                                              \\\n"+
                "|     [1] Equiper votre trouvaille             |\n"+
                "|     [2] Passer votre chemin                  |\n"+
                "\\______________________________________________/\n"
        );
        int option = Interact.parseInt(this.input.nextLine());
        while (option < 1 || option > 2) {
            System.out.println("Nous n'avons pas compris votre choix... Tappez 1 ou 2");
            option = Interact.parseInt(this.input.nextLine());
        }
        if (option == 1) return true; else return false;
    }
}
