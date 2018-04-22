package ar.com.meli.mutant;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ar.com.meli.mutant.dna.BaseNitrogenada;

public class HasSequenceSETest {

	@Test
	public void testHasSESequence() {
		String[] adnAsStringArray = { "ATGCGA", "CAGTGC", "TTATCT", "AGACGG", "CCCCTA", "TCACTG" };
		String[][] adn = MutantDetector.arrayToMatrix(adnAsStringArray);
		BaseNitrogenada baseNitrogenada = BaseNitrogenada.build(2, 4, adn);
		HasSequenceSW sequenceSW = new HasSequenceSW();
		assertTrue(sequenceSW.test(baseNitrogenada));
	}

	@Test
	public void testHasNotSESequence() {
		String[] adnAsStringArray = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		String[][] adn = MutantDetector.arrayToMatrix(adnAsStringArray);
		BaseNitrogenada baseNitrogenada = BaseNitrogenada.build(1, 4, adn);
		HasSequenceSW sequenceWE = new HasSequenceSW();
		assertFalse(sequenceWE.test(baseNitrogenada));
	}

}
