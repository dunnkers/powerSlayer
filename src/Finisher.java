class Finisher {
	private String[] names;
	private int amount;

	public Finisher(String[] names, int amount) {
		this.names = names;
		this.amount = amount;
	}

	public Finisher(String[] names) {
		this(names, 1);
	}

	public Finisher(String name) {
		this(new String[] { name }, 1);
	}

	public Finisher(String name, int amount) {
		this(new String[] { name }, amount);
	}

	public Finisher(String[] names, boolean full) {
		this(names, (full ? 28 : 1));
	}

	public Finisher(String name, boolean full) {
		this(new String[] { name }, (full ? 28 : 1));
	}

	public int getAmount() {
		return this.amount;
	}

	public String[] getNames() {
		return this.names;
	}
}