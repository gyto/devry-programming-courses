package com.company;
import java.util.Scanner;

public class Practice2 {
    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args)
    {
        double costOfBuilding;
        double insuranceRecommendation;

        System.out.print("Cost of the building: ");
        if (userInput.hasNextDouble())
        {
            costOfBuilding = userInput.nextDouble();
            insuranceRecommendation = costOfBuilding * 80 / 100;
            System.out.println("Recommended cost of the insurances: " + insuranceRecommendation);
        }
    }
}
