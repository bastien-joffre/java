import Characters.Character;
import Characters.Wizard;
import Characters.Warrior;
import Equipments.Attack.Weapon;
import Equipments.Defense.Shield;


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

        Character monPerso;
        if (characterType.equals("g")) {
            monPerso = new Warrior(name, image);
        } else {
            monPerso = new Wizard(name, image);
        }

        System.out.println("Sur une échelle de " + monPerso.getMinHealth() + " à " + monPerso.getMaxHealth() + ", à quel point pense tu être résistant ?");
        int health = input.nextInt(); // Rentrer le nombre de Points de vie
        while (health < monPerso.getMinHealth() || health > monPerso.getMaxHealth()) {
            System.out.println("Soyons raisonnables, rentre un nombre entre " + monPerso.getMinHealth() + " et " + monPerso.getMaxHealth() + " on a dit...");
            health = input.nextInt(); // Tant que le nombre de points de vie est invalide, reproposer
        }
        monPerso.setHealth(health);

        System.out.println("Et sur une échelle de " + monPerso.getMinStrength() + " à " + monPerso.getMaxStrength() + ", à quel point pense tu être balèze ?");
        int strength = input.nextInt(); // Rentrer le nombre de Points de vie
        while (strength < monPerso.getMinStrength() || strength > monPerso.getMaxStrength()) {
            System.out.println("Soyons raisonnables, rentre un nombre entre " + monPerso.getMinStrength() + " et " + monPerso.getMaxStrength() + " on a dit...");
            strength = input.nextInt(); // Tant que le nombre de points de force est invalide, reproposer
        }
        monPerso.setStrength(strength);

        monPerso.setEquipedAttack();
        monPerso.setEquipedDefense();
        
        System.out.println(monPerso);
    }
}
