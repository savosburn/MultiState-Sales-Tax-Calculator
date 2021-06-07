/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Savannah Osburn
 */

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
        String county = "Dunn";

        String expectedOutput = "The tax is $0.50.\n" +
                "The total is $10.50.";

        String actualOutput = myApp.generateOutput(tax, price, state);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void output_wisconsin() {
        App myApp = new App();


        double price = 10.0;
        String state = ("wisconsin");
        String county = "dane";
        double tax = myApp.calculateTax(county, state, price);

        String expectedOutput = "The tax is $0.50.\n" +
                "The total is $10.50.";

        String actualOutput = myApp.generateOutput(tax, price, state);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void output_wisconsin_eau_claire() {
        App myApp = new App();

        double price = 10.0;
        String state = ("wisconsin");
        String county = "eau claire";
        double tax = myApp.calculateTax(county, state, price);

        String expectedOutput = "The tax is $0.55.\n" +
                "The total is $10.55.";

        String actualOutput = myApp.generateOutput(tax, price, state);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void output_wisconsin_dunn() {
        App myApp = new App();

        double price = 10.0;
        String state = ("wisconsin");
        String county = "dunn";
        double tax = myApp.calculateTax(county, state, price);

        String expectedOutput = "The tax is $0.54.\n" +
                "The total is $10.54.";

        String actualOutput = myApp.generateOutput(tax, price, state);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void output_illinois() {
        App myApp = new App();

        double price = 10.0;
        String state = ("illinois");
        String county = null;
        double tax = myApp.calculateTax(null, state, price);

        String expectedOutput = "The tax is $0.80.\n" +
                "The total is $10.80.";

        String actualOutput = myApp.generateOutput(tax, price, state);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void output_all_other_cases() {
        App myApp = new App();

        double price = 10.0;
        String state = ("florida");
        String county = "null";
        double tax = myApp.calculateTax(null, state, price);

        String expectedOutput = "The total is $10.00.";

        String actualOutput = myApp.generateOutput(tax, price, state);

        assertEquals(expectedOutput, actualOutput);
    }
}