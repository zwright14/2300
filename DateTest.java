import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DateTest {
		
		@Test
		public void testDateClass() {
			Date myDate = new Date(1, 11, 1996);
			assertEquals(1, myDate.getDay());
			assertEquals(11, myDate.getMonth());
			assertEquals(1996, myDate.getYear());
		}
		
		@Test
		public void testIsLeapYear() {
			assertEquals(true, Date.isLeapYear(2000));
			assertEquals(true, Date.isLeapYear(2004));
			assertEquals(false, Date.isLeapYear(2100));
			assertEquals(false, Date.isLeapYear(2017));
		}
		
		@Test
		public void testIsValidDate() {
			assertEquals(true, Date.isValidDate(29, 2, 2016));
			assertEquals(true, Date.isValidDate(1, 1, 1));
			assertEquals(false, Date.isValidDate(32, 1, 2017));
			assertEquals(false, Date.isValidDate(1, 13, 1));
			assertEquals(false, Date.isValidDate(0, 0, 0));
			assertEquals(false, Date.isValidDate(0, 1, 1));
			assertEquals(false, Date.isValidDate(1, 0, 1));
			assertEquals(false, Date.isValidDate(1, 1, 0));
			assertEquals(false, Date.isValidDate(-1, -1, -1));
			assertEquals(false, Date.isValidDate(-1, 1, 1));
			assertEquals(false, Date.isValidDate(1, -1, 1));
			assertEquals(false, Date.isValidDate(1, 1, -1));
			
			}
		
		@Test
		public void testDateToInt() {
			assertEquals(1, Date.toInt(1, 1, 1));
			assertEquals(60, Date.toInt(1, 3, 1));
			assertEquals(728964, Date.toInt(1, 11, 1996));
		}
		
		@Test
		public void testCalculateDate() {
			Date Date1 = new Date(1, 1, 1);
			Date Date2 = new Date(1, 3, 1);
			Date Date3 = new Date(1, 11, 1996);
			assertEquals(Date1.getDay(), Date.calculateDate(1).getDay());
			assertEquals(Date2.getDay(), Date.calculateDate(60).getDay());
			assertEquals(Date3.getDay(), Date.calculateDate(728964).getDay());
			assertEquals(Date1.getMonth(), Date.calculateDate(1).getMonth());
			assertEquals(Date2.getMonth(), Date.calculateDate(60).getMonth());
			assertEquals(Date3.getMonth(), Date.calculateDate(728964).getMonth());
			assertEquals(Date1.getYear(), Date.calculateDate(1).getYear());
			assertEquals(Date2.getYear(), Date.calculateDate(60).getYear());
			assertEquals(Date3.getYear(), Date.calculateDate(728964).getYear());
		}
}
