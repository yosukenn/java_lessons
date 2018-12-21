package lesson17;

import org.junit.Test;
import static org.junit.Assert.*;
import java.time.*;

public class MovieTest {
	@Test public void instanciateNull() {
		Movie movie = new Movie();
		assertNotNull(movie);
	}
	
	@Test public void instanciateTitle() {
		Movie movie = new Movie("ララランド");
		assertEquals("ララランド", movie.getTitle());
	}
	
	@Test public void  getTitleTest() {
		Movie movie = new Movie("ララランド");
		assertEquals("ララランド", movie.getTitle());
	}
	
	@Test public void  setTitleTest() {
		Movie movie = new Movie();
		movie.setTitle("ララランド");
		assertEquals("ララランド", movie.getTitle());
	}
	@Test public void  getReleasedDateTest() {
		Movie movie = new Movie("ララランド");
		LocalDate t = LocalDate.of(2018, 12, 16);
		movie.setReleasedDate(t);
		assertEquals(t, movie.getReleasedDate());
	}
	
	@Test public void  setReleasedDateTest() {
		Movie movie = new Movie("ララランド");
		LocalDate t = LocalDate.of(2018, 12, 16);
		movie.setReleasedDate(t);
		assertEquals(t, movie.getReleasedDate());
	}
}
