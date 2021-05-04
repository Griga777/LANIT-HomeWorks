package animals;

import food.Food;
import food.Meat;

public class Carnivorous extends Animal {

    public String toString() {
        return "Плотоядные";
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            System.out.println(toString() + " ест мясо");
            System.out.println("Сытость составляет: " + ((Meat) food).getSatiety());
        } else {
            System.out.println(toString() + " не ест траву");
        }
    }
}
