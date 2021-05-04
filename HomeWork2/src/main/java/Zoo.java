import animals.*;
import food.Food;
import food.Grass;
import food.Meat;

public class Zoo {
    public static void main(String[] args) {

        Animal duck = new Duck();
        Animal fish = new Fish();
        Animal giraffe = new Giraffe();
        Animal eagle = new Eagle();
        Animal lion = new Lion();
        Animal wolf = new Wolf();

        Food food = new Food();
        Food meat = new Meat();
        Food grass = new Grass();

        Voice duck1 = new Duck();
        Voice eagle1 = new Eagle();
        Voice giraffe1 = new Giraffe();
        Voice lion1 = new Lion();
        Voice wolf1 = new Wolf();

        Worker worker = new Worker("Вася");
        System.out.println(worker.getName() + " работник зоопарка, он кормит животных");
        worker.feed(lion, meat);
        worker.getVoice(giraffe1);

        Swim duck2 = new Duck();
        Swim fish2 = new Fish();
        Swim lion2 = new Lion();
        Swim wolf2 = new Wolf();

        Swim [] pond = {duck2, fish2, lion2, wolf2};
        for (int i = 0; i < pond.length; i++) {
            pond[i].canSwim();
        }
    }
}

