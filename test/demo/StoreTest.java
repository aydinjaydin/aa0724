package demo;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

class StoreTest {

    private Store store;

    @BeforeEach
    void setup() {
        store = new Store(new Inventory());
    }

    @AfterEach
    void tearDown() {
        store = null;
    }

    @Test
    public void test1_invalidDiscountPercentageThrowsException() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> store.checkout(ToolCode.JAKR, LocalDate.of(2015, 9, 3), 5, 101) );
    }

    @Test
    public void test2_ladderRental_4thOfJuly_onSaturday() {
        RentalAgreement agreement = store.checkout(ToolCode.LADW, LocalDate.of(2020, 7,2), 3, 10);
        Assertions.assertEquals(BigDecimal.valueOf(3.58), agreement.getFinalChargeAmount());
    }

    @Test
    public void test3_chainsaw_4thOfJulyOnSaturday_holidayCharge_noWeekendCharge() {
        RentalAgreement agreement = store.checkout(ToolCode.CHNS, LocalDate.of(2015, 7,2), 5, 25);
        Assertions.assertEquals(BigDecimal.valueOf(3.35), agreement.getFinalChargeAmount());
    }

    @Test
    public void test4_jackhammer_includingMemorialDay_noWeekendCharge_noHolidayCharge_3ChargeableDays() {
        RentalAgreement agreement = store.checkout(ToolCode.JAKD, LocalDate.of(2015, 9,3), 6, 0);
        Assertions.assertEquals(BigDecimal.valueOf(8.97), agreement.getFinalChargeAmount());
    }

    @Test
    public void test5_jackhammer_4thOfJulyOnSaturday_noWeekendCharge_noHolidayCharge_5ChargeableDays() {
        RentalAgreement agreement = store.checkout(ToolCode.JAKR, LocalDate.of(2015, 7,2), 9, 0);
        Assertions.assertEquals(BigDecimal.valueOf(14.95), agreement.getFinalChargeAmount());
    }

    @Test
    public void test6_jackhammer_4thOfJulyOnSaturday_noWeekendCharge_noHolidayCharge_1chargeableDay_withDiscount() {
        RentalAgreement agreement = store.checkout(ToolCode.JAKR, LocalDate.of(2020, 7,2), 4, 50);
        Assertions.assertEquals(BigDecimal.valueOf(1.49), agreement.getFinalChargeAmount());
    }
}