
public class Date {

	private int day;
	private int month;
	private int year;
	private int dateInt;
	public static int[] daysOfTheMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
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
	
	public void setDateInt(int newDate) {
		dateInt = newDate;
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
}
