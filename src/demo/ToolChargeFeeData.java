package demo;

import java.math.BigDecimal;

public class ToolChargeFeeData {

    private final BigDecimal dailyCharge;
    private final boolean weekdayCharge;
    private final boolean weekendCharge;
    private final boolean holidayCharge;

    public ToolChargeFeeData(BigDecimal dailyCharge, boolean weekdayCharge, boolean weekendCharge, boolean holidayCharge) {
        this.dailyCharge = dailyCharge;
        this.weekdayCharge = weekdayCharge;
        this.weekendCharge = weekendCharge;
        this.holidayCharge = holidayCharge;
    }

    public BigDecimal getDailyCharge() {
        return dailyCharge;
    }

    public boolean isWeekdayCharge() {
        return weekdayCharge;
    }

    public boolean isWeekendCharge() {
        return weekendCharge;
    }

    public boolean isHolidayCharge() {
        return holidayCharge;
    }
}
