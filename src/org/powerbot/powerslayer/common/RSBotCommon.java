package org.powerbot.powerslayer.common;

import org.powerbot.powerslayer.PowerSlayer;
import org.rsbot.script.methods.*;

/**
 * Created by IntelliJ IDEA.
 * User: Taylor
 * Date: 5/5/11
 * Time: 5:05 PM
 * Package: org.powerbot.powerslayer.common;
 */
public class RSBotCommon {
    protected final PowerSlayer main;
    protected final Equipment equipment;
    protected final Combat combat;
    protected final Walking walking;
    protected final GrandExchange grandExchange;
    protected final Account account;
    protected final Bank bank;
    protected final Calculations calc;
    protected final Camera camera;
    protected final ClanChat clanChat;
    protected final Environment env;
    protected final FriendChat friendChat;
    protected final GroundItems groundItems;
    protected final Hiscores hiscores;
    protected final Interfaces interfaces;
    protected final Inventory inventory;
    protected final Keyboard keyboard;
    protected final Magic magic;
    protected final Menu menu;
    protected final Mouse mouse;
    protected final NPCs npcs;
    protected final Objects objects;
    protected final Players players;
    protected final Prayer prayer;
    protected final Settings settings;
    protected final Skills skills;
    protected final Store store;
    protected final Summoning summoning;
    protected final Tiles tiles;
    protected final Trade trade;
    protected final PowerSlayer.Methods methods;

    public RSBotCommon(PowerSlayer main) {
        this.main = main;
        equipment = main.EquipmentMethod;
        combat = main.CombatMethod;
        walking = main.WalkingMethod;
        grandExchange = main.GrandExchangeMethod;
        account = main.AccountMethod;
        bank = main.BankMethod;
        calc = main.CalcMethod;
        camera = main.CameraMethod;
        clanChat = main.ClanChatMethod;
        env = main.Env;
        friendChat = main.FriendChatMethod;
        groundItems = main.GroundItemsMethod;
        hiscores = main.HiscoresMethod;
        interfaces = main.InterfacesMethod;
        inventory = main.InventoryMethod;
        keyboard = main.KeyboardMethod;
        magic = main.MagicMethod;
        menu = main.MenuMethod;
        mouse = main.MouseMethod;
        npcs = main.NpcsMethod;
        objects = main.ObjectsMethod;
        players = main.PlayersMethod;
        prayer = main.PrayerMethod;
        settings = main.SettingsMethod;
        skills = main.SkillsMethod;
        store = main.StoreMethod;
        summoning = main.SummoningMethod;
        tiles = main.TilesMethod;
        trade = main.TradeMethod;
        methods = main.methods;
    }

}
