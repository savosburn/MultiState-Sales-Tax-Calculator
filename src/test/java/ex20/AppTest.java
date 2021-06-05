package ex20;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    public void output_string_includes_tax_and_total() {
        App myApp = new App();

        double tax = .05 * 10;
        double price = 10.0;
        String state = ("wisconsin");

        String expectedOutput = "The tax is $0.50.\n" +
                "The total is $10.50.";

        String actualOutput = myApp.generateOutput(tax, price, state);

        assertEquals(expectedOutput, actualOutput);
    }

}