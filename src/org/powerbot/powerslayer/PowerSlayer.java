package org.powerbot.powerslayer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.powerbot.powerslayer.abstracts.State;
import org.powerbot.powerslayer.data.SlayerMaster;
import org.powerbot.powerslayer.methods.UniversalFighter.Loot;
import org.powerbot.powerslayer.methods.UniversalFighter.Potion;
import org.powerbot.powerslayer.methods.UniversalFighter.SlayerNPCs;
import org.powerbot.powerslayer.methods.UniversalFighter.Tiles;
import org.powerbot.powerslayer.wrappers.Task;
import org.rsbot.bot.event.events.MessageEvent;
import org.rsbot.script.Script;
import org.rsbot.script.ScriptManifest;
import org.rsbot.script.internal.event.MessageListener;
import org.rsbot.script.internal.event.PaintListener;
import org.rsbot.script.methods.Skills;

@ScriptManifest(authors = {"Powerbot Scripters Team"}, name = "Power Slayer", version = 1.00, description = "The best universal slayer bot!")
public class PowerSlayer extends Script implements PaintListener, MouseListener, MessageListener {

	public static Task currentTask;
	public SlayerMaster slayerMaster;

	private static ArrayList<State> states = new ArrayList<State>();

	private int tab = 1;


	@Override
	public boolean onRun() {
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

	@SuppressWarnings("unused")
	private static int getStateLoop() {
		for (State state : states) {
			if (state.activeCondition()) {
				return state.loop();
			}
		}
		return -1;
	}

	public void messageReceived(MessageEvent messageEvent) {
		if(messageEvent.getMessage().equals("You can't reach that.")) {
			if(Loot.itemWasClickedLast && Loot.lastClickedItem != null) {
				Tiles.addBadTile(Loot.lastClickedItem.getLocation());
			} else if(SlayerNPCs.npcWasClickedLast && SlayerNPCs.lastClickedNPC != null) {
				Tiles.addBadTile(SlayerNPCs.lastClickedNPC.getLocation());
			}
		} else if(messageEvent.getMessage().equals("You don't have any quick prayers selected.")) {
			Potion.setQuickPrayer = false;
			log("You must set your quick prayers to use prayer potions.");
		}
	}

	//Start Paint

	public static class Paint {
		public static String Current = "Loading...";
		public static Image closed = null, tabOne = null, tabTwo = null;
		public static final Rectangle 
			hideRect = new Rectangle(477, 336, 34, 37), 
			tabOneRect = new Rectangle(177, 335, 147, 37),
			tabTwoRect = new Rectangle(327, 336, 148, 37);

		public Paint () {
			URL resource = this.getClass().getClassLoader().getResource("/resources/closedc.png");
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

		private static Image getImage(String url) {
			try {
				return ImageIO.read(new URL(url));
			} catch (IOException e) {
				return null;
			}
		}
	}

	enum Skill {
		ATTACK (Skills.ATTACK, "Attack", 1),
		CONSTITUTION (Skills.CONSTITUTION, "Constitution", 4),
		DEFENCE (Skills.DEFENSE, "Defence", 3),
		MAGIC (Skills.MAGIC, "Magic", 6),
		RANGE (Skills.RANGE, "Range", 5),
		SLAYER (Skills.SLAYER, "Slayer", 0),
		STRENGTH (Skills.STRENGTH, "Strength", 2);

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
			g.drawImage(Paint.tabOne, -1, 293, null);
		} else if (tab == 2) {
			g.drawImage(Paint.tabTwo, -1, 293, null);
			drawSkillBars(g);
		} else {
			g.drawImage(Paint.closed, 162, 293, null);
		}
	}

	private static void drawSkillBars(Graphics g) {
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
		if (Paint.hideRect.contains(e.getPoint())) {
			tab = 3;
		} else if (Paint.tabOneRect.contains(e.getPoint())) {
			tab = 1;
		} else if (Paint.tabTwoRect.contains(e.getPoint())) {
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
