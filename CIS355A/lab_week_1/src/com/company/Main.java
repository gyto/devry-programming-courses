/*
 Program Name: HealthProfile.java
 Programmer's Name: Roman Kovtun
 Program Description: Calculate BMI and Heart Rate
 */

package com.company;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {

    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {

        // set the exit point
        boolean exit = true;

        // create a loop
        do {
            // declare variables
            String yourName;
            int yourAge;
            int yourWeight;
            int yourHeightFeet;
            int yourHeightInc;

            // ask name or wait for a call to exit
            System.out.print("Enter name or X to exit: ");
            yourName = userInput.nextLine();

            // check if user want to exit console
            if (!yourName.equals("X"))
            {
                // ask for your age
                System.out.print("Your age: ");
                yourAge = userInput.nextInt();

                // ask for your weight
                System.out.print("Your Weight: ");
                yourWeight = userInput.nextInt();

                // ask for your height
                System.out.print("Your height - feet: ");
                yourHeightFeet = userInput.nextInt();
                System.out.print("Your height - inches: ");
                yourHeightInc = userInput.nextInt();

                // create an object of the Health Profile and set the variables to it
                HealthProfile healthProfile = new HealthProfile();
                healthProfile.setName(yourName);
                healthProfile.setAge(yourAge);
                healthProfile.setWeight(yourWeight);
                healthProfile.setHeight(yourHeightFeet, yourHeightInc);

                // set the decimal format
                DecimalFormat df = new DecimalFormat("0.0");

                // give a BMI results
                System.out.println("\nHealth Profile for " + healthProfile.getName());
                System.out.println("BMI: " + df.format(healthProfile.getBMI()));
                System.out.println("BMI Category: " + healthProfile.getCategory());
                System.out.println("Max heart rate: " + healthProfile.getMaxHR() + "\n");

                // continue the loop
                userInput.nextLine();
            }
            else {
                // if user type X then exit the loop
                exit = false;
            }
        } while (exit);
    }
}
