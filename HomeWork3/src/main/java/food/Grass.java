package food;

public class Grass extends Food {
    private int satiety = 1;

    public String toString() {
        return "траву";
    }

    public int getSatiety() {
        return satiety++;
    }
}
