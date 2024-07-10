package demo;

public class Tool {
    private ToolCode toolCode;
    private ToolType toolType;
    private ToolBrand toolBrand;

    public Tool(ToolCode toolCode, ToolType toolType, ToolBrand toolBrand) {
        this.toolCode = toolCode;
        this.toolType = toolType;
        this.toolBrand = toolBrand;
    }

    public ToolCode getToolCode() {
        return toolCode;
    }

    public ToolType getToolType() {
        return toolType;
    }

    public ToolBrand getToolBrand() {
        return toolBrand;
    }
}
