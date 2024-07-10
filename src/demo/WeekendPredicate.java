package demo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Set;
import java.util.function.Predicate;

public class WeekendPredicate implements Predicate<LocalDate> {

    private final Set<DayOfWeek> weekend = Set.of(
            DayOfWeek.SATURDAY, DayOfWeek.SUNDAY
    );

    @Override
    public boolean test(LocalDate localDate) {
        return weekend.contains(localDate.getDayOfWeek());
    }
}
