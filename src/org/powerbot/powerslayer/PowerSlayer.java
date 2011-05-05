package org.powerbot.powerslayer;

import org.powerbot.powerslayer.abstracts.ITeleport;
import org.powerbot.powerslayer.abstracts.State;
import org.powerbot.powerslayer.data.Banks;
import org.powerbot.powerslayer.data.SlayerMaster;
import org.powerbot.powerslayer.data.TeleportItem;
import org.powerbot.powerslayer.movement.TeleportSpell;
import org.powerbot.powerslayer.states.BankingState;
import org.powerbot.powerslayer.wrappers.*;
import org.rsbot.event.listeners.PaintListener;
import org.rsbot.script.Script;
import org.rsbot.script.ScriptManifest;
import org.rsbot.script.methods.*;
import org.rsbot.script.wrappers.RSInterface;
import org.rsbot.script.wrappers.RSItem;
import org.rsbot.script.wrappers.RSNPC;
import org.rsbot.script.wrappers.RSTile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@ScriptManifest(authors = {"Powerbot Scripters Team"},
        name = "Power Slayer",
        version = 0.1,
        description = "Slayer bot.")
public class PowerSlayer extends Script implements PaintListener, MouseListener {
    public Task currentTask;
    public SlayerMaster slayerMaster;
    private int weaponSpecUsage = -1;
    private List<String> pickup = new ArrayList<String>();
    public RSNPC currentMonster;
    private int tab = 1;
    public Methods methods = new Methods();

    public org.rsbot.script.methods.Equipment EquipmentMethod;
    public Combat CombatMethod;
    public Walking WalkingMethod;
    public GrandExchange GrandExchangeMethod;
    public Account AccountMethod;
    public Bank BankMethod;
    public Calculations CalcMethod;
    public Camera CameraMethod;
    public ClanChat ClanChatMethod;
    public Environment Env;
    public FriendChat FriendChatMethod;
    public GroundItems GroundItemsMethod;
    public Hiscores HiscoresMethod;
    public Interfaces InterfacesMethod;
    public Inventory InventoryMethod;
    public Keyboard KeyboardMethod;
    public Magic MagicMethod;
    public org.rsbot.script.methods.Menu MenuMethod;
    public Mouse MouseMethod;
    public NPCs NpcsMethod;
    public Objects ObjectsMethod;
    public Players PlayersMethod;
    public Prayer PrayerMethod;
    public Settings SettingsMethod;
    public Skills SkillsMethod;
    public Store StoreMethod;
    public Summoning SummoningMethod;
    public Tiles TilesMethod;
    public Trade TradeMethod;

    public boolean onStart() {
        EquipmentMethod = equipment;
        CombatMethod = combat;
        WalkingMethod = walking;
        GrandExchangeMethod = grandExchange;
        AccountMethod = account;
        BankMethod = bank;
        CalcMethod = calc;
        CameraMethod = camera;
        ClanChatMethod = clanChat;
        Env = env;
        FriendChatMethod = friendChat;
        GroundItemsMethod = groundItems;
        HiscoresMethod = hiscores;
        InterfacesMethod = interfaces;
        InventoryMethod = inventory;
        KeyboardMethod = keyboard;
        MagicMethod = magic;
        MenuMethod = menu;
        MouseMethod = mouse;
        NpcsMethod = npcs;
        ObjectsMethod = objects;
        PlayersMethod = players;
        PrayerMethod = prayer;
        SettingsMethod = settings;
        SkillsMethod = skills;
        StoreMethod = store;
        SummoningMethod = summoning;
        TilesMethod = tiles;
        TradeMethod = trade;
        return true;
    }

    private int getKillsLeft() {
        return settings.getSetting(394);
    }

    private int inventSpace() {
        return 28 - inventory.getCount();
    }

