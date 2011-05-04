class Equipment {
    private String[] names;
    private int slot;

    public Equipment(String[] names, int slot) {
        this.names = names;
        this.slot = slot;
    }

    public Equipment(String name, int slot) {
        this(new String[]{name}, slot);
    }

    public String[] getNames() {
        return this.names;
    }

    public int getSlot() {
        return this.slot;
    }
}