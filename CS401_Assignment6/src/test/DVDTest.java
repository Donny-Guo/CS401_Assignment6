package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import dev.DVD;

@DisplayName("DVD Test")
class DVDTest {
	DVD dvd;
	
	@BeforeEach
	void setUp(){
		dvd = new DVD("STAR TREK", "R", 127);
	}
	
	
	@DisplayName("Test getTitle() method")
	@Test
	void getTitleTest() {
		assertTrue("STAR TREK".equals(dvd.getTitle()));
	}
	
	@DisplayName("Test getRating() method")
	@Test
	void getRatingTest() {
		assertTrue("R".equals(dvd.getRating()));
	}
	
	@DisplayName("Test getRunningTime() method")
	@Test
	void getRunningTimeTest() {
		assertEquals(127, dvd.getRunningTime());
	}
	
	@DisplayName("Test setTitle() method")
	@Test
	void setTitleTest() {
		String newTitle = "ABC";
		dvd.setTitle(newTitle);
		assertTrue(newTitle.equals(dvd.getTitle()));
	}
	
	@DisplayName("Test setRating() method")
	@Test
	void setRatingTest() {
		String newRating = "PG-13";
		dvd.setRating(newRating);
		assertTrue(newRating.equals(dvd.getRating()));
	}
	
	@DisplayName("Test setRunningTime method")
	@Test
	void setRunningTimeTest() {
		int newTime = 1000;
		dvd.setRunningTime(newTime);
		assertEquals(newTime, dvd.getRunningTime());
	}
	
	@DisplayName("Test toString() method")
	@Test
	void toStringTest() {
		String info = "STAR TREK,R,127\n";
		assertTrue(info.equals(dvd.toString()));
	}
}
