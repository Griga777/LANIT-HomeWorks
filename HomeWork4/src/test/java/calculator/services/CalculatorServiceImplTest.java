package calculator.services;

import org.junit.jupiter.api.DisplayName;
import org.mockito.InOrder;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.testng.Assert.assertThrows;

@DisplayName("Сервис CalculatorService должен ")
public class CalculatorServiceImplTest {

    private static final String FIRST_NUMBER = "63";
    private static final String SECOND_NUMBER = "7";
    private static final String OUTPUT_RESULT = "63,000000 + 7,000000 = 70,000000";
    private static final String OUTPUT_RESULT1 = "63,000000 - 7,000000 = 56,000000";
    private static final String OUTPUT_RESULT2 = "63,000000 * 7,000000 = 441,000000";
    private static final String OUTPUT_RESULT3 = "63,000000 / 7,000000 = 9,000000";

    private InOrder inOrder;
    private IOService ioService;
    private CalculatorService calculatorService;

    @BeforeMethod
    void setUp() {
        ioService = mock(IOService.class);
        calculatorService = new CalculatorServiceImpl(ioService);
        inOrder = inOrder(ioService);
    }

    @DataProvider
    public Object[][] testAdditionPositiveVerification() {
        return new Object[][] {
                {-1,-1,0},
                {1,0,1},
                {0,1,-1},
                {7.2,2.7,4.5},
                {-14.6,-9.2,-5.4},
                {-50,-26,-24},
                {46,22.9,23.1}
        };
    }

    @DisplayName("сложить два числа и вывести результат позитивной проверки ")
    @Test(dataProvider = "testAdditionPositiveVerification")
    void TwoNumbersAddAndOutputResultWithIOServicePositiveVerification(double one, double two, double three) {
        Assert.assertEquals(one, two + three);
    }

    @DataProvider
    public Object[][] testSubtractionPositiveVerification() {
        return new Object[][] {
                {0,-2,-2},
                {-1,2,3},
                {2,1,-1},
                {-2.3,2.7,5},
                {-3.5,-9,-5.5},
                {-2,-26,-24},
                {2,51,49}
        };
    }

    @DisplayName("вычесть два числа и вывести результат позитивной проверки ")
    @Test(dataProvider = "testSubtractionPositiveVerification")
    void TwoNumbersSubAndOutputResultWithIOServicePositiveVerification(double one, double two, double three) {
        Assert.assertEquals(one, two - three);
    }

    @DataProvider
    public Object[][] testMultiplicationPositiveVerification() {
        return new Object[][] {
                {770,50,15.4},
                {-54,3,-18},
                {8,4,2},
                {-2.4,-1.2,2},
                {220,-10,-22},
                {0,-1,0},
                {0,0,1}
        };
    }

    @DisplayName("умножить два числа и вывести результат позитивной проверки ")
    @Test(dataProvider = "testMultiplicationPositiveVerification")
    void TwoNumbersMultiplyAndOutputResultWithIOServicePositiveVerification(double one, double two, double three) {
        Assert.assertEquals(one, two * three);
    }

    @DataProvider
    public Object[][] testDivisionPositiveVerification() {
        return new Object[][] {
                {1,12,12},
                {-6,24,-4},
                {15,30,2},
                {-2.4,-4.8,2},
                {86.4,-1728,-20},
                {-1,-1,1},
                {0,0,1}
        };
    }

    @DisplayName("разделить два числа и вывести результат позитивной проверки ")
    @Test(dataProvider = "testDivisionPositiveVerification")
    void TwoNumbersDivAndOutputResultWithIOServicePositiveVerification(double one, double two, double three) {
        Assert.assertEquals(one, two / three);
    }

    @DataProvider
    public Object[][] testNegativeVerification() {
        return new Object[][] {
                {9.12,0,5},
                {96,10,32},
                {0.01,-111,35},
                {5,22.9,-4.3},
                {45.5,-9.2,-54.4},
                {89,2.9,-43},
                {-63.9,-9.05,-54.9}
        };
    }

    @DisplayName("сложить два числа и вывести результат негативной проверки ")
    @Test(dataProvider = "testNegativeVerification")
    void TwoNumbersAddAndOutputResultWithIOServiceNegativeVerification(double one, double two, double three) {
        Assert.assertNotEquals(one, two + three);
    }

    @DisplayName("вычесть два числа и вывести результат негативной проверки ")
    @Test(dataProvider = "testNegativeVerification")
    void TwoNumbersSubAndOutputResultWithIOServiceNegativeVerification(double one, double two, double three) {
        Assert.assertNotEquals(one, two - three);
    }

