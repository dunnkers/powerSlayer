package org.powerbot.powerslayer.methods;

import org.powerbot.powerslayer.PowerSlayer;
import org.powerbot.powerslayer.common.DMethodProvider;
import org.powerbot.powerslayer.data.Monsters;
import org.powerbot.powerslayer.data.Monsters.Monster;
import org.powerbot.powerslayer.data.SlayerMaster;
import org.powerbot.powerslayer.wrappers.Task;
import org.rsbot.script.methods.NPCs;
import org.rsbot.script.methods.ui.Interfaces;
import org.rsbot.script.wrappers.NPC;

//TODO: Peer review code
public class SlayerMasters extends DMethodProvider {
	
	public SlayerMasters(PowerSlayer parent) {
		super(parent);
	}

	public static SlayerMaster getBestUsableMaster() {
		SlayerMaster[] masters = SlayerMaster.values();
		for (int i = masters.length; i > 0; i--) {
			SlayerMaster currMaster = masters[i];
			if (currMaster.canUse())
				return currMaster;
		}
		return null;
	}

	//TODO: Dan's method  (I have no clue where your going with this so i just wont touch it)
	public boolean getTask(NPC SlayerMaster) {
		return Interfaces.getComponent(64, 4) != null || SlayerMaster.interact("Get-Task") && waitIf(2000, new Condition() {
			public boolean isTrue() {
				return Interfaces.getComponent(64, 4).getText().equals("I need another assignment");
			}
		});
	}

	//TODO: Overly complicated.  Make multiple methods
	public static Task getTaskFromMaster(SlayerMaster master) {
		NPC npc = getNearestMaster();
		if (npc != null) {
			if (npc.interact ("Get-Task")) {
				long time = System.currentTimeMillis ();
				while (Interfaces.getComponent(64, 4) == null &&
						!Interfaces.getComponent(64, 4).getText ().equals("I need another assignment") &&
						System.currentTimeMillis () - time < 10000) {
					sleep (random (50, 80));
				}

				if (Interfaces.canContinue ()) {
					Interfaces.clickContinue ();
				}

				time = System.currentTimeMillis ();
				while (Interfaces.getComponent (64, 4) == null &&
						!Interfaces.getComponent (64, 4).getText ().contains("Your new task is to kill") &&
						System.currentTimeMillis () - time < 10000) {
					DMethodProvider.sleep (random (50, 80));
				}
				//make sure we have the right page instead of referring to another master
				if (Interfaces.getComponent (64, 4) == null &&
						Interfaces.getComponent (64, 4).getText ().contains("Your new task is to kill")) {
					int amount = 0;
					Monster monster = null;
					String string = Interfaces.getComponent (64, 4).getText ();
					String subString = string.substring (string.indexOf ("kill") + 5);
					if (subString.length () != 0 && subString.contains (" ")) {
						String[] words = subString.split (" ");
						if (words.length == 2) {
							amount = Integer.parseInt(words[0]);
							for (Monster mon : Monster.values()) {
								if (mon.getNames() == null)
									continue;
								for (String name : mon.getNames()) {
									if (words[1].equals(name)) {
										monster = mon;
										return new Task (monster, amount, master);
									}
								}
							}
							for (Monsters.MonsterGroup mg : Monsters.MonsterGroup.values ()) {
								if (mg.toString ().equals (words[1])) {
									return new Task(mg, amount, master);
								}
							}
						}
					}
				}
			}
		}
		return null;
	}

	public static NPC getNearestMaster() {
		for (SlayerMaster currMaster : SlayerMaster.values()) {
			NPC master = NPCs.getNearest(currMaster.getNames());
			if (master != null) 
				return master;
		}
		return null;
	}
}
