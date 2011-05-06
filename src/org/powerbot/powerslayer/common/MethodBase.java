package org.powerbot.powerslayer.common;

import java.util.Random;

import org.powerbot.powerslayer.PowerSlayer;
import org.powerbot.powerslayer.methods.Banking;
import org.powerbot.powerslayer.methods.Traveling;
import org.powerbot.powerslayer.methods.UniversalFighter;
import org.rsbot.script.methods.Account;
import org.rsbot.script.methods.Bank;
import org.rsbot.script.methods.Calculations;
import org.rsbot.script.methods.Camera;
import org.rsbot.script.methods.ClanChat;
import org.rsbot.script.methods.Combat;
import org.rsbot.script.methods.Environment;
import org.rsbot.script.methods.Equipment;
import org.rsbot.script.methods.FriendChat;
import org.rsbot.script.methods.GrandExchange;
import org.rsbot.script.methods.GroundItems;
import org.rsbot.script.methods.Hiscores;
import org.rsbot.script.methods.Interfaces;
import org.rsbot.script.methods.Inventory;
import org.rsbot.script.methods.Keyboard;
import org.rsbot.script.methods.Magic;
import org.rsbot.script.methods.Menu;
import org.rsbot.script.methods.Mouse;
import org.rsbot.script.methods.NPCs;
import org.rsbot.script.methods.Objects;
import org.rsbot.script.methods.Players;
import org.rsbot.script.methods.Prayer;
import org.rsbot.script.methods.Settings;
import org.rsbot.script.methods.Skills;
import org.rsbot.script.methods.Store;
import org.rsbot.script.methods.Summoning;
import org.rsbot.script.methods.Tiles;
import org.rsbot.script.methods.Trade;
import org.rsbot.script.methods.Walking;

/**
 * Created by IntelliJ IDEA. User: Taylor Date: 5/5/11 Time: 5:05 PM Package:
 * org.powerbot.powerslayer.common;
 */
public class MethodBase {
	public PowerSlayer parent = null;
	public Equipment equipment = null;
	public Combat combat = null;
	public Walking walking = null;
	public GrandExchange grandExchange = null;
	public Account account = null;
	public Bank bank = null;
	public Calculations calc = null;
	public Camera camera = null;
	public ClanChat clanChat = null;
	public Environment env = null;
	public FriendChat friendChat = null;
	public GroundItems groundItems = null;
	public Hiscores hiscores = null;
	public Interfaces interfaces = null;
	public Inventory inventory = null;
	public Keyboard keyboard = null;
	public Magic magic = null;
	public Menu menu = null;
	public Mouse mouse = null;
	public NPCs npcs = null;
	public Objects objects = null;
	public Players players = null;
	public Prayer prayer = null;
	public Settings settings = null;
	public Skills skills = null;
	public Store store = null;
	public Summoning summoning = null;
	public Tiles tiles = null;
	public Trade trade = null;
	public UniversalFighter fighter = new UniversalFighter(this);
	public Banking bankingProcess = new Banking(this);
	public Traveling travel = new Traveling(this);
	public Random random = new Random();

	public MethodBase(PowerSlayer parent) {
		this.parent = parent;
	}
}
