package temi.EquazioniChimiche;

import java.util.Objects;

/**
 * OVERVIEW: {@code ElementoChimico} modella un elemento chimico. è immutabile
 */
public class ElementoChimico implements Comparable<ElementoChimico> {
    private final String nome;
    private final String simbolo;
    private final float peso;
    private final int nAtomico;

    /*
     * AF: Un elemento chimico è rappresentato da un nome, simbolo, peso e numero atomico
     * IR: nome, simboli != null nome e simbolo non vuot peso > 0 e 1<= nAtomico <= 118 e simbolo con solo la prima lettera maiuscola
     */


    /**
      * Costruisce un {@code ElementoChimico} a partire dal nome, simbolo, peso e numero atomico
      * @param nome il nome
      * @param simbolo il simbolo
      * @param peso il peso
      * @param nAtomico il numero atomico
      * @throws IllegalArgumentException se nome o simbolo sono vuoti, peso <= 0, nAtomico <1 e > 118 e simbolo deve avere solo la prima lettere maiscola
      * @throws NullPointerException se nome o simbolo sono {@code null}
      */
    public ElementoChimico(String nome, String simbolo, float peso, int nAtomico) {
        Objects.requireNonNull(nome, "Il nome non può essere null");
        Objects.requireNonNull(simbolo, "Il simbolo non può essere null");

        if(nome.length() == 0) throw new IllegalArgumentException("Il nome non può essere vuoto");
        if(simbolo.length() == 0) throw new IllegalArgumentException("Il simbolo non può essere vuoto");
        if(!Helpers.elementoValido(simbolo)) throw new IllegalArgumentException("Simbolo non valido");

        if(peso <= 0) throw new IllegalArgumentException("Il peso non può essere <= 0");
        if(nAtomico <= 0 || nAtomico > 118) throw new IllegalArgumentException("Numero atomico non compreso tra 1 e 118");

        this.nome = nome;
        this.simbolo = simbolo;
        this.peso = peso;
        this.nAtomico = nAtomico;
    }

    public String Nome() {
        return nome;
    }

    public String Simbolo() {
        return simbolo;
    }

    public float Peso() {
        return peso;
    }

    public int nAtomico() {
        return nAtomico;
    }

    @Override
    public int compareTo(ElementoChimico arg0) {
        return this.Simbolo().compareTo(arg0.Simbolo());
    }
}
