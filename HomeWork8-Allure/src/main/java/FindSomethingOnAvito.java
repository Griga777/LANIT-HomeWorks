import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class FindSomethingOnAvito {

    static {
        System.setProperty("webdriver.chrome.driver", "E:\\ЛАНИТ\\Программы\\chromedriver_win32\\chromedriver.exe");
    }
    static WebDriver driver = new ChromeDriver();
    static WebElement params;

    public static void main(String[] args) {

        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        findCategory();
        searchAd();
        clickFieldCity();
        fieldCityVladivostok();
        activateCheckbox();
        selectFilter();
        mostPriceyPrinters();

        try {
            Thread.sleep(7_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }

    @Step("Выбрать категорию")
    protected static void findCategory() {

        driver.get("https://www.avito.ru/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);

        params = driver.findElement(By.cssSelector("#category"));
        params.click();

        Select select = new Select(driver.findElement(By.cssSelector("#category")));
        select.selectByVisibleText("Оргтехника и расходники");
    }

    @Attachment
    @Step("Сделать скриншот выбора категории")
    protected static byte[] makeScreenShot1() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Step("В поле поиск по объявлению ввести значение “Принтер”")
    protected static void searchAd() {

        driver.findElement(By.xpath("//input[@data-marker='search-form/suggest']")).sendKeys("Принтер");
        driver.findElement(By.xpath("//input[@data-marker='search-form/suggest']")).sendKeys(Keys.ENTER);

        System.out.println("Принтер найден!");
    }

    @Attachment
    @Step("Сделать скриншот поля поиск по объявлению")
    protected static byte[] makeScreenShot2() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Step("Нажать на поле город")
    protected static void clickFieldCity() {

        params = driver.findElement(By.xpath("//div[@class='main-text-2PaZG']"));
        params.click();
    }

    @Attachment
    @Step("Сделать скриншот поля город")
    protected static byte[] makeScreenShot3() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Step("Заполнить значением “Владивосток” поле город")
    protected static void fieldCityVladivostok() {

        WebDriverWait wait = new WebDriverWait(driver, 25);
        params = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='suggest-input-3p8yi']")));
        params.sendKeys("Владивосток");

        wait.until(p -> driver.findElement(By.xpath("//li[@data-marker='suggest(0)']")).getText().contains("Владивосток"));
        params.click();

        WebElement button = driver.findElement(By.xpath("//button[@class='button-button-2Fo5k button-size-m-7jtw4 button-primary-1RhOG']"));
        button.click();

        System.out.println("Владивосток найден!");
    }

    @Attachment
    @Step("Сделать скриншот поля город со значением “Владивосток”")
    protected static byte[] makeScreenShot4() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Step("Активировать чекбокс “С Авито доставкой”")
    protected static void activateCheckbox() {

        WebElement checkbox = driver.findElement(By.xpath("//label[@data-marker='delivery-filter']"));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }

        driver.findElement(By.xpath("//button[@data-marker='search-filters/submit-button']")).click();
    }

    @Attachment
    @Step("Сделать скриншот активированного чекбокса “С Авито доставкой”")
    protected static byte[] makeScreenShot5() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Step("Выбрать фильтрацию по убыванию цены")
    protected static void selectFilter() {

        driver.findElement(By.xpath("//div[@class='sort-select-3QxXG select-select-box-3LBfK select-size-s-2gvAy']/select")).sendKeys("Дороже");
    }

    @Attachment
    @Step("Сделать скриншот фильтрации по убыванию цены")
    protected static byte[] makeScreenShot6() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Step("Вывести в консоль название и стоимость 3х самых дорогих принтеров")
    protected static void mostPriceyPrinters() {

        List<WebElement> webElementList = driver.findElements(By.xpath("//div[@class='items-items-38oUm']//div[@data-marker='item']"));

        for (int i = 0; i < 3; i++) {
            System.out.println(webElementList.get(i).findElement(By.xpath(".//h3[@itemprop='name']")).getText());
            System.out.println(webElementList.get(i).findElement(By.xpath(".//span[@class='price-text-1HrJ_ text-text-1PdBw text-size-s-1PUdo']")).getText());
        }
    }

    @Attachment
    @Step("Сделать скриншот страницы результатов")
    protected static byte[] makeScreenShot7() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment
    @Step("Сделать скриншот элемента на странице")
    protected static byte[] makeAshotScreenShot() {

        WebElement element = driver.findElement(By.xpath("//input[@data-marker='search-form/suggest']"));

        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver, element);

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try {
            ImageIO.write(screenshot.getImage(), "PNG", buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toByteArray();
    }

    @Step("Закрыть страницу браузера")
    protected static void quit() {
        driver.quit();
    }
}
