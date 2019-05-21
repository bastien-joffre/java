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
}
