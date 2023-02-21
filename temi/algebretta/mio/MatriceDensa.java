package mio;

import java.util.Objects;

public class MatriceDensa extends AbsMatrice{

    private final int[][] values;

    /**
     * Costruisce una nuova matrice a partire da un array bi-dimensionale
     * @param values l'array bi-dimensionale
     * @throws IllegalArgumentException se l'array è {@code null} o una delle sue righe ha un numero
     * di elementi divrso da quello delle altre righe, o il numero di righe è zero.
     */
    public MatriceDensa(int[][] values) {
        Objects.requireNonNull(values, "la matrice non può essere null");
        if(values.length == 0) throw new IllegalArgumentException("La matrice non può essere vuota");
        final int dim = values.length;
        this.values = new int[dim][dim];
        for(int i = 0; i < dim; i++){
            if(values[i].length != dim) throw new IllegalArgumentException("La matrice deve essere quadrata");
            for(int j = 0; j < dim; j++) this.values[i][j] = values[i][j];   
        }
    }

    /**
     * Costruisce una nuova matrice della dimensione passata con tutti i valori pari a 0
     * @param dim la dimenzione
     * @throws IllegalArgumentException se la dimensione è <= a 0
     */
    private MatriceDensa(int dim){
        if(dim <= 0) throw new IllegalArgumentException("La dimensione deve essere > 0");
        this.values = new int[dim][dim];
    }

    /**
   * Costruisce una matrice copiando i valori di una matrice data.
   *
   * @param A la matrice.
   * @throws IllegalArgumentException se la matrice è {@code null}.
   */
  public MatriceDensa(final Matrice A) {
    this(Objects.requireNonNull(A, "La matrice non può essere null.").dim());
    for (int i = 0; i < dim(); i++) for (int j = 0; j < dim(); j++) values[i][j] = A.val(i, j);
  }

    @Override
    public int dim() {
        return values.length;
    }

    @Override
    public int val(int i, int j) throws IndexOutOfBoundsException {
        validIJ(i, j);
        return values[i][j];
    }

    @Override
    public Matrice per(int alpha) {
        final MatriceDensa res = new MatriceDensa(this.dim());
        for(int i = 0; i < this.dim(); i++){
            for(int j = 0; j < this.dim(); j++) res.values[i][j] = this.values[i][j] * alpha;
        }
        return res;
    }

    @Override
    public Matrice per(Matrice m) throws NullPointerException, IllegalArgumentException {
        Objects.requireNonNull(m, "La matrice non può essere null");
        if(!Conforme(m)) throw new IllegalArgumentException("Le due matrici devono essere conformi");
        MatriceDensa res = new MatriceDensa(this.dim());
        for (int i = 0; i < dim(); i++)
            for (int j = 0; j < dim(); j++)
                for (int k = 0; k < dim(); k++) res.values[i][j] += this.values[i][k] * m.val(k, j);
        return res;
    }

    @Override
    public Matrice più(Matrice m) throws NullPointerException, IllegalArgumentException {
        Objects.requireNonNull(m,"La matrice non può essere null");
        if(!Conforme(m)) throw new IllegalArgumentException("Le due matrici devono essere conformi");
        final MatriceDensa res = new MatriceDensa(this.dim());
        for(int i = 0; i < this.dim(); i++){
            for(int j = 0; j < this.dim(); j++) res.values[i][j] = this.values[i][j] + m.val(i, j);
        }
        return res;
    }

    @Override
    public Vettore per(Vettore v) throws NullPointerException, IllegalArgumentException {
        Objects.requireNonNull(v,"Il vettore non può essere null");
        if(!Conforme(v)) throw new IllegalArgumentException("Il vettore deve essere conforme");
        final int[] temp = new int[values.length];
        for (int i = 0; i < values.length; i++)
            for (int j = 0; j < values.length; j++) temp[i] += values[i][j] * v.val(j);
        return new VettoreDenso(temp);
    }
    
}
