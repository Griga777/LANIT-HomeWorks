package animals;

import food.Food;

public class Fish extends Herbivores implements Swim {

    public String toString() {
        return "Рыба";
    }

    @Override
    public void canSwim() {
        System.out.println(toString() + " плавает в пруду");
    }
}
