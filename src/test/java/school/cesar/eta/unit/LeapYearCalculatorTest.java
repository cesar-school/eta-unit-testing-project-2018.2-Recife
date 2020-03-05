package school.cesar.eta.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeapYearCalculatorTest {


    @Test //é ano comum
    public void Year_AnoComum_true() {
        Assertions.assertEquals("Não é Bisexto",
                LeapYearCalculator.year(2100));
    }

    @Test
    public void Year_AnoBisexto_true(){
        Assertions.assertEquals("Ano Bisexto",
                LeapYearCalculator.year(1996));
    }
}
