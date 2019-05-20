import Characters.Character;
import Characters.Wizard;
import Characters.Warrior;


import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

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
        if (characterType.equals("g")) {
            Warrior monPerso = new Warrior(name, image);
        } else {
            Wizard monPerso = new Wizard(name, image);
        }

        System.out.println("Hmm canon ! Sur une échelle de 5 à 10, à quel point pense tu être résistant ?");
        int health = input.nextInt(); // Rentrer le nombre de Points de vie
        while (health < 5 || health > 10) {
            System.out.println("Soyons raisonnables, rentre un nombre entre 5 et 10 on a dit...");
            health = input.nextInt(); // Tant que le nombre de points de vie est invalide, reproposer
        }

        System.out.println("Pas mal ! Et sur une échelle de 5 à 10, à quel point pense tu être balèze ?");
        int strength = input.nextInt(); // Rentrer le nombre de Points de vie
        while (strength < 5 || strength > 10) {
            System.out.println("Soyons raisonnables, rentre un nombre entre 5 et 10 on a dit...");
            strength = input.nextInt(); // Tant que le nombre de points de force est invalide, reproposer
        }

        // Wizard monPerso = new Wizard(name, image, health, strength);

        // Character monPerso = new Character("Joe", "empty", 8, 8);

        monPerso.getInfo();
    }
}
