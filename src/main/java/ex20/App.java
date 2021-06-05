/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Savannah Osburn
 */

package ex20;

import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);

    public static double WI_TAX = 0.05;
    public static double EAU_CLAIRE = 0.005;
    public static double DUNN = 0.004;
    public static double IL_TAX = 0.08;

    public static void main(String[] args) {
        App myApp = new App();

        // Input
        double orderAmount = Double.parseDouble(myApp.readOrderAmount());
        String state = myApp.readState();

        // Prompt for county only if resident lives in Wisconsin
        String county = null;
        if (state.equals("wisconsin") || state.equals("wi")) {
            county = myApp.readCounty();
        }

        // Calculations
        double tax = myApp.calculateTax(county, state, orderAmount);

        // Output
        String outputString = myApp.generateOutput(tax, orderAmount, state);
        myApp.output(outputString);
    }

    public String readOrderAmount() {
        System.out.print("What is the order amount? ");
        return in.nextLine();
    }

    public String readState() {
        System.out.print("What state do you live in? ");
        return in.nextLine().toLowerCase();
    }


    public String readCounty() {
        System.out.print("What county do you live in? ");
        return in.nextLine().toLowerCase();
    }

    public double calculateTax(String county, String state, double price) {
        double tax = 0;

        if (state.equals("illinois") || state.equals("il")) {
            tax = IL_TAX;
        } else if (state.equals("wisconsin") || state.equals("wi")){
            if (county.equals("eau claire")) {
                tax = WI_TAX + EAU_CLAIRE;
            } else if (county.equals("dunn")) {
                tax = WI_TAX + DUNN;
            } else {
                tax = WI_TAX;
            }
        }

        return tax * price;
    }

    public String generateOutput(double tax, double orderAmount, String state) {
        return (state.equals("wi") || state.equals("il") || state.equals("wisconsin") || state.equals("illinois")) ?
                String.format("The tax is $%.2f.\nThe total is $%.2f.", tax, orderAmount + tax) :
                String.format("The total is $%.2f.", orderAmount + tax);

    }

    public void output (String output) {
        System.out.print(output);
    }
}
