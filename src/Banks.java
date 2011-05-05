import org.rsbot.script.wrappers.RSArea;
import org.rsbot.script.wrappers.RSTile;

enum Banks {
	VARROCK_EAST(new RSArea(new RSTile(3258, 3424), new RSTile(3249, 3415), 0)),
	VARROCK_WEST(new RSArea(new RSTile(3195, 3447), new RSTile(3178, 3431), 0)),
	SEERS(new RSArea(new RSTile(2731, 3495), new RSTile(2719, 3487), 0)),
	EAST_FALADOR(new RSArea(new RSTile(3022, 3359), new RSTile(3007, 3351), 0)),
	WEST_FALADOR(new RSArea(new RSTile(2949, 3374), new RSTile(2941, 3365), 0)),
	DRAYNOR(new RSArea(new RSTile(3098, 3247), new RSTile(3087, 3238), 0)),
	NORTH_ARDOUGNE(new RSArea(new RSTile(2622, 3337), new RSTile(2611, 3328), 0)),
	SOUTH_ARDOUGNE(new RSArea(new RSTile(2660, 3288), new RSTile(2648, 3279), 0)),
	YANNILLE(new RSArea(new RSTile(2617, 3098), new RSTile(2607, 3087), 0)),
	EDGEVILLE(new RSArea(new RSTile(3099, 3500), new RSTile(3089, 3487), 0)),
	AL_KHARID(new RSArea(new RSTile(3273, 3174), new RSTile(3263, 3160), 0)),
	GRAND_EXCHANGE(new RSArea(new RSTile(3171, 3494), new RSTile(3159, 3485), 0)),
	CASTLE_WARS(new RSArea(new RSTile(2444, 3087), new RSTile(2442, 3083), 0)),
	PORT_PHASMATYS(new RSArea(3686, 3466, 3691, 3471)),
	MOS_LE_HARMLESS(new RSArea(3679, 2980, 3680, 2984)),
	MOS_LE_HARMLESS_DEPOSIT_BOX(new RSArea(3810, 3020, 3817, 3024), true),
	CANAFIS(new RSArea(3508, 3475, 3516, 3483)),
	BURGH_DE_ROTT(new RSArea(3495, 3210, 3500, 3213)),
	LUMBRIDGE(new RSArea(new RSTile(3207, 3217), new RSTile(3210, 3220), 2)),
	CULINAROMANCERS_CHEST(new RSArea(3208, 9615, 3219, 9625)),
	DORGESH_KAAN(new RSArea(2701, 5345, 2706, 5354)),
	LLETYA(new RSArea(2351, 3161, 2354, 3164));
	// TODO add a lot more banks.

	private RSArea area;
	private boolean isDepositBox = false;

	private Banks(RSArea area) {
		this.area = area;
	}

	private Banks(RSArea area, boolean isDepositBox) {
		this.area = area;
		this.isDepositBox = isDepositBox;
	}

	public RSArea getRSArea() {
		return this.area;
	}

	public boolean isDepositBox() {
		return isDepositBox;
	}

	public int getPlane() {
		return area.getPlane();
	}

	public boolean containsTile(RSTile tile) {
		return this.area.contains(tile);
	}

}
