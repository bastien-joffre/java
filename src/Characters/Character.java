package Characters;

import Equipments.Attack.*;
import Equipments.Defense.*;

public abstract class Character
{
    private String name;
    private String image;
    private int health;
    private int strength;
    protected Attack equipedAttack;
    protected Defense equipedDefense;


    /********** Constructors **********/

    public Character(String pName, String pImage, int pHealth, int pStrength)
    {
        this.name = pName;
        this.image = pImage;
        this.health = pHealth;
        this.strength = pStrength;
    }
    public Character(String pName, String pImage)
    {
        this.name = pName;
        this.image = pImage;
    }
    public Character()
    {
        this.name = "Inconnu";
        this.image = "Pas d'image";
        this.health = 5;
        this.strength = 5;
    }

    /********** Getters **********/

    public String getName() {
        return this.name;
    }
    public String getImage() {
        return this.image;
    }
    public int getHealth() {
        return this.health;
    }
    public int getStrength() {
        return this.strength;
    }

    /********** Setters **********/

    public void setName(String pName) {
        this.name = pName;
    }
    public void setImage(String pImage) {
        this.image = pImage;
    }
    public void setHealth(int pHealth) {
        this.health = pHealth;
    }
    public void setStrength(int pStrength) {
        this.strength = pStrength;
    }

//    public void setEquipedAttack(Attack pAttack) {
//        if ((this instanceof Warrior && pAttack instanceof Weapon) ||
//            (this instanceof Wizard && pAttack instanceof Spell)) {
//            this.equipedAttack = pAttack;
//        } else {
//            System.out.println("Cet équipement n'est pas accessible pour votre type de combattant...");
//        }
//    }
//    public void setEquipedDefense(Defense pDefense) {
//        if ((this instanceof Warrior && pDefense instanceof Shield) ||
//            (this instanceof Wizard && pDefense instanceof Philter)) {
//            this.equipedDefense = pDefense;
//        } else {
//            System.out.println("Cet équipement n'est pas accessible pour votre type de combattant...");
//        }
//    }

    public abstract void setEquipedAttack();
    public abstract void setEquipedDefense();

    /********* Autres méthodes ***********/

    public abstract int getMinHealth();
    public abstract int getMaxHealth();
    public abstract int getMinStrength();
    public abstract int getMaxStrength();
    public abstract String getType();

    public String  toString() {
        return "Caractéristiques de " + this.name + " le " + this.getType() + ":" +
            "\n- Image : " + this.image +
            "\n- Points de vie : " + this.health +
            "\n- Force de frappe : " + this.strength +
            "\n- Je frappe avec : " + this.equipedAttack.getName() + " avec une puissance de " + this.equipedAttack.getPower() +
            "\n- Je me protège avec : " + this.equipedDefense.getName() + " qui possède une résistance de " + this.equipedDefense.getResistance();
    }
}