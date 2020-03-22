package school.cesar.eta.unit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LeapYearCalculatorTest {

    private Integer currentYear;
    private LeapYearCalculator leapYearCalculator;


    @BeforeEach
    public void suiteSetUp() {
        currentYear = null;
        leapYearCalculator = new LeapYearCalculator() {
            @Override
            public int getCurrentYear() {
                return currentYear;
            }
        };

    }
    @Test
    public void getCurrentYear(){
        assertEquals(Year.now().getValue(), new LeapYearCalculator().getCurrentYear());
    }

    @Test
    public void isLeapYear_forNumberDivisibleByFour_true(){
        currentYear = 2012;
        assertTrue(leapYearCalculator.isCurrentYearLeapYear());
    }

    @Test
    public void isLeapYear_forNumbersNotDivisibleByFour_false(){
        currentYear = 1999;
        assertFalse(leapYearCalculator.isCurrentYearLeapYear());
    }

    @Test
    public void isLeapYear_forMultiplesOfOneHundred_false(){
        currentYear = 1990;
        assertFalse(leapYearCalculator.isCurrentYearLeapYear());
    }

    @Test
    public void isLeapYear_forMultiplesOfFourHundred_true(){
        currentYear = 2000;
        assertTrue(leapYearCalculator.isCurrentYearLeapYear());
    }
}
