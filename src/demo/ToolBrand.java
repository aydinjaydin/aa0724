package demo;

public enum ToolBrand {
    STIHL("Stihl"),
    WERNER("Werner"),
    DEWALT("DeWalt"),
    RIDGIT("Ridgid");

    private String name;
    ToolBrand(String name) {
        this.name = name;
    }
}
