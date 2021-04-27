package animals;

import food.Food;
import food.Grass;
import food.Meat;

public class Herbivores extends Animals {

    public String toString() {
        return "Травоядные";
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Grass) {
            System.out.println(toString() + " ест траву");
            System.out.println("Сытость составляет: " + ((Grass) food).getSatiety());
        } else {
            System.out.println(toString() + " не ест мясо");
        }
    }
}
