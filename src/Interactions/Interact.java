package Interactions;

import Characters.Character;
import Characters.Warrior;
import Characters.Wizard;

import java.util.Scanner;

public class Interact
{
    private static Scanner input = new Scanner(System.in);

    public static Character createCharacter() {
        System.out.println("Quel sera le nom de votre combattant ?");
        String name = input.nextLine(); // Rentrer le nom du personnage

        System.out.println("Bienvenue à toi " + name + ", donne moi un lien vers une image de toi maintenant :");
        String image = input.nextLine(); // Rentrer l"url de l"image

        System.out.println("Tu te sens plutôt guerrier ou magicien ?\n (tappe g ou m)");
        String characterType = input.nextLine();
        while (!characterType.equals("g") && !characterType.equals("m")) {
            System.out.println("Type inconnu... Choisi g ou m");
            characterType = input.nextLine(); // Tant que le nombre de points de force est invalide, reproposer
        }

        Character newCharacter;
        if (characterType.equals("g")) {
            newCharacter = new Warrior(name, image);
        } else {
            newCharacter = new Wizard(name, image);
        }

        newCharacter.setHealth(Interact.chooseHealth(newCharacter));
        newCharacter.setStrength(Interact.chooseStrength(newCharacter));

        newCharacter.setEquipedAttack();
        newCharacter.setEquipedDefense();

        return newCharacter;
    }

    public static int chooseAttackPower(String type) {
        System.out.println("Quelle sera la puissance de votre " + type);
        return parseInt(input.nextLine());
    }

    public static String chooseEquipmentName(String type) {
        System.out.println("Comment souhaitez vous appeler votre " + type);
        return input.nextLine();
    }

    public static int chooseDefenseResistance(String type) {
        System.out.println("Quelle sera la resistance de votre " + type);
        return parseInt(input.nextLine());
    }

    public static int chooseHealth(Character character) {
        System.out.println("Sur une échelle de " + character.getMinHealth() + " à " + character.getMaxHealth() + ", à quel point pense tu être résistant ?");
        int health = parseInt(input.nextLine()); // Rentrer le nombre de Points de vie
        if (health == 0) {
            return randomiser(character.getMinHealth(), character.getMaxHealth());
        }
        while (health < character.getMinHealth() || health > character.getMaxHealth()) {
            System.out.println("Soyons raisonnables, rentre un nombre entre " + character.getMinHealth() + " et " + character.getMaxHealth() + " on a dit...");
            health = parseInt(input.nextLine());; // Tant que le nombre de points de vie est invalide, reproposer
        }
        return health;
    }

    public static int chooseStrength(Character character) {
        System.out.println("Et sur une échelle de " + character.getMinStrength() + " à " + character.getMaxStrength() + ", à quel point pense tu être balèze ?");
        int strength = parseInt(input.nextLine()); // Rentrer le nombre de Points de vie
        if (strength == 0) {
            return randomiser(character.getMinStrength(), character.getMaxStrength());
        }
        while (strength < character.getMinStrength() || strength > character.getMaxStrength()) {
            System.out.println("Soyons raisonnables, rentre un nombre entre " + character.getMinStrength() + " et " + character.getMaxStrength() + " on a dit...");
            strength = parseInt(input.nextLine()); // Tant que le nombre de points de force est invalide, reproposer
        }
        return strength;
    }

    public static int parseInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException nfe) {
            System.out.println("Saisissez un nombre entier.");
            return parseInt(input.nextLine());
        }
    }

    public static String ascii() {
        return
            "            .                                                      .             \n" +
            "          .n                   .                 .                  n.           \n" +
            "    .   .dP                  dP                   9b                 9b.    .    \n" +
            "   4    qXb         .       dX                     Xb       .        dXp     t   \n" +
            "  dX.    9Xb      .dXb    __                         __    dXb.     dXP     .Xb  \n" +
            "  9XXb._       _.dXXXXb dXXXXbo.                 .odXXXXb dXXXXb._       _.dXXP  \n" +
            "   9XXXXXXXXXXXXXXXXXXXVXXXXXXXXOo.           .oOXXXXXXXXVXXXXXXXXXXXXXXXXXXXP   \n" +
            "    `9XXXXXXXXXXXXXXXXXXXXX'~   ~`OOO8b   d8OOO'~   ~`XXXXXXXXXXXXXXXXXXXXXP'    \n" +
            "      `9XXXXXXXXXXXP' `9XX'          `98v8P'          `XXP' `9XXXXXXXXXXXP'      \n" +
            "          ~~~~~~~       9X.          .db|db.          .XP       ~~~~~~~          \n" +
            "                          )b.  .dbo.dP'`v'`9b.odb.  .dX(                         \n" +
            "                        ,dXXXXXXXXXXXb     dXXXXXXXXXXXb.                        \n" +
            "                       dXXXXXXXXXXXP'   .   `9XXXXXXXXXXXb                       \n" +
            "                      dXXXXXXXXXXXXb   d|b   dXXXXXXXXXXXXb                      \n" +
            "                      9XXb'   `XXXXXb.dX|Xb.dXXXXX'   `dXXP                      \n" +
            "                      `'      9XXXXXX(   )XXXXXXP      `'                        \n" +
            "                                XXXX X.`v'.X XXXX                                \n" +
            "                                XP^X'`b   d'`X^XX                                \n" +
            "                                X. 9  `   '  P )X                                \n" +
            "                               `b  `       '  d'                                 \n" +
            "                                 `             '                                 \n\n" +
            " ▄▄▄▄    ██▓▓█████  ███▄    █ ██▒   █▓▓█████  ███▄    █  █    ██ ▓█████     ▐██▌ \n" +
            "▓█████▄ ▓██▒▓█   ▀  ██ ▀█   █▓██░   █▒▓█   ▀  ██ ▀█   █  ██  ▓██▒▓█   ▀     ▐██▌ \n" +
            "▒██▒ ▄██▒██▒▒███   ▓██  ▀█ ██▒▓██  █▒░▒███   ▓██  ▀█ ██▒▓██  ▒██░▒███       ▐██▌ \n" +
            "▒██░█▀  ░██░▒▓█  ▄ ▓██▒  ▐▌██▒ ▒██ █░░▒▓█  ▄ ▓██▒  ▐▌██▒▓▓█  ░██░▒▓█  ▄     ▓██▒ \n" +
            "░▓█  ▀█▓░██░░▒████▒▒██░   ▓██░  ▒▀█░  ░▒████▒▒██░   ▓██░▒▒█████▓ ░▒████▒    ▒▄▄  \n" +
            "░▒▓███▀▒░▓  ░░ ▒░ ░░ ▒░   ▒ ▒   ░ ▐░  ░░ ▒░ ░░ ▒░   ▒ ▒ ░▒▓▒ ▒ ▒ ░░ ▒░ ░    ░▀▀▒ \n" +
            "▒░▒   ░  ▒ ░ ░ ░  ░░ ░░   ░ ▒░  ░ ░░   ░ ░  ░░ ░░   ░ ▒░░░▒░ ░ ░  ░ ░  ░    ░  ░ \n" +
            " ░    ░  ▒ ░   ░      ░   ░ ░     ░░     ░      ░   ░ ░  ░░░ ░ ░    ░          ░ \n" +
            " ░       ░     ░  ░         ░      ░     ░  ░         ░    ░        ░  ░    ░    \n" +
            "      ░                           ░                                              \n\n"
        ;
    }

    private static int randomiser(int min, int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }
}
