package demo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<ToolCode, Tool> tools = new HashMap<>();

    private final Map<ToolType, ToolChargeFeeData> fees = new HashMap<>();

    public Inventory() {
        initInventory();
        initFees();
    }

    public Tool getTool(ToolCode toolCode) {
        return tools.get(toolCode);
    }

    public ToolChargeFeeData getToolFeeData(ToolType toolType) {
        return fees.get(toolType);
    }

    private void initInventory() {
        tools.put(ToolCode.CHNS, new Tool(ToolCode.CHNS, ToolType.CHAINSAW, ToolBrand.STIHL));
        tools.put(ToolCode.LADW, new Tool(ToolCode.LADW, ToolType.LADDER, ToolBrand.WERNER));
        tools.put(ToolCode.JAKD, new Tool(ToolCode.JAKD, ToolType.JACKHAMMER, ToolBrand.DEWALT));
        tools.put(ToolCode.JAKR, new Tool(ToolCode.JAKR, ToolType.JACKHAMMER, ToolBrand.RIDGIT));
    }

    private void initFees() {
        fees.put(ToolType.LADDER, new ToolChargeFeeData(new BigDecimal("1.99"), true, true, false));
        fees.put(ToolType.CHAINSAW, new ToolChargeFeeData(new BigDecimal("1.49"), true, false, true));
        fees.put(ToolType.JACKHAMMER, new ToolChargeFeeData(new BigDecimal("2.99"), true, false, false));
    }
}
