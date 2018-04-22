package ar.com.meli.mutant;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ar.com.meli.mutant.dna.BaseNitrogenada;

public class HasSequenceSTest {

	@Test
	public void testHasSESequence() {
		String[] adnAsStringArray = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		String[][] adn = MutantDetector.arrayToMatrix(adnAsStringArray);
		BaseNitrogenada baseNitrogenada = BaseNitrogenada.build(0, 4, adn);
		HasSequenceS sequenceS = new HasSequenceS();
		assertTrue(sequenceS.test(baseNitrogenada));
	}

	@Test
	public void testHasNotSESequence() {
		String[] adnAsStringArray = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		String[][] adn = MutantDetector.arrayToMatrix(adnAsStringArray);
		BaseNitrogenada baseNitrogenada = BaseNitrogenada.build(1, 3, adn);
		HasSequenceS sequenceS = new HasSequenceS();
		assertFalse(sequenceS.test(baseNitrogenada));
	}
}
