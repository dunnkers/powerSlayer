class Task {
	private Monsters monster;

	private Task(Monsters monster) {
		this.monster = monster;
	}

	public Requirements getRequirements() {
		return this.monster.getRequirements();
	}

	public Monsters getMonster() {
		return this.monster;
	}

	public void setMonster(Monsters monster) {
		this.monster = monster;
	}
}