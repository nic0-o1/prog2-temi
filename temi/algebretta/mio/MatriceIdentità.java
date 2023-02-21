package mio;

import java.util.Objects;


public class MatriceIdentità extends AbsMatrice{

    /**Dimensione della matrice */
    private final int dim;

    /**
     * AF: matrice identità di dimensione dim
     * RI: dim > 0
     */

    /**
     * Costruisce una matrice identità della dimensione fornita
     * @param dim la dimensione fornita
     * @throws IllegalArgumentException se la dimensione è <= 0
     */
    public MatriceIdentità(int dim) {
        if(dim <= 0) throw new IllegalArgumentException("La dimensione deve essere > di 0");
        this.dim = dim;
    }

    @Override
    public int dim() {
        return dim;
    }

    @Override
    public int val(int i, int j) throws IndexOutOfBoundsException {
        validIJ(i, j);
        return i == j ? 1 : 0;
    }
    
    @Override
    public Matrice per(int alpha) {
        if(alpha == 0) return new MatriceNulla(this.dim());
        int values[] = new int[this.dim()];
        for(int i = 0; i< this.dim(); i++) values[i] = alpha;
        return new MatriceDiagonale(values);
    }

    @Override
    public Matrice per(Matrice m) throws NullPointerException, IllegalArgumentException {
        Objects.requireNonNull(m, "La matrice non può essere null");
        if(!Conforme(m)) throw new IllegalArgumentException("Le matrici devono essere conformi");
        return m;
        
    }

    @Override
    public Matrice più(Matrice m) throws NullPointerException, IllegalArgumentException {
        Objects.requireNonNull(m, "La matrice non può essere null");
        if(!Conforme(m)) throw new IllegalArgumentException("Le matrici devono essere conformi");
        if(m instanceof MatriceNulla) return this;
        return new MatriceDensa(this).più(m);
    }

    @Override
    public Vettore per(Vettore v) throws NullPointerException, IllegalArgumentException {
        Objects.requireNonNull(v,"Il vettore non può essere null");
        if(!Conforme(v)) throw new IllegalArgumentException("Il vettore deve essere conforme");
        return v;
    }
    
}
