package ar.com.meli.mutant;

import java.util.function.Predicate;

import ar.com.meli.mutant.dna.BaseNitrogenada;

public class HasSequenceSW implements Predicate<BaseNitrogenada> {

	@Override
	public boolean test(BaseNitrogenada bn) {
		int count = 0;

		String[][] adn = bn.getAdn();
		String bnData = bn.getData();

		for (int y = bn.getY() + 1, x = bn.getX() - 1; y < adn.length && x >= 0; y++, x--) {
			if (bnData.equals(adn[y][x])) {
				count++;
			} else {
				break;
			}
		}

		return count >= 3;
	}

}
