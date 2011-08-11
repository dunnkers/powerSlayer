package org.powerbot.powerslayer.data;

import org.rsbot.script.wrappers.Area;
import org.rsbot.script.wrappers.Tile;

public enum Banks {
    VARROCK_EAST(new Area(new Tile(3258, 3424), new Tile(3249, 3415), 0)),
    VARROCK_WEST(new Area(new Tile(3195, 3447), new Tile(3178, 3431), 0)),
    SEERS(new Area(new Tile(2731, 3495), new Tile(2719, 3487), 0)),
    EAST_FALADOR(new Area(new Tile(3022, 3359), new Tile(3007, 3351), 0)),
    WEST_FALADOR(new Area(new Tile(2949, 3374), new Tile(2941, 3365), 0)),
    DRAYNOR(new Area(new Tile(3098, 3247), new Tile(3087, 3238), 0)),
    NORTH_ARDOUGNE(new Area(new Tile(2622, 3337), new Tile(2611, 3328), 0)),
    SOUTH_ARDOUGNE(new Area(new Tile(2660, 3288), new Tile(2648, 3279), 0)),
    YANNILLE(new Area(new Tile(2617, 3098), new Tile(2607, 3087), 0)),
    EDGEVILLE(new Area(new Tile(3099, 3500), new Tile(3089, 3487), 0)),
    AL_KHARID(new Area(new Tile(3273, 3174), new Tile(3263, 3160), 0)),
    GRAND_EXCHANGE(new Area(new Tile(3171, 3494), new Tile(3159, 3485), 0)),
    CASTLE_WARS(new Area(new Tile(2444, 3087), new Tile(2442, 3083), 0)),
    PORT_PHASMATYS(new Area(3686, 3466, 3691, 3471)),
    MOS_LE_HARMLESS(new Area(3679, 2980, 3680, 2984)),
    MOS_LE_HARMLESS_DEPOSIT_BOX(new Area(3810, 3020, 3817, 3024), true),
    CANAFIS(new Area(3508, 3475, 3516, 3483)),
    BURGH_DE_ROTT(new Area(3495, 3210, 3500, 3213)),
    LUMBRIDGE(new Area(new Tile(3207, 3217), new Tile(3210, 3220), 2)),
    CULINAROMANCERS_CHEST(new Area(3208, 9615, 3219, 9625)),
    DORGESH_KAAN(new Area(2701, 5345, 2706, 5354)),
    LLETYA(new Area(2351, 3161, 2354, 3164));
    // TODO add a lot more banks.

    private Area area;
    private boolean isDepositBox = false;

    private Banks(Area area) {
        this.area = area;
    }

    private Banks(Area area, boolean isDepositBox) {
        this.area = area;
        this.isDepositBox = isDepositBox;
    }

    public Area getArea() {
        return this.area;
    }

    public boolean isDepositBox() {
        return isDepositBox;
    }

    public int getPlane() {
        return area.getPlane();
    }

    public boolean containsTile(Tile tile) {
        return this.area.contains(tile);
    }
}