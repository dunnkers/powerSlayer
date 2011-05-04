import org.rsbot.script.wrappers.RSTile;

public enum TeleportItem implements Teleport {
    ;
    private final int[] itemIDs;
    private final RSTile dest;
    private final String action;
    private final int rubInterfaceID;

    private TeleportItem(RSTile dest, int... itemIDs) {
	this.dest = dest;
	this.itemIDs = itemIDs;
	this.action = "Break";
	this.rubInterfaceID = -1;
    }

    private TeleportItem(RSTile dest, String action, int... itemIDs) {
	this.dest = dest;
	this.itemIDs = itemIDs;
	this.action = action;
	this.rubInterfaceID = -1;
    }

    private TeleportItem(RSTile dest, String action, int rubInterfaceID,
	    int... itemIDs) {
	this.dest = dest;
	this.itemIDs = itemIDs;
	this.action = action;
	this.rubInterfaceID = rubInterfaceID;
    }

    public int getRubInterfaceID() {
	return rubInterfaceID;
    }

    public String getAction() {
	return action;
    }

    public int[] getIDs() {
	return itemIDs;
    }

    @Override
    public RSTile getDest() {
	return dest;
    }

}
