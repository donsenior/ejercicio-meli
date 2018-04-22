package ar.com.meli.mutant;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ar.com.meli.mutant.dna.BaseNitrogenada;

public class HasSequenceETest {

	@Test
	public void testHasESequence() {
		String[] adnAsStringArray = { "ATGCGA", "CAGTGC", "TTATCT", "AGACGG", "CCCCTA", "TCACTG" };
		String[][] adn = MutantDetector.arrayToMatrix(adnAsStringArray);
		BaseNitrogenada baseNitrogenada = BaseNitrogenada.build(4, 3, adn);
		HasSequenceE sequenceE = new HasSequenceE();
		assertTrue(sequenceE.test(baseNitrogenada));
	}

	@Test
	public void testHasNotESequence() {
		String[] adnAsStringArray = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		String[][] adn = MutantDetector.arrayToMatrix(adnAsStringArray);
		BaseNitrogenada baseNitrogenada = BaseNitrogenada.build(0, 0, adn);
		HasSequenceE sequenceE = new HasSequenceE();
		assertFalse(sequenceE.test(baseNitrogenada));
	}
}
