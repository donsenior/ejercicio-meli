package ar.com.meli.mutant;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import ar.com.meli.mutant.dna.BaseNitrogenada;

public class HasSequenceNWTest {

	@Test
	public void testHasNESequence() {
		String[] adnAsStringArray = { "ATGCGA", "CAGTGC", "TTATCT", "AGAAGG", "CCCCTA", "TCACTG" };
		String[][] adn = MutantDetector.arrayToMatrix(adnAsStringArray);
		BaseNitrogenada baseNitrogenada = BaseNitrogenada.build(3, 3, adn);
		HasSequenceNW sequenceNW = new HasSequenceNW();
		assertTrue(sequenceNW.test(baseNitrogenada));
	}

	@Test
	public void testHasNotNESequence() {
		String[] adnAsStringArray = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		String[][] adn = MutantDetector.arrayToMatrix(adnAsStringArray);
		BaseNitrogenada baseNitrogenada = BaseNitrogenada.build(5, 1, adn);
		HasSequenceNW sequenceNW = new HasSequenceNW();
		assertFalse(sequenceNW.test(baseNitrogenada));
	}

}
