package ar.com.meli.mutant;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.com.meli.mutant.MutantDetector;

public class MutantDetectorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIsMutant() {
		String[] array = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		MutantDetector mutantDetector = new MutantDetector();
		assertTrue(mutantDetector.isMutant(array));
	}

	@Test
	public void testIsMutantSameNB() {
		String[] array = { "ATGAGA", "CAGACC", "TTAAGT", "AGAAGG", "GCCCTA", "TCACTG" };
		MutantDetector mutantDetector = new MutantDetector();
		assertTrue(mutantDetector.isMutant(array));
	}

	@Test
	public void testIsNotMutant() {
		String[] array = { "ATGCCA", "CAGTGC", "TTATGT", "AGAAGG", "ACCCTA", "TCACTG" };
		MutantDetector mutantDetector = new MutantDetector();
		assertFalse(mutantDetector.isMutant(array));
	}

}
