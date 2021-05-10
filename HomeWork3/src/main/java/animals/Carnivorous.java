package animals;

import food.Food;
import food.Meat;

public class Carnivorous<SizeAviary> extends Animal {
    protected SizeAviary sizeAviary;

    public String toString() {
        return "Плотоядные";
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
    public SizeAviary getSizeAviary() {
        return sizeAviary;
    }

    @Override
    public void eat(Food food) throws WrongFoodException {
        if (!(food instanceof Meat)) {
            throw new WrongFoodException(toString() + " не ест траву");
        }
        System.out.println(toString() + " ест мясо");
        System.out.println("Сытость составляет: " + ((Meat) food).getSatiety());
    }
}
