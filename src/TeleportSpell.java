import java.util.HashMap;
import java.util.Map;

import org.rsbot.script.methods.Magic;
import org.rsbot.script.wrappers.RSTile;

enum TeleportSpell implements Teleport {
	LUMBRIDGE_HOME(Magic.SPELL_HOME_TELEPORT, new RSTile(0, 0, 0), 0), VARROCK(
			Magic.SPELL_VARROCK_TELEPORT, new RSTile(0, 0, 0), 25, Rune.FIRE,
			3, Rune.AIR, Rune.LAW), MOBILISING_ARMIES(
			Magic.SPELL_MOBILISING_ARMIES_TELEPORT, new RSTile(0, 0, 0), 10,
			Rune.LAW, Rune.WATER, Rune.AIR), LUMBRIDGE(
			Magic.SPELL_LUMBRIDGE_TELEPORT, new RSTile(0, 0, 0), 31, Rune.LAW,
			Rune.AIR, 3, Rune.EARTH), FALADOR(Magic.SPELL_FALADOR_TELEPORT,
			new RSTile(0, 0), 37, Rune.LAW, Rune.AIR, 3, Rune.WATER), CAMELOT(
			Magic.SPELL_CAMELOT_TELEPORT, new RSTile(0, 0), 45, Rune.LAW,
			Rune.AIR, 5);
	private RSTile loc;
	private int magicLevel;
	private Map<Rune, Integer> runes = new HashMap<Rune, Integer>();
	private int spellNum;
	private Magic.Book book;

	private TeleportSpell(int spellNum, RSTile loc, int magicLevel,
			Rune... runes) {
		this.loc = loc;
		this.book = Magic.Book.MODERN;
		this.spellNum = spellNum;
		this.magicLevel = magicLevel;
		for (Rune r : runes) {
			Integer oldVal = this.runes.get(r);
			this.runes.put(r, (oldVal != null ? oldVal.intValue() : 0) + 1);
		}
	}

	private TeleportSpell(int spellNum, RSTile loc, int magicLevel,
			Object... runes) {
		this.loc = loc;
		this.book = Magic.Book.MODERN;
		this.spellNum = spellNum;
		this.magicLevel = magicLevel;
		for (int i = 0; i < runes.length; i++) {
			if (runes[i] instanceof Rune) {
				Rune rune = (Rune) runes[i];
				int count = 1;
				if (i + 1 < runes.length && runes[i + 1] instanceof Integer) {
					count = ((Integer) runes[i + 1]).intValue();
				}
				Integer old = this.runes.get(rune);
				this.runes
						.put(rune, (old != null ? old.intValue() : 0) + count);
			}
		}
	}

	@Override
	public RSTile getDest() {
		return loc;
	}

	public int getMagicLevel() {
		return magicLevel;
	}

	public int getSpell() {
		return spellNum;
	}

	public Magic.Book getBook() {
		return book;
	}

	public Map<Rune, Integer> getRunes() {
		return runes;
	}

	public int getRuneCount(Rune rune) {
		Integer i = runes.get(rune);
		return i != null ? i.intValue() : 0;
	}
}