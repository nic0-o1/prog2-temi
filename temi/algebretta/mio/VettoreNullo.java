package mio;

import java.util.Collections;
import java.util.Objects;

public class VettoreNullo implements Vettore{

    /**La dimensione del vettore nullo */
    private final int dim;

    /**
     * AF: vettore nullo di dimensione dim
     * RI: dim > 0 
     */

    /**
     * Costruice un nuovo vettore nullo della dimensione fornita
     * @param dim la dimensione
     * @throws IllegalArgumentException se la dimensione è <= 0
     */
    public VettoreNullo(int dim) {
        if(dim <= 0) throw new IllegalArgumentException("La dimensione deve essere > di 0");
        this.dim = dim;
    }

    @Override
    public int dim() {
        return  dim;
    }

    @Override
    public int val(int i) {
        if( i < 0 || i >= this.dim()) throw new IndexOutOfBoundsException("L'indice eccede le dimensioni del vettore");
        return 0;
    }
    @Override
    public Vettore per(int alpha) {
        return this;
    }

    @Override
    public Vettore più(Vettore v) {
        Objects.requireNonNull(v, "Il vettore non può essere null");
        if(!Conforme(v)) throw new IllegalArgumentException("Vettore non conforme");
        return v;
    }

    @Override
    public String toString() {
        return Collections.nCopies(dim, "0").toString().replace("[", "(").replace("]", ")");
  }
}
