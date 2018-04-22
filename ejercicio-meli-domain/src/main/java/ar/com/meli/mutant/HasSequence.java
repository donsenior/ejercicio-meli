package ar.com.meli.mutant;

import java.util.function.Predicate;

import ar.com.meli.mutant.dna.BaseNitrogenada;

public class HasSequence implements Predicate<BaseNitrogenada> {

	private final HasSequenceN hasSequenceN = new HasSequenceN();
	private final HasSequenceNE hasSequenceNE = new HasSequenceNE();
	private final HasSequenceE hasSequenceE = new HasSequenceE();
	private final HasSequenceSE hasSequenceSE = new HasSequenceSE();
	private final HasSequenceS hasSequenceS = new HasSequenceS();
	private final HasSequenceSW hasSequenceSW = new HasSequenceSW();
	private final HasSequenceW hasSequenceW = new HasSequenceW();
	private final HasSequenceNW hasSequenceNW = new HasSequenceNW();
	
	@Override
	public boolean test(BaseNitrogenada bn) {
		return hasSequenceN
				.or(hasSequenceNE)
				.or(hasSequenceE)
				.or(hasSequenceSE)
				.or(hasSequenceS)
				.or(hasSequenceSW)
				.or(hasSequenceW)
				.or(hasSequenceNW)
				.test(bn);
	}

}
