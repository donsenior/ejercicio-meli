package ar.com.meli.mutant;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import ar.com.meli.mutant.dna.BaseNitrogenada;

public class HasSequenceNTest {

	@Test
	public void testHasNSequence() {
		String[] adnAsStringArray = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		String[][] adn = MutantDetector.arrayToMatrix(adnAsStringArray);
		BaseNitrogenada baseNitrogenada = BaseNitrogenada.build(3, 4, adn);
		HasSequenceN sequenceN = new HasSequenceN();
		assertTrue(sequenceN.test(baseNitrogenada));
	}

	@Test
	public void testHasNotNSequence() {
		String[] adnAsStringArray = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		String[][] adn = MutantDetector.arrayToMatrix(adnAsStringArray);
		BaseNitrogenada baseNitrogenada = BaseNitrogenada.build(0, 0, adn);
		HasSequenceN sequenceN = new HasSequenceN();
		assertFalse(sequenceN.test(baseNitrogenada));
	}

}
