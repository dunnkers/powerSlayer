import org.rsbot.script.methods.Magic;

enum TeleportType {
    HOME_SPELL(Magic.SPELL_HOME_TELEPORT),
    VARROCK_SPELL(
            Magic.SPELL_VARROCK_TELEPORT),
    LUMBRIDGE_SPELL(
            Magic.SPELL_LUMBRIDGE_TELEPORT),
    FALADOR_SPELL(
            Magic.SPELL_FALADOR_TELEPORT),
    ARDOUGNE_SPELL(
            Magic.SPELL_ARDOUGNE_TELEPORT),
    TAB("Break"),
    OTHER();

    private boolean isSpell;
    private int magicSpell;
    private String action;

    // default to the home teleport spell (realistically should never be
    // used though)
    private TeleportType() {
        this(true, Magic.SPELL_HOME_TELEPORT, "");
    }

    private TeleportType(int spell) {
        this(true, spell, null);
    }

    private TeleportType(String action) {
        this(false, 0, null);
    }

    private TeleportType(boolean isSpell, int spell, String action) {
        this.isSpell = isSpell;
        this.magicSpell = spell;
        this.action = action;
    }

    public boolean isSpell() {
        return isSpell;
    }

    public int getSpell() {
        return magicSpell;
    }

    public String getAction() {
        return action;
    }
}