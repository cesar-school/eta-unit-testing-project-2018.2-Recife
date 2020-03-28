package school.cesar.eta.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//4545

public class LeapYearTest {
    @Test
    public void isLeapYear_yearNonDivisibleByFour_false() {
        Assertions.assertFalse(LeapYear.isLeapYear(3));
    }

    @Test
    public void isLeapYear_yearDivisibleByFour_true() {
        Assertions.assertTrue(LeapYear.isLeapYear(4));
    }

    @Test
    public void isLeapYear_yearDivisibleByAHundred_false() {
        Assertions.assertFalse(LeapYear.isLeapYear(100));
    }

    @Test
    public void isLeapYear_yearDivisibleByFourHundreds_True() {
        Assertions.assertTrue(LeapYear.isLeapYear(400));
    }
}
