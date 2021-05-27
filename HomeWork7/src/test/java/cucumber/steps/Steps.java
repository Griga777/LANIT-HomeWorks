package cucumber.steps;

import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;

import java.util.HashMap;

public class Steps {
    private static HashMap<String, String> storage = new HashMap<>();
    private static HashMap<String, Integer> storage1 = new HashMap<>();

    @Пусть("открыт ресурс авито")
    public static void openResource() {
        System.out.println("Открыт ресурс авито" + "\n");
    }

    @И("в выпадающем списке категорий выбрана {string}")
    public static void selectCategory(String s) {
        System.out.println("Выбрана категория " + s + "\n");
        storage.put("Выбрана категория", s);
    }

    @И("в поле поиска введено значение {word}")
    public static void enterValuePrinter(String s) {
        System.out.println("Найден результат поиска " + s + "\n");
        storage.put("Найден результат поиска", s);
    }

    @Тогда("кликнуть по выпадающему списку региона")
    public static void clickRegionList() {
        System.out.println("Кликнуть по выпадающему списку региона" + "\n");
    }

    @Тогда("в поле регион введено значение {word}")
    public static void enterValueVladivostok(String s) {
        System.out.println("Мой регион " + s + "\n");
        storage.put("Мой регион", s);
    }

    @И("нажата кнопка показать объявления")
    public static void clickShowAds() {
        System.out.println("Нажать кнопку показать объявления" + "\n");
    }

    @Тогда("открылась страница результаты по запросу {word}")
    public static void openPageOnRequest(String s) {
        System.out.println("Результат по запросу " + s + "\n");
        storage.put("Результат по запросу", s);
    }

    @И("активирован чекбокс только с фотографией")
    public static void activateCheckbox() {
        System.out.println("Активировать чекбокс только с фотографией" + "\n");
    }

    @И("в выпадающем списке сортировка выбрано значение {string}")
    public static void selectSort(String s) {
        System.out.println("Выбрана сортировка " + s + "\n");
        storage.put("Выбрана сортировка", s);
    }

    @И("^в консоль выведено значение названия и цены (\\d+) первых товаров$")
    public static void outputResultsInConsole(int num) {
        System.out.println("Количество выведенных товаров " + num + "\n");
        storage1.put("Количество выведенных товаров", num);
    }
}
