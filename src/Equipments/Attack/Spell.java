package Equipments.Attack;

public class Spell extends Attack
{
    private String category = "un sort";

    /********** Constructors **********/

    public Spell(String pName, int pPower)
    {
        super(pName, pPower);
    }

    @Override public String getCategory() {
        return category;
    }
}