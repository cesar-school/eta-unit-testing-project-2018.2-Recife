package school.cesar.eta.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeapYearCalculatorTest {

    @Test
public void verifyYear_isLeapYear_True(){
    Assertions.assertTrue(LeapYearCalculator.isCurrentYearLeapYear());
}

}
