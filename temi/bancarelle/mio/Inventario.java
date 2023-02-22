package mio;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * OVERVIEW: {@code Inventario} modella un inventario di giocattoli, è mutabile
 */
public class Inventario implements Iterable<Giocattolo>{
    private final HashMap<Giocattolo, Integer> inventario = new HashMap<Giocattolo,Integer>();

    /**
     * AF: Un {@code Inventario} è una collezione di giocattoli con la rispetttiva quantià a disposizione
     * IR: inventario != null e per ogni giocattolo presente la quantità deve essere > 0
     */

     /**
      * Permette di aggiungere all'inventario un nuovo giocattolo con la rispettiva quantità
      * @param quantità la quantità
      * @param giocattolo il giocattolo
      * @throws NullPointerException se giocattolo è null
      * @throws IllegalArgumentException se quantitò è <= di 0
      */
     public void aggiungi(int quantità, Giocattolo giocattolo){
        Objects.requireNonNull(giocattolo, "Il giocattolo non può essere null");

        if(quantità <= 0) throw new IllegalArgumentException("La quantità deve essere > di 0");

        if(inventario.containsKey(giocattolo))
            inventario.put(giocattolo, inventario.get(giocattolo) + quantità);
        else
            inventario.put(giocattolo, quantità);
        
     }

     /**
   * Rimuove (se possibile) il numero indicato di giocattoli di un certo tipo dall'inventario.
   *
   * @param num il numero di giocattoli da rimuovere.
   * @param giocattolo il giocattolo da rimuovere.
   * @return il numero rimanente di giocattoli del tipo appena rimosso ancora presenti
   *     nell'inventario.
   * @throws NullPointerException se il giocattolo è {@code null}.
   * @throws IllegalArgumentException se il numero non è positivo, o eccede il numero di giocattoli
   *     di quel tipo presenti nell'inventario.
   */
  public int rimuovi(final int num, final Giocattolo giocattolo) {
    Objects.requireNonNull(giocattolo, "Il giocattolo non può essere null.");
    if (num <= 0) throw new IllegalArgumentException("Il numero deve essere positivo");
    if (!inventario.containsKey(giocattolo))
      throw new NoSuchElementException("Giocattolo non presente: " + giocattolo);
    final int totale = inventario.get(giocattolo) - num;
    if (totale < 0)
      throw new IllegalArgumentException("Non ci sono abbastanza giocattoli: " + giocattolo);
    if (totale == 0) inventario.remove(giocattolo);
    else inventario.put(giocattolo, totale);
    return totale;
  }

     /**
   * Restituisce il numero di giocattoli del tipo indicato presenti nell'inventario.
   *
   * @param giocattolo il giocattolo.
   * @return il numero di giocattoli di tale tipo presenti nell'inventario, (eventualmente 0 se
   *     l'inventario non contiene il giocattolo indicato).
   * @throws NullPointerException se giocattolo è {@code null}
   */
  public int quantità(final Giocattolo giocattolo) {
    Objects.requireNonNull(giocattolo, "Il giocattolo non può essere null.");
    if (!inventario.containsKey(giocattolo)) return 0;
    return inventario.get(giocattolo);
  }

  @Override
  public Iterator<Giocattolo> iterator() {
    final List<Giocattolo> giocattoli = new ArrayList<>(inventario.keySet());
    Collections.sort(
        giocattoli,
        new Comparator<Giocattolo>() {
          @Override
          public int compare(Giocattolo o1, Giocattolo o2) {
            return o1.toString().compareTo(o2.toString());
          }
        });
    return giocattoli.iterator();
  }
}
