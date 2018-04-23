package ar.com.meli.mutant.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ar.com.meli.mutant.MutantDetector;
import ar.com.meli.mutant.service.MutantDetectorService;

public class MutantDetectorServiceTest {

	@Test
	public void testGetMutantDnaCount() {
		MutantDetectorService mutantDetectorService = new MutantDetectorService(new MutantDetector());

		String[] mutantDna1 = { "ATGCGA", "CAGTGC", "TTATCT", "AGACGG", "CCCCTA", "TCACTG" };
		String[] mutantDna2 = { "CTGCGA", "CCGTGC", "CTCTGA", "CGACGG", "CCCCTA", "TCACTG" };
		String[] mutantDna3 = { "GTGCGA", "GAGTGC", "GTATCT", "GGACGT", "CCCCTA", "TCACTG" };
		String[] humanDna1 = { "ATGCCA", "CAGTGC", "TTATGT", "AGAAGG", "ACCCTA", "TCACTG" };
		String[] humanDna2 = { "TTGCCA", "CAGTGC", "TTATGT", "AGAAGG", "ACCCTA", "TCACTG" };
		String[] humanDna3 = { "GTGCCA", "CAGTGC", "TTATGT", "AGAAGG", "ACCCTA", "TCACTG" };
		String[] humanDna4 = { "ATGCCA", "GAGTGC", "TTATGT", "AGAAGG", "ACCCTA", "TCACTG" };

		mutantDetectorService.isMutant(mutantDna1);
		mutantDetectorService.isMutant(mutantDna1.clone());
		mutantDetectorService.isMutant(mutantDna2);
		mutantDetectorService.isMutant(mutantDna3);
		mutantDetectorService.isMutant(humanDna1);
		mutantDetectorService.isMutant(humanDna2);
		mutantDetectorService.isMutant(humanDna3);
		mutantDetectorService.isMutant(humanDna4);

		assertEquals(3, mutantDetectorService.getDnaStats().getMutantDnaCount());
		assertEquals(4, mutantDetectorService.getDnaStats().getHumanDnaCount());
		assertEquals(0.75, mutantDetectorService.getDnaStats().getRatio(), 0.1);
	}

}
