package Characters;

import Interactions.Interact;

import Equipments.Attack.Weapon;
import Equipments.Defense.Shield;

public class Warrior extends Character
{
    private static int minHealth = 5;
    private static int maxHealth = 10;
    private static int minStrength = 5;
    private static int maxStrength = 10;

//    private Interact interact = new Interact();

    /********** Constructeurs **********/

    public Warrior(String pName, String pImage, int pHealth, int pStrength) {
        super(pName, pImage, pHealth, pStrength);
    }
    public Warrior(String pName, String pImage)
    {
        super(pName, pImage);
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

    public void setEquipedAttack() {
        Weapon weapon = new Weapon(
            Interact.chooseEquipmentName("arme"),
            Interact.chooseAttackPower("arme")
        );
        super.equipedAttack = weapon;
    }
    public void setEquipedDefense() {
        Shield shield = new Shield(
            Interact.chooseEquipmentName("bouclier"),
            Interact.chooseDefenseResistance("bouclier")
        );
        super.equipedDefense = shield;
    }

    /********* Autres méthodes ***********/

    @Override public String getType() { return "guerrier"; }
}
