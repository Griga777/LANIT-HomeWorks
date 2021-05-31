package cucumber.steps;

import io.cucumber.java.ParameterType;
import io.cucumber.java.ru.И;

public class StepsWithCategories {
    @ParameterType(".*")
    public Categories categories(String category) {
        return Categories.valueOf(category);
    }

    @И("в выпадающем списке категорий выбрать {categories}")
    public void printCategories(Categories category) {
        System.out.println("Выбрана категория: " + category.value + "\n");
    }
}
