package mio;

/*Interfaccia che descrive il contratto di un vettore immutabile di interi */
public interface Vettore {
    /**
     * Restituisce la dimensione del vettore (sempre > 0)
     * @return la dimensione del vettore
     */
    int dim();

    /**
     * Restiituisce il valore della i-esima componente del vettorre
     * @param i indice i-esima componente
     * @return  valore dell'i-esima componente
     * @throws IndexOutOfBoundsException se l'indice è < di 0 o eccede la dimensione del vettore
     */
    int val(final int i);

    /**
     * Restituisce un nuovo vettore ottenuto moltiplicando l'attuale vettore pe uno scalare
     * @param alpha lo scalare
     * @return il nuovo vettore
     */
    Vettore per(final int alpha);

    /**
     * Restituisce un nuovo vettore ottenuto moltiplicando l'attuale vettore un altro vettore
     * @param v l'altro vettore
     * @return il nuovo vettore
     * @throws NullPointerException se il vettore è {@code null}
     * @throws IllegalArgumentException se i due vettori hanno dimensione differente
     */
    Vettore più(final Vettore v);

     /**
      * Restituisce {@code true} sse l'attuale vettore ha la stessa dimensione dell'altro vettore 
      * @param v l'altro vettore
      * @return {code true} sse l'altro vettore ha la stessa dimensione dell'attuale
      * @throws NullPointerException se l'altro vettore è {@code null}
      */
    default boolean Conforme(final Vettore v){
        return dim() == v.dim();
    }

    /**
      * Restituisce {@code true} sse l'attuale vettore ha la stessa dimensione dell'altra matrice 
      * @param m l'altra matrice
      * @return {code true} sse l'altra matricre ha la stessa dimensione del vettore attuale
      * @throws NullPointerException se la matrice è {@code null}
      */
      default boolean Conforme(final Matrice m){
        return dim() == m.dim();
    }

}