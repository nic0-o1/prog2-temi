package mio;

import java.util.NoSuchElementException;

/**
 * 
 * OVERVIEW: {@code Listino} modella un listino di giocattoli, indici il prezzo complessivo di un certo numero di 
 * giocattoli e se lo conosce il prezzo di un singolo giocattolo
 */
public interface Listino {
    /**
     * Indica se il listino conosce il giocattolo fornito
     * 
     * @param giocattolo il giocattolo
     * @return {@code true} se il giocattolo è presente
     */
    public boolean conosce(final Giocattolo giocattolo);

    /**
     * Indica il prezzo di un certo numero di giocattoli di un dato tipo
     * 
     * @param tot il numero di giocattoli
     * @param giocattolo il giocattolo
     * @return il prezzo totale
     * @throws NullPointerException se giocattolo è null
     * @throws IllegalArgumentException se la quantità è <= 0
     * @throws NoSuchElementException se il giocattolo non è presente nel listino
     */
    public int prezzoTotale(final int tot, final Giocattolo giocattolo);
}
