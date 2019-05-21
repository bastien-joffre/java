package Characters;

import Interactions.Interact;

import Equipments.Attack.Weapon;
import Equipments.Defense.Shield;

public class Warrior extends Character
{
    private int minHealth = 5;
    private int maxHealth = 10;
    private int minStrength = 5;
    private int maxStrength = 10;

    private Interact interact = new Interact();

    /********** Constructeurs **********/

    public Warrior(String pName, String pImage, int pHealth, int pStrength)
    {
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
            interact.chooseEquipmentName("arme"),
            interact.chooseAttackPower("arme")
        );
        super.equipedAttack = weapon;
    }
    public void setEquipedDefense() {
        Shield shield = new Shield(
            interact.chooseEquipmentName("bouclier"),
            interact.chooseDefenseResistance("bouclier")
        );
        super.equipedDefense = shield;
    }

    /********* Autres méthodes ***********/

    @Override public String getType() { return "guerrier"; }
}
