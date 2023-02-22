package mio;

/**
 * OVERVIEW: {@code Piastrella} interfaccia che descrive una piastrella
 */
public interface Piastrella {

    /**
     * Restituisce il costo della piastrella corrente
     * @return il costo, sempre > di 0
     */
    int costo();

    /**
     * Restituisce la superficie della piastrella
     * @return la superficie, sempre > di 0
     */
    int superficie();
}
