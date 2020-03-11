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
    public void verifyYear_DivisibleByFour_True(){
        currentYear = 4;
        Assertions.assertTrue(leapYearCalculator.isCurrentYearLeapYear());
    }

    @Test
    public void verifyYear_DivisibleBy100_True(){
        currentYear = 100;
        Assertions.assertTrue(leapYearCalculator.isCurrentYearLeapYear());
    }

    @Test
    public void verifyYear_DivisibleBy400_True(){
        currentYear = 400;
        Assertions.assertTrue(leapYearCalculator.isCurrentYearLeapYear());
    }

}
