package cucumber.steps;

import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Steps {
    static {
        System.setProperty("webdriver.chrome.driver", "E:\\ЛАНИТ\\Программы\\chromedriver_win32\\chromedriver.exe");
    }
    static WebDriver driver = new ChromeDriver();
    static WebElement params;

    @Пусть("открыт ресурс авито")
    public static void openResource() {

        driver.get("https://www.avito.ru/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);

        System.out.println("Открыт ресурс авито" + "\n");
    }

    @И("в выпадающем списке категорий выбрана {categories}")
    public static void findCategory(Categories category) {

        params = driver.findElement(By.cssSelector("#category"));
        params.click();

        Select select = new Select(driver.findElement(By.cssSelector("#category")));
        select.selectByVisibleText(category.value);

        System.out.println("Выбрана категория: " + category.value + "\n");
    }

    @И("^в поле поиска введено значение (.*)$")
    public static void searchAd(String str) {

        driver.findElement(By.xpath("//input[@data-marker='search-form/suggest']")).sendKeys(str);
        driver.findElement(By.xpath("//input[@data-marker='search-form/suggest']")).sendKeys(Keys.ENTER);

        System.out.println(str + " найден!" + "\n");
    }

    @Тогда("кликнуть по выпадающему списку региона")
    public static void clickFieldCity() {

        params = driver.findElement(By.xpath("//div[@class='main-text-2PaZG']"));
        params.click();

        System.out.println("Кликнуть по выпадающему списку региона" + "\n");
    }

    @Тогда("в поле регион введено значение {word}")
    public static void fieldCityVladivostok(String str) {

        WebDriverWait wait = new WebDriverWait(driver, 25);
        params = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='suggest-input-3p8yi']")));
        params.sendKeys(str);

        driver.findElement(By.xpath("//ul[@class='suggest-suggests-bMAdj']//li[@data-marker='suggest(0)']")).click();

        System.out.println(str + " найден!" + "\n");
    }

    @И("нажата кнопка показать объявления")
    public static void ClickButtonShowAds() {

        driver.manage().timeouts().implicitlyWait(10, SECONDS);

        WebElement button = driver.findElement(By.xpath("//button[@class='button-button-2Fo5k button-size-m-7jtw4 button-primary-1RhOG']"));
        button.click();

        System.out.println("Нажата кнопка показать объявления" + "\n");
    }

    @Тогда("^открылась страница результаты по запросу (.*)$")
    public static void openPageOnRequest(String str) {

        System.out.println("Открылась страница результаты по запросу " + str + "\n");
    }

    @И("активирован чекбокс только с фотографией")
    public static void activateCheckbox() {

        WebElement checkbox = driver.findElement(By.xpath("//label[@data-marker='delivery-filter']"));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
        driver.findElement(By.xpath("//button[@data-marker='search-filters/submit-button']")).click();

        System.out.println("Активирован чекбокс только с фотографией" + "\n");
    }

    @И("в выпадающем списке сортировка выбрано значение {sorting}")
    public static void selectFilter(Sorting sort) {

        driver.findElement(By.xpath("//div[@class='sort-select-3QxXG select-select-box-3LBfK select-size-s-2gvAy']/select")).sendKeys(sort.value);

        System.out.println("Выбрана сортировка: " + sort.value + "\n");
    }

    @И("^в консоль выведено значение названия и цены (\\d+) первых товаров$")
    public static void mostPriceyPrinters(int num) {

        List<WebElement> webElementList = driver.findElements(By.xpath("//div[@class='items-items-38oUm']//div[@data-marker='item']"));

        for (int i = 0; i < num; i++) {
            System.out.println(webElementList.get(i).findElement(By.xpath(".//h3[@itemprop='name']")).getText());
            System.out.println(webElementList.get(i).findElement(By.xpath(".//span[@class='price-text-1HrJ_ text-text-1PdBw text-size-s-1PUdo']")).getText());
            }
    }
}
