package ar.com.meli.mutant.valueobjects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DnaRecordStats {

	private final int mutantDnaCount;
	private final int humanDnaCount;

	public DnaRecordStats(int mutantDna, int humanDna) {
		this.mutantDnaCount = mutantDna;
		this.humanDnaCount = humanDna;
	}

	@JsonProperty(value = "count_mutant_dna")
	public int getMutantDnaCount() {
		return mutantDnaCount;
	}

	@JsonProperty(value = "count_human_dna")
	public int getHumanDnaCount() {
		return humanDnaCount;
	}
	
	@JsonProperty(value = "ratio")
	public Float getRatio() {
		return humanDnaCount > 0 ? (float)mutantDnaCount/humanDnaCount : null;
	}

}
