package Characters;

public class Wizard extends Character
{
    private int minHealth = 3;
    private int maxHealth = 6;
    private int minStrength = 8;
    private int maxStrength = 15;

    /********** Constructeurs **********/

    public Wizard(String pName, String pImage, int pHealth, int pStrength)
    {
        super(pName, pImage, pHealth, pStrength);
    }
    public Wizard(String pName, String pImage)
    {
        super(pName, pImage);
    }

    /********** Getters **********/

    protected int getMinHealth() {
        return this.minHealth;
    }
    public int getMaxHealth() {
        return this.maxHealth;
    }
    public int getMinStrength() {
        return this.minStrength;
    }
    public int getMaxStrength() {
        return this.maxStrength;
    }
}
