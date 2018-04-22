package ar.com.meli.mutant;

import java.util.function.Predicate;

import ar.com.meli.mutant.dna.BaseNitrogenada;

public class HasSequenceE implements Predicate<BaseNitrogenada> {

	@Override
	public boolean test(BaseNitrogenada bn) {
		int count = 0;
		
		String[][] adn = bn.getAdn();
		String bnData = bn.getData();
		
		for (int x = bn.getX() - 1; x >= 0; x--) {
			if (bnData.equals(adn[bn.getY()][x])) {
				count++;
			} else {
				break;
			}
		}
		
		return count >=3;
	}

}
