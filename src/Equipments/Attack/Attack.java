package Equipments.Attack;

import Equipments.Equipment;

public abstract class Attack extends Equipment
{
    private int power;

    /********** Constructors **********/

    public Attack(String pName, int pPower)
    {
        super(pName);
        this.power = pPower;
    }

    /********** Getters **********/

    public int getPower() {
        return this.power;
    }

    @Override public abstract String getCategory();

    @Override public String toString() {
        return
            "--- " + super.getName() + " ---\n" +
            "Puissance : " + this.power +
            "\n";
    }
}
