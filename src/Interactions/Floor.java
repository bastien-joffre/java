package Interactions;

import Characters.Snake;
import Characters.Character;
//import Equipments.Attack.Attack;
//import Equipments.Defense.Defense;

public class Floor
{
    public Character snake;
    int snakeChance = 75;
    boolean attack;
    int attackChance = 80;
    boolean defense;
    int defenseChance = 10;

    public Floor() {
        if (shallISpawn(this.snakeChance)) {
            this.snake = new Snake();
            this.snake.setHealth(Interact.randomiser(this.snake.getMinHealth(), this.snake.getMaxHealth()));
            this.snake.setStrength(Interact.randomiser(this.snake.getMinStrength(), this.snake.getMaxStrength()));
        }
        if (shallISpawn(this.attackChance)) this.attack = true; else this.attack = false;
        if (shallISpawn(this.defenseChance)) this.defense = true; else this.defense = false;
    }

    public boolean shallISpawn(int coef) {
        if ((Math.random() * 100 ) < coef) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        String floorContent;
        if (this.snake != null) {
            floorContent = this.snake.toString();
        } else {
            floorContent = "Absolument rien";
        }
        return
            "Dans la salle :\n" +
            floorContent;

    }
}