    private int specialUsage() {
        int[] amountUsage = {10, 25, 33, 35, 45, 50, 55, 60, 80, 85, 100};
        String[][] weapons = {{"Rune thrownaxe", "Rod of ivandis"},
                {"Dragon Dagger",
                        "Dragon dagger (p)",
                        "Dragon dagger (p+)",
                        "Dragon dagger (p++)",
                        "Dragon Mace",
                        "Dragon Spear",
                        "Dragon longsword",
                        "Rune claws"},
                {"Dragon Halberd"},
                {"Magic Longbow"},
                {"Magic Composite Bow"},
                {"Dragon Claws",
                        "Abyssal Whip",
                        "Granite Maul",
                        "Darklight",
                        "Barrelchest Anchor",
                        "Armadyl Godsword"},
                {"Magic Shortbow"},
                {"Dragon Scimitar", "Dragon 2H Sword", "Zamorak Godsword", "Korasi's sword"},
                {"Dorgeshuun Crossbow", "Bone Dagger", "Bone Dagger (p+)", "Bone Dagger (p++)"},
                {"Brine Sabre"},
                {"Bandos Godsword",
                        "Dragon Battleaxe",
                        "Dragon Hatchet",
                        "Seercull Bow",
                        "Excalibur",
                        "Enhanced excalibur",
                        "Ancient Mace",
                        "Saradomin sword"}};
        String str = equipment.getItem(org.rsbot.script.methods.Equipment.WEAPON).getName();
        str = str.substring(str.indexOf(">") + 1);
        for (int i = 0; i < weapons.length; i++) {
            for (int j = 0; j < weapons[i].length; j++) {
                if (weapons[i][j].equalsIgnoreCase(str)) {
                    return amountUsage[i];
                }
            }
        }
        return -1;
    }

    // TODO 90% of these need rewriting
    public boolean performAction(Item items, String action) {
        for (RSItem item : inventory.getItems()) {
            for (String name : items.getNames()) {
                if (item.getName().equalsIgnoreCase(name)) {
                    return item.doAction(action);
                }
            }
        }
        return false;
    }

    public boolean isInInvent(Item items) {
        for (RSItem item : inventory.getItems()) {
            for (String name : items.getNames()) {
                if (item.getName().equalsIgnoreCase(name)) {
                    if (inventory.getCount(true, item.getID()) >= items.getAmount())
                        return true;
                }
            }
        }
        return false;
    }

