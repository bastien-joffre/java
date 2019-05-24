package Characters;

import Equipments.Equipment;

public class Snake extends Character
{
    private int minHealth = 1;
    private int maxHealth = 5;
    private int minStrength = 1;
    private int maxStrength = 5;

    /********** Constructors **********/

    public Snake (int pHealth, int pStrength) {
        super("snake","", pHealth, pStrength);
    }

    public Snake () {
        super("snake","");
    }

    /********** Getters **********/

    @Override public int getMinHealth() {
        return minHealth;
    }
    @Override public int getMaxHealth() {
        return maxHealth;
    }
    @Override public int getMinStrength() {
        return minStrength;
    }
    @Override public int getMaxStrength() {
        return maxStrength;
    }

    /********** Setters **********/

    public void setEquipedAttack() {}
    public void setEquipedDefense() {}

    /********* Autres méthodes ***********/

    @Override public String getType() { return "serpent"; }

    @Override public Equipment getRandomWeapon() {
        return null;
    }
    @Override public Equipment getRandomDefense() {
        return null;
    }

    public String toString() {
        return
            "                      __    __    __    __                               \n"+
            "                     /  \\  /  \\  /  \\  /  \\                              \n"+
            "____________________/  __\\/  __\\/  __\\/  __\\_____________________________\n"+
            "___________________/  /__/  /__/  /__/  /________________________________\n"+
            "                   | / \\   / \\   / \\   / \\   \\____                        \n"+
            "                   |/   \\_/   \\_/   \\_/   \\     o \\                       \n"+
            "                                           \\______/--<                    \n\n" +
            super.toString();
    }
}
