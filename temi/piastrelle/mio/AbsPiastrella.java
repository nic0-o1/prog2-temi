package mio;

/**
 * OVERVIEW: {@code AbsPiastrella}, classe astratta che modella una piastrella immutabile
 */
public abstract class AbsPiastrella implements Piastrella {
    private final int costo;

    /**
     * AF:
     * IR: superficie e costo > di 0
     */

    /**
     * Costruisce una nuova piastrella a partire dal costo indicato
     * 
     * @param costo il costo
     * @throws IllegalArgumentException se costo è <= di 0
     */
    public AbsPiastrella(final int costo) {
        if(costo <=0) throw new IllegalArgumentException("Il costo deve essere > di 0");
        this.costo = costo;
    }

    @Override
    public int costo() {
        return costo;
    }
    
}
