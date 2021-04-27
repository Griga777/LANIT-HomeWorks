package animals;

import food.Food;

public abstract class Animals {

    public String toString() {
        return "Животные";
    }

    public abstract void eat(Food food);
}
