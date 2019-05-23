package Interactions;

import Characters.Character;
import Characters.Warrior;
import Characters.Wizard;

import Exceptions.NamingException;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Interact
{
    public static ArrayList<Character> characters = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    /********** Menus **********/

    public static int mainMenu() {
        System.out.println(
            "  ___ MENU PRINCIPAL _________________________  \n"+
            "/                                              \\\n"+
            "|     [1] Créer un nouveau personnage          |\n"+
            "|     [2] Consulter vos personnages            |\n"+
            "|     [3] Quitter le jeu                       |\n"+
            "\\______________________________________________/\n"
        );
        int option = Interact.parseInt(input.nextLine());
        while (option < 1 || option > 3) {
            System.out.println("Nous n'avons pas compris votre choix... Tappez 1, 2 ou 3.");
            option = Interact.parseInt(input.nextLine());
        }
        return option;
    }

    public static void charactersMenu() {
        System.out.println();
        for (Character character : Interact.characters) {
            System.out.println(
                    "[" + (Interact.characters.indexOf(character) + 1) + "] " +
                            character.getName() + " le " + character.getType()
            );
        }
        System.out.println(
            "\n" +
            "  ___ OPTIONS ________________________________  \n"+
            "/                                              \\\n"+
            "|   Pour sélectionner un personnage, tappez    |\n"+
            "|   son numéro. Pour retourner au menu         |\n"+
            "|   principal, tappez n'importe quel chiffre   |\n"+
            "\\______________________________________________/\n"
        );

        Character selectedCharacter;
        int option = Interact.parseInt(input.nextLine());
        if (option <= characters.size() && option > 0) {
            selectedCharacter = characters.get(option - 1);
            modifyCharacter(selectedCharacter);
        }
    }

    private static void modifyCharacter(Character character) {
        System.out.println(
            "\n\n" + character + "\n\n" +
            "  ___ OPTIONS ________________________________  \n"+
            "/                                              \\\n"+
            "|     [1] Modifier le nom                      |\n"+
            "|     [2] Modifier l'image                     |\n"+
            "|     [3] Changer d'attaque                    |\n"+
            "|     [4] Changer de défense                   |\n"+
            "|     [5] Supprimer le personnage              |\n"+
            "|                                              |\n"+
            "|     Pour revenir au menu principal,          |\n"+
            "|     appuyez sur n'importe quelle touche.     |\n"+
            "\\______________________________________________/\n"
        );
        switch (input.nextLine()) {
            case "1":
                try {
                    character.setName(chooseName());
                    modifyCharacter(character);
                } catch(NamingException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "2":
                character.setImage(chooseImage());
                modifyCharacter(character);
                break;
            case "3":
                character.setEquipedAttack();
                modifyCharacter(character);
                break;
            case "4":
                character.setEquipedDefense();
                modifyCharacter(character);
                break;
            case "5":
                characters.remove(character);
                charactersMenu();
                break;
        }
    }

    /********** Characters **********/

    public static void createCharacter() throws NamingException {

        String name;
        try {
            name = chooseName();
        } catch (NamingException e) {
            System.out.println(e.getMessage());
            name = chooseName();
        }

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

        System.out.println(newCharacter);
        characters.add(newCharacter);
    }

    private static String chooseName() throws NamingException {
        System.out.println("Quel sera le nom de votre combattant ?");
        String name = input.nextLine();
        if (stringContainsNumber(name)){
          throw new NamingException();
        } else {
            return name;
        }
    }

    private static String chooseImage() {
        System.out.println("Quelle image veux-tu utiliser ?");
        return input.nextLine(); // Rentrer l'url de l'image
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

    /********** Other methods **********/

    public static int parseInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException nfe) {
            System.out.println("Saisissez un nombre entier.");
            return parseInt(input.nextLine());
        }
    }

    public static boolean stringContainsNumber( String s ) {
        return Pattern.compile( "[0-9]" ).matcher( s ).find();
    }

    public static void asciiWelcome() {
        System.out.println(
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
        );
    }

    public static void asciiGoodbye() {
        System.out.println(
            "\n"+
            "  ▄████  ▄▄▄       ███▄ ▄███▓▓█████     ▒█████   ██▒   █▓▓█████  ██▀███      ▐██▌ \n"+
            " ██▒ ▀█▒▒████▄    ▓██▒▀█▀ ██▒▓█   ▀    ▒██▒  ██▒▓██░   █▒▓█   ▀ ▓██ ▒ ██▒    ▐██▌ \n"+
            "▒██░▄▄▄░▒██  ▀█▄  ▓██    ▓██░▒███      ▒██░  ██▒ ▓██  █▒░▒███   ▓██ ░▄█ ▒    ▐██▌ \n"+
            "░▓█  ██▓░██▄▄▄▄██ ▒██    ▒██ ▒▓█  ▄    ▒██   ██░  ▒██ █░░▒▓█  ▄ ▒██▀▀█▄      ▓██▒ \n"+
            "░▒▓███▀▒ ▓█   ▓██▒▒██▒   ░██▒░▒████▒   ░ ████▓▒░   ▒▀█░  ░▒████▒░██▓ ▒██▒    ▒▄▄  \n"+
            " ░▒   ▒  ▒▒   ▓▒█░░ ▒░   ░  ░░░ ▒░ ░   ░ ▒░▒░▒░    ░ ▐░  ░░ ▒░ ░░ ▒▓ ░▒▓░    ░▀▀▒ \n"+
            "  ░   ░   ▒   ▒▒ ░░  ░      ░ ░ ░  ░     ░ ▒ ▒░    ░ ░░   ░ ░  ░  ░▒ ░ ▒░    ░  ░ \n"+
            "░ ░   ░   ░   ▒   ░      ░      ░      ░ ░ ░ ▒       ░░     ░     ░░   ░        ░ \n"+
            "      ░       ░  ░       ░      ░  ░       ░ ░        ░     ░  ░   ░         ░    \n"+
            "                                                     ░                            \n"
        );
    }

    private static int randomiser(int min, int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }
}
