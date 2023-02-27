import java.util.Stack;

public class RimorchiatorePrudente implements Rimorchiatore {
	private final int pesoMassimo;

	public RimorchiatorePrudente(int pesoMassimo) {
		this.pesoMassimo = pesoMassimo;
	}

	@Override
	public int muovi(int tot, Molo partenza, Molo arrivo) {
		int viaggi = 0;
		Stack<NaveCargo> temp = new Stack<NaveCargo>();
		NaveCargo p = partenza.salpa();
		temp.push(p);
		int pesoTotale = p.getPeso();
		for (int i = 0; i < tot;) {
			if (pesoTotale + partenza.pesoSalpante() <= pesoMassimo) {
				p = partenza.salpa();
				temp.push(p);
				pesoTotale += p.getPeso();
			} else {
				for (int j = temp.size() - 1; j >= 0; j--) {
					arrivo.attracca(temp.get(j));
					i++;
				}
				temp.clear();
				pesoTotale = 0;
				viaggi++;
			}
		}
		return viaggi;
	}

}
