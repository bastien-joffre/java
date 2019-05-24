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

//    private Interact interact = new Interact();

    /********** Constructeurs **********/

    public Warrior(String pName, String pImage, int pHealth, int pStrength) {
        super(pName, pImage, pHealth, pStrength);
        super.equipedAttack = new Weapon ("hache", 4);
        super.equipedDefense = new Shield("bouclier en bois", 1);

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

    public String toString() {
        return super.toString() +
        "\n- Je frappe avec : " + this.equipedAttack.getName() + " à une puissance de " + this.equipedAttack.getPower() +
        "\n- Je me protège avec : " + this.equipedDefense.getName() + " qui possède une résistance de " + this.equipedDefense.getResistance();
    }
}
