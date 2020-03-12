package school.cesar.eta.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Year;

public class LeapYearCalculatorTest{

    public Integer currentYear;
    public LeapYearCalculator leapYearCalculator;

    @BeforeEach
    public void setUp(){
        currentYear = null;
        leapYearCalculator = new LeapYearCalculator(){
            @Override
            public int getCurrentYear(){
                return currentYear;
            }
        };
    }

    @Test
    public void year_CorfirmCurrentYear_YearCurrent(){
        Assertions.assertEquals(Year.now().getValue(), new LeapYearCalculator().getCurrentYear());
    }

    @Test
    public void year_NotDivisibleByFour_LeapYearFalse(){
        currentYear = 2001;
        Assertions.assertFalse(leapYearCalculator.isCurrentYearLeapYear());
    }

    @Test
    public void year_DivisibleByFourButNotDivisibleByAHundred_LeapYearTrue(){
        currentYear = 2020;
        Assertions.assertTrue(leapYearCalculator.isCurrentYearLeapYear());
    }

    @Test
    public void year_DivisibleByFourAndByOneHundredButNotDivisibleByFourHundreds_LeapYearFalse(){
        currentYear = 1990;
        Assertions.assertFalse(leapYearCalculator.isCurrentYearLeapYear());
    }

    @Test
    public void year_DivisibleByFourAndByOneHundredAndByFourHundreds_LeapYearFalse(){
        currentYear = 2020;
        Assertions.assertTrue(leapYearCalculator.isCurrentYearLeapYear());
    }
}

