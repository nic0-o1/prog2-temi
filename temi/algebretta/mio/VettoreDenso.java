package mio;

import java.util.Arrays;
import java.util.Objects;

/**Rappresentazione concreta di un vettore denso */
public class VettoreDenso implements Vettore {

    /**I valori del vettore */
    private final int[] values;

     // AF: l'i-esimo valore del vettore corrisponde all'i-esimo valore dell'array.
     // RI: val non è null ed ha almeno un elemento.

    /**
     * Genera un vettore a partire da un array
     * @param values l'array iniziale
     * @throws IllegalArgumentException se la dimensione dell'array e <= 0
     */
    public VettoreDenso(int[] values) {
        Objects.requireNonNull(values,"L'array non può essere null");
        if(values.length <= 0)  throw new IllegalArgumentException("La dimensione non può essere <= 0");
        this.values = values.clone();
    }

    /**
     * Costruisce un vettore della dimensione data con tutti i valori pari a 0
     * @param dim la dimensione data
     * @throws IllegalArgumentException se la dimensione è <= 0
     */
    public VettoreDenso(int dim){
        if(dim <= 0) throw new IllegalArgumentException("La dimensione non può essere <= 0");
        values = new int[dim];
    }

    @Override
    public int dim() {
        return values.length;
    }

    @Override
    public int val(int i) {
        if( i < 0 || i >= this.dim()) throw new IndexOutOfBoundsException("L'indice eccede le dimensioni del vettore");
        return values[i];
    }

    @Override
    public Vettore per(int alpha) {
        final VettoreDenso res = new VettoreDenso(this.dim());
        for(int i = 0; i < this.dim(); i++) res.values[i] = this.values[i] * alpha;
        return res;
    }

    @Override
    public Vettore più(Vettore v) {
        Objects.requireNonNull(v, "Il vettore non può essere null");
        if(!Conforme(v)) throw new IllegalArgumentException("La dimensione deve essere la medesima");
        final VettoreDenso res = new VettoreDenso(this.dim());
        for (int i = 0; i < values.length; i++) res.values[i] = values[i] + v.val(i);
        return res;
    }

    @Override
    public String toString() {
        return Arrays.toString(values).replace("[", "(").replace("]", ")");
  }
}