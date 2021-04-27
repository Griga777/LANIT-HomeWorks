package animals;

import food.Food;

public class Giraffe extends Herbivores implements Run, Voice {

    public String toString() {
        return "Жираф";
    }

    @Override
    public void eat(Food food) {
        super.eat(food);
    }

    @Override
    public void canRun() {
        System.out.println(toString() + " бежит");
    }

    @Override
    public String makeVoice() {
        return "фыркает";
    }
}
