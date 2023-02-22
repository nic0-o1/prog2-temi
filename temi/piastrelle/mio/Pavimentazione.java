package mio;

/**
 * OVERVIEW: {@code Pavimentazione} è una classe immutabile che rappresenta una pavimentazione data da una 
 * collezione di {@code Componente} i quali rappresentano una certa quantità di una piastrella o di un'altra paviementazione
 */
public class Pavimentazione implements Piastrella{

    /**
     * OVERVIEW: {@code Rivestimento} modella un componente di una {@code Pavimentazione} ovvero
     * una certa quantità per una data {@code Piastrella}, è immutabile
     */
    public static class Rivestimento implements Piastrella{

        public final Piastrella piastrella;
        public final int quantità;

        /**
         * IR: piastrella non è mai null e quantità è sempre > di 0
         */

        /**
         * Costruis
         * 
         * @param piastrella
         * @param quantità
         */
        public Rivestimento(Piastrella piastrella, int quantità) {
            this.piastrella = piastrella;
            this.quantità = quantità;
        }

        @Override
        public int costo() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'costo'");
        }

        @Override
        public int superficie() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'superficie'");
        }

    }

    @Override
    public int costo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'costo'");
    }

    @Override
    public int superficie() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'superficie'");
    }
    
}
