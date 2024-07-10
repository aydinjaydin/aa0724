package demo;

import java.time.LocalDate;

public class CheckoutRequest {
    private final Tool tool;
    private final ToolChargeFeeData feeData;
    private final LocalDate checkoutDate;
    private final int rentalDays;
    private final int discountPercentage;

    public CheckoutRequest(Tool tool, ToolChargeFeeData feeData, LocalDate checkoutDate, int rentalDays, int discountPercentage) {
        if(rentalDays < 1) {
            throw new IllegalArgumentException("Invalid rental days. Rental days can't be less than one. Tools should be rented for 1 or more days");
        }
        if(discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Invalid discount percentage. Discount percentage should be between 0 and 100");
        }
        this.tool = tool;
        this.feeData = feeData;
        this.checkoutDate = checkoutDate;
        this.rentalDays = rentalDays;
        this.discountPercentage = discountPercentage;
    }

    public Tool getTool() {
        return tool;
    }

    public ToolChargeFeeData getFeeData() {
        return feeData;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }
}
