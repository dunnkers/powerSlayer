package org.powerbot.powerslayer;

import org.powerbot.powerslayer.abstracts.State;
import org.powerbot.powerslayer.common.MethodBase;
import org.powerbot.powerslayer.data.SlayerMaster;
import org.powerbot.powerslayer.states.BankingState;
import org.powerbot.powerslayer.states.FighterState;
import org.powerbot.powerslayer.wrappers.*;
import org.rsbot.event.listeners.PaintListener;
import org.rsbot.script.Script;
import org.rsbot.script.ScriptManifest;
import org.rsbot.script.methods.*;
import org.rsbot.script.methods.Menu;
import org.rsbot.script.wrappers.Item;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

@SuppressWarnings("unused")
@ScriptManifest(authors = {"Powerbot Scripters Team"}, name = "Power Slayer", version = 0.1, description = "Slayer bot.")
public class PowerSlayer extends Script implements PaintListener, MouseListener {
	
	public Task currentTask;
    public SlayerMaster slayerMaster;

	private ArrayList<State> states = new ArrayList<State>();
	public MethodBase methodBase = null;

    private int tab = 1;
    public Paint paint = new Paint();


    @Override
    public boolean onRun() {
        setMethodBase();
	    initStates();
        return true;
    }

	public int loop() {
        return getStateLoop();
    }

	public void initStates() {
        states.add(new BankingState(methodBase));
	    states.add(new FighterState(methodBase));
    }

    private int getStateLoop() {
        for (State state : states) {
            if (state.activeCondition()) {
                return state.loop();
            }
        }
        return -1;
    }


    private int inventSpace() {
        return 28 - Inventory.getCount();
    }

	// TODO 90% of these need rewriting and classification
    public boolean performAction(SlayerItem items, String action) {
        for (Item item : Inventory.getItems()) {
            for (String name : items.getNames()) {
                if (item.getName().equalsIgnoreCase(name)) {
                    return item.interact(action);
                }
            }
        }
        return false;
    }

    public boolean isInInvent(SlayerItem items) {
        for (Item item : Inventory.getItems()) {
            for (String name : items.getNames()) {
                if (item.getName().equalsIgnoreCase(name)) {
                    if (Inventory.getCount(true, item.getID()) >= items.getAmount())
                        return true;
                }
            }
        }
        return false;
    }

