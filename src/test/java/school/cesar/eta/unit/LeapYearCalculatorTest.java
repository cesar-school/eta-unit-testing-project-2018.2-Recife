package school.cesar.eta.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.*;



public class LeapYearCalculatorTest {

    private Integer currentYear;
    private LeapYearCalculator leapYearCalculator;

    @BeforeEach
    public void initialSetup(){
        currentYear = null;
        leapYearCalculator = new LeapYearCalculator(){
            @Override
            public int getCurrentYear(){
                return currentYear;
            }
        };
    }

    @Test
    public void verifyYear_getCurrentYear(){
        Assertions.assertEquals(Year.now().getValue(), new LeapYearCalculator().getCurrentYear());
    }

    @Test
    public void verifyYear_notDivisibleBy4(){
        currentYear = 1999;
        Assertions.assertFalse(leapYearCalculator.isCurrentYearLeapYear());
    }

    @Test
    public void verifyYear_DivisibleBy4_notBy100(){
        currentYear = 2016;
        Assertions.assertTrue(leapYearCalculator.isCurrentYearLeapYear());
    }

    @Test
    public void verifyYear_DivisibleBy4_By100_notBy400(){
        currentYear = 200;
        Assertions.assertFalse(leapYearCalculator.isCurrentYearLeapYear());
    }

    @Test
    public void verifyYear_DivisibleBy4_By100_By400(){
        currentYear = 2000;
        Assertions.assertTrue(leapYearCalculator.isCurrentYearLeapYear());
    }

}
