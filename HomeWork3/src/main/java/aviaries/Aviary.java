package aviaries;

import animals.Animal;
import java.util.HashMap;
import java.util.Map;

public class Aviary<T extends Animal> {
    protected SizeAviary sizeAviary;
    protected SizeAviary small = SizeAviary.SMALL;
    protected SizeAviary medium = SizeAviary.MEDIUM;
    protected SizeAviary large = SizeAviary.LARGE;
    protected SizeAviary huge = SizeAviary.HUGE;

    private final Map<String, T> mapAnimals = new HashMap<>();

    public void addAnimalInAviary(T animal) throws WrongAviaryException {
        if (mapAnimals.containsKey(animal.getName())) {
            throw new WrongAviaryException("Животное с именем " + animal.getName() + " уже существует");
        }
        if (animal.getSizeAviary().ordinal() > sizeAviary.ordinal()) {
            System.out.println("Животное с именем " + animal.getName() + " не подходит для этого вольера");
        }
        mapAnimals.put(animal.getName(), animal);
    }

    public void removeAnimalFromAviary(T animal) {
        mapAnimals.remove(animal.getName());
    }

    public T getLinkOnAnimalInAviary(String nameAnimal) throws WrongAviaryException {
        if (!mapAnimals.containsKey(nameAnimal)) {
            throw new WrongAviaryException("Такого животного с именем " + nameAnimal + " в вольере нет");
        }
        return mapAnimals.get(nameAnimal);
    }
}
