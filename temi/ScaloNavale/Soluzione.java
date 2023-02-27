
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Soluzione {
	public static void main(String[] args) {

		int tot;
		List<Molo> moli;
		try (Scanner scanner = new Scanner(System.in)) {
			tot = Integer.parseInt(scanner.nextLine());
			moli = new ArrayList<Molo>();
			while (scanner.hasNextLine()) {
				String navi[] = scanner.nextLine().split(" ");
				Molo m = new Molo();
				for (int i = 0; i < navi.length; i++) {
					m.attracca(new NaveCargo(navi[i], Integer.parseInt(navi[i + 1])));
					i++;
				}
				moli.add(m);
			}
			RimorchiatorePrudente rim = new RimorchiatorePrudente(30);
			ScaloNavale scaloNavale = new ScaloNavale(tot, moli, rim);
			System.out.println(scaloNavale.toString());

			System.out.println(
					scaloNavale.muovi(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2])));

			System.out.println(scaloNavale.toString());

		}

		catch (Exception e) {

		}
	}
}
