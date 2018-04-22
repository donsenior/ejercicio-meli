package ar.com.meli.mutant.dna;

public class BaseNitrogenada {

	private final int y;
	private final int x;
	private final String[][] adn;

	public BaseNitrogenada(int y, int x, String[][] adn) {
		this.y = y;
		this.x = x;
		this.adn = adn;
	}

	public static BaseNitrogenada build(int y, int x, String[][] adn) {
		return new BaseNitrogenada(y, x, adn);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public String getData() {
		return adn[y][x];
	}
	
	public String[][] getAdn() {
		return adn;
	}

}
