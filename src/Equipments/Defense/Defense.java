package Equipments.Defense;

import Equipments.Equipment;

public abstract class Defense extends Equipment
{
    private int resistance;

    /********** Constructors **********/

    public Defense(String pName, int pResistance)
    {
        super(pName);
        this.resistance = pResistance;
    }

    /********** Getters **********/

    public int getResistance() {
        return this.resistance;
    }

    @Override public abstract String getCategory();

    @Override public String toString() {
        return
            "--- " + super.getName() + " ---\n" +
            "Puissance : " + this.resistance +
            "\n";
    }
}
