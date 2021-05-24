import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.List;

public class FindSomethingOnAvito {

    static {
        System.setProperty("webdriver.chrome.driver", "E:\\ЛАНИТ\\Программы\\chromedriver_win32\\chromedriver.exe");
    }
    static WebDriver driver = new ChromeDriver();
    static WebElement params;

    public static void main(String[] args) {

        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        driver.get("https://www.avito.ru/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);

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

    private static void findCategory() {

        params = driver.findElement(By.cssSelector("#category"));
        params.click();

        Select select = new Select(driver.findElement(By.cssSelector("#category")));
        select.selectByVisibleText("Оргтехника и расходники");
    }

    private static void searchAd() {

        driver.findElement(By.cssSelector("#search")).sendKeys("Принтер");
        driver.findElement(By.cssSelector("#search")).sendKeys(Keys.ENTER);

        System.out.println("Принтер найден!");
    }

    private static void clickFieldCity() {

        params = driver.findElement(By.xpath("//div[@class='main-text-2PaZG']"));
        params.click();
    }

    private static void fieldCityVladivostok() {

        driver.findElement(By.xpath("//div[@class='main-text-2PaZG']")).click();
        driver.findElement(By.xpath("//input[@class='suggest-input-3p8yi']")).sendKeys("Владивосток");
        driver.findElement(By.xpath("//li[@data-marker='suggest(0)']")).click();

        WebElement button = driver.findElement(By.xpath("//button[@class='button-button-2Fo5k button-size-m-7jtw4 button-primary-1RhOG']"));
        button.click();

        System.out.println("Владивосток найден!");
    }

    private static void activateCheckbox() {

        Select select = new Select(driver.findElement(By.cssSelector("#category")));
        select.selectByVisibleText("Оргтехника и расходники");

        WebElement checkbox = driver.findElement(By.xpath("//span[@data-marker='delivery-filter/text']"));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }

        driver.findElement(By.xpath("//button[@data-marker='search-filters/submit-button']")).click();
    }

    private static void selectFilter() {

        Select select = new Select(driver.findElement(By.cssSelector("#category")));
        select.selectByVisibleText("Оргтехника и расходники");

        driver.findElement(By.xpath("//div[@class='sort-select-3QxXG select-select-box-3LBfK select-size-s-2gvAy']/select")).sendKeys("Дороже");
    }

    private static void mostPriceyPrinters() {

        driver.findElement(By.cssSelector("#search")).sendKeys("Принтер");
        driver.findElement(By.cssSelector("#search")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//li[@data-marker='category[1000047]']")).click();
        driver.findElement(By.xpath("//div[@class='sort-select-3QxXG select-select-box-3LBfK select-size-s-2gvAy']/select")).sendKeys("Дороже");

        List<WebElement> webElementList = driver.findElements(By.xpath("//div[@class='items-items-38oUm']//div[@data-marker='item']"));

        for (int i = 0; i < 3; i++) {
            System.out.println(webElementList.get(i).findElement(By.xpath(".//h3[@itemprop='name']")).getText());
            System.out.println(webElementList.get(i).findElement(By.xpath(".//span[@class='price-text-1HrJ_ text-text-1PdBw text-size-s-1PUdo']")).getText());
        }
    }
}
