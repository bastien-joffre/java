import Characters.Character;
import Interactions.Interact;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print(
            Interact.ascii() +
            "Que souhaitez-vous faire ?\n" +
            "[1] Créer un nouveau personnage\n" +
            "[2] Consulter vos personnages\n" +
            "[3] Quitter le jeu"
        );
        int option = Interact.parseInt(input.nextLine());
        
        Character monPerso = Interact.createCharacter();
        System.out.println(monPerso);
    }
}
