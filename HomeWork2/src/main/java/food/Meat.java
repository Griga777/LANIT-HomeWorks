package food;

public class Meat extends Food {
    private int satiety = 2;

    public String toString() {
        return "мясо";
    }

    @Override
    public void eat(Food food) {
        super.eat(food);
    }

    public int getSatiety() {
        return satiety++;
    }
}
