package edu.stchas.cpt189.project1.printcalendar;

import edu.stchas.cpt189.project1.userinputdata.UserInputData;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrintCalendar {
    private String monthStr;
    private Integer year;
    private Integer numDaysInMonth;
    private String firstDayOfMonth;

    private static Integer calendarCharWidth = 27;

    List<Integer> daysInMonth;

    /**
     * Map <Integer month number, String month name>
     */
    private static Map<Integer, String> monthMap = Stream.of(new Object[][]{
            {1, "January"},
            {2, "February"},
            {3, "March"},
            {4, "April"},
            {5, "May"},
            {6,"June"},
            {7, "July"},
            {8, "August"},
            {9, "September"},
            {10, "October"},
            {11, "November"},
            {12, "December"}
    }).collect(Collectors.toMap(data -> (Integer) data[0], data -> (String) data[1]));

    /**
     * List<String> that holds days of the week as 3 letter string values
     */
    private static List<String> weekdayList = new ArrayList<>(Arrays.asList(
            "Sun", "Mon","Tue","Wed","Thu","Fri","Sat"));

    /**
     * All arguments constructor
     * @param userInputData UserInputData object containing the input user data
     * @param numDaysInMonth Integer number of days in month
     *
     */
    public PrintCalendar(UserInputData userInputData, Integer numDaysInMonth){
        this.year = userInputData.getYear();
        this.numDaysInMonth = numDaysInMonth;
        this.monthStr = monthMap.get(userInputData.getMonth());
        this.firstDayOfMonth = userInputData.getFirstDayOfMonth().substring(0,1).toUpperCase() +
                            userInputData.getFirstDayOfMonth().substring(1).toLowerCase();

    }

    /**
     *
     * @param calendarCharWidth Integer for the character length of the calendar
     * @return String representation of Month Year centered; length = input calendarCharWidth
     *
     */
    private String createMonthHeader(Integer calendarCharWidth){
        /*
         * figure out padding totals & how much to pad on each sidek
         */
        int monthPadding = calendarCharWidth - monthStr.length() - 5;

        int paddingLeft = monthPadding / 2;
        int paddingRight = calendarCharWidth - monthStr.length()-5-paddingLeft;


        /*
         * pad left
         */
        String output = "";
        for (int i=0; i<paddingLeft; i++){
            output = output.concat(" ");
        }

        /*
         * add month & year to output string separated by a space
         */
        output = output + monthStr + " " + year.toString();

        /*
         * pad right
         */
        for (int j=0; j<paddingRight; j++){
            output = output.concat(" ");
        }

        return output;
    }

    /**
     *
     * @param calendarCharWidth Integer character length of calendar
     * @return String weekday header
     */
    private String createWeekdayHeader(Integer calendarCharWidth){
        String output = "";
        Integer weekdayCharCount = 0;

        /*
         * Determine how many characters are taken up by weekday string
         */
        for(String item: weekdayList){
            weekdayCharCount = weekdayCharCount + item.length();
        }
        /*
         * determine how much padding is needed.
         *
         */
        Integer totalPaddingNeeded = calendarCharWidth - weekdayCharCount;

        for (int i=0; i<weekdayList.size()-1; i++){
            output = output.concat(weekdayList.get(i));

            /*
             * Space between start of next day description
             */
            output = output.concat(getRightPaddingBetweenDays());
        }
        /*
         * add last week day
         */
        output = output.concat(weekdayList.get(weekdayList.size()-1));

        /*
         * pad end
         */
        while (output.length() < calendarCharWidth){
                output = output.concat(" ");
        }

        return output;
    }

    private String getRightPaddingBetweenDays(){
        String output = "";
        Integer weekdayCharCount = 0;

        for(String weekday : weekdayList){
            weekdayCharCount = weekdayCharCount + weekday.length();
        }


        int totalPaddingNeeded = calendarCharWidth - weekdayCharCount;
            /*
             * Space between start of next day description = totalPaddingNeeded/ # of week days - 1
             */
            for (int j = 0; j < totalPaddingNeeded/(weekdayList.size()-1); j++) {
                output = output.concat(" ");
            }
            return output;
        }



    private List<Integer> getDaysList(){
        List<Integer> dayList = new ArrayList<>(Arrays.asList());

        for (int i=0; i<numDaysInMonth; i++){
            dayList.add(i+1);
        }
        return dayList;
    }


    /**
     * Formats the days of the month into the Sun-Sat format
     * shwoing black spaces on weekdays before the first
     * and weekdays after the last day of month
     *
     * @return String month dates in weekly format
     */
    private String printRows(){
        List<String> strDayList = new ArrayList<>(Arrays.asList());
        List<Integer> daysList = getDaysList();
        String leftPadding;
        String rightPadding = getRightPaddingBetweenDays();
        int startIndex = 0;
        int endIndex = 6;
        List<String> outputRows = new ArrayList<>(Arrays.asList());
        String output = "";

        /*
         * pad the beginning of the days list with 0s to represent
         * weekdays before the first
         */
        for (int i=0; i<weekdayList.indexOf(firstDayOfMonth); i++){
            daysList.add(0,0);
        }

        /*
         * pad the end of the days list with 0s to represent weekdays
         * after the last day of the month
         */
        while (daysList.size()%7 != 0){
            daysList.add(0);
        }

        /*
         * Populate strDays list by
         * padding left + item in days list + pad right
         * for each item in days list
         */
        for (int day: daysList){
            /*
             * Determine left padding;
             *  3 spaces if item in days list = 0
             *  2 spaces if item in days lis <10
             *  1 space if item in days list >= 10;
             */
            if (day == 0){
                leftPadding = "   ";
                strDayList.add(leftPadding + rightPadding);
            } else if (day < 10){
                leftPadding = "  ";
                strDayList.add(leftPadding + day + getRightPaddingBetweenDays());
            } else{
                leftPadding = " ";
                strDayList.add(leftPadding + day + getRightPaddingBetweenDays());
            }
        }

        /*
         * create a string that represents each row;
         */

        for(int i = 0; i<strDayList.size(); i++){
            String row = "";

            for(i = startIndex; i <= endIndex; i++){
                row = row.concat(strDayList.get(i));
            }
            /*
             * make sure final row length = calendarCharWidth
             * by padding right additional spaces if row length < calendarCharWidth
             * & by only returning the substring that is = calenderCharWidth if row length > calendarCharWidth
             */
            while (row.length() != calendarCharWidth){
                if (row.length() < calendarCharWidth){
                    row =row.concat(" ");
                } else{
                    row = row.substring(0,calendarCharWidth);
                }
            }

            /*
             * add individual row to output rows
             */
            outputRows.add(row);

            /*
             * update start & end indexes for the next row's selection
             */
            startIndex = startIndex + 7;
            endIndex = endIndex + 7;

        }
        /*
         * add each date row to output string followed by a new line
         */
        for(String row: outputRows){
            output = output.concat(row + "\n");

        }

        return output;
    }


    /**
     * prints calendar to console
     *
     * @return String representation of the calendar
     */
    public String printCalendar(){
        String output = createMonthHeader(PrintCalendar.calendarCharWidth);
        output = output.concat("\n" + createWeekdayHeader(calendarCharWidth));
        output = output.concat("\n" + printRows());

        System.out.print(output);

        return output;




    }
}
