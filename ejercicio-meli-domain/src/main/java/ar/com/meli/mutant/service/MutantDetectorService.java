package ar.com.meli.mutant.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import ar.com.meli.mutant.MutantDetector;
import ar.com.meli.mutant.valueobjects.DnaRecordStats;

public class MutantDetectorService {

	private final MutantDetector mutantDetector;

	private final Map<String[], Boolean> dnaRecord = new ConcurrentHashMap<>();

	public MutantDetectorService(MutantDetector mutantDetector) {
		this.mutantDetector = mutantDetector;
	}

	public boolean isMutant(String[] dna) {
		boolean result;

		if (dnaRecord.containsKey(dna)) {
			result = dnaRecord.get(dna);
		} else {
			result = mutantDetector.isMutant(dna);
			dnaRecord.put(dna, result);
		}

		return result;

	}

	public DnaRecordStats getDnaStats() {
		int mutants = dnaRecord.values().stream().mapToInt(b -> b ? 1 : 0).sum();
		int humans = dnaRecord.values().stream().mapToInt(b -> !b ? 1 : 0).sum();

		return new DnaRecordStats(mutants, humans);
	}

}
