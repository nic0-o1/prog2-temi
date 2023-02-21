package mio;

import java.util.Objects;

public class MatriceNulla extends AbsMatrice{

    private final int dim;

    // AF: è la matrice nulla di dimensione pari a dim
    // RI: dim > 0

    /**
     * Costruisce una matrice nulla data la sua dimensione.
     *
     * @param dim la dimensione.
     * @throws IllegalArgumentException se la dimensione non è positiva.
     */
    public MatriceNulla(final int dim) {
        if (dim <= 0) throw new IllegalArgumentException("La dimensione deve essere positiva.");
        this.dim = dim;
    }

    @Override
    public int dim() {
        return dim;
    }

    @Override
    public int val(int i, int j) throws IndexOutOfBoundsException {
        validIJ(i, j);
        return 0;
    }

    @Override
    public Matrice per(int alpha) {
        return this;
    }

    @Override
    public Matrice per(Matrice m) throws NullPointerException, IllegalArgumentException {
        Objects.requireNonNull(m, "La matrice non può essere null");
        if(!Conforme(m)) throw new IllegalArgumentException("Le matrici devono essere conformi");
        return this;
    }

    @Override
    public Matrice più(Matrice m) throws NullPointerException, IllegalArgumentException {
        Objects.requireNonNull(m,"La matrice non può essere null");
        if(!Conforme(m)) throw new IllegalArgumentException("Le due matrici devono essere conformi");
        return m;
    }

    @Override
    public Vettore per(Vettore v) throws NullPointerException, IllegalArgumentException {
        Objects.requireNonNull(v,"Il vettore non può essere null");
        if(!Conforme(v)) throw new IllegalArgumentException("Il vettore deve essere conforme");
        return new VettoreNullo(this.dim());
    }
    
}