    public boolean isInBank(Item items) {
        for (RSItem item : bank.getItems()) {
            for (String name : items.getNames()) {
                if (item.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isEquiped(Item item) {
        for (RSItem i : equipment.getItems()) {
            for (String name : item.getNames()) {
                if (i.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isInInvent(EquipmentItems equip) {
        for (RSItem item : inventory.getItems()) {
            for (String name : equip.getNames()) {
                if (item.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isEquiped(EquipmentItems equip) {
        for (RSItem item : equipment.getItems()) {
            for (String name : equip.getNames()) {
                if (item.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isInBank(EquipmentItems equip) {
        for (RSItem item : bank.getItems()) {
            for (String name : equip.getNames()) {
                if (item.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String willRemove(EquipmentItems equip) {
        return equipment.getItem(equip.getSlot()).getName();
    }

    public void equip(EquipmentItems equip) {
        for (RSItem item : inventory.getItems()) {
            for (String name : equip.getNames()) {
                if (item.getName().equalsIgnoreCase(name)) {
                    item.doClick(true);
                    return;
                }
            }
        }
    }

    public boolean isFullyEquiped(Requirements req) {
        for (EquipmentItems e : req.getEquipment()) {
            if (!isEquiped(e)) {
                if (isInInvent(e)) {
                    for (EquipmentItems r : req.getEquipment()) {
                        for (String name : r.getNames()) {
                            if (willRemove(e).equals(name)) {
                                return false;
                            }
                        }
                    }
                    equip(e);
                    if (!isEquiped(e)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean inventReady(Requirements req) {
        for (Item i : req.getItems()) {
            if (!isInInvent(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isInInvent(Finisher fin) {
        for (RSItem item : inventory.getItems()) {
            for (String name : fin.getNames()) {
                if (item.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isInBank(Finisher fin) {
        for (RSItem item : bank.getItems()) {
            for (String name : fin.getNames()) {
                if (item.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isInInvent(Starter start) {
        for (RSItem item : inventory.getItems()) {
            for (String name : start.getNames()) {
                if (item.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isInBank(Starter start) {
        for (RSItem item : bank.getItems()) {
            for (String name : start.getNames()) {
                if (item.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean use(Starter start, RSNPC monster) {
        for (String s : start.getNames()) {
            for (RSItem inventItem : inventory.getItems()) {
                if (s.equalsIgnoreCase(inventItem.getName())) {
                    if (inventory.selectItem(inventItem.getID())) {
                        if (monster != null) {
                            if (!monster.isOnScreen()) {
                                camera.turnTo(monster);
                            }
                            if (monster.isOnScreen()) {
                                return monster.doAction("Use");
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean use(Finisher finisher, RSNPC monster) {
        for (String s : finisher.getNames()) {
            for (RSItem inventItem : inventory.getItems()) {
                if (s.equalsIgnoreCase(inventItem.getName())) {
                    if (inventory.selectItem(inventItem.getID())) {
                        if (monster != null) {
                            if (!monster.isOnScreen()) {
                                camera.turnTo(monster);
                            }
                            if (monster.isOnScreen()) {
                                return monster.doAction("Use");
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    // A mix of teleporting and walking/running to travel
    // to certain slayer masters, tasks, and banks
    public class Traveling {
        public boolean travelToMaster(SlayerMaster master) {
            ITeleport t = getBestTeleport(master.getLocation());
            if (t != null)
                return castTeleport(t);
            else
                return walking.getWebPath(master.getLocation()).traverse();
        }

        public boolean travelToMonster(Task task) {
            ITeleport t = getBestTeleport(task.getMonster().getLocation());
            if (t != null)
                return castTeleport(t);
            else
                return walking.getWebPath(task.getMonster().getLocation()).traverse();
        }

        public RSItem getEquipmentItem(int... ids) {
            for (RSItem i : equipment.getItems()) {
                for (int id : ids) {
                    if (id == i.getID())
                        return i;
                }
            }
            return null;
        }

        public boolean castTeleport(ITeleport t) {
            if (t instanceof TeleportSpell) {
                TeleportSpell tS = (TeleportSpell) t;
                if (magic.getCurrentSpellBook() == tS.getBook())
                    return magic.castSpell(tS.getSpell());
            } else if (t instanceof TeleportItem) {
                TeleportItem tI = (TeleportItem) t;
                RSItem item;
                if ((item = inventory.getItem(tI.getIDs())) != null || (item = getEquipmentItem(tI.getIDs())) != null) {
                    if (item.doAction(tI.getAction())) {
                        return true;
                    } else if (item.doAction("Rub")) {
                        sleep(1750, 2250);
                        RSInterface inter = interfaces.get(tI.getRubInterfaceID());
                        if (inter != null)
                            return interfaces.clickDialogueOption(inter, tI.getAction());
                    }
                }
            }
            return false;
        }

        // The default will be the closest bank to the player
        public boolean travelToBank() {
            return travelToBank(getNearestBank());
        }

        public boolean travelToBank(Banks bank) {
            ITeleport t = getBestTeleport(bank.getRSArea().getCentralTile());
            if (t != null)
                return castTeleport(t);
            else
                return walking.getWebPath(bank.getRSArea().getCentralTile()).traverse();
        }

        // returns null if there are no teleports that are closer
        public ITeleport getBestTeleport(RSTile dest) {
            ITeleport best = null;
            double dist = 0;
            for (ITeleport t : getAllTeleports()) {
                if (canCast(t)) {
                    if (best == null || calc.distanceBetween(t.getDest(), dest) < dist) {
                        best = t;
                        dist = calc.distanceBetween(t.getDest(), dest);
                    }
                }
            }
            if (calc.distanceTo(dest) > dist) // player is farthur away than the
                // best teleport
                return best;
            return null;
        }

        // Makes sure the player has the required Magic level, and then
        // checks to make sure all of the required items are available
        public boolean canCast(ITeleport t) {
            if (t instanceof TeleportSpell) {
                TeleportSpell tS = (TeleportSpell) t;
                if (skills.getCurrentLevel(Skills.MAGIC) < tS.getMagicLevel() ||
                        magic.getCurrentSpellBook() != tS.getBook())
                    return false;
                for (Rune rune : tS.getRunes().keySet()) {
                    if (getRuneCount(rune) < tS.getRuneCount(rune))
                        return false;
                }
            } else if (t instanceof TeleportItem) {
                TeleportItem tT = (TeleportItem) t;
                return inventory.containsOneOf(tT.getIDs()) || equipment.containsOneOf(tT.getIDs());
            }
            return true;
        }

        public Banks getNearestBank() {
            /*
            * TODO Add a method to remove all banks that a player can not
            * reach.TODO Use the web to return a 'real' distance.
            */
            Banks best = null;
            int bDist = Integer.MAX_VALUE;
            for (Banks b : Banks.values()) {
                int dist = calc.distanceTo(b.getRSArea().getCentralTile());
                if (dist < bDist) {
                    best = b;
                    bDist = dist;
                }
            }
            return best;
        }

        public boolean isInBank(RSTile tile) {
            for (Banks b : Banks.values()) {
                if (b.containsTile(tile)) {
                    return true;
                }
            }
            return false;
        }

        public int getArrayIndex(int[] array, int num) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == num) {
                    return i;
                }
            }
            return -1;
        }

        public int min(int[] a) {
            int res = Integer.MAX_VALUE;
            for (int anA : a) {
                res = Math.min(anA, res);
            }
            return res;
        }
    }


    public class Banking {
        public boolean doBanking() {
            return false;
            // TODO;
        }
    }

    private class UniversalFighter {

        private class Potion {
            // TODO add options to include pots and which pots
            private int[] ids;
            private int[] boostedSkills;
            private int amount;

            private Potion(int[] ids, int[] boostedSkills) {
                this.ids = ids;
                this.boostedSkills = boostedSkills;
            }

            private Potion(int[] ids, int boostedSkill) {
                this(ids, new int[boostedSkill]);
            }

            private int getAmount() {
                return inventory.getCount(true, ids);
            }
        }

        private class PotionMethods {
            private final int[] VIAL = new int[]{229};

            private LinkedList<Potion> getPotions() {
                LinkedList<Potion> potions = new LinkedList<Potion>();
                potions.add(new Potion(new int[]{3040, 3042, 3044, 3046, 11513, 11515, 13520, 13521, 13522, 13523},
                        Skills.MAGIC));
                // Magic pots
                potions.add(new Potion(new int[]{2434, 139, 141, 143, 11465, 11467}, Skills.PRAYER));
                // Prayer pots
                potions.add(new Potion(new int[]{2444, 169, 171, 173, 11509, 11511, 13524, 13525, 15326, 15327},
                        Skills.RANGE));
                // Range pots
                potions.add(new Potion(new int[]{9739, 9741, 9743, 9745, 11445, 11447},
                        new int[]{Skills.ATTACK, Skills.STRENGTH}));
                // Combat pots
                potions.add(new Potion(new int[]{2428,
                        121,
                        123,
                        125,
                        2436,
                        145,
                        147,
                        149,
                        11429,
                        11431,
                        11429,
                        11431,
                        11429,
                        11431,
                        11469,
                        11471,
                        15308,
                        15309,
                        15310,
                        15311}, Skills.ATTACK));
                // Attack pots
                potions.add(new Potion(new int[]{113,
                        115,
                        117,
                        119,
                        2440,
                        157,
                        159,
                        161,
                        11443,
                        11441,
                        11485,
                        11487,
                        15312,
                        15313,
                        15314,
                        15315}, Skills.STRENGTH));
                // Strength pots
                potions.add(new Potion(new int[]{2432,
                        133,
                        135,
                        137,
                        2442,
                        163,
                        165,
                        167,
                        11457,
                        11459,
                        11497,
                        11499,
                        15316,
                        15317,
                        15318,
                        15319}, Skills.DEFENSE));
                // Defense pots
                potions.add(new Potion(new int[]{15332, 15333, 15334, 15335},
                        new int[]{Skills.STRENGTH,
                                Skills.ATTACK,
                                Skills.DEFENSE,
                                Skills.MAGIC,
                                Skills.RANGE}));
                // Overloads
                return potions;
            }

            private Potion needToPot() {
                for (Potion p : getPotions()) {
                    // Check that the pot is needed.
                    if (p.getAmount() > 1 && areSkillsBoosted(p.boostedSkills)) {
                        return p;
                    }
                }
                return null;
            }

            public boolean usePotions() {
                Potion pot = needToPot();
                if (pot != null) {
                    RSItem item = inventory.getItem(pot.ids);
                    if (item != null) {
                        return item.doClick(true);
                    }
                }
                return false;
            }

            private boolean areSkillsBoosted(int[] skillsArray) {
                for (int skill : skillsArray) {
                    if (skills.getCurrentLevel(skill) <= skills.getRealLevel(skill)) {
                        return true;
                    }
                }
                return false;
            }
        }
    }


    @Override
    public int loop() {
        return getStateLoop();
    }

    private Image getImage(String url) {
        try {
            return ImageIO.read(new URL(url));
        } catch (IOException e) {
            return null;
        }
    }

    public class Paint {
        public String Current = "Loading...";
        public final Image closed = getImage("https://github.com/Timer/PowerSlayer/tree/master/resources/closedc.png");
        public final Image tabOne = getImage("https://github.com/Timer/PowerSlayer/tree/master/resources/gentab.png");
        public final Image tabTwo = getImage("https://github.com/Timer/PowerSlayer/tree/master/resources/exptab.png");
        public final Rectangle hideRect = new Rectangle(477, 336, 34, 37);
        public final Rectangle tabOneRect = new Rectangle(177, 335, 147, 37);
        public final Rectangle tabTwoRect = new Rectangle(327, 336, 148, 37);
    }

    private enum Skill {
        SLAYER(Skills.SLAYER, "Slayer", 0),
        ATTACK(Skills.ATTACK, "Attack", 1),
        STRENGTH(Skills.STRENGTH, "Strength", 2),
        DEFENCE(Skills.DEFENSE, "Defence", 3),
        CONSTITUTION(Skills.CONSTITUTION, "Constitution", 4),
        RANGE(Skills.RANGE, "Range", 5),
        MAGIC(Skills.MAGIC, "Magic", 6);

        int skillID;
        String skillName;
        int index;

        private Skill(int skillID, String skillName, int index) {
            this.skillID = skillID;
            this.skillName = skillName;
            this.index = index;
        }
    }

    /*
    * Used because we're all lazy and its just tidier.
    */
    public class Methods {
        public Traveling travel = new Traveling();
        public Banking banking = new Banking();
        public UniversalFighter fighter = new UniversalFighter();
        public Paint paint = new Paint();
    }

    // TODO Alot more...
    public void onRepaint(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        if (tab == 1) {
            g.drawImage(methods.paint.tabOne, -1, 293, null);
        } else if (tab == 2) {
            g.drawImage(methods.paint.tabTwo, -1, 293, null);
            drawSkillBars(g);
        } else {
            g.drawImage(methods.paint.closed, 162, 293, null);
        }
    }

    public void mouseClicked(MouseEvent e) {
        if (methods.paint.hideRect.contains(e.getPoint())) {
            tab = 3;
        } else if (methods.paint.tabOneRect.contains(e.getPoint())) {
            tab = 1;
        } else if (methods.paint.tabTwoRect.contains(e.getPoint())) {
            tab = 2;
        }
    }

    private void drawSkillBars(Graphics g) {
        for (Skill s : Skill.values()) {
            int x = s.index <= 3 ? 20 : 180;
            int y = s.index <= 3 ? 390 + (s.index * 20) : 390 + ((s.index - 3) * 20);
            g.setColor(new Color(153, 153, 153));
            g.drawRect(x, y, 150, 15);
            g.setColor(new Color(0, 0, 0, 80));
            g.fillRect(x, y, (int) (skills.getPercentToNextLevel(s.skillID) * 1.5), 15);
            g.setColor(new Color(90, 15, 15));
            g.setFont(new Font("Serif", 0, 12));
            g.drawString(s.skillName +
                    ": " +
                    skills.getPercentToNextLevel(s.skillID) +
                    "% to level " +
                    (skills.getRealLevel(s.skillID) + 1), x + 4, y + 12);
            g.setColor(new Color(255, 255, 255, 90));
            g.drawString(s.skillName +
                    ": " +
                    skills.getPercentToNextLevel(s.skillID) +
                    "% to level " +
                    (skills.getRealLevel(s.skillID) + 1), x + 5, y + 13);
        }
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    private ArrayList<State> states = new ArrayList<State>();

    public void initStates() {
        states.add(new BankingState(this));
    }

    private int getStateLoop() {
        for (State state : states) {
            if (state.activeCondition()) {
                return state.loop();
            }
        }
        return -1;
    }

    /**
     * Gets the rune count, including staves
     *
     * @param rune the Rune
     * @return rune count
     */
    public int getRuneCount(Rune rune) {
        if (rune.isElemental()) {
            String wepName = equipment.getItem(org.rsbot.script.methods.Equipment.WEAPON) != null ?
                    equipment.getItem(org.rsbot.script.methods.Equipment.WEAPON).getName() :
                    "";
            if (rune == Rune.WATER) {
                String shieldName = equipment.getItem(org.rsbot.script.methods.Equipment.SHIELD) != null ?
                        equipment.getItem(org.rsbot.script.methods.Equipment.SHIELD).getName() :
                        "";
                if (shieldName != null && shieldName.trim().equalsIgnoreCase("tome of frost"))
                    return 999999;
            }
            if (wepName != null && wepName.toLowerCase().contains("staff")) {
                if (wepName.toLowerCase().contains(rune.name().toLowerCase()))
                    return 999999;
                if (wepName.toLowerCase().contains("dust") && (rune == Rune.AIR || rune == Rune.EARTH))
                    return 999999;
                if (wepName.toLowerCase().contains("lava") && (rune == Rune.EARTH || rune == Rune.FIRE))
                    return 999999;
                if (wepName.toLowerCase().contains("steam") && (rune == Rune.WATER || rune == Rune.FIRE))
                    return 999999;
            }
        }
        return inventory.getCount(true, rune.getItemIDs());
    }

    public ITeleport[] getAllTeleports() {
        List<ITeleport> teleports = new ArrayList<ITeleport>();
        for (TeleportSpell t : TeleportSpell.values())
            teleports.add(t);
        for (TeleportItem t : TeleportItem.values())
            teleports.add(t);
        return teleports.toArray(new ITeleport[teleports.size()]);
    }
}
