package cucumber.steps;

import io.cucumber.java.Before;

public class hook {
    @Before
    public void before() {

        System.out.println("БУДЕТ ВЫПОЛНЯТЬСЯ ПЕРЕД КАЖДЫМ СЦЕНАРИЕМ!\n");
    }
}
