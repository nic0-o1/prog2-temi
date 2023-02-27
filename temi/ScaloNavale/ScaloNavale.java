import java.util.List;
import java.util.Objects;

/**
 * OVERVIEW: {@code ScaloNavale} modella uno scalo navale, ovvere un insieme di
 * moli, è immutabile
 */
public class ScaloNavale {

	private final Molo[] moli;
	private final int tot;
	private final Rimorchiatore rim;

	/**
	 * AF: uno {@code ScaloNavale} è un insieme finito e non vuoto di Moli
	 * IR: moli != null e non vuoto
	 */

	/**
	 * Genera un nuovo {@code ScaloNavale} composto da un numero totale di moli e la
	 * lista di moli e da un rimorchiatore
	 * 
	 * @param tot  il numero totale
	 * @param moli la lista
	 * @param rim  il rimorchiatore
	 * @throws NullPointerException     se moli o rim è null
	 * @throws IllegalArgumentException se tot <= 0 o se la lista è vuota o cantiene
	 *                                  elementi null o se tot != moli.size()
	 */
	public ScaloNavale(int tot, List<Molo> moli, Rimorchiatore rim) {
		Objects.requireNonNull(moli, "Moli non può essere null");
		Objects.requireNonNull(rim, "Rimorchiatore non può essere null");
		if (tot <= 0)
			throw new IllegalArgumentException("Il numero totale di moli deve essere > di 0");
		for (Molo molo : moli) {
			Objects.requireNonNull(molo, "Molo non puo essere null");
		}

		if (tot != moli.size())
			throw new IllegalArgumentException("Il numero totale di moli non corrisponde ai moli forniti");

		this.moli = new Molo[tot];
		for (int i = 0; i < tot; i++) {
			this.moli[i] = new Molo(moli.get(i));
		}
		this.rim = rim;
		this.tot = tot;
	}

	public int muovi(int tot, int moloP, int moloA) {
		return rim.muovi(tot, moli[moloP], moli[moloA]);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < moli.length; i++) {
			sb.append(i).append(":").append(" < ");
			sb.append(moli[i].toString()).append("\n");
		}
		return sb.toString();
	}
}
