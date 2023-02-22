package mio;


/**
 * OVERVIEW: {@code PiastrellaRomboidale} modella una piastrella di dimensioni romboidali, composta da un costo e dalla
 * dimensione delle due diagonali
 */
public class PiastrellaRomboidale extends AbsPiastrella{

    private final int diagonale1;
    private final int diagonale2;

    /**
     * IR: diagonale1, diagonale2 e costo > di 0
     */

    /**
     * Costruisce una nuova piastrella romboidale a partire da un costo e dalla
     * dimensione delle due diagonali
     * 
     * @param costo il costo
     * @param diagonale1 la prima diagonale
     * @param diagonale2 la seconda diagonale
     * @throws IllegalArgumentException se costo o diagonale1 o diagonale2 sono <= di0
     */
    public PiastrellaRomboidale(int costo, int diagonale1, int diagonale2) {
        super(costo);
        if(diagonale1 <= 0) throw new IllegalArgumentException("La prima diagonale deve essere > di 0");
        if(diagonale2 <= 0) throw new IllegalArgumentException("La seconda diagonale deve essere > di 0");

        this.diagonale1 = diagonale1;
        this.diagonale2 = diagonale2;
    }
    
    @Override
    public int superficie() {
        return(diagonale1 * diagonale2) / 2;
    }
    
}
