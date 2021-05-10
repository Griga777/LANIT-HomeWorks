package animals;

import aviaries.SizeAviary;

public class Giraffe extends Herbivores implements Run, Voice {
    protected SizeAviary sizeAviary = SizeAviary.HUGE;

    public String toString() {
        return "Длинный";
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
    public void canRun() {
        System.out.println(toString() + " бежит");
    }

    @Override
    public String makeVoice() {
        return "фыркает";
    }
}
