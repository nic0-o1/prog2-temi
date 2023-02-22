package mio;

/**
 * OVERVIEW: {@code PiastrellaTriangolare} modella una piastrella di dimensioni triangolari caratterizzata
 * da un costo e dalla dimensione della base e dell'altezza
 */
public class PiastrellaTriangolare extends AbsPiastrella{

    private final int base;
    private final int altezza;

    /**
     * IR: base,altezza e costo > di 0
    */

    /**
     * Costruisce una nuova piastrella triangolare a partire da un costo, base e
     * altezza forniti
     * 
     * @param costo il costo
     * @param base la base
     * @param altezza l'altezza
     * @throws IllegalArgumentException se il costo o la base o l'altezza non <= di 0
     */
    public PiastrellaTriangolare(int costo, int base, int altezza) {
        super(costo);
        if(base <= 0) throw new IllegalArgumentException("La base deve essere > di 0");
        if(altezza <= 0) throw new IllegalArgumentException("L'altezza deve essere > di 0");

        this.base = base;
        this.altezza = altezza;
    }


    @Override
    public int superficie() {
        return (base*altezza)/2;
    }
    
}
