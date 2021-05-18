package calculator.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

@Execution(ExecutionMode.CONCURRENT)
@DisplayName("ClosedConsoleIOService")
public class ClosedConsoleIOServiceTest {

    private static final String EOL = System.lineSeparator();
    private static final String TEXT_TO_PRINT1 = "Ничто не истинно";
    private static final String TEXT_TO_PRINT2 = "Все дозволено";

    private PrintStream backup;
    private ByteArrayOutputStream bos;
    private IOService ioService;

    @BeforeMethod
    void setUp() {
        System.out.println(Thread.currentThread().getName());

        backup = System.out;
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
        ioService = new ClosedConsoleIOService();
    }

    @AfterMethod
    void tearDown() {
        System.setOut(backup);
    }

    @Test
    void testOut() throws InterruptedException {
        ioService.out(TEXT_TO_PRINT1);
        Thread.sleep(1000);
        assertThat(bos.toString()).isEqualTo(TEXT_TO_PRINT1 + EOL);
    }

    @Test
    void testReadString() {
        ioService.out(TEXT_TO_PRINT2);
        assertThat(bos.toString()).isEqualTo(TEXT_TO_PRINT2 + EOL);
    }
}