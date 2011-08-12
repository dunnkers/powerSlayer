package org.powerbot.powerslayer.common;

import java.util.Random;

import org.powerbot.powerslayer.PowerSlayer;
import org.powerbot.powerslayer.methods.Banking;
import org.powerbot.powerslayer.methods.Traveling;
import org.powerbot.powerslayer.methods.UniversalFighter;
import org.rsbot.script.methods.*;

/**
 * Created by IntelliJ IDEA. User: Taylor Date: 5/5/11 Time: 5:05 PM Package:
 * org.powerbot.powerslayer.common;
 */
public class MethodBase {
	//RSBot classes
    public PowerSlayer parent = null;
    public Account account = null;
    public Bank bank = null;
    public Calculations calculations = null;
    public Camera camera = null;
    public Combat combat = null;
    public ClanChat clanChat = null;
    public Environment environment = null;
    public Equipment equipment = null;
    public FriendChat friendChat = null;
    public Game game = null;
    public GrandExchange grandExchange = null;
    public GroundItems groundItems = null;
    public Hiscores hiscores = null;
    public Interfaces interfaces = null;
    public Inventory inventory = null;
    public Keyboard keyboard = null;
	public Lobby lobby = null;
    public Magic magic = null;
    public Menu menu = null;
    public Mouse mouse = null;
    public NPCs npcs = null;
    public Objects objects = null;
    public Players players = null;
    public Prayer prayer = null;
	public Projectiles projectiles = null;
    public Settings settings = null;
	public Quests quests = null;
    public Skills skills = null;
    public Store store = null;
    public Summoning summoning = null;
    public Tiles tiles = null;
    public Trade trade = null;
    public Walking walking = null;
    public Web web = null;
    
    //Internal classes
    public UniversalFighter fighter = new UniversalFighter(this);
    public Banking bankingProcess = new Banking(this);
    public Traveling travel = new Traveling(this);
    public Random random = new Random();

    public MethodBase(PowerSlayer parent) {
        this.parent = parent;
    }
}
