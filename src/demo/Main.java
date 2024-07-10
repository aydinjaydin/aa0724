package demo;

import java.time.LocalDate;

public class Main {
    public static void main(String args[]) {
        Inventory inventory = new Inventory();
        Store store = new Store(inventory);
        RentalAgreement rentalAgreement = store.checkout(ToolCode.LADW, LocalDate.of(2020,7,2), 300, 10);
        rentalAgreement.print();
    }
}