    public boolean isInBank(SlayerItem items) {
        for (Item item : Bank.getItems()) {
            for (String name : items.getNames()) {
                if (item.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isEquipped(SlayerItem item) {
        for (Item i : Equipment.getItems()) {
            for (String name : item.getNames()) {
                if (i.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isInInvent(EquipmentItems equip) {
        for (Item item : Inventory.getItems()) {
            for (String name : equip.getNames()) {
                if (item.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isEquipped(EquipmentItems equip) {
        for (Item item : Equipment.getItems()) {
            for (String name : equip.getNames()) {
                if (item.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isInBank(EquipmentItems equip) {
        for (Item item : Bank.getItems()) {
            for (String name : equip.getNames()) {
                if (item.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String willRemove(EquipmentItems equip) {
        return Equipment.getItem(equip.getSlot()).getName();
    }

    public void equip(EquipmentItems equip) {
        for (Item item : Inventory.getItems()) {
            for (String name : equip.getNames()) {
                if (item.getName().equalsIgnoreCase(name)) {
                    item.click(true);
                    return;
                }
            }
        }
    }

    public boolean isFullyEquipped(Requirements req) {
        for (EquipmentItems e : req.getEquipment()) {
            if (!isEquipped(e)) {
                if (isInInvent(e)) {
                    for (EquipmentItems r : req.getEquipment()) {
                        for (String name : r.getNames()) {
                            if (willRemove(e).equals(name)) {
                                return false;
                            }
                        }
                    }
                    equip(e);
                    if (!isEquipped(e)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean inventReady(Requirements req) {
        for (SlayerItem i : req.getItems()) {
            if (!isInInvent(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isInInvent(Finisher fin) {
        for (Item item : Inventory.getItems()) {
            for (String name : fin.getNames()) {
                if (item.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isInBank(Finisher fin) {
        for (Item item : Bank.getItems()) {
            for (String name : fin.getNames()) {
                if (item.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isInInvent(Starter start) {
        for (Item item : Inventory.getItems()) {
            for (String name : start.getNames()) {
                if (item.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isInBank(Starter start) {
        for (Item item : Bank.getItems()) {
            for (String name : start.getNames()) {
                if (item.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        return false;
    }



    public class Paint {
        public String Current = "Loading...";
	    public Image closed;
        public Image tabOne;
        public Image tabTwo;
        public final Rectangle hideRect = new Rectangle(477, 336, 34, 37);
        public final Rectangle tabOneRect = new Rectangle(177, 335, 147, 37);
        public final Rectangle tabTwoRect = new Rectangle(327, 336, 148, 37);

	    public Paint () {
		    URL resource = this.getClass().getClassLoader().getResource("/resources/slosedc.png");
			if (resource != null) {
				try {
					closed = ImageIO.read(resource);
					resource = this.getClass().getClassLoader().getResource("/resources/gentab.png");
					tabOne = ImageIO.read(resource);
					resource = this.getClass().getClassLoader().getResource("/resources/exptab.png");
					tabTwo = ImageIO.read(resource);
				} catch (Exception ignored) {}
			} else {
				closed = getImage("https://github.com/Zalgo2462/PowerSlayer/tree/master/resources/closedc.png");
				tabOne = getImage("https://github.com/Zalgo2462/PowerSlayer/tree/master/resources/gentab.png");
				tabTwo = getImage("https://github.com/Zalgo2462/PowerSlayer/tree/master/resources/exptab.png");
			}
	    }

	    private Image getImage(String url) {
			try {
				return ImageIO.read(new URL(url));
			} catch (IOException e) {
				return null;
            }
        }
    }

	enum Skill {
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

    private void drawSkillBars(Graphics g) {
        for (Skill s : Skill.values()) {
            int x = s.index <= 3 ? 20 : 180;
            int y = s.index <= 3 ? 390 + (s.index * 20)
                    : 390 + ((s.index - 3) * 20);
            g.setColor(new Color(153, 153, 153));
            g.drawRect(x, y, 150, 15);
            g.setColor(new Color(0, 0, 0, 80));
            g.fillRect(x, y,
                    (int) (Skills.getPercentToLevel(s.skillID) * 1.5), 15);
            g.setColor(new Color(90, 15, 15));
            g.setFont(new Font("Serif", 0, 12));
            g.drawString(
                    s.skillName + ": "
                            + Skills.getPercentToLevel(s.skillID)
                            + "% to level "
                            + (Skills.getAbsoluteLevel(s.skillID) + 1), x + 4,
                    y + 12);
            g.setColor(new Color(255, 255, 255, 90));
            g.drawString(
                    s.skillName + ": "
                            + Skills.getPercentToLevel(s.skillID)
                            + "% to level "
                            + (Skills.getAbsoluteLevel(s.skillID) + 1), x + 5,
                    y + 13);
        }
    }

    public void mouseClicked(MouseEvent e) {
        if (paint.hideRect.contains(e.getPoint())) {
            tab = 3;
        } else if (paint.tabOneRect.contains(e.getPoint())) {
            tab = 1;
        } else if (paint.tabTwoRect.contains(e.getPoint())) {
            tab = 2;
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





    /**
     * Gets the rune count, including staves
     *
     * @param rune the Rune
     * @return rune count
     */
    public int getRuneCount(Rune rune) {
        if (rune.isElemental()) {
            String wepName = Equipment
                    .getItem(org.rsbot.script.methods.Equipment.WEAPON) != null ? Equipment
                    .getItem(org.rsbot.script.methods.Equipment.WEAPON)
                    .getName() : "";
            if (rune == Rune.WATER) {
                String shieldName = Equipment
                        .getItem(org.rsbot.script.methods.Equipment.SHIELD) != null ? Equipment
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
        return Inventory.getCount(true, rune.getItemIDs());
    }

    public void setMethodBase() {
        if (methodBase == null)
            methodBase = new MethodBase(this);
        methodBase.account = new Account();
        methodBase.bank = new Bank();
        methodBase.calculations = new Calculations();
        methodBase.camera = new Camera();
        methodBase.clanChat = new ClanChat();
        methodBase.combat = new Combat();
        methodBase.environment = new Environment();
        methodBase.equipment = new Equipment();
        methodBase.friendChat = new FriendChat();
        methodBase.game = new Game();
        //methodBase.grandExchange = new GrandExchange();
        methodBase.groundItems = new GroundItems();
        //methodBase.hiscores = new Hiscores();
        methodBase.interfaces = new Interfaces();
        methodBase.inventory = new Inventory();
        methodBase.keyboard = new Keyboard();
        methodBase.lobby = new Lobby();
        methodBase.magic = new Magic();
        methodBase.menu = new Menu();
        methodBase.mouse = new Mouse();
        methodBase.npcs = new NPCs();
        methodBase.objects = new Objects();
        methodBase.players = new Players();
        methodBase.prayer = new Prayer();
        methodBase.projectiles = new Projectiles();
        methodBase.quests = new Quests();
        methodBase.settings = new Settings();
        methodBase.skills = new Skills();
        //methodBase.store = new Store();
        //methodBase.summoning = new Summoning();
        methodBase.tiles = new Tiles();
        //methodBase.trade = new Trade();
        methodBase.walking = new Walking();
        //methodBase.web = new Web();
    }
}
