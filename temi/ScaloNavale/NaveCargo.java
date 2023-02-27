import java.util.Objects;

/**
 * 
 * OVERVIEW: {@code NaveCargo} modella la rappresentazione di una nave cargo
 * caratterizzata da un nome e un peso, è immutabile
 */
public class NaveCargo {
	private final String nome;
	private final int peso;

	/**
	 * AR: {@code NaveCargo} è rappresentata da un nome (string) e un peso(int)
	 * IR: nome != null e non vuoto, peso > 0
	 */

	/**
	 * Costruisce una nuova nave a partire dal nome e dal peso forniti
	 * 
	 * @param nome il nome
	 * @param peso il peso
	 * @throws NullPointerException     se nome è null
	 * @throws IllegalArgumentException se nome è vuoto o peso <= 0
	 */
	public NaveCargo(String nome, int peso) {
		Objects.requireNonNull(nome, "Il nome non può essere null");
		if (nome.isEmpty())
			throw new IllegalArgumentException("Il nome non può essere vuoto");
		if (peso <= 0)
			throw new IllegalArgumentException("Il peso deve essere > di 0");

		this.nome = nome;
		this.peso = peso;
	}

	public String getNome() {
		return nome;
	}

	public int getPeso() {
		return peso;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.nome).append("[").append(this.peso).append("]");
		return sb.toString();
	}
}
