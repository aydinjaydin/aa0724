package demo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.function.Predicate;

public class HolidayPredicate implements Predicate<LocalDate> {
    @Override
    public boolean test(LocalDate localDate) {
        // Independence day
        if(Month.JULY.equals(localDate.getMonth()) ) {
            LocalDate fourthOfJuly = LocalDate.of(localDate.getYear(), localDate.getMonth(), 4);
            if(localDate.equals(fourthOfJuly)) {
                return !DayOfWeek.SATURDAY.equals(localDate.getDayOfWeek()) &&
                        !DayOfWeek.SUNDAY.equals(localDate.getDayOfWeek());
            }
            else if(DayOfWeek.SATURDAY.equals(fourthOfJuly.getDayOfWeek())) {
                LocalDate dayBefore4th = fourthOfJuly.minusDays(1);
                return localDate.equals(dayBefore4th);
            }
            else if(DayOfWeek.SUNDAY.equals(fourthOfJuly.getDayOfWeek())) {
                LocalDate dayAfter4th = fourthOfJuly.plusDays(1);
                return localDate.equals(dayAfter4th);
            }

        }
        // Memorial day, check if it is the first Monday of September
        else if(Month.SEPTEMBER.equals(localDate.getMonth()) && DayOfWeek.MONDAY.equals(localDate.getDayOfWeek())) {
            LocalDate oneWeekBefore = localDate.minusWeeks(1);
            return Month.AUGUST.equals(oneWeekBefore.getMonth());
        }
        return false;
    }
}
