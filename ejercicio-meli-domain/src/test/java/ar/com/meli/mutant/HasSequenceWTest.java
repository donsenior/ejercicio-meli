package ar.com.meli.mutant;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ar.com.meli.mutant.dna.BaseNitrogenada;

public class HasSequenceWTest {

	@Test
	public void testHasESequence() {
		String[] adnAsStringArray = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		String[][] adn = MutantDetector.arrayToMatrix(adnAsStringArray);
		BaseNitrogenada baseNitrogenada = BaseNitrogenada.build(4, 0, adn);
		HasSequenceW sequenceW = new HasSequenceW();
		assertTrue(sequenceW.test(baseNitrogenada));
	}

	@Test
	public void testHasNotESequence() {
		String[] adnAsStringArray = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		String[][] adn = MutantDetector.arrayToMatrix(adnAsStringArray);
		BaseNitrogenada baseNitrogenada = BaseNitrogenada.build(2, 0, adn);
		HasSequenceW sequenceW = new HasSequenceW();
		assertFalse(sequenceW.test(baseNitrogenada));
	}
}
