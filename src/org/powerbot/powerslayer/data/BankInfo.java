package org.powerbot.powerslayer.data;

import org.rsbot.script.wrappers.Tile;

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
