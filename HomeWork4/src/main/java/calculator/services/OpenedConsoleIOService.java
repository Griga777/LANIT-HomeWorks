package calculator.services;

import java.io.PrintStream;
import java.util.Scanner;

public class OpenedConsoleIOService implements IOService {
    private final PrintStream out;
    private final Scanner sc;

    public OpenedConsoleIOService(ConsoleContext cc) {
        this.out = cc.getOut();
        this.sc = new Scanner(cc.getIn());
    }

    @Override
    public void out(String prompt) {
        out.println(prompt);
    }

    @Override
    public String readString() {
        return sc.nextLine();
    }
}
