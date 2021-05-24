package calculator.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

@Execution(ExecutionMode.CONCURRENT)
@DisplayName("OpenedConsoleIOService ")
public class OpenedConsoleIOServiceTest {

    private static final String EOL = System.lineSeparator();
    private static final String TEXT_TO_PRINT1 = "Ничто не истинно";
    private static final String TEXT_TO_PRINT2 = "Все дозволено";
    private ByteArrayOutputStream bos;
    private ConsoleContext consoleContext;
    private IOService ioService;

    @BeforeMethod
    void setUp() {
        System.out.println(Thread.currentThread().getName());

        bos = new ByteArrayOutputStream();
        consoleContext = new ConsoleContext(new PrintStream(bos), System.in);
        ioService = new OpenedConsoleIOService(consoleContext);
    }

    @Test
    void testOut() throws InterruptedException {
        ioService.out(TEXT_TO_PRINT1);
        Thread.sleep(5000);
        assertThat(bos.toString()).isEqualTo(TEXT_TO_PRINT1 + EOL);
    }

    @Test
    void testReadString() throws InterruptedException {
        ioService.out(TEXT_TO_PRINT2);
        Thread.sleep(5000);
        assertThat(bos.toString()).isEqualTo(TEXT_TO_PRINT2 + EOL);
    }
}