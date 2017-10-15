
public class Date {

	private int day;
	private int month;
	private int year;
	
	public Date(int d, int m, int y) {
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
}
