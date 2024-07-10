package demo;

public enum ToolType {
    CHAINSAW("Chainsaw"),
    LADDER("Ladder"),
    JACKHAMMER("Jackhammer");
    private String name;

    public String getName() { return name; }

    ToolType(String name) {
        this.name = name;
    }
}
