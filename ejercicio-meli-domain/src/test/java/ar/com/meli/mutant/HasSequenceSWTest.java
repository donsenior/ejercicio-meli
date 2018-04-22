package ar.com.meli.mutant;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ar.com.meli.mutant.dna.BaseNitrogenada;

public class HasSequenceSWTest {

	@Test
	public void testHasSESequence() {
		String[] adnAsStringArray = { "ATGCGA", "CAGTGC", "TTATCT", "AGAAGG", "CCCCTA", "TCACTG" };
		String[][] adn = MutantDetector.arrayToMatrix(adnAsStringArray);
		BaseNitrogenada baseNitrogenada = BaseNitrogenada.build(0, 0, adn);
		HasSequenceSE sequenceSE = new HasSequenceSE();
		assertTrue(sequenceSE.test(baseNitrogenada));
	}

	@Test
	public void testHasNotSESequence() {
		String[] adnAsStringArray = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		String[][] adn = MutantDetector.arrayToMatrix(adnAsStringArray);
		BaseNitrogenada baseNitrogenada = BaseNitrogenada.build(1, 1, adn);
		HasSequenceSE sequenceSE = new HasSequenceSE();
		assertFalse(sequenceSE.test(baseNitrogenada));
	}

}
