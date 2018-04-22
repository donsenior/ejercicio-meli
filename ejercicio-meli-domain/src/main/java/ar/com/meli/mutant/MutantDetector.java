package ar.com.meli.mutant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.com.meli.mutant.dna.BaseNitrogenada;

public class MutantDetector {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MutantDetector.class);

	private final HasSequence hasSequence = new HasSequence();

	public boolean isMutant(String[] array) {
		String[][] matrix = arrayToMatrix(array);

		print(matrix);

		return isMutant(matrix.clone());
	}

	private boolean isMutant(String[][] adn) {
		int sequencesCount = 0;
		for (int i = 0; i < adn.length; i++) {
			for (int j = 0; j < adn.length; j++) {
				if (hasSequence.test(BaseNitrogenada.build(i, j, adn))) {
					sequencesCount++;
					LOGGER.debug("Secuencia encontrada comenzando en {},{} ({})", i, j, adn[i][j]);
					//Marcamos ésta base nitrogenada para no volver a incluirla
					adn[i][j] = "-";
				}
			}
		}

		return sequencesCount > 1;
	}

	private static void print(String[][] matrix) {
		StringBuilder stringBuilder = new StringBuilder("\n");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				stringBuilder.append(String.format(" %s ", matrix[i][j]));
			}
			stringBuilder.append("\n");
		}
		
		LOGGER.debug("Matriz: \n{}", stringBuilder);
	}

	static String[][] arrayToMatrix(String[] array) {
		String[][] matrix = new String[array.length][array.length];

		for (int i = 0; i < array.length; i++) {
			String[] adn = array[i].split("");

			for (int j = 0; j < adn.length; j++) {
				matrix[i][j] = adn[j];
			}
		}

		return matrix;
	}

}
