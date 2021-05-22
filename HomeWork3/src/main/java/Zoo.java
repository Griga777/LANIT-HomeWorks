import animals.*;
import aviaries.Aviary;
import aviaries.WrongAviaryException;
import food.Food;
import food.Grass;
import food.Meat;

public class Zoo {

    public static void main(String[] args) throws WrongFoodException, WrongAviaryException {

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

        Carnivorous eagle3 = new Eagle();
        Carnivorous lion3 = new Lion();
        Carnivorous wolf3 = new Wolf();
        Herbivores duck3 = new Duck();
        Herbivores fish3 = new Fish();
        Herbivores giraffe3 = new Giraffe();

        Aviary<Carnivorous> carnivorous = new Aviary<>();
        carnivorous.addAnimalInAviary(eagle3);
        carnivorous.addAnimalInAviary(lion3);
        carnivorous.addAnimalInAviary(wolf3);
        carnivorous.getLinkOnAnimalInAviary("Резвый");

        Aviary<Herbivores> herbivores = new Aviary<>();
        herbivores.addAnimalInAviary(duck3);
        herbivores.addAnimalInAviary(fish3);
        herbivores.addAnimalInAviary(giraffe3);
        herbivores.getLinkOnAnimalInAviary("Дональд");
    }
}

