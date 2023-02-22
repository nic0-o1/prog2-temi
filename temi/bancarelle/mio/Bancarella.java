package mio;

import java.util.Objects;

/**
 * OVERVIEW: {@code Bancarella} modella una bancarella formata da un proprietario,
 * un insieme di giocattoli che espone e un listino di prezzi. Le bancarelle di distingueranno
 * in base al nome del prorietario
 */
public class Bancarella {

    private final String proprietario;
    private final Inventario inventario;
    private final Listino listino;

    /**
     * IR: attributi non sono null, proprietario non vuoto e il listino conosce il prezzo di ogni elemento nell'inventario
     */

    /**
     * Costruisce una nuova bancarella a partire dal nome del proprietario, l'inventario dei suoi giocattoli
     * e il listino corrispondente
     * 
     * @param proprietario il proprietario
     * @param inventario l'inventario
     * @param listino il listino
     * @throws NullPointerException se proprietario o inventario o listino sono null
     * @throws IllegalArgumentException se il proprietario è vuoto o se il listino non conosce dei prezzi di 
     * giocattoli nell'inventario
     */

    public Bancarella(final String proprietario, final Inventario inventario, final Listino listino) {
        Objects.requireNonNull(proprietario, "Il proprietatio non può essere null");
        Objects.requireNonNull(inventario, "L' inventario non può essere null");
        Objects.requireNonNull(listino, "Il listino non può essere null");

        if(proprietario.isEmpty()) throw new IllegalArgumentException("Il proprietario non può essere vuoto");

        for (Giocattolo giocattolo : inventario) {
            if(!listino.conosce(giocattolo)) 
                throw new IllegalArgumentException("Prezzo di "+ giocattolo.toString() + " non noto");
        }

        this.proprietario = proprietario;
        this.inventario = inventario;
        this.listino = listino;
    }
    
}
