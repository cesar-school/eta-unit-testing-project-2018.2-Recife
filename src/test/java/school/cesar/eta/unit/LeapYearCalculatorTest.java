package school.cesar.eta.unit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Year;

public class LeapYearCalculatorTest {

    private Integer currentYear;
    private LeapYearCalculator leapYearCalculator;

    @BeforeEach
    public void setUp(){
        currentYear = null;
        leapYearCalculator = new LeapYearCalculator() {
            @Override
            public int getCurrentYear() {
                return currentYear;
            }
        };
    }

    @Test
    public void isCurrentYear_confirmCurrentYear_currentYearTrue() {
        Assertions.assertEquals(Year.now().getValue(), new LeapYearCalculator().getCurrentYear());
    }

    @Test
    public void isLeapYear_yearNonDivisibleByFour_false() {
        currentYear = 2003;
        Assertions.assertFalse(leapYearCalculator.isCurrentYearLeapYear());
    }

    @Test
    public void isLeapYear_yearDivisibleByFourNotDivisibleByOneHundred_true() {
        currentYear = 2004;
        Assertions.assertTrue(leapYearCalculator.isCurrentYearLeapYear());
    }

    @Test
    public void isLeapYear_yearDivisibleByFourDivisibleByOneHundredNotDivisibleByFourHundred_false() {
        currentYear = 3000;
        Assertions.assertFalse(leapYearCalculator.isCurrentYearLeapYear());
    }

    @Test
    public void isLeapYear_yearDivisibleByFourDivisibleByOneHundredDivisibleByFourHundred_true() {
        currentYear = 4000;
        Assertions.assertTrue(leapYearCalculator.isCurrentYearLeapYear());
    }
}
