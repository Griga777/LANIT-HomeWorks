import animals.Animal;
import animals.Voice;
import animals.WrongFoodException;
import food.Food;

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

    public void feed(Animal animal, Food food) throws WrongFoodException {
        animal.eat(food);
    }

    public void getVoice(Voice animal) {
        System.out.println(animal.toString() + " " + animal.makeVoice());
    }
}
