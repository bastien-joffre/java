package Characters;

import Interactions.Interact;

import Equipments.Equipment;
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
        super.equipedAttack = new Weapon ("épée pourrave", 1);
        super.equipedDefense = new Shield("bouclier en polysthyrène expansé", 1);

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

//    public void setEquipedAttack() {
//        Weapon weapon = new Weapon(
//            Interact.chooseEquipmentName("arme"),
//            Interact.chooseAttackPower("arme")
//        );
//        super.equipedAttack = weapon;
//    }
//    public void setEquipedDefense() {
//        Shield shield = new Shield(
//            Interact.chooseEquipmentName("bouclier"),
//            Interact.chooseDefenseResistance("bouclier")
//        );
//        super.equipedDefense = shield;
//    }

    /********* Autres méthodes ***********/

    @Override public String getType() { return "guerrier"; }

    @Override public Equipment getRandomWeapon() {
        int random = (int) (Math.random() * 100 + 1);

        if (random < 60) {
            return new Weapon("épée en bois", 2);
        } else if (random < 80) {
            return new Weapon("masse d'arme en mousse", 3);
        } else if (random < 95) {
            return new Weapon("hache en contraplaqué", 4);
        } else {
            return new Weapon("AK-47", 5);
        }
    }

    @Override public Equipment getRandomDefense() {
        int random = (int) (Math.random() * 100 + 1);

        if (random < 60) {
            return new Shield("bouclier en carton", 2);
        } else if (random < 80) {
            return new Shield("string en mithryl", 3);
        } else if (random < 95) {
            return new Shield("armure en acier", 4);
        } else {
            return new Shield("casque tactique", 5);
        }
    }


    public String toString() {
        return super.toString() +
        "\n- Je frappe avec : " + this.equipedAttack.getName() + " à une puissance de " + this.equipedAttack.getPower() +
        "\n- Je me protège avec : " + this.equipedDefense.getName() + " qui possède une résistance de " + this.equipedDefense.getResistance();
    }
}
