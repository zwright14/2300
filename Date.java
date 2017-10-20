/**
 * A class for producing simple dates.
 * @author Zach Wright
 */
public class Date implements Comparable<Date> {

	private int day;
	private int month;
	private int year;
	private int dateInt;
	public static int[] daysOfTheMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	/**
	 * Constructs a Date object from a given day, month, and year. Checks to see whether the 
	 * input parameters are a valid date, and calculates a dateInt value relative to the
	 * Gregorian calendar starting date 01/11/0001.
	 * @param d the day of the given date
	 * @param m the month of the given date
	 * @param y the year of the given date
	 */
	public Date(int d, int m, int y) {
		if (!Date.isValidDate(d, m, y)) {
			throw new IllegalArgumentException("Invalid Date was Used");
		}
		day = d;
		month = m;
		year = y;
		dateInt = Date.toInt(d, m, y);
		
	}

	public int getDay() {
		return day;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}
	
	public int getDateInt() {
		return dateInt;
	}
	
	/**
	 * Checks to see if a given year is a leap year. 
	 * @param y the year being checked.
	 * @return a boolean that represents if the year is a leap year.
	 */
	public static boolean isLeapYear(int y) {
		if (y%4==0) {
			if (y%100==0) {
				if (y%400==0) {
					return true;
				}
				else {
					return false;
				}
			}
			else { 
				return true;
			}
		}
		else {
			return false;
		}
	}
	
	/**
	 * Checks to see if a given day, month, and year can form a valid date.
	 * @param d the day of the date.
	 * @param m the month of the date.
	 * @param y the year of the date.
	 * @return a boolean that represents if the parameters form a valid date.
	 */
	public static boolean isValidDate(int d, int m, int y) {
		if (y>=1) {
			if (m>=1 && m<=12) {
				if (Date.isLeapYear(y) && m==2 && d==29) {
					return true;
				}
				else if (d>=1 && d<=daysOfTheMonth[m-1]) {
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}

	/**
	 * Converts a day, month, and year into a single integer that represents 
	 * the day relative to the Gregorian calendar starting date 01/01/0001.
	 * @param d the day of the date.
	 * @param m the month of the date.
	 * @param y the year of the date.
	 * @return an integer that represents the specific date in the Gregorian calendar
	 */
	public static int toInt(int d, int m, int y) {
		int count = 1;
		int totalDays = 0;
		while (count<y) {
			if (Date.isLeapYear(count)) {
				totalDays += 366;
			}
			else {
				totalDays += 365;
			}
			count++;
		}
		
		for (int i=1; i<m; i++) {
			totalDays += daysOfTheMonth[i-1];
		}
		
		totalDays += d;
				
		if (Date.isLeapYear(y) && m>2) {
			totalDays++;
		}
		
		return totalDays;
	}
	
	/**
	 * Calculates a date based off the given integer value in the Gregorian calendar.
	 * @param totalDays the integer value representing a date in the Gregorian calendar.
	 * @return a date that corresponds to the passed in integer day.
	 */
	public static Date calculateDate(int totalDays) {
		int y = 1;
		int m = 1;
		int d = 1;
		
		while (totalDays>365) {
			if (Date.isLeapYear(y)) {
				if (totalDays>366) {
					totalDays -= 366;
				}
				else {
					break;
				}
			}
			else {
				totalDays -= 365;
			}
			y++;
		}
		
		while (totalDays>daysOfTheMonth[m-1]) {
			totalDays -= daysOfTheMonth[m-1];
			if (m==2 && Date.isLeapYear(y)) {
				totalDays--;
				if (totalDays==0) {
					break;
				}
			}
			m++;				
		}
		
		if (totalDays==0) {
			d = 29;
		}
		else {
			d = totalDays;
		}
		
		return new Date(d, m, y);
	}
	
	/**
	 * Changes the values of one date to the date passed in.
	 * @param other another date that you want to change to.
	 */
	public void changeDate(Date other) {
		day = other.getDay();
		month = other.getMonth();
		year = other.getYear();
		dateInt = other.getDateInt();
	}
	
	/**
	 * Moves the date a specified number of days forward or backward. If the input is a negative number
	 * with a magnitude larger than the initial dateInt value, the moveDate will not change anything.
	 * @param days the number of days you want to increment your original date by.
	 */
	public void moveDate(int days) {
		int otherDays = dateInt + days;
		if (otherDays>0) {
			Date other = Date.calculateDate(otherDays);
			this.changeDate(other);
		}
	}
	
	/**
	 * Calculates the day of the week of a certain date.
	 * @return an integer that specifies the day of the week starting with 0 as Sunday.
	 */
	public int dayOfTheWeek() {
		return dateInt % 7;
	}
	
	/**
	 * Compares two dates based off of their dateInt value.
	 * @param other another date that you want to compare your original date to.
	 * @return an integer that represents the relationship between the two dates. 
	 */
	public int compareTo(Date other) {
		if (dateInt > other.getDateInt()) {
			return 1;
		}
		
		else if (dateInt < other.getDateInt()) {
			return -1;
		}
		else {
			return 0;
		}
	}
}
