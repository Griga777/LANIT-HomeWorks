package food;

import animals.Animals;

public class Food extends Animals {

    public String toString() {
        return "еда";
    }

    @Override
    public void eat(Food food) {
        System.out.println(toString());
    }
}
