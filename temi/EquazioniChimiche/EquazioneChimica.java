import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * OVERVIEW: {@code EquazioneChimica} modella una equazione chimica formata da
 * un insieme di reagenti e prodotti
 */
public class EquazioneChimica {

	private final Map<Molecola, Integer> reagenti = new HashMap<Molecola, Integer>();
	private final Map<Molecola, Integer> prodotti = new HashMap<Molecola, Integer>();
	private final String equazione;

	/**
	 * AF: l'equazione è rappresentata da una mappa di reagenti e prodotti con il
	 * rispettivo coefficiente stechiometrico. Una equazione è bilanciata sse
	 * ciascun tipo di elementi è presente nello stesso numero sia nei reagenti che
	 * nei prodotti.
	 * L'equazione deve essere nella forma A -> B sono A sono i reagenti e B i
	 * prodotti
	 * IR: mappa di reagenti e prodotti != null e non vuota e per ogni elemento il
	 * coefficiente stechiometrico deve essere > di 0
	 */

	/**
	 * Costruisce una nuova equazione chimica a partire dalla sua equazione e dalla
	 * tavola periodica
	 * 
	 * @param equazione       l'equazione
	 * @param tavolaPeriodica la tavola periodica
	 * @throws NullPointerException     se equazione o tavolaPeriodica sono null
	 * @throws IllegalArgumentException se l'equazione non è nel formato corretto
	 */
	public EquazioneChimica(String equazione, TavolaPeriodica tavolaPeriodica) {
		Objects.requireNonNull(equazione, "L'equazione non può essere null");
		Objects.requireNonNull(tavolaPeriodica, "La tavola periodica non può essere null");

		String formula[] = equazione.split("->");
		if (formula.length != 2)
			throw new IllegalArgumentException("Formato equazione non valido");

		this.equazione = equazione;
		String formulaReagenti[] = Helpers.parseSommaStechiometrica(formula[0]);
		for (int i = 0; i < formulaReagenti.length; i++) {
			int coeff = Integer.parseInt(formulaReagenti[i]);
			if (coeff <= 0)
				throw new IllegalArgumentException("Coefficiente stechiometrico non valido");

			String elem = formulaReagenti[i + 1];
			Molecola m = new Molecola(elem, tavolaPeriodica);
			reagenti.put(m, reagenti.getOrDefault(m, 0) + coeff);
			i++;
		}

		String formulaProdotti[] = Helpers.parseSommaStechiometrica(formula[1]);
		for (int i = 0; i < formulaProdotti.length; i++) {
			int coeff = Integer.parseInt(formulaProdotti[i]);
			System.out.println("Coeff: " + coeff);
			if (coeff <= 0)
				throw new IllegalArgumentException("Coefficiente stechiometrico non valido");

			String elem = formulaProdotti[i + 1];
			Molecola m = new Molecola(elem, tavolaPeriodica);
			prodotti.put(m, prodotti.getOrDefault(m, 0) + coeff);

			i++;
		}
	}

	/**
	 * Restituisce {@code true} se l'attuale equazione è bilanciata
	 * 
	 * @return {@code true} se l'attuale equazione è bilanciata
	 */
	public boolean èBilanciata() {
		
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Equazione:\n\t");
		sb.append(this.equazione);

		if (this.èBilanciata())
			sb.append(" bilanciata");
		else
			sb.append(" non bilanciata");

		sb.append("\nReagenti:\n");
		for (Molecola reagente : reagenti.keySet()) {
			sb.append("\t");
			sb.append(reagente.toString());
			sb.append("\n");
		}

		sb.append("\nProdotto:\n");
		for (Molecola prodotto : prodotti.keySet()) {
			sb.append("\t");
			sb.append(prodotto.toString());
			sb.append("\n");
		}
		return sb.toString();
	}
}
