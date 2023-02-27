import java.util.Stack;

public enum SuperRimorchiatore implements Rimorchiatore {
	INSTANCE;

	@Override
	public int muovi(int tot, Molo partenza, Molo arrivo) {
		Stack<NaveCargo> tmp = new Stack<NaveCargo>();
		for (int i = 0; i < tot; i++) {
			tmp.push(partenza.salpa());
		}
		for (int i = 0; i < tot; i++) {
			arrivo.attracca(tmp.pop());
		}

		return 1;
	}

}
