package animals;

public class Giraffe extends Herbivores implements Run, Voice {

    public String toString() {
        return "Длинный";
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
    public void canRun() {
        System.out.println(toString() + " бежит");
    }

    @Override
    public String makeVoice() {
        return "фыркает";
    }
}
