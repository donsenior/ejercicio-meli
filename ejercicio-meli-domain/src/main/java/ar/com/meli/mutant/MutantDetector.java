package ar.com.meli.mutant;

import static java.lang.String.format;

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
		for (int i = 0; i < adn.length && sequencesCount < 2; i++) {
			for (int j = 0; j < adn.length && sequencesCount < 2; j++) {
				if (hasSequence.test(BaseNitrogenada.build(i, j, adn))) {
					sequencesCount++;
					LOGGER.debug("Secuencia encontrada comenzando en {},{} ({})", i, j, adn[i][j]);
					// Marcamos esta base nitrogenada para no volver a incluirla
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

			if (array.length != adn.length) {
				throw new IllegalArgumentException(
						format("ADN mal formado (tamaño matriz %s, tamaño cadena %s, posición -> %s)", array.length,
								adn.length, i));
			}

			for (int j = 0; j < adn.length; j++) {

				if (null == adn[j] || "".equals(adn[j])) {
					throw new IllegalArgumentException(
							format("El valor de la cadena no puede ser nulo o vacío (posición -> %s, %s)", i, j));
				}

				matrix[i][j] = adn[j];
			}
		}

		return matrix;
	}

}
