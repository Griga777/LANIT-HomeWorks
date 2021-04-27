import animals.Animals;
import animals.Herbivores;
import animals.Voice;
import food.Food;
import food.Grass;
import food.Meat;

public class Worker {
    private String name;

    public Worker(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void feed(Animals animals, Food food) {
        animals.eat(food);
    }

    public void getVoice(Voice animals) {
        System.out.println(animals.toString() + " " + animals.makeVoice());
    }
}
