import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {

	
	//creating two objects
	GradeBook gb1;
	GradeBook gb2;
	
	
	@BeforeEach
	void setUp() throws Exception {
		gb1 = new GradeBook(5);
		gb2 = new GradeBook(5);
		// calling addscore method for each
		gb1.addScore(90);
		gb1.addScore(80);
		gb1.addScore(100);
		
		gb2.addScore(70);
		gb2.addScore(60);
		gb2.addScore(80);
	}

	@AfterEach
	void tearDown() throws Exception {
		 gb1= null;
	     gb2= null;
	}
	
	@Test
	void testAddScore() {
		assertTrue(gb1.toString().equals("90.0 80.0 100.0 "));
		assertTrue(gb2.toString().equals("70.0 60.0 80.0 "));
		
	}

	@Test
	void testSum() {
		assertEquals(270, gb1.sum(), .0001);
		assertEquals(210, gb2.sum(), .0001);
	}

	@Test
	void testMinimum() {
		assertEquals(80, gb1.minimum(), .001);
		assertEquals(60, gb2.minimum(), .001);
	}

	@Test
	void testFinalScore() {
		assertEquals(190, gb1.finalScore(), .0001);
		assertEquals(150, gb2.finalScore(), .0001);
	}

}
