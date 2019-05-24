package Characters;

import Interactions.Interact;

import Equipments.Attack.Spell;
import Equipments.Defense.Philter;

public class Wizard extends Character
{
    private static int minHealth = 3;
    private static int maxHealth = 6;
    private static int minStrength = 8;
    private static int maxStrength = 15;

//    private Interact interact = new Interact();

    /********** Constructeurs **********/

    public Wizard(String pName, String pImage, int pHealth, int pStrength) {
        super(pName, pImage, pHealth, pStrength);
        super.equipedAttack = new Spell ("boules de fire", 16);
        super.equipedDefense = new Philter("champ de force", 5);
    }
    public Wizard(String pName, String pImage)
    {
        super(pName, pImage);
    }

    /********** Getters **********/

    @Override public int getMinHealth() {
        return this.minHealth;
    }
    @Override public int getMaxHealth() {
        return this.maxHealth;
    }
    @Override public int getMinStrength() {
        return this.minStrength;
    }
    @Override public int getMaxStrength() {
        return this.maxStrength;
    }

    /********** Setters **********/

    public void setEquipedAttack() {
        Spell spell = new Spell(
            Interact.chooseEquipmentName("sort"),
            Interact.chooseAttackPower("sort")
        );
        super.equipedAttack = spell;
    }
    public void setEquipedDefense() {
        Philter philter = new Philter(
            Interact.chooseEquipmentName("filtre"),
            Interact.chooseDefenseResistance("filtre")
        );
        super.equipedDefense = philter;
    }

    /********* Autres méthodes ***********/

    @Override public String getType() { return "magicien"; }

    public String toString() {
        return super.toString() +
            "\n- Je lance le sort : " + this.equipedAttack.getName() + " à une puissance de " + this.equipedAttack.getPower() +
            "\n- Je me protège avec : " + this.equipedDefense.getName() + " qui possède une résistance de " + this.equipedDefense.getResistance();
    }
}
