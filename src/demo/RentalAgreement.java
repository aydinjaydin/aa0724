package demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RentalAgreement {

    private ToolCode toolCode;
    private ToolType toolType;
    private ToolBrand toolBrand;
    private int rentalDays;
    private LocalDate checkoutDate;
    private int discountPercent;
    private BigDecimal dailyRentalCharge;
    private LocalDate dueDate;

    private int countOfChargeableDays;

    private BigDecimal preDiscountChargeAmount;
    private BigDecimal discountAmount;
    private BigDecimal finalChargeAmount;

    public static RentalAgreement forCheckout(CheckoutRequest checkoutRequest) {
        RentalAgreement rentalAgreement = new RentalAgreement();
        rentalAgreement.toolCode = checkoutRequest.getTool().getToolCode();
        rentalAgreement.toolType = checkoutRequest.getTool().getToolType();
        rentalAgreement.toolBrand = checkoutRequest.getTool().getToolBrand();
        rentalAgreement.rentalDays = checkoutRequest.getRentalDays();
        rentalAgreement.checkoutDate = checkoutRequest.getCheckoutDate();
        rentalAgreement.discountPercent = checkoutRequest.getDiscountPercentage();
        rentalAgreement.dailyRentalCharge = checkoutRequest.getFeeData().getDailyCharge();
        return rentalAgreement;
    }

    public void print() {
        System.out.println("Tool code: " + toolCode);
        System.out.println("Tool type: " + toolType);
        System.out.println("Tool brand: " + toolBrand);
        System.out.println("Rental days: " + rentalDays);
        System.out.println("Checkout date: " + checkoutDate.format(DateTimeFormatter.ofPattern("MM/dd/yy")));
        System.out.println("Due date: " + dueDate.format(DateTimeFormatter.ofPattern("MM/dd/yy")));
        System.out.println("Daily rental charge: $" + dailyRentalCharge);
        System.out.println("Charge days: " + countOfChargeableDays);
        System.out.println("Pre-discount charge: $" + preDiscountChargeAmount);
        System.out.println("Discount percent: " + discountPercent + "%");
        System.out.println("Discount amount: $" + discountAmount);
        System.out.println("Final charge: $" + finalChargeAmount);
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

    public int getRentalDays() {
        return rentalDays;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public BigDecimal getDailyRentalCharge() {
        return dailyRentalCharge;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public int getCountOfChargeableDays() {
        return countOfChargeableDays;
    }

    public void setCountOfChargeableDays(int countOfChargeableDays) {
        this.countOfChargeableDays = countOfChargeableDays;
    }

    public BigDecimal getPreDiscountChargeAmount() {
        return preDiscountChargeAmount;
    }

    public void setPreDiscountChargeAmount(BigDecimal preDiscountChargeAmount) {
        this.preDiscountChargeAmount = preDiscountChargeAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getFinalChargeAmount() {
        return finalChargeAmount;
    }

    public void setFinalChargeAmount(BigDecimal finalChargeAmount) {
        this.finalChargeAmount = finalChargeAmount;
    }

    @Override
    public String toString() {
        return "RentalAgreement{" +
                "toolCode=" + toolCode +
                ", toolType=" + toolType +
                ", toolBrand=" + toolBrand +
                ", rentalDays=" + rentalDays +
                ", checkoutDate=" + checkoutDate +
                ", discountPercent=" + discountPercent +
                ", dailyRentalCharge=" + dailyRentalCharge +
                ", dueDate=" + dueDate +
                ", countOfChargeableDays=" + countOfChargeableDays +
                ", preDiscountChargeAmount=" + preDiscountChargeAmount +
                ", discountAmount=" + discountAmount +
                ", finalChargeAmount=" + finalChargeAmount +
                '}';
    }
}
