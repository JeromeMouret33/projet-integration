package integration;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

class FIFOTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@ParameterizedTest()
	@MethodSource("add")
	void testAdd(int nbr, int resultat) {
		FIFO fifo = new FIFO();
		fifo.add(nbr);
		int t = fifo.first();
		assertEquals(resultat, t);
	}
	
	static Stream<Arguments> add() throws Throwable{
		return Stream.of(Arguments.of(2,2),
						Arguments.of(3,3),
						Arguments.of(4,4));
	}

	@ParameterizedTest()
	@MethodSource("testFirst")
	void testFirst(int nbr, int resultat) {
		FIFO fifo = new FIFO();
		fifo.add(nbr);
		int t = fifo.first();
		assertEquals(resultat, t);
	}
	
	static Stream<Arguments> testFirst() throws Throwable{
		return Stream.of(Arguments.of(2,2),
						Arguments.of(3,3),
						Arguments.of(4,4));
	}

	@ParameterizedTest()
	@MethodSource("testEmpty")
	void testIsEmpty() {
		FIFO fifo = new FIFO();
		assertTrue(fifo.isEmpty());
	}
	
	static Stream<Arguments> testEmpty() throws Throwable{
		return Stream.of(Arguments.of(),
						Arguments.of(),
						Arguments.of());
	}

	@ParameterizedTest()
	@MethodSource("remove")
	void testRemoveFirst(int nbr1, int nbr2, int resultat) {
		FIFO fifo = new FIFO();
		fifo.add(nbr1);
		fifo.add(nbr2);
		fifo.removeFirst();
		int t = fifo.first();
		assertEquals(resultat, t);
	}

	static Stream<Arguments> remove() throws Throwable{
		return Stream.of(Arguments.of(1, 2, 2));
	}
	
	
	@ParameterizedTest()
	@MethodSource("size")
	void testSize(int nbrs[], int resultat) {
		FIFO fifo = new FIFO();
		for(int nbr: nbrs) {
			fifo.add(nbr);
		}
		int t = fifo.size();
		assertEquals(resultat, t);
	}
	
	static Stream<Arguments> size() throws Throwable{
		int[] tab1 = new int[] {4};
		int[] tab2 = new int[] {4,5};
		int[] tab3 = new int[] {4,5,4};
		return Stream.of(Arguments.of(tab1, 1),
						Arguments.of(tab2, 2),
						Arguments.of(tab3, 3));
	}
	


}
