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
}
