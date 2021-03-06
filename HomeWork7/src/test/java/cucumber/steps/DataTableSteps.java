package cucumber.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.И;

import java.util.List;
import java.util.Map;

public class DataTableSteps {
    @И("выведем в консоль названия и цены товаров")
    public void avito(DataTable table) {

        List<Map<String, String>> dataTable = table.asMaps();
        dataTable.forEach(row -> {
            System.out.println("В поле поиска введено значение: " + row.get("Что ищем") + ", в поле регион введено значение: " + row.get("Город") + " и в консоль выведено значение названия и цены " + row.get("Количество выведенных товаров") + " первых товаров");
        });
    }
}

