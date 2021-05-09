package animals;

import food.Food;

public class Lion extends Carnivorous implements Run, Swim, Voice {

    public String toString() {
        return "Лев";
    }

    @Override
    public void canRun() {
        System.out.println(toString() + " бежит");
    }

    @Override
    public void canSwim() {
        System.out.println(toString() + " плавает в пруду");
    }

    @Override
    public String makeVoice() {
        return "рычит";
    }
}
