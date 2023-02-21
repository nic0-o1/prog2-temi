package temi.EquazioniChimiche;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Soluzione {
    public static void main(String[] args) {
        List<ElementoChimico> elems = new ArrayList<ElementoChimico>();
        int tot = 1;
        try(Scanner scanner = new Scanner(System.in)){
            while(scanner.hasNext()){
                String[] values = scanner.nextLine().split(" ");
                float peso = Float.parseFloat(values[2]);
                elems.add(new ElementoChimico(values[0], values[1], peso, tot));
                tot++;
            }
        }

        TavolaPeriodica tavolaPeriodica = new TavolaPeriodica(elems);
        try {
            Molecola molecola = new Molecola(args[0], tavolaPeriodica);
            System.out.println(molecola.toString());
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}
