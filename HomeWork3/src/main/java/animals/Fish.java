package animals;

import aviaries.SizeAviary;

public class Fish extends Herbivores implements Swim {
    protected SizeAviary sizeAviary = SizeAviary.SMALL;

    public String toString() {
        return "Флаундер";
    }

    @Override
    public SizeAviary getSizeAviary() {
        return sizeAviary;
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
