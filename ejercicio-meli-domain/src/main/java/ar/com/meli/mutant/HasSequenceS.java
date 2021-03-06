package ar.com.meli.mutant;

import java.util.function.Predicate;

import ar.com.meli.mutant.dna.BaseNitrogenada;

public class HasSequenceS implements Predicate<BaseNitrogenada> {

	@Override
	public boolean test(BaseNitrogenada bn) {
		int count = 0;

		String[][] adn = bn.getAdn();
		String bnData = bn.getData();

		for (int y = bn.getY() + 1; y < adn.length; y++) {
			if (bnData.equals(adn[y][bn.getX()])) {
				count++;
			} else {
				break;
			}
		}

		return count >= 3;
	}

}
