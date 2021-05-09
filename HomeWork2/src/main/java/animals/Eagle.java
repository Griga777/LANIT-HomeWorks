package animals;

import food.Food;

public class Eagle extends Carnivorous implements Fly, Voice {

    public String toString() {
        return "Орёл";
    }

    @Override
    public void canFly() {
        System.out.println(toString() + " летит");
    }

    @Override
    public String makeVoice() {
        return "клекочет";
    }
}
