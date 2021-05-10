package animals;

import aviaries.SizeAviary;

public class Eagle extends Carnivorous implements Fly, Voice {
    protected SizeAviary sizeAviary = SizeAviary.HUGE;

    public String toString() {
        return "Резвый";
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
    public void canFly() {
        System.out.println(toString() + " летит");
    }

    @Override
    public String makeVoice() {
        return "клекочет";
    }
}
