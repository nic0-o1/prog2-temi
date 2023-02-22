package mio;

import java.util.Objects;

/**
 * OVERVIEW: {@code Giocattolo} modella un giocattolo è immutabile
 */
public class Giocattolo {
    private final String nome;
    private final String materiale;
    
   /**
     * AF: Un {@code Giocattolo} è rappresentato da un nome e un materiale
     * IR: nome e materiale non null e non vuoti, due giocattoli sono uguali se e solo e se 
     * nome e materiale coincidono
     */

     /**
      * Costruisce un nuovo giocattolo a partire da un nome e un materiale
      * @param nome il nome
      * @param materiale il materiale
      * @throws NullPointerException se nome o materiale sono null
      * @throws IllegalArgumentException se nome o materiale sono vuoti
      */
     public Giocattolo(String nome, String materiale) {
        Objects.requireNonNull(nome, "Il nome non può essere null");
        Objects.requireNonNull(materiale, "Il materiale non può essere null");

        if(nome.length() == 0) throw new IllegalArgumentException("Il nome non può essere vuoto");
        if(materiale.length() == 0) throw new IllegalArgumentException("Il materiale non può essere vuoto");

        this.nome = nome;
        this.materiale = materiale;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome,materiale);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Giocattolo)) return false;
        final Giocattolo altro = (Giocattolo)obj;
        return nome == altro.nome && materiale == altro.materiale;
    }


}
