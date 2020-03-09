package school.cesar.eta.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeapYearCalculatorTest {


    @Test
    public void year_currentYearLeapIsTrue() {
        LeapYearCalculator leapYearCalculator = new LeapYearCalculator();
        Assertions.assertEquals(true, leapYearCalculator.isCurrentYearLeapYear());
    }

//    @Test
//    public void Year_AnoBisexto_true(){
//        Assertions.assertEquals("Ano Bisexto",
//                LeapYearCalculator.year(1996));
//    }
}
