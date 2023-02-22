package mio;

import java.util.HashMap;

/**
 * OVERVIEW: {@code ListinoNormale} modella un listino cui prezzi sono i medesimi riportati
 * senza sconto alcuno
 */
public class ListinoNormale extends AbsListino {

    /**
     * Costruisce un listino a partire da una mappa di giocattoli, quantità
     * 
     * @param listino la mappa
     */
    public ListinoNormale(HashMap<Giocattolo, Integer> listino) {
        super(listino);
    }

    @Override
    public int prezzoTotale(int tot, Giocattolo giocattolo) {
        if(tot <= 0) throw new IllegalArgumentException("La quantitò deve essere > di 0");
        return prezzoUnitario(giocattolo) * tot;
    }

}