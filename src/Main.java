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

        Interact.asciiWelcome();

        Character monPerso1 = new Warrior("André", "", 10, 1); //Objets de test
        Wizard monPerso2 = new Wizard("Michel", "", 6, 12);    //Objets de test
        Interact.characters.add(monPerso1);                                                    //Objets de test
        Interact.characters.add(monPerso2);                                                    //Objets de test
//
//        do {
//            switch (Interact.mainMenu()) {
//                case 1:
//                    Interact.createCharacter();
//                    break;
//                case 2:
//                    Interact.charactersMenu();
//                    break;
//                case 3:
//                    play = false;
//                    break;
//            }
//        } while (play);

        Action.goToNewFloor(Interact.characters.get(0));

        Interact.asciiGoodbye();
    }
}
