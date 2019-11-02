package edu.stchas.cpt189.project1.userinputdata;

public class UserInputData {
    private Integer month; // Integer representation of user input month
    private Integer year; // Integer representation of user input year
    private String firstDayOfMonth; //String representation of weekday the first day of the month falls on

    /**
     * All arguments constructor
     * @param month Integer representation of user input month
     * @param year Integer representation of user input year
     * @param firstDayOfMonth String representation of weekday the first day of the month falls on
     */
    public UserInputData(Integer month, Integer year, String firstDayOfMonth){
        this.month = month;
        this.year = year;
        this.firstDayOfMonth = firstDayOfMonth;

    }

    protected UserInputData(){

    }

    // Create getters & setters

    public String getFirstDayOfMonth() {
        return firstDayOfMonth;
    }

    public void setFirstDayOfMonth(String newFirstDayOfMonth) {
        firstDayOfMonth = newFirstDayOfMonth;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer newYear) {
        year = newYear;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer newMonth) {
        month = newMonth;
    }
}
