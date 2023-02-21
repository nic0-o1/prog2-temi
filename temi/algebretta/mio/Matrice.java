package mio;

/**Interfaccia che descrive il contratto di una matrice quadrata immutabile di interi */
public interface Matrice {
    /**
     * Restituisce la dimensione della matrice (sempre > 0)
     * @return la dimensione della matrice
     */
    int dim();

    /**
     * Restiituisce il valore della i,j-esima componente della matrice
     * @param i indice i-esima componente
     * @param j indice j-esima componente
     * @return  valore dell'i-j-esima componente
     * @throws IndexOutOfBoundsException se almeno uno degli indici è < di 0 o eccede la dimensione della matrice
     */
    int val(final int i,final int j) throws IndexOutOfBoundsException;

    /**
     * Restituisce una nuova matrice ottenuta dalla moltiplicazione dell'attuale matrice per uno scalare
     * @param alpha lo scalare
     * @return la nuova matrice
     */
    Matrice per(final int alpha);

    /**
     * Restituisce una nuova matrice ottenuta dalla moltiplicazione dell'attuale matrice per la matrice passata
     * @param m la matrice
     * @return la nuova matrice
     * @throws NullPointerException se la matrice passata è {@code null}
     * @throws IllegalArgumentException se la matrice passata non è conforme
     */
    Matrice per(final Matrice m) throws NullPointerException, IllegalArgumentException;

    /**
     * Restituisce il vettore ottenuto moltiplicando questa matrice per il vettore dato.
     *
     * @param v il vettore.
     * @return il risultato.
     * @throws NullPointerException se il vettore è {@code null}.
     * @throws IllegalArgumentException se le matrice e il vettore non sono confrmi.
     */
    Vettore per(final Vettore v) throws NullPointerException, IllegalArgumentException;

    /**
     * Restituisce una nuova matrice ottenuta dalla somma dell'attuale matrice per la matrice passata
     * @param m la matrice
     * @return la nuova matrice
     * @throws NullPointerException se la matrice passata è {@code null}
     * @throws IllegalArgumentException se la matrice passata non è conforme
     */
    Matrice più(final Matrice m) throws NullPointerException, IllegalArgumentException;

    /**
     * Ritorna {@code true} sse la dimensione della matrice passata è uguale a quella dell'attuale matrice
     * @param m la matrice passata
     * @return {@code true} se le dimensioni coincidono
     * @throws NullPointerException se la matrice passata è {@code null}
     */
    default boolean Conforme(final Matrice m) throws NullPointerException{
        return m.dim() == dim();
    }

    default boolean Conforme(final Vettore v) throws NullPointerException {
        return v.dim() == dim();
    }

    /**
     * Verifica sei gli indici forniti siano validi
     * @param i primo indice
     * @param j secondo indice
     * @throws IndexOutOfBoundsException se gli indici non sono validi
     */
    default void validIJ(final int i, final int j) throws IndexOutOfBoundsException{
        if(i >= 0 && i < dim() && j >= 0 &&  j < dim()) return;
        throw new IndexOutOfBoundsException("Almeno uno degli indici non è valido");

    }

}
