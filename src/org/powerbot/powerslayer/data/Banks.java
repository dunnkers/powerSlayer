package org.powerbot.powerslayer.data;

import org.rsbot.script.wrappers.Area;
import org.rsbot.script.wrappers.Tile;

public enum Banks {
    VARROCK_EAST (new Area (new Tile (3258, 3424), new Tile (3249, 3415), 0)),
    VARROCK_WEST (new Area (new Tile (3195, 3447), new Tile (3178, 3431), 0)),
    SEERS (new Area (new Tile (2731, 3495), new Tile (2719, 3487), 0)),
    EAST_FALADOR (new Area (new Tile (3022, 3359), new Tile (3007, 3351), 0)),
    WEST_FALADOR (new Area (new Tile (2949, 3374), new Tile (2941, 3365), 0)),
    DRAYNOR (new Area (new Tile (3098, 3247), new Tile (3087, 3238), 0)),
    NORTH_ARDOUGNE (new Area (new Tile (2622, 3337), new Tile (2611, 3328), 0)),
    SOUTH_ARDOUGNE (new Area (new Tile (2660, 3288), new Tile (2648, 3279), 0)),
    YANNILLE (new Area (new Tile (2617, 3098), new Tile (2607, 3087), 0)),
    EDGEVILLE (new Area (new Tile (3099, 3500), new Tile (3089, 3487), 0)),
    AL_KHARID (new Area (new Tile (3273, 3174), new Tile (3263, 3160), 0)),
    GRAND_EXCHANGE (new Area (new Tile (3171, 3494), new Tile (3159, 3485), 0)),
    CASTLE_WARS (new Area (new Tile (2444, 3087), new Tile (2442, 3083), 0)),
    PORT_PHASMATYS (new Area (3686, 3466, 3691, 3471)),
    MOS_LE_HARMLESS (new Area (3679, 2980, 3680, 2984)),
    MOS_LE_HARMLESS_DEPOSIT_BOX (new Area (3810, 3020, 3817, 3024), true),
    CANAFIS (new Area (3508, 3475, 3516, 3483)),
    BURGH_DE_ROTT (new Area (3495, 3210, 3500, 3213)),
    LUMBRIDGE (new Area (new Tile (3207, 3217), new Tile (3210, 3220), 2)),
    CULINAROMANCERS_CHEST (new Area (3208, 9615, 3219, 9625)),
    DORGESH_KAAN (new Area (2701, 5345, 2706, 5354)),
    LLETYA (new Area (2351, 3161, 2354, 3164));
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
        return this.area.contains(new Tile[] {tile});
    }
}
/**
public enum BankInfo {

	LUMBRIDGE_CASTLE 
		(new Tile (3208, 3220, 2), new int[] {36786}, new int[] {494}, 
		new String[] {"Bank booth", "Use-quickly", "Banker", "Bank"}),
	
	//TODO: Get Information| Requirements RFD Subquest 1
	Culinaromancers_Chest (new Tile (3208, 3220, 2), new int[] {}, new int[] {}, new String[] {}),
	
	//TODO Get Information| Requirements: Buyers and Cellars, All Capers Completed
	Thieves_Guild (new Tile (3208, 3220, 2), new int[] {}, new int[] {}, new String[] {}),
	
	
	AlKharid 
		(new Tile (3269, 3167, 0), new int[] {35647}, new int[] {496, 497}, 
		new String[] {"Bank booth", "Use-quickly", "Banker", "Bank"}),
	
	Edgeville 
		(new Tile (3093, 3497, 0), new int[] {42217, 42377, 42378}, new int[] {553, 2759}, 
		new String[] {"Counter", "Use-quickly", "Banker", "Bank"}),
	
	Grand_Exchange 
		(new Tile (3177, 3477, 0), new int[] {3418, 2718}, new String[] {"Banker", "Bank"}, false),
	
	Varrock_West
		(new Tile (3185, 3434, 0), new int[] {782}, new int[] {553, 2759}, 
		new String[] {"Bank booth", "Use-quickly", "Banker", "Bank"}),
		
	Varrock_East
		(new Tile (3254, 3420, 0), new int[] {782}, new int[] {553, 2759}, 
		new String[] {"Bank booth", "Use-quickly", "Banker", "Bank"}),
	
	LUMBRIDGE_CASTLE1000 (new Tile (3208, 3220, 2), new int[] {}, new int[] {}, new String[] {});
	
	Tile location;
	int[] bankerIDs;
	int[] objectIDs;
	int[] limitedOptions;
	String bankerName;
	String bankerOption;
	String objectName;
	String objectOption;
	boolean depositBox = false;
	boolean noted = false;
	
	BankInfo() {
		
	}
	
	BankInfo (Tile Location, int[] ObjectIDs, int[] BankerIDs, String[] BankInfo) {
		this (Location, ObjectIDs, BankerIDs, BankInfo, null, false);
	}
	
	BankInfo (Tile Location, int[] ObjectIDs, int[] BankerIDs, String[] BankInfo, int[] LimitedOptions, boolean Noted) {
		if (BankInfo.length == 4) {
			location = Location;
			objectIDs = ObjectIDs;
			bankerIDs = BankerIDs;
			objectName = BankInfo[0];
			objectOption = BankInfo[1];
			bankerName = BankInfo[2];
			bankerOption = BankInfo[3];
			limitedOptions = LimitedOptions;
			noted = Noted;
		}
	}
	
	BankInfo (Tile Location, int[] BankIDs, String[] BankInfo, boolean DepositBox) {
		if (BankInfo.length == 2) {
			location = Location;
			depositBox = DepositBox;
			objectIDs = BankIDs;
			objectName = BankInfo[0];
			objectOption = BankInfo[1];
		}
	}
} 
*/

