package Interactions;

import Characters.Snake;
import Characters.Character;
//import Equipments.Attack.Attack;
//import Equipments.Defense.Defense;

public class Floor
{
    static int level = 0;

    public Character snake;
    int snakeChance = 75;
    boolean attack;
    int attackChance = 50;
    boolean defense;
    int defenseChance = 50;

    public Floor() {
        level++;
        if (shallISpawn(this.snakeChance)) {
            this.snake = new Snake();
            this.snake.setHealth(randomLife(this.snake.getMinHealth(), this.snake.getMaxHealth()));
            this.snake.setStrength(randomLife(this.snake.getMinStrength(), this.snake.getMaxStrength()));
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

    public int randomLife(double min, double max) {
        return (int) (min + (Math.random() * ((max - min) + 1))) * ((level * 3 / 100) + 1);
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
