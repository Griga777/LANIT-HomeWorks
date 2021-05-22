package animals;

import aviaries.SizeAviary;
import food.Food;
import java.util.Objects;

public abstract class Animal {
    protected String name;
    protected SizeAviary sizeAviary;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public SizeAviary getSizeAviary() {
        return sizeAviary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal animal = (Animal) o;
        return getName().equals(animal.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    public String toString() {
        return getName();
    }

    public abstract void eat(Food food) throws WrongFoodException;
}
