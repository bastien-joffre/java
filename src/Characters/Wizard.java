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

    @Override public int getMinHealth() {
        return this.minHealth;
    }
    @Override public int getMaxHealth() {
        return this.maxHealth;
    }
    @Override public int getMinStrength() {
        return this.minStrength;
    }
    @Override public int getMaxStrength() {
        return this.maxStrength;
    }

    /********* Autres méthodes ***********/

    @Override public String getType() { return "magicien"; }
}
