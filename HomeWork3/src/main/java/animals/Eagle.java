package animals;

public class Eagle extends Carnivorous implements Fly, Voice {

    public String toString() {
        return "Резвый";
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
    public void canFly() {
        System.out.println(toString() + " летит");
    }

    @Override
    public String makeVoice() {
        return "клекочет";
    }
}
