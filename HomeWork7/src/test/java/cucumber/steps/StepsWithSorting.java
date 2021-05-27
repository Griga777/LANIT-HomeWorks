package cucumber.steps;

import io.cucumber.java.ParameterType;
import io.cucumber.java.ru.И;

public class StepsWithSorting {
    @ParameterType(".*")
    public Sorting sorting(String sort) {
        return Sorting.valueOf(sort);
    }

    @И("в выпадающем списке сортировка выбрано значение {sorting}")
    public void printSorting(Sorting sort) {
        System.out.println("Выбрана сортировка " + sort.value + "\n");
    }
}
