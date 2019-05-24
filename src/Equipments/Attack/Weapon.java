package Equipments.Attack;

public class Weapon extends Attack
{
    private String category = "une arme";

    /********** Constructors **********/

    public Weapon(String pName, int pPower)
    {
        super(pName, pPower);
    }

    /********** Getters **********/

    @Override public String getCategory() {
        return category;
    }

}
