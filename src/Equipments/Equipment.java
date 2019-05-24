package Equipments;

public abstract class Equipment
{
    private String name;

    /********** Constructors **********/

    public Equipment(String pName) {
        this.name = pName;
    }

    /********** Getters **********/

    public String getName() {
        return name;
    }

    public abstract String getCategory();

    public abstract String toString();
}
