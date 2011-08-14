package org.powerbot.powerslayer.methods;

import org.powerbot.powerslayer.common.DMethodProvider;
import org.powerbot.powerslayer.common.MethodBase;
import org.powerbot.powerslayer.data.Monster;
import org.powerbot.powerslayer.data.SlayerMaster;
import org.powerbot.powerslayer.wrappers.Task;
import org.rsbot.script.methods.Interfaces;
import org.rsbot.script.methods.NPCs;
import org.rsbot.script.methods.Players;
import org.rsbot.script.methods.Skills;
import org.rsbot.script.wrappers.NPC;

import java.util.ArrayList;

public class SlayerMasters extends DMethodProvider {
	public SlayerMasters(MethodBase methods) {
		super(methods);
	}

	public SlayerMaster getBestSlayerMaster() {
		ArrayList<SlayerMaster> possibleMasters = new ArrayList<SlayerMaster>();
		for(SlayerMaster master : SlayerMaster.values()) {
			if(master.getSlayerLevel() < Skills.getLevel(Skills.SLAYER) &&
					master.getCombatLevel() < Players.getMyPlayer().getCombatLevel()) {
				possibleMasters.add(master);
			}
		}
		if(possibleMasters.size() < 1) {
			return null;
		}
		if(possibleMasters.size() == 1) {
			return possibleMasters.get(0);
		}
		if(possibleMasters.size() > 1) {
			SlayerMaster best = null;
			for(SlayerMaster master : possibleMasters) {
				if(best == null || master.getCombatLevel() > best.getCombatLevel()) {
					best = master;
				}
			}

			for(SlayerMaster master : possibleMasters) {
				if(best == null || master.getSlayerLevel() > best.getSlayerLevel()) {
					best = master;
				}
			}
			return best;
		}
		return null;
	}

	public Task getTaskFromMaster(SlayerMaster master) {
		NPC npc = getMasterNPC(master);
		if(npc != null) {
			if(npc.interact("Get-Task")) {
				long time = System.currentTimeMillis();
				while(Interfaces.getComponent(64, 4) == null &&
						!Interfaces.getComponent(64, 4).getText().equals("I need another assignment") &&
						System.currentTimeMillis() - time < 10000) {
					sleep(random(50, 80));
				}

				if(Interfaces.canContinue()) {
					Interfaces.clickContinue();
				}

				time = System.currentTimeMillis();
				while(Interfaces.getComponent(64, 4) == null &&
						!Interfaces.getComponent(64, 4).getText().contains("Your new task is to kill") &&
						System.currentTimeMillis() - time < 10000) {
					sleep(random(50, 80));
				}
				//make sure we have the right page instead of referring to another master
				if(Interfaces.getComponent(64, 4) == null &&
						Interfaces.getComponent(64, 4).getText().contains("Your new task is to kill")) {
					int amount = 0;
					Monster monster = null;
					String string = Interfaces.getComponent(64, 4).getText();
					String subString = string.substring(string.indexOf("kill") + 5);
					if(subString.length() != 0 && subString.contains(" ")) {
						String[] words = subString.split(" ");
						if(words.length != 0) {
							amount = Integer.parseInt(words[0]);
							for(Monster mon : Monster.values()) {
								for(String name : mon.getNames()) {
									if(words[1].equals(name)) {
										monster = mon;
									}
								}
							}
						}
					}
					return new Task(monster, amount, master);
				}
			}
		}
		return null;
	}

	public NPC getMasterNPC(SlayerMaster master) {
		NPC masterNPC = null;
		for(String name : master.getNames()) {
			if(NPCs.getNearest(name) != null) {
				return masterNPC;
			}
		}
		return null;
	}
}
