package org.powerbot.powerslayer;

import org.powerbot.powerslayer.abstracts.State;
import org.powerbot.powerslayer.common.MethodBase;
import org.powerbot.powerslayer.data.SlayerMaster;
import org.powerbot.powerslayer.states.BankingState;
import org.powerbot.powerslayer.wrappers.*;
import org.rsbot.event.listeners.PaintListener;
import org.rsbot.script.Script;
import org.rsbot.script.ScriptManifest;
import org.rsbot.script.methods.Skills;
import org.rsbot.script.wrappers.RSItem;
import org.rsbot.script.wrappers.RSNPC;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@ScriptManifest(authors = {"Powerbot Scripters Team"}, name = "Power Slayer", version = 0.1, description = "Slayer bot.")
public class PowerSlayer extends Script implements PaintListener, MouseListener {
    public Task currentTask;
    public SlayerMaster slayerMaster;
    private int weaponSpecUsage = -1;
    private List<String> pickup = new ArrayList<String>();
    public RSNPC currentMonster;
    private int tab = 1;
    public Paint paint = new Paint();
    public MethodBase methodBase = null;

    @Override
    public boolean onStart() {
        setMethodBase();
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
        String[][] weapons = {
                {"Rune thrownaxe", "Rod of ivandis"},
                {"Dragon Dagger", "Dragon dagger (p)", "Dragon dagger (p+)",
                        "Dragon dagger (p++)", "Dragon Mace", "Dragon Spear",
                        "Dragon longsword", "Rune claws"},
                {"Dragon Halberd"},
                {"Magic Longbow"},
                {"Magic Composite Bow"},
                {"Dragon Claws", "Abyssal Whip", "Granite Maul", "Darklight",
                        "Barrelchest Anchor", "Armadyl Godsword"},
                {"Magic Shortbow"},
                {"Dragon Scimitar", "Dragon 2H Sword", "Zamorak Godsword",
                        "Korasi's sword"},
                {"Dorgeshuun Crossbow", "Bone Dagger", "Bone Dagger (p+)",
                        "Bone Dagger (p++)"},
                {"Brine Sabre"},
                {"Bandos Godsword", "Dragon Battleaxe", "Dragon Hatchet",
                        "Seercull Bow", "Excalibur", "Enhanced excalibur",
                        "Ancient Mace", "Saradomin sword"}};
        String str = equipment.getItem(
                org.rsbot.script.methods.Equipment.WEAPON).getName();
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
                    if (inventory.getCount(true, item.getID()) >= items
                            .getAmount())
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

    // TODO Alot more...
    @Override
    public void onRepaint(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        if (tab == 1) {
            g.drawImage(paint.tabOne, -1, 293, null);
        } else if (tab == 2) {
            g.drawImage(paint.tabTwo, -1, 293, null);
            drawSkillBars(g);
        } else {
            g.drawImage(paint.closed, 162, 293, null);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (paint.hideRect.contains(e.getPoint())) {
            tab = 3;
        } else if (paint.tabOneRect.contains(e.getPoint())) {
            tab = 1;
        } else if (paint.tabTwoRect.contains(e.getPoint())) {
            tab = 2;
        }
    }

    private void drawSkillBars(Graphics g) {
        for (Skill s : Skill.values()) {
            int x = s.index <= 3 ? 20 : 180;
            int y = s.index <= 3 ? 390 + (s.index * 20)
                    : 390 + ((s.index - 3) * 20);
            g.setColor(new Color(153, 153, 153));
            g.drawRect(x, y, 150, 15);
            g.setColor(new Color(0, 0, 0, 80));
            g.fillRect(x, y,
                    (int) (skills.getPercentToNextLevel(s.skillID) * 1.5), 15);
            g.setColor(new Color(90, 15, 15));
            g.setFont(new Font("Serif", 0, 12));
            g.drawString(
                    s.skillName + ": "
                            + skills.getPercentToNextLevel(s.skillID)
                            + "% to level "
                            + (skills.getRealLevel(s.skillID) + 1), x + 4,
                    y + 12);
            g.setColor(new Color(255, 255, 255, 90));
            g.drawString(
                    s.skillName + ": "
                            + skills.getPercentToNextLevel(s.skillID)
                            + "% to level "
                            + (skills.getRealLevel(s.skillID) + 1), x + 5,
                    y + 13);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    private ArrayList<State> states = new ArrayList<State>();

    public void initStates() {
        states.add(new BankingState(methodBase));
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
            String wepName = equipment
                    .getItem(org.rsbot.script.methods.Equipment.WEAPON) != null ? equipment
                    .getItem(org.rsbot.script.methods.Equipment.WEAPON)
                    .getName() : "";
            if (rune == Rune.WATER) {
                String shieldName = equipment
                        .getItem(org.rsbot.script.methods.Equipment.SHIELD) != null ? equipment
                        .getItem(org.rsbot.script.methods.Equipment.SHIELD)
                        .getName() : "";
                if (shieldName != null
                        && shieldName.trim().equalsIgnoreCase("tome of frost"))
                    return 999999;
            }
            if (wepName != null && wepName.toLowerCase().contains("staff")) {
                if (wepName.toLowerCase().contains(rune.name().toLowerCase()))
                    return 999999;
                if (wepName.toLowerCase().contains("dust")
                        && (rune == Rune.AIR || rune == Rune.EARTH))
                    return 999999;
                if (wepName.toLowerCase().contains("lava")
                        && (rune == Rune.EARTH || rune == Rune.FIRE))
                    return 999999;
                if (wepName.toLowerCase().contains("steam")
                        && (rune == Rune.WATER || rune == Rune.FIRE))
                    return 999999;
            }
        }
        return inventory.getCount(true, rune.getItemIDs());
    }

    public void setMethodBase() {
        if (methodBase == null)
            methodBase = new MethodBase(this);
        methodBase.equipment = equipment;
        methodBase.combat = combat;
        methodBase.walking = walking;
        methodBase.grandExchange = grandExchange;
        methodBase.account = account;
        methodBase.bank = bank;
        methodBase.calc = calc;
        methodBase.camera = camera;
        methodBase.clanChat = clanChat;
        methodBase.env = env;
        methodBase.friendChat = friendChat;
        methodBase.groundItems = groundItems;
        methodBase.hiscores = hiscores;
        methodBase.interfaces = interfaces;
        methodBase.inventory = inventory;
        methodBase.keyboard = keyboard;
        methodBase.magic = magic;
        methodBase.menu = menu;
        methodBase.mouse = mouse;
        methodBase.npcs = npcs;
        methodBase.objects = objects;
        methodBase.players = players;
        methodBase.prayer = prayer;
        methodBase.settings = settings;
        methodBase.skills = skills;
        methodBase.store = store;
        methodBase.summoning = summoning;
        methodBase.tiles = tiles;
        methodBase.trade = trade;
        methodBase.web = web;
    }
}
