package calculator.services;

public class CalculatorServiceImpl implements CalculatorService {
    private final IOService ioService;

    public CalculatorServiceImpl(IOService ioService) {
        this.ioService = ioService;
    }

    @Override
    public void twoNumbersAddition() {
        double num1 = Double.parseDouble(ioService.readString());
        double num2 = Double.parseDouble(ioService.readString());
        addAndOutResult(num1, num2);
    }

    @Override
    public void twoNumbersAddition(String prompt) {
        ioService.out(prompt);
        twoNumbersAddition();
    }

    @Override
    public void twoNumbersSubtraction() {
        double num1 = Double.parseDouble(ioService.readString());
        double num2 = Double.parseDouble(ioService.readString());
        subtractAndOutResult(num1, num2);
    }

    @Override
    public void twoNumbersSubtraction(String prompt) {
        ioService.out(prompt);
        twoNumbersSubtraction();
    }

    @Override
    public void twoNumbersMultiplication() {
        double num1 = Double.parseDouble(ioService.readString());
        double num2 = Double.parseDouble(ioService.readString());
        multiplyAndOutResult(num1, num2);
    }

    @Override
    public void twoNumbersMultiplication(String prompt) {
        ioService.out(prompt);
        twoNumbersMultiplication();
    }

    @Override
    public void twoNumbersDivision() {
        double num1 = Double.parseDouble(ioService.readString());
        double num2 = Double.parseDouble(ioService.readString());
        divideAndOutResult(num1, num2);
    }

    @Override
    public void twoNumbersDivision(String prompt) {
        ioService.out(prompt);
        twoNumbersDivision();
    }

    @Override
    public void longCalculations() {
        ioService.out("Ответ на главный вопрос жизни, вселенной и всего такого");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ioService.out("<<42>>");
    }

    private void addAndOutResult(double num1, double num2) {
        ioService.out(String.format("%f + %f = %f", num1, num2, num1 + num2));
    }

    private void subtractAndOutResult(double num1, double num2) {
        ioService.out(String.format("%f - %f = %f", num1, num2, num1 - num2));
    }

    private void multiplyAndOutResult(double num1, double num2) {
        ioService.out(String.format("%f * %f = %f", num1, num2, num1 * num2));
    }

    private void divideAndOutResult(double num1, double num2) {
        ioService.out(String.format("%f / %f = %f", num1, num2, num1 / num2));
    }
}
