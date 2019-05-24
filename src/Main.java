import Characters.Character;
import Characters.Warrior;
import Characters.Wizard;
import Characters.Snake;
import Exceptions.NamingException;
import Interactions.Action;
import Interactions.Interact;

public class Main
{
    public static void main(String[] args)
    {
        boolean play = true;
        Interact interactions = new Interact();
        Action actions = new Action();

        interactions.asciiWelcome();

        Character monPerso1 = new Warrior("André", "", 10, 1); //Objets de test
        Wizard monPerso2 = new Wizard("Michel", "", 6, 12);    //Objets de test
        interactions.characters.add(monPerso1);                                                    //Objets de test
        interactions.characters.add(monPerso2);                                                    //Objets de test

        do {
            switch (interactions.mainMenu()) {
                case 1:
                    interactions.createCharacter();
                    break;
                case 2:
                    interactions.charactersMenu();
                    break;
                case 3:
                    actions.goToNewFloor(interactions.characters.get(0));
                    break;
                case 4:
                    play = false;
                    break;
            }
        } while (play);

        interactions.asciiGoodbye();
    }
}
