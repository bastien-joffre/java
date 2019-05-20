package Characters;

public class Character
{
    private String name;
    private String image;
    private int health;
    private int strength;

    /********** s **********/

    public Character(String pName, String pImage, int pHealth, int pStrength)
    {
        this.name = pName;
        this.image = pImage;
        this.health = pHealth;
        this.strength = pStrength;
    }
    public Character(String pName, String pImage)
    {
        this.name = pName;
        this.image = pImage;
    }
    public Character()
    {
        this.name = "Inconnu";
        this.image = "Pas d'image";
        this.health = 5;
        this.strength = 5;
    }

    /********** Getters **********/

    public String getName() {
        return this.name;
    }
    public String getImage() {
        return this.image;
    }
    public int getHealth() {
        return this.health;
    }
    public int getStrength() {
        return this.strength;
    }

    /********** Setters **********/

    public void setName(String pName) {
        this.name = pName;
    }
    public void setImage(String pImage) {
        this.image = pImage;
    }
    public void setHealth(int pHealth) {
        this.health = pHealth;
    }
    public void setStrength(int pStrength) {
        this.strength = pStrength;
    }

    /********* Autres méthodes ***********/

    public void getInfo() {
        System.out.println("Caractéristiques de " + this.name + " :" +
                "\n- Image : " + this.image +
                "\n- Points de vie : " + this.health +
                "\n- Force de frappe : " + this.strength
        );
    }
}