
/**
 * OVERVIEW: {@code MiniRimorchiatore} modella un {@code Rimorchiatore} che può muovere una sola nave per volta
 */
public enum MiniRimorchiatore implements Rimorchiatore{
	INSTANCE;

	@Override
	public int muovi(int tot, Molo partenza, Molo arrivo) {
		for(int i = 0; i < tot; i++) {
			arrivo.attracca(partenza.salpa());
		}
		return tot;
	}
	
}
