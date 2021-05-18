package calculator;

import calculator.services.*;

public class Main {

    public static void main(String[] args) {
        IOService closedConsoleIOService = new ClosedConsoleIOService();
        IOService openedConsoleIOService = new OpenedConsoleIOService(new ConsoleContext());

        closedConsoleIOService.out("BEGIN");

        CalculatorService calculatorService = new CalculatorServiceImpl(openedConsoleIOService);
        calculatorService.twoNumbersAddition("Введите два числа и я их сложу");
        calculatorService.twoNumbersSubtraction("Введите ещё два числа и я их вычту");
        calculatorService.twoNumbersMultiplication("Введите ещё два числа и я их умножу");
        calculatorService.twoNumbersDivision("Введите ещё два числа и я их разделю");

        openedConsoleIOService.out("THE END");
    }
}
