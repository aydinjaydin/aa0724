package demo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Store {
    private final Inventory inventory;

    public Store(Inventory inventory) {
        this.inventory = inventory;
    }

    public RentalAgreement checkout(ToolCode toolCode, LocalDate checkoutDate, int rentalDays, int discountPercentage) {
        Tool tool = inventory.getTool(toolCode);
        ToolChargeFeeData feeData = inventory.getToolFeeData(tool.getToolType());
        CheckoutRequest checkoutRequest = new CheckoutRequest(tool, feeData, checkoutDate, rentalDays, discountPercentage);

        RentalAgreement rentalAgreement = RentalAgreement.forCheckout(checkoutRequest);

        LocalDate dueDate = calculateDueDate(checkoutRequest);
        rentalAgreement.setDueDate(dueDate);

        int chargeableDays = calculateTotalChargeableDays(checkoutRequest);
        rentalAgreement.setCountOfChargeableDays(chargeableDays);

        BigDecimal preDiscountChargeAmount = calculatePrediscountCharge(checkoutRequest.getFeeData().getDailyCharge(), chargeableDays);
        rentalAgreement.setPreDiscountChargeAmount(preDiscountChargeAmount);

        BigDecimal discountAmount = calculateDiscountAmount(preDiscountChargeAmount, checkoutRequest.getDiscountPercentage());
        rentalAgreement.setDiscountAmount(discountAmount);

        BigDecimal finalChargeAmount = calculateFinalChargeAmount(preDiscountChargeAmount, discountAmount);
        rentalAgreement.setFinalChargeAmount(finalChargeAmount);

        return rentalAgreement;
    }

    private LocalDate calculateDueDate(CheckoutRequest checkoutRequest) {
        LocalDate checkoutDate = checkoutRequest.getCheckoutDate();
        int rentalDays = checkoutRequest.getRentalDays();
        return checkoutDate.plusDays(rentalDays);
    }

    private int calculateTotalChargeableDays(CheckoutRequest checkoutRequest) {
        ToolChargeFeeData feeData = checkoutRequest.getFeeData();
        LocalDate firstRentalDay = checkoutRequest.getCheckoutDate().plusDays(1);
        LocalDate dueDate = firstRentalDay.plusDays(checkoutRequest.getRentalDays());
        List<LocalDate> rentalDays = firstRentalDay.datesUntil(dueDate).collect(Collectors.toList());
        WeekendPredicate isWeekend = new WeekendPredicate();
        HolidayPredicate isHoliday = new HolidayPredicate();
        int totalChargeDays = 0;
        for(LocalDate rentalDay : rentalDays) {
            if(isWeekend.test(rentalDay)) {
                if(feeData.isWeekendCharge()) {
                    totalChargeDays++;
                }
            }
            else if(isHoliday.test(rentalDay)) {
                if(feeData.isHolidayCharge()) {
                    totalChargeDays++;
                }
            }
            else {
                if(feeData.isWeekdayCharge()) {
                    totalChargeDays++;
                }
            }
        }
        return totalChargeDays;
    }

    private BigDecimal calculatePrediscountCharge(BigDecimal dailyChargeAmount, int chargeableDays) {
        return dailyChargeAmount.multiply(BigDecimal.valueOf(chargeableDays))
                .setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateDiscountAmount(BigDecimal preDiscountChargeAmount, int discountPercentage) {
        return preDiscountChargeAmount.multiply(BigDecimal.valueOf(discountPercentage))
                .divide(BigDecimal.valueOf(100))
                .setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateFinalChargeAmount(BigDecimal preDiscountChargeAmount, BigDecimal discountAmount) {
        return preDiscountChargeAmount.subtract(discountAmount)
                .setScale(2, RoundingMode.HALF_UP);
    }
}
