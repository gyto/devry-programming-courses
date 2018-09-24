package com.company;
import java.util.Scanner;

public class Practice1 {
    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        double miles;
        double kilometers;

        System.out.print("Enter distance in kilometers: ");

        if (userInput.hasNextDouble())
        {
            kilometers = userInput.nextDouble();
            miles = kilometers * 0.6214;
            System.out.println("The distance in miles is: " + miles);
        }
    }
}
