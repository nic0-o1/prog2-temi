package mio;

import java.util.Objects;

public class MatriceDiagonale extends AbsMatrice {

    private final int[] diagonale;

    /**
     * Construisce una matrice diagonale a partire da un array dato'
     * @param diagonale l'array dato
     * @throws IllegalArgumentException new l'array è {@code null}
     */
    public MatriceDiagonale(final int[] diagonale) {
        Objects.requireNonNull(diagonale, "L'array diagonale non può essere null.");
        if (diagonale.length == 0) throw new IllegalArgumentException("La diagonale deve contenere almeno un valore.");
        this.diagonale = diagonale.clone();
    }

    @Override
    public int dim() {
        return diagonale.length;
    }

    @Override
    public int val(int i, int j) throws IndexOutOfBoundsException {
        validIJ(i, j);
        return i == j ? diagonale[i] : 0;
    }

    @Override
    public Matrice per(int alpha) {
        if(alpha == 0) return new MatriceNulla(this.dim());
        int res[] = new int[this.dim()];
        for(int i = 0; i< this.dim(); i++) res[i] = diagonale[i] * alpha;
        return new MatriceDiagonale(res);
    }

    @Override
    public Matrice per(Matrice m) throws NullPointerException, IllegalArgumentException {
        Objects.requireNonNull(m, "La matrice non può essere null");
        if(!Conforme(m)) throw new IllegalArgumentException("Matrici non conformi");
        if(m instanceof MatriceNulla) return new MatriceNulla(this.dim());
        return new MatriceDensa(this).per(m);
    } 

    @Override
    public Matrice più(Matrice m) throws NullPointerException, IllegalArgumentException {
        Objects.requireNonNull(m, "La matrice non può essere null");
        if(!Conforme(m)) throw new IllegalArgumentException("Le matrici non sono conformi");
        if(m instanceof MatriceNulla) return this;
        return new MatriceDensa(this).più(m);
    }

    @Override
    public Vettore per(Vettore v) throws NullPointerException, IllegalArgumentException {
        Objects.requireNonNull(v, "Il vettore non può essere null.");
        if (!Conforme(v)) 
            throw new IllegalArgumentException("Il vettore e la matrice non sono conformi.");
        final int[] temp = new int[diagonale.length];
        for (int i = 0; i < diagonale.length; i++) temp[i] = diagonale[i] * v.val(i);
        return new VettoreDenso(temp);
    }
    
}
