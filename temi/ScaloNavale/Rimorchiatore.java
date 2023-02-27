
/**
 * OVERVIEW: {@code Rimorchiatore} modella il comportamento di un rimorchiatore
 * di Navi Cargo
 */
public interface Rimorchiatore {

	/**
	 * Permette di spostare un certo numedi di navi da un molo di partenza ad un
	 * molo di arrivo,
	 * restituisce il nuove di viaggi effettuati
	 * 
	 * @param tot      il numero di navi da spostare
	 * @param partenza il molo di partenza
	 * @param arrivo   il molo di arrivo
	 * @return il numero di viaggi
	 * @throws NullPointerException se partenza o arrivo sono null
	 */
	public int muovi(int tot, final Molo partenza, final Molo arrivo);
}
