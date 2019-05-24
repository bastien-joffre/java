package Equipments.Defense;

public class Shield extends Defense
{
    private String category = "un bouclier";

    public Shield(String pName, int pResistance)
    {
        super(pName, pResistance);
    }

    @Override public String getCategory() {
        return category;
    }
}
