package edu.stchas.cpt189.project1;

import java.util.Calendar;

import edu.stchas.cpt189.project1.printcalendar.PrintCalendar;
import edu.stchas.cpt189.project1.userinputdata.UserInputData;

public class Cpt189Project1CalendarApp {

    public static void main(String[] args) {
        // write your code here
    	UserInputData inputdata = new UserInputData(2, 2000, "Mon");
    	

    	PrintCalendar calender = new PrintCalendar(inputdata);
    
    	calender.printCalendar();
    	}
}