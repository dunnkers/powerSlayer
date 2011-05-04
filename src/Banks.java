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
    GRAND_EXCHANGE(new RSArea(new RSTile(3171, 3494), new RSTile(3159, 3485), 0));
    // TODO add a lot more banks.

    private RSArea area;

    private Banks(RSArea area) {
        this.area = area;
    }

    public RSArea getRSArea() {
        return this.area;
    }

    public int getPlane() {
        return area.getPlane();
    }

    public boolean containsTile(RSTile tile) {
        return this.area.contains(tile);
    }

}