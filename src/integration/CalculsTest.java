package integration;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.runners.Parameterized;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;

@RunWith(Parameterized.class)
class CalculsTest {
	
	
	
	
	
	
	private static Calculs math;

	@BeforeEach
	void setUp() throws Exception {
		math = new Calculs(10, 0);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@ParameterizedTest(name="Multiplication numero {0} : nombre1{0} nombre2= {1} resultat nombre3= {2}")
	@MethodSource("chargerJeuTest")
	void testMultiplier(int nb1, int nb2, int resultat) {
		math = new Calculs(nb1, nb2);
		assertEquals(resultat, math.multiplier());
	}

	@Test
	void testAdditionner() {
		assertEquals(10, math.additionner());
	}

	@Test
	void testDiviser() {
		/*
		assertThrows(NumberFormatException.class, ()->{
			Integer.parseInt("");
		});
		*/
		assertEquals(0, math.diviser());
	}

	@Test
	void testSoustraire() {
		assertEquals(10, math.soustraire());
	}
	
	static Stream<Arguments> chargerJeuTest() throws Throwable{
		return Stream.of(Arguments.of(2,2,4),
						Arguments.of(3,3,9),
						Arguments.of(2,3,6));
	}

}
