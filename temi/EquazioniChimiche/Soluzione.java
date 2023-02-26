
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Soluzione {
    public static void main(String[] args) {
        List<ElementoChimico> elems = new ArrayList<ElementoChimico>();
        int tot = 1;
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] tokens = line.split("\t");
            Float peso = Float.parseFloat(tokens[2]);
            elems.add(new ElementoChimico(tokens[0], tokens[1], peso, tot));
            tot++;
        }
        in.close();

        TavolaPeriodica tavolaPeriodica = new TavolaPeriodica(elems);
        try {
            Molecola molecola = new Molecola(args[0], tavolaPeriodica);
            System.out.println(molecola.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
