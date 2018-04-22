package ar.com.meli.mutant;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import ar.com.meli.mutant.dna.BaseNitrogenada;

public class HasSequenceNETest {

	@Test
	public void testHasNESequence() {
		String[] adnAsStringArray = { "ATGCGA", "CAGTGC", "TTATCT", "AGACGG", "CCCCTA", "TCACTG" };
		String[][] adn = MutantDetector.arrayToMatrix(adnAsStringArray);
		BaseNitrogenada baseNitrogenada = BaseNitrogenada.build(5, 1, adn);
		HasSequenceNE sequenceNE = new HasSequenceNE();
		assertTrue(sequenceNE.test(baseNitrogenada));
	}

	@Test
	public void testHasNotNESequence() {
		String[] adnAsStringArray = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		String[][] adn = MutantDetector.arrayToMatrix(adnAsStringArray);
		BaseNitrogenada baseNitrogenada = BaseNitrogenada.build(5, 1, adn);
		HasSequenceNE sequenceNE = new HasSequenceNE();
		assertFalse(sequenceNE.test(baseNitrogenada));
	}

}
