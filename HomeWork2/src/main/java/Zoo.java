import animals.*;
import food.Food;
import food.Grass;
import food.Meat;

public class Zoo {
    public static void main(String[] args) {

        Animals duck = new Duck();
        Animals fish = new Fish();
        Animals giraffe = new Giraffe();
        Animals eagle = new Eagle();
        Animals lion = new Lion();
        Animals wolf = new Wolf();

        Food food = new Food();
        Food meat = new Meat();
        Food grass = new Grass();

        Worker worker = new Worker("Вася");
        System.out.println(worker.getName() + " работник зоопарка, он кормит животных");
        worker.feed(duck, grass);
        worker.getVoice((Voice) lion);

        Swim [] pond = {(Swim) duck, (Swim) fish, (Swim) lion, (Swim) wolf};
        for (int i = 0; i < pond.length; i++) {
            pond[i].canSwim();
        }
    }
}

