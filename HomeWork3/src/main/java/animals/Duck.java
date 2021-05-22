package animals;

public class Duck extends Herbivores implements Fly, Swim, Voice {

    public String toString() {
        return "Дональд";
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
    public void canSwim() {
        System.out.println(toString() + " плавает в пруду");
    }

    @Override
    public String makeVoice() {
        return "крякает";
    }
}
