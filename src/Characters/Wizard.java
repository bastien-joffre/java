package Characters;

import Equipments.Equipment;

import Equipments.Attack.Attack;
import Equipments.Attack.Spell;
import Equipments.Defense.Defense;
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
        super.equipedAttack = new Spell ("briquet magique", 1);
        super.equipedDefense = new Philter("distraction", 1);
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

//    public void setEquipedAttack() {
//        Spell spell = new Spell(
//            Interact.chooseEquipmentName("sort"),
//            Interact.chooseAttackPower("sort")
//        );
//        super.equipedAttack = spell;
//    }
//    public void setEquipedDefense() {
//        Philter philter = new Philter(
//            Interact.chooseEquipmentName("filtre"),
//            Interact.chooseDefenseResistance("filtre")
//        );
//        super.equipedDefense = philter;
//    }

    /********* Autres méthodes ***********/

    @Override public String getType() { return "magicien"; }

    @Override public Equipment getRandomWeapon() {
        int random = (int) (Math.random() * 100 + 1);

        if (random < 60) {
            return new Spell("étincelles", 2);
        } else if (random < 80) {
            return new Spell("éclectricité statique", 3);
        } else if (random < 95) {
            return new Spell("dégât des eaux", 4);
        } else {
            return new Spell("pluie de pierres", 5);
        }
    }

    @Override public Equipment getRandomDefense() {
        int random = (int) (Math.random() * 100 + 1);

        if (random < 60) {
            return new Philter("contrejour", 2);
        } else if (random < 80) {
            return new Philter("tour de magie ou quand on fait un noeud sur une ficelle et on tire et ya plus de noeud", 3);
        } else if (random < 95) {
            return new Philter("illusion", 4);
        } else {
            return new Philter("champ de force", 5);
        }
    }

    public String toString() {
        return super.toString() +
            "\n- Je lance le sort : " + this.equipedAttack.getName() + " à une puissance de " + this.equipedAttack.getPower() +
            "\n- Je me protège avec : " + this.equipedDefense.getName() + " qui possède une résistance de " + this.equipedDefense.getResistance();
    }
}
