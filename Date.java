
public class Date {

	private int day;
	private int month;
	private int year;
	public static int[] daysOfTheMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public Date(int d, int m, int y) {
		if (!Date.isValidDate(d, m, y)) {
			throw new IllegalArgumentException("Invalid Date was Used");
		}
		day = d;
		month = m;
		year = y;
		
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
	
	public void setDay(int d) {
		day = d;
	}
	
	public void setMonth(int m) {
		month = m;
	}
	
	public void setYear(int y) {
		year = y;
	}
	
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
	
	public static boolean isValidDate(int d, int m, int y) {
		if (y>=0) {
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
}
