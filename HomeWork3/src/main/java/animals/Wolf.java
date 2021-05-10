package animals;

import aviaries.SizeAviary;

public class Wolf extends Carnivorous implements Run, Swim, Voice {
    protected SizeAviary sizeAviary = SizeAviary.LARGE;

    public String toString() {
        return "Шарик";
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
    public void canSwim() {
        System.out.println(toString() + " плавает в пруду");
    }

    @Override
    public String makeVoice() {
        return "тявкает";
    }
}
