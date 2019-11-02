package edu.stchas.cpt189.project1;

import edu.stchas.cpt189.project1.getuserinput.GetUserInput;
import edu.stchas.cpt189.project1.printcalendar.PrintCalendar;
import edu.stchas.cpt189.project1.userinputdata.UserInputData;

/**
 * CPT 189 Java
 * Team project #1 - Print Calendar
 * Rebecca Fleak
 * Laura Martin
 * Tyler Scott
 *
 * Program asks user for month, year, and day the first of the month falls on
 * Program calculates days in the month;
 * Program prints out monthly calendar based on the requested inputs;
 */
public class Cpt189Project1CalendarApp {

    public static void main(String[] args) {
        // get & store user input
        GetUserInput getInput = new GetUserInput();
        UserInputData userInputData = getInput.getUserInput();
        // print calendar
        PrintCalendar printCalendar = new PrintCalendar(userInputData);
        printCalendar.printCalendar();


    }
}