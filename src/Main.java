import Characters.Character;
import Characters.Warrior;
import Characters.Wizard;
import Exceptions.NamingException;
import Interactions.Interact;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) throws NamingException
    {
        ArrayList<Character> characters = new ArrayList<>();

        boolean play = true;

        Interact.asciiWelcome();

        Character monPerso1 = new Warrior("André", "", 10, 5); //Objets de test
        Wizard monPerso2 = new Wizard("Michel", "", 6, 12);    //Objets de test
        characters.add(monPerso1);                                                             //Objets de test
        characters.add(monPerso2);                                                             //Objets de test

        do {
            switch (Interact.mainMenu()) {
                case 1:
//                    try {
//                        Character monPerso = Interact.createCharacter(); // Commenter pour tests
//                        System.out.println(monPerso);                    // Commenter pour tests
//                        characters.add(monPerso);                        // Commenter pour tests
//                    } catch (NamingException e) {                        // Commenter pour tests
//                        System.out.println(e.getMessage());              // Commenter pour tests
//                    }                                                    // Commenter pour tests
                    break;
                case 2:
                    System.out.println();
                    for (Character character : characters) {
                        System.out.println(
                            "[" + (characters.indexOf(character) + 1) + "] " +
                            character.getName() + " le " + character.getType()
                        );
                    }
                    Interact.charactersMenu(characters);
                    break;
                case 3:
                    play = false;
                    break;
            }
        } while (play);

        Interact.asciiGoodbye();
    }
}
