package animals;

import food.Food;

public class Duck extends Herbivores implements Fly, Swim, Voice {

    public String toString() {
        return "Утка";
    }

    @Override
    public void eat(Food food) {
        super.eat(food);
    }

    @Override
    public void canFly() {
        System.out.println(toString() + " летит");
    }

    @Override
    public void canSwim() {
        System.out.println(toString() + " плавает в пруду");
    }

    @Override
    public String makeVoice() {
        return "крякает";
    }
}