    @DisplayName("умножить два числа и вывести результат негативной проверки ")
    @Test(dataProvider = "testNegativeVerification")
    void TwoNumbersMultiplyAndOutputResultWithIOServiceNegativeVerification(double one, double two, double three) {
        Assert.assertNotEquals(one, two * three);
    }

    @DisplayName("разделить два числа и вывести результат негативной проверки ")
    @Test(dataProvider = "testNegativeVerification")
    void TwoNumbersDivAndOutputResultWithIOServiceNegativeVerification(double one, double two, double three) {
        Assert.assertNotEquals(one, two / three);
    }

    @DisplayName("прочитать два числа, сложить их и вывести результат ")
    @Test
    void shouldReadTwoNumbersAddAndOutputResultWithIOService() {
        given(ioService.readString()).willReturn(FIRST_NUMBER).willReturn(SECOND_NUMBER);
        calculatorService.twoNumbersAddition();
        inOrder.verify(ioService, times(2)).readString();
        inOrder.verify(ioService, times(1)).out(OUTPUT_RESULT);
    }

    @DisplayName("прочитать два числа, вычесть их и вывести результат ")
    @Test
    void shouldReadTwoNumbersSubAndOutputResultWithIOService() {
        given(ioService.readString()).willReturn(FIRST_NUMBER).willReturn(SECOND_NUMBER);
        calculatorService.twoNumbersSubtraction();
        inOrder.verify(ioService, times(2)).readString();
        inOrder.verify(ioService, times(1)).out(OUTPUT_RESULT1);
    }

    @DisplayName("прочитать два числа, умножить их и вывести результат ")
    @Test
    void shouldReadTwoNumbersMultiplyAndOutputResultWithIOService() {
        given(ioService.readString()).willReturn(FIRST_NUMBER).willReturn(SECOND_NUMBER);
        calculatorService.twoNumbersMultiplication();
        inOrder.verify(ioService, times(2)).readString();
        inOrder.verify(ioService, times(1)).out(OUTPUT_RESULT2);
    }

    @DisplayName("прочитать два числа, разделить их и вывести результат ")
    @Test
    void shouldReadTwoNumbersDivAndOutputResultWithIOService() {
        given(ioService.readString()).willReturn(FIRST_NUMBER).willReturn(SECOND_NUMBER);
        calculatorService.twoNumbersDivision();
        inOrder.verify(ioService, times(2)).readString();
        inOrder.verify(ioService, times(1)).out(OUTPUT_RESULT3);
    }

    @DisplayName("выкинуть NumberFormatException, если при сложении двух чисел ввели строку")
    @Test
    void shouldThrowNumberFormatExceptionWhenEnteredIsNotANumberAdd() {
        given(ioService.readString()).willReturn("").willReturn(SECOND_NUMBER);
        assertThrows(NumberFormatException.class, () -> calculatorService.twoNumbersAddition());
    }

    @DisplayName("выкинуть NumberFormatException, если при вычетании двух чисел ввели строку")
    @Test
    void shouldThrowNumberFormatExceptionWhenEnteredIsNotANumberSub() {
        given(ioService.readString()).willReturn("").willReturn(SECOND_NUMBER);
        assertThrows(NumberFormatException.class, () -> calculatorService.twoNumbersSubtraction());
    }

    @DisplayName("выкинуть NumberFormatException, если при умножении двух чисел ввели строку")
    @Test
    void shouldThrowNumberFormatExceptionWhenEnteredIsNotANumberMultiply() {
        given(ioService.readString()).willReturn("").willReturn(SECOND_NUMBER);
        assertThrows(NumberFormatException.class, () -> calculatorService.twoNumbersMultiplication());
    }

    @DisplayName("выкинуть NumberFormatException, если при делении двух чисел ввели строку")
    @Test
    void shouldThrowNumberFormatExceptionWhenEnteredIsNotANumberDiv() {
        given(ioService.readString()).willReturn("").willReturn(SECOND_NUMBER);
        assertThrows(NumberFormatException.class, () -> calculatorService.twoNumbersDivision());
    }

    @DisplayName("вывести на экран ответ на вопрос: в чём сила, брат? не менее, чем за 5 сек")
    @Test
    void shouldDisplayAnswerForMainQuestion() {
        assertTimeout(Duration.ofSeconds(6), () -> calculatorService.longCalculations());
    }
}