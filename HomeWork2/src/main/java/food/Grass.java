package food;

public class Grass extends Food {
    private int satiety = 1;

    public String toString() {
        return "траву";
    }

    @Override
    public void eat(Food food) {
        super.eat(food);
    }

    public int getSatiety() {
        return satiety++;
    }
}
