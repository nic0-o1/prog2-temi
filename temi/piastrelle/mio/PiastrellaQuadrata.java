package mio;

/**
 * OVERVIEW: {@code PiastrellaQuadrata} modella una piastrella di dimensioni quadrate, è immutabile
 */
public class PiastrellaQuadrata extends AbsPiastrella{

    private final int lato;

    /**
    * AF:
    * IR: lato > 0 
    */

    /**
     * Costruisce una nuova piastrella quadrata a partire da un lato e costo forniti
     * 
     * @param lato il lato
     * @param costo il costo
     * @throws IllegalArgumentException se il costo o il lato sono <= 0
     */
    public PiastrellaQuadrata(final int lato, final int costo){
        super(costo);
        if(lato <= 0) throw new IllegalArgumentException("Il lato deve essere > di 0");
        this.lato = lato;
    }

    @Override
    public int superficie() {
        return lato * lato;
    }
    
}
