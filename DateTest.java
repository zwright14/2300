import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DateTest {
		
		@Test
		public void testDateClass() {
			Date myDate = new Date(11, 1, 1996);
			assertEquals(11, myDate.getDay());
			assertEquals(1, myDate.getMonth());
			assertEquals(1996, myDate.getYear());
		}
		
		@Test
		public void testIsLeapYear() {
			int i=2000;
			while (i<2100) {
				if (i%4==0) {
					assertEquals(true, Date.isLeapYear(i));
				}
				else {
					assertEquals(false, Date.isLeapYear(i));	
				}
				i++;
			}
			assertEquals(false, Date.isLeapYear(2100));
			assertEquals(true, Date.isLeapYear(2400));
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
			assertEquals(728669, Date.toInt(11, 1, 1996));
		}
		
		@Test
		public void testCalculateDate() {
			Date Date1 = new Date(1, 1, 1);
			Date Date2 = new Date(1, 3, 1);
			Date Date3 = new Date(11, 1, 1996);
			assertEquals(Date1.getDay(), Date.calculateDate(1).getDay());
			assertEquals(Date2.getDay(), Date.calculateDate(60).getDay());
			assertEquals(Date3.getDay(), Date.calculateDate(728669).getDay());
			assertEquals(Date1.getMonth(), Date.calculateDate(1).getMonth());
			assertEquals(Date2.getMonth(), Date.calculateDate(60).getMonth());
			assertEquals(Date3.getMonth(), Date.calculateDate(728669).getMonth());
			assertEquals(Date1.getYear(), Date.calculateDate(1).getYear());
			assertEquals(Date2.getYear(), Date.calculateDate(60).getYear());
			assertEquals(Date3.getYear(), Date.calculateDate(728669).getYear());
		}
		
		@Test
		public void testChangeDate() {
			Date testDate = new Date(19, 10, 2017);
			for (int i=1; i<=12; i++) {
				Date changedDate = new Date (i, i, i);
				testDate.changeDate(changedDate);
				assertEquals(i, testDate.getDay());
				assertEquals(i, testDate.getMonth());
				assertEquals(i, testDate.getYear());
			}
		}

		@Test
		public void testMoveDate() {
			Date testDate1 = new Date (31, 12, 1996);
			Date testDate2 = new Date (31, 1, 1997);
			for (int i=1; i<31; i++) {
				testDate1.moveDate(1);
				testDate2.moveDate(-1);
				assertEquals(i, testDate1.getDay());
				assertEquals(31-i, testDate2.getDay());
			}
			testDate2.moveDate(-1);
			assertEquals(31, testDate2.getDay());
			assertEquals(1, testDate1.getMonth());
			assertEquals(12, testDate2.getMonth());
			assertEquals(1997, testDate1.getYear());
			assertEquals(1996, testDate2.getYear());
			Date testDate3 = new Date(28, 2, 2012);
			testDate3.moveDate(1);
			assertEquals(29, testDate3.getDay());
			assertEquals(2, testDate3.getMonth());
			assertEquals(2012, testDate3.getYear());
		}
}
