package animals;

public class Fish extends Herbivores implements Swim {

    public String toString() {
        return "Флаундер";
    }

    @Override
    public void setName(String name) {
        this.toString();
    }

    @Override
    public String getName() {
        return toString();
    }

    @Override
    public void canSwim() {
        System.out.println(toString() + " плавает в пруду");
    }
}
