package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class ApiHooks {

    @Before
    public void setup(Scenario scenario) {
        // Выполняется перед КАЖДЫМ сценарием
        System.out.println("Starting scenario: " + scenario.getName());
    }
}
