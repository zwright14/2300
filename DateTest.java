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
}
