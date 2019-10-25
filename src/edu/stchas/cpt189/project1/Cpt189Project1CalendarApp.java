package edu.stchas.cpt189.project1;

import edu.stchas.cpt189.project1.printcalendar.PrintCalendar;
import edu.stchas.cpt189.project1.userinputdata.UserInputData;

public class Cpt189Project1CalendarApp {

    public static void main(String[] args) {
        // write your code here
        UserInputData userInput = new UserInputData(1,2016,"wed");
        PrintCalendar cal = new PrintCalendar(userInput,31);

        cal.printCalendar();
    }
}
