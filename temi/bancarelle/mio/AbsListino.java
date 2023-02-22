package mio;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * OVERVIEW: {@code AbsListino} classe astratta immutabile che rappresenta i listini
 */
public abstract class AbsListino  implements Listino{

    private final HashMap<Giocattolo, Integer> listino;

    /**
     * AF: Un listino è rappresentato da una collezioni di giocattoli con il rispettivo prezzo
     * RI: per ogni Giocattolo presente il prezzo deve essere > 0 e diverso da null
     */

    /**
     * Costruisce un nuovo listino a partire da una mappa di giocattoi e quantità
     * 
     * @param listino la mappa
     * @throws NullPointerException se il listino o il giocattolo o la quantità sono null
     * @throws IllegalArgumentException se la quantità è <= a 0
     */

    public AbsListino(HashMap<Giocattolo, Integer> listino) {
        this.listino = new HashMap<Giocattolo,Integer>();
        Objects.requireNonNull(listino,"Il listino non può essere null");
        for (Giocattolo giocattolo : listino.keySet()) {
            final Giocattolo res = Objects.requireNonNull(giocattolo, "Il giocattolo non può essere null");
            final Integer num = Objects.requireNonNull(listino.get(giocattolo), "La quantità non può essere null");
            if(num <= 0) throw new IllegalArgumentException("La quantità deve essere > di 0");
            this.listino.put(res, num);
        }
    }

    /**
     * Restituisce il prezzo unitario del {@code Giocattolo} fornito
     * 
     * @param giocattolo il giocattolo
     * @return il suo prezzo unitario
     * @throws NullPointerException se giocattolo è null
     * @throws NoSuchElementException se il giocattolo non è presente
     */
    public int prezzoUnitario(Giocattolo giocattolo){
        Objects.requireNonNull(giocattolo, "Il giocattolo non può essere null");
        if(listino.containsKey(giocattolo))
            return listino.get(giocattolo);
        throw new NoSuchElementException("Giocattolo non noto nel listino");
    }

    @Override
    public boolean conosce(Giocattolo giocattolo) {
        return listino.containsKey(giocattolo);
    }

    @Override
    public abstract int prezzoTotale(int tot, Giocattolo giocattolo);
    
}
