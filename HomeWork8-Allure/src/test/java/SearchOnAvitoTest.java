import io.qameta.allure.Attachment;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class SearchOnAvitoTest {

    private FindSomethingOnAvito tests;

    @Test
    public void searchOnAvitoTest() throws Exception {

        tests.findCategory();
        tests.makeScreenShot1();
        tests.searchAd();
        tests.makeScreenShot2();
        tests.clickFieldCity();
        tests.makeScreenShot3();
        tests.fieldCityVladivostok();
        tests.makeScreenShot4();
        tests.activateCheckbox();
        tests.makeScreenShot5();
        tests.selectFilter();
        tests.makeScreenShot6();
        tests.mostPriceyPrinters();
        tests.makeScreenShot7();
        tests.makeAshotScreenShot();
        tests.quit();

    }
}









