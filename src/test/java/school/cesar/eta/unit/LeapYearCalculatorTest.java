package school.cesar.eta.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import java.time.Year;

public class LeapYearCalculatorTest {
    @InjectMocks
    LeapYearCalculator application;

   @Test
    public void  thisYear_IsLeapYear_true() {
    application = new LeapYearCalculator();
        Assertions.assertTrue(application.isCurrentYearLeapYear());
    }

    @Test
    public void compareYear_CurrentYearIsLeapYear_true (){
        Assertions.assertEquals(Year.now().getValue(), new LeapYearCalculator().getCurrentYear());
    }

    @Test
    public void compareYear_CurrentYearIsLeapYear_false (){
        Assertions.assertNotEquals(Year.now().getValue()+1, new LeapYearCalculator().getCurrentYear());
    }


}
