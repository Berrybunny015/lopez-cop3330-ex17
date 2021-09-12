/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution
 *  Copyright 2021 Sabrina Lopez
 */

package org.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //variable declarations
        double alcoholDistributionRatio_Men = 0.73; //the alcohol distribution rate for men
        double alcoholDistributionRatio_Women = 0.66; //the alcohol distribution rate for women
        double maxBAC = 0.08; //the maximum blood alcohol content the user can have to legally drive

        System.out.println("\nEnter 1 if you are male OR 2 if you are female: "); //ask the user's sex
        Scanner userSexInput = new Scanner(System.in); //scan for the user's sex
        while (!userSexInput.hasNextInt()) { //to check if the user is inputting a numeric value
            System.out.println("\nPlease input a numeric value, either 1 for male OR 2 for female.");
            userSexInput = new Scanner(System.in);
        }
        int userSex = userSexInput.nextInt();

        System.out.println("\nHow many ounces of alcohol did you have? "); //ask the user's alcohol intake
        Scanner userAlcoholIntakeInput = new Scanner(System.in); //scan for the user's alcohol intake
        while (!userAlcoholIntakeInput.hasNextInt()) { //to check if the user is inputting a numeric value
            System.out.println("\nPlease input a numeric value.");
            userAlcoholIntakeInput = new Scanner(System.in);
        }
        int userAlcoholIntake = userAlcoholIntakeInput.nextInt();

        System.out.println("\nWhat if your weight, in pounds (lbs)? "); //ask the user's weight
        Scanner userWeightInput = new Scanner(System.in); //scan for the user's weight
        while (!userWeightInput.hasNextInt()) { //to check if the user is inputting a numeric value
            System.out.println("\nPlease input a numeric value.");
            userWeightInput = new Scanner(System.in);
        }
        int userWeight = userWeightInput.nextInt();

        System.out.println("\nHow many hours has it been since your last drink? "); //ask when was the user's last drink
        Scanner userLastDrinkInput = new Scanner(System.in); //scan for when was the user's last drink
        while (!userLastDrinkInput.hasNextInt()) { //to check if the user is inputting a numeric value
            System.out.println("\nPlease input a numeric value.");
            userLastDrinkInput = new Scanner(System.in);
        }
        int userLastDrink = userLastDrinkInput.nextInt();

        //variable declaration
        double bloodAlcoholContent = 0;

        //calculate the blood alcohol content of the user
        if (userSex == 1) { //if the user is male
            bloodAlcoholContent = (userAlcoholIntake * 5.14 / userWeight * alcoholDistributionRatio_Men) - 0.015 * userLastDrink;
        }
        else if (userSex == 2) { //if the user is female
            bloodAlcoholContent = (userAlcoholIntake * 5.14 / userWeight * alcoholDistributionRatio_Women) - 0.015 * userLastDrink;
        }

        //determine and output if the user can or cannot legally drive due to their bloodAlcoholContent
        if (bloodAlcoholContent <= maxBAC) { //if the user has a low enough blood alcohol content to legally drive
            System.out.println("\nYour BAC is " + String.format("%.6f", bloodAlcoholContent) + "\nIt is legal for you to drive.");
        }
        else { //if the user has a high enough blood alcohol content to illegally drive
            System.out.println("\nYour BAC is " + String.format("%.6f", bloodAlcoholContent) + "\nIt is not legal for you to drive.");

        }
    }
}
