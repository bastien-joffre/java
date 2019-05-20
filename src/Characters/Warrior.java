package Characters;

public class Warrior extends Character
{
    private int minHealth = 5;
    private int maxHealth = 10;
    private int minStrength = 5;
    private int maxStrength = 10;

    /********** Constructeurs **********/

    public Warrior(String pName, String pImage, int pHealth, int pStrength)
    {
        super(pName, pImage, pHealth, pStrength);
    }
    public Warrior(String pName, String pImage)
    {
        super(pName, pImage);
    }

    /********** Getters **********/

    protected int getMinHealth() {
        return minHealth;
    }
    public int getMaxHealth() {
        return maxHealth;
    }
    public int getMinStrength() {
        return minStrength;
    }
    public int getMaxStrength() {
        return maxStrength;
    }
}
