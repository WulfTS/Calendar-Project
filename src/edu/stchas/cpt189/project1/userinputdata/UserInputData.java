package edu.stchas.cpt189.project1.userinputdata;

public class UserInputData {
    private Integer month; // Integer representation of user input month
    private Integer year; // Integer representation of user input year
    private String firstDayOfMonth; //String representation of weekday the first day of the month falls on
    private Integer daysInMonth;
	/**
	 * All arguments constructor
	 *
	 * @param month           Integer representation of user input month
	 * @param year            Integer representation of user input year
	 * @param firstDayOfMonth String representation of weekday the first day of the
	 *                        month falls on
	 */
	public UserInputData(Integer month, Integer year, String firstDayOfMonth) {
		this.month = month;
		this.year = year;
		this.firstDayOfMonth = firstDayOfMonth;
		determineNumDaysInMonth();

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
	public Integer getDaysInMonth() {
		return daysInMonth;
	}

	public void setDaysInMonth(Integer newDaysInMonth) {
		daysInMonth = newDaysInMonth;
	}

	private void determineNumDaysInMonth() {
		switch (month) {
		case 4:
		case 6:
		case 9:
		case 11:
			daysInMonth = 30;
			break;
		case 2:
			if (year % 4 != 0) {
				daysInMonth = 28;
			} else if (year % 100 != 0) {
				daysInMonth = 29;
			} else if (year % 400 != 0) {
				daysInMonth = 28;
			} else {
				daysInMonth = 29;
			}
			break;
		default:
			daysInMonth = 31;
		}
	}
}
