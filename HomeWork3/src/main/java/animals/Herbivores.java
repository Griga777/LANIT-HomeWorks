package animals;

import food.Food;
import food.Grass;

public class Herbivores extends Animal {

    public String toString() {
        return "Травоядные";
    }

    @Override
    public void setName(String name) {
        this.toString();
    }

    @Override
    public String getName() {
        return toString();
    }

    @Override
    public void eat(Food food) throws WrongFoodException {
        if (!(food instanceof Grass)) {
            throw new WrongFoodException(toString() + " не ест мясо");
        }
        System.out.println(toString() + " ест траву");
        System.out.println("Сытость составляет: " + ((Grass) food).getSatiety());
    }
}
