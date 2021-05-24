package calculator.services;

import java.io.PrintStream;
import java.util.Scanner;

public class ClosedConsoleIOService implements IOService {
    private final PrintStream out;
    private final Scanner sc;

    public ClosedConsoleIOService() {
        this.out = System.out;
        this.sc = new Scanner(System.in);
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
