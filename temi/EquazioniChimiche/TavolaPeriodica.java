
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * OVERVIEW: {@code TavolaPeriodica} modella una tavola periodica composta da
 * Elementi Chimici
 */
public class TavolaPeriodica implements Iterable<ElementoChimico> {
    private static final int TOTALE_ELEMENTI = 118;
    private ElementoChimico[] tavola = new ElementoChimico[TOTALE_ELEMENTI + 1];;

    /**
     * AF: gli elementi sono rappresentati da da degli {@code ElementoChimico} presi
     * in modo ordinato
     * IR: tavola != null e gli elementi diversi da null e non deve contenere
     * elementi duplicati, la posizione i-esima corrispone all'
     * {@code ElementoChimico} di
     * numero atomico i+1
     */

    /**
     * Costruisce una tavola periodica a partire da una lista di
     * {@code ElementoChimico}
     * 
     * @param elems la lista
     * @throws NullPointerException     se la lista è null
     * @throws IllegalArgumentException se ...
     */
    public TavolaPeriodica(List<ElementoChimico> elems) {
        Objects.requireNonNull(elems, "La lisa di elementi non può essere null");

        for (ElementoChimico elementoChimico : elems)
            Objects.requireNonNull(elementoChimico, "La lista non può contenere elementi null");

        for (ElementoChimico elementoChimico : elems) {
            for (ElementoChimico elChimico : elems) {
                if (!elementoChimico.equals(elChimico)) {
                    if (elementoChimico.Nome().equals(elChimico.Nome()))
                        throw new IllegalArgumentException("Elementi duplicati");
                    if (elementoChimico.Simbolo().equals(elChimico.Simbolo()))
                        throw new IllegalArgumentException("Elementi duplicati");
                    if (elementoChimico.nAtomico() == elChimico.nAtomico())
                        throw new IllegalArgumentException("Elementi duplicati");
                }
            }
        }
        for (ElementoChimico elementoChimico : elems) {
            int i = elementoChimico.nAtomico();
            this.tavola[i - 1] = new ElementoChimico(elementoChimico);
        }
    }

    /**
     * Restituisce {@code true} se il simobolo fornito è presente nella tavola
     * periodica
     * 
     * @param simbolo il simbolo
     * @return {@code true} se il simobolo fornito è presente nella tavola periodica
     * @throws IllegalArgumentException se il simbolo non è presente
     * @throws NullPointerException     se il simbolo fornito è null
     */
    public Boolean èPresente(String simbolo) {
        Objects.requireNonNull(simbolo, "Il simbolo non può essere null");
        if (simbolo.length() == 0)
            throw new IllegalArgumentException("Il simbolo non può essere null");

        try {
            prendiElemento(simbolo);
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    /**
     * Restituisce l'elemento chimico corrispondente al simbolo passato
     * 
     * @param simbolo il simbolo
     * @throws NoSuchElementException   se il simbolo fornito non è presente
     * @throws NullPointerException     se il simbolo fornito è null
     * @throws IllegalArgumentException se il simbolo è vuoto
     */
    public ElementoChimico prendiElemento(String simbolo) {
        Objects.requireNonNull(simbolo, "Il simbolo non può essere null");
        if (simbolo.length() == 0)
            throw new IllegalArgumentException("Il simbolo non può essere null");

        for (ElementoChimico e : tavola) {
            if (e.Simbolo().equals(simbolo))
                return e;
        }
        throw new NoSuchElementException("Il simbolo non è presente");
    }

    @Override
    public Iterator<ElementoChimico> iterator() {
        return Arrays.asList(tavola).iterator();

    }
}
