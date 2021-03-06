package edu.stchas.cpt189.project1.getuserinput;


import edu.stchas.cpt189.project1.userinputdata.UserInputData;

import java.util.Scanner;

public class GetUserInput {

    public UserInputData getUserInput() {

        Scanner scanner = new Scanner(System.in);


        // read keyboard entries and assign to variables
        System.out.print("Please enter a year.  It must be four digits, and between 1980 and 2019, inclusive: ");
        Integer year = scanner.nextInt();

        System.out.print("Please enter a month. It must be one or two digits, such as \"5\" means May or \"11\" means November: ");
        Integer month = scanner.nextInt();

        System.out.println("Please enter what day-of-week is the first day of that year that month. ");
        System.out.print("Enter 3 characters to represent a day of week, such as \"Mon\" means Monday and \"Thu\" means Thursday: ");
        String day = scanner.next();

        scanner.close();

        return new UserInputData(month,year, day);
    }

}


