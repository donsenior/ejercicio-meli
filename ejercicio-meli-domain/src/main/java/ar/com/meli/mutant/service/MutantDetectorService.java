package ar.com.meli.mutant.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import ar.com.meli.mutant.MutantDetector;
import ar.com.meli.mutant.valueobjects.DnaRecordStats;

public class MutantDetectorService {

	private final MutantDetector mutantDetector;

	private final Map<String, Boolean> dnaRecord = new ConcurrentHashMap<>();

	public MutantDetectorService(MutantDetector mutantDetector) {
		this.mutantDetector = mutantDetector;
	}

	public DnaRecordStats getDnaStats() {
		int mutants = dnaRecord.values().stream().mapToInt(b -> b ? 1 : 0).sum();
		int humans = dnaRecord.values().stream().mapToInt(b -> !b ? 1 : 0).sum();

		return new DnaRecordStats(mutants, humans);
	}

	public boolean isMutant(String[] dna) {
		boolean result;
		
		String dnaString = asString(dna);

		if (dnaRecord.containsKey(dnaString)) {
			result = dnaRecord.get(dnaString);
		} else {
			result = mutantDetector.isMutant(dna);
			dnaRecord.put(dnaString, result);
		}

		return result;

	}

	private String asString(String[] dna) {
		StringBuilder stringBuilder = new StringBuilder();
		for (String string : dna) {
			stringBuilder.append(string);
		}
		return stringBuilder.toString();
	}

}
