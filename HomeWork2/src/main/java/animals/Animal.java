package animals;

import food.Food;

public abstract class Animal {

    public String toString() {
        return "Животное";
    }

    public abstract void eat(Food food);
}