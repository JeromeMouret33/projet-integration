package integration;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.Assert;

class TriTableauTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}


	@ParameterizedTest()
	@MethodSource("croissant")
	void testTriCroissant(int tab[], int resultat[]) {

		Assert.assertArrayEquals(resultat, TriTableau.triCroissant(tab));
	}
	
	static Stream<Arguments> croissant() throws Throwable{
		int[] tab = new int[] {3,5,4};
		int[] resultat = new int[] {3,4,5};
		int[] tab2 = new int[] {6,5,0};
		int[] resultat2 = new int[] {0,5,6};
		return Stream.of(Arguments.of(tab, resultat),
						Arguments.of(tab2, resultat2));
	}

	@ParameterizedTest()
	@MethodSource("deCroissant")
	void testTriDecroissant(int tab[], int resultat[]) {
		Assert.assertArrayEquals(resultat, TriTableau.triDecroissant(tab));
	}
	
	static Stream<Arguments> deCroissant() throws Throwable{
		int[] tab = new int[] {3,5,4};
		int[] resultat = new int[] {5,4,3};
		int[] tab2 = new int[] {6,5,0};
		int[] resultat2 = new int[] {6,5,0};
		return Stream.of(Arguments.of(tab, resultat),
						Arguments.of(tab2, resultat2));
	}

}
