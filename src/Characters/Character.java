package Characters;

import Equipments.Attack.*;
import Equipments.Defense.*;
import Equipments.Equipment;

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
    public Attack getEquipedAttack() {
        return equipedAttack;
    }
    public Defense getEquipedDefense() {
        return equipedDefense;
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

//    public abstract void setEquipedAttack();
//    public abstract void setEquipedDefense();
    public void setEquipedAttack(Equipment attack) {
        this.equipedAttack = (Attack) attack;
    };
    public void setEquipedDefense(Equipment defense) {
        this.equipedDefense = (Defense) defense;
    };

    /********* Autres méthodes ***********/

    public abstract int getMinHealth();
    public abstract int getMaxHealth();
    public abstract int getMinStrength();
    public abstract int getMaxStrength();
    public abstract String getType();
    public abstract Equipment getRandomWeapon();
    public abstract Equipment getRandomDefense();

    public String toString() {
        return "Caractéristiques de " + this.name + " le " + this.getType() + ":" +
            "\n- Points de vie : " + this.health +
            "\n- Force de frappe : " + this.strength;
    }
}