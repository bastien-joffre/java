package Interactions;

import java.util.Scanner;

public class Interact
{
    private Scanner input = new Scanner(System.in);

    public int chooseAttackPower(String type) {
        System.out.println("Quelle sera la puissance de votre " + type);
        return this.input.nextInt();
    }

    public String chooseEquipmentName(String type) {
        System.out.println("Comment souhaitez vous appeler votre " + type);
        return this.input.nextLine();
    }

    public int chooseDefenseResistance(String type) {
        System.out.println("Quelle sera la resistance de votre " + type);
        return this.input.nextInt();
    }
}
