
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * OVERVIEW: {@code Molecola} modella una molecola composta da Elementi chimici
 */
public class Molecola {
    private HashMap<ElementoChimico, Integer> elementi = new HashMap<ElementoChimico, Integer>();
    private float pesoTotale;

    private final TavolaPeriodica tavolaPeriodica;

    /**
     * AF: Una molecola è composta da una aggregazione di uno o più
     * {@code ElementoChimico} e dal peso complessivo della stessa.
     * Il toString restituirà la formnula in formato di Hill e un indicazione sulla
     * composizione della molecola: semplice (formata da un solo elemento)
     * o composta (formata da più elementi).
     * IR: elementi != null, size di elementi > 0 e per ogni chiave presenti in
     * elementi, il numero di atomi identificato dalla chiave deve essere
     * > 0 tavolaPeriodica != null
     */

    /**
     * Costruisce una molecola a partire da una formula fornita e una tavola
     * periodica
     * 
     * @param formula         la formula fornita
     * @param tavolaPeriodica la tavola periodica
     * @throws NullPointerException     se la formula fornita è null
     * @throws IllegalArgumentException se la formula fornita è vuota
     */
    public Molecola(String formula, TavolaPeriodica tavolaPeriodica) {
        Objects.requireNonNull(formula, "La fornula non può essere null");
        Objects.requireNonNull(tavolaPeriodica, "La tavola non può essere null");

        if (!tavolaPeriodica.iterator().hasNext())
            throw new IllegalArgumentException("La tavola periodica non può essere vuota");
        if (formula.length() == 0)
            throw new IllegalArgumentException("La formula non può essere vuota");

        this.tavolaPeriodica = tavolaPeriodica;

        String elems[] = Helpers.parseFormula(formula);
        for (int i = 0; i < elems.length; i++) {
            ElementoChimico e = this.tavolaPeriodica.prendiElemento(elems[i]);

            if (elementi.containsKey(e)) {
                elementi.put(e, elementi.get(e) + Integer.parseInt(elems[1]));
            } else {
                elementi.put(e, Integer.parseInt(elems[1]));
            }
            i++;
        }

    }

    public float PesoTotale() {
        for (ElementoChimico elementoChimico : elementi.keySet()) {
            pesoTotale += elementoChimico.Peso() * elementi.get(elementoChimico);
        }
        return pesoTotale;
    }

    public String formula() {
        final String[] priority = { "C", "N", "H", "O" };
        Map<ElementoChimico, Integer> nonPriority = new LinkedHashMap<ElementoChimico, Integer>(elementi);
        Map<ElementoChimico, Integer> prioriyItems = new LinkedHashMap<ElementoChimico, Integer>();

        for (String elem : priority) {
            if (nonPriority.containsKey(tavolaPeriodica.prendiElemento(elem))) {
                ElementoChimico e = tavolaPeriodica.prendiElemento(elem);
                prioriyItems.put(e, nonPriority.get(e));
                nonPriority.remove(e);
            }
        }

        List<ElementoChimico> sortedKeys = new ArrayList<ElementoChimico>(nonPriority.keySet());
        Collections.sort(sortedKeys);

        for (ElementoChimico elementoChimico : sortedKeys) {
            prioriyItems.put(elementoChimico, nonPriority.get(elementoChimico));
        }

        StringBuilder sb = new StringBuilder();

        for (ElementoChimico elementoChimico : prioriyItems.keySet()) {
            if (prioriyItems.get(elementoChimico) > 1)
                sb.append(prioriyItems.get(elementoChimico));
            sb.append(elementoChimico.Simbolo());
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(formula());

        sb.append(", ");
        sb.append(PesoTotale());
        sb.append(", ");

        if (elementi.keySet().size() == 1)
            sb.append("semplice");
        else
            sb.append("composta");
        return sb.toString();
    }
}
