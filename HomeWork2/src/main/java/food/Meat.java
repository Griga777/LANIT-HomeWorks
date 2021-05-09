package food;

public class Meat extends Food {
    private int satiety = 2;

    public String toString() {
        return "мясо";
    }

    public int getSatiety() {
        return satiety++;
    }
}
