
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Stack;

/**
 * OVERVIEW: {@code Molo} modella la rappresentazione di un molo, è mutabile
 */
public class Molo implements Iterable<NaveCargo> {

	private final Stack<NaveCargo> molo;

	/**
	 * AF: Un molo è rappresentato da una coda, eventualmente vuota, di
	 * {@code NaveCargo}. Una nave potrò
	 * salpare o attraccare. Il primo ad aver attraccato sarò l'ultimo a salpare
	 * IR:
	 */

	public Molo(Molo m) {
		Objects.requireNonNull(m, "Molo non può essere null");
		// this.molo = new Stack<NaveCargo>();
		this.molo = (Stack<NaveCargo>) m.molo.clone();
	}

	public Molo() {
		this.molo = new Stack<NaveCargo>();
	}

	/**
	 * Permette di aggiungere una nuova nave al molo
	 * 
	 * @param nave la nave
	 * @throws NullPointerException se la nave è null
	 */
	public void attracca(NaveCargo nave) {
		Objects.requireNonNull(nave, "La nave non può essere null");
		molo.push(nave);
	}

	/**
	 * Permette di rimuovere l'ultima nave attraccata al molo
	 * 
	 * @return l'ultima nave attraccata
	 * @throws NoSuchElementException se il molo è vuoto
	 */
	public NaveCargo salpa() {
		if (molo.isEmpty())
			throw new NoSuchElementException("Molo vuoto");
		return molo.pop();
	}

	public int pesoSalpante(){
		return molo.peek().getPeso();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = molo.size() - 1; i >= 0; i--) {
			sb.append(molo.get(i).toString());
			sb.append(", ");
		}
		sb.deleteCharAt(sb.length() - 2);
		sb.append("#");

		return sb.toString();
	}

	@Override
	public Iterator<NaveCargo> iterator() {
		return molo.iterator();
	}
}
