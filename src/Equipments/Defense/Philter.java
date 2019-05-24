package Equipments.Defense;

public class Philter extends Defense
{
    private String category = "un philtre";

    public Philter(String pName, int pResistance)
    {
        super(pName, pResistance);
    }
    @Override public String getCategory() {
        return category;
    }

}
