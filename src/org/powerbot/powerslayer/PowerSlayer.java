package org.powerbot.powerslayer;

import org.powerbot.powerslayer.abstracts.State;
import org.powerbot.powerslayer.common.MethodBase;
import org.powerbot.powerslayer.data.SlayerMaster;
import org.powerbot.powerslayer.states.*;
import org.powerbot.powerslayer.wrappers.Task;
import org.rsbot.bot.event.events.MessageEvent;
import org.rsbot.script.Script;
import org.rsbot.script.ScriptManifest;
import org.rsbot.script.internal.event.MessageListener;
import org.rsbot.script.internal.event.PaintListener;
import org.rsbot.script.methods.Skills;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

@ScriptManifest(authors = {"Powerbot Scripters Team"}, name = "Power Slayer", version = 1.00, description = "The best universal slayer bot!")
public class PowerSlayer extends Script implements PaintListener, MouseListener, MessageListener {

	public static Task currentTask;
	public SlayerMaster slayerMaster;

	private ArrayList<State> states = new ArrayList<State>();
	public MethodBase methodBase = null;

	private int tab = 1;
	public Paint paint = new Paint();


	@Override
	public boolean onRun() {
		//TODO: Decide where a player must start the script
		initalizeMethodBase();
		initStates();
		return true;
	}

	@Override
	protected int loop() {
		// Loop through every state, first one active will be executed.
		for (State state : states) {
			if (state.activeCondition()) {
				return state.loop();
			}
		}
		return -1;
	}

	public void initalizeMethodBase() {
		if (methodBase == null) {
			methodBase = new MethodBase(this);
		}
	}

	public void initStates() {
		states.add(new GetTaskState(methodBase));
		states.add(new GoToMasterState(methodBase));
		states.add(new GoToBankState(methodBase));
		states.add(new GoToMonsterState(methodBase));
		states.add(new BankingState(methodBase));
		states.add(new FighterState(methodBase));
	}

	@SuppressWarnings("unused")
	private int getStateLoop() {
		for (State state : states) {
			if (state.activeCondition()) {
				return state.loop();
			}
		}
		return -1;
	}

	public void messageReceived(MessageEvent messageEvent) {
		if(messageEvent.getMessage().equals("You can't reach that.")) {
			if(methodBase.fighter.loot.itemWasClickedLast && methodBase.fighter.loot.lastClickedItem != null) {
				methodBase.fighter.tiles.addBadTile(methodBase.fighter.loot.lastClickedItem.getLocation());
			} else if(methodBase.fighter.npcs.npcWasClickedLast && methodBase.fighter.npcs.lastClickedNPC != null) {
				methodBase.fighter.tiles.addBadTile(methodBase.fighter.npcs.lastClickedNPC.getLocation());
			}
		} else if(messageEvent.getMessage().equals("You don't have any quick prayers selected.")) {
			methodBase.fighter.pot.setQuickPrayer = false;
			log("You must set your quick prayers to use prayer potions.");
		}
	}

	//Start Paint

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
		ATTACK(Skills.ATTACK, "Attack", 1),
		CONSTITUTION(Skills.CONSTITUTION, "Constitution", 4),
		DEFENCE(Skills.DEFENSE, "Defence", 3),
		MAGIC(Skills.MAGIC, "Magic", 6),
		RANGE(Skills.RANGE, "Range", 5),
		SLAYER(Skills.SLAYER, "Slayer", 0),
		STRENGTH(Skills.STRENGTH, "Strength", 2);

		int skillID;
		String skillName;
		int index;

		private Skill(int skillID, String skillName, int index) {
			this.skillID = skillID;
			this.skillName = skillName;
			this.index = index;
		}
	}

	public void onRepaint(Graphics g) {
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
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
}
