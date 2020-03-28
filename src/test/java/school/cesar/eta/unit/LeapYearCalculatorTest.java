package school.cesar.eta.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.awt.geom.AreaOp;

import java.time.Year;

// * if (year is not divisible by 4) then (it is a common year)
// * else if (year is not divisible by 100) then (it is a leap year)
// * else if (year is not divisible by 400) then (it is a common year)
// * else (it is a leap year)

public class LeapYearCalculatorTest {

    public Integer ano;
    public LeapYearCalculator calc;

    @BeforeEach
    public void setUp(){
        ano = null;
        calc = new LeapYearCalculator(){
            @Override
            public int getCurrentYear(){
                return ano;
            }
        };
    }

    //Ano atual
    @Test
    public void verificarAnoAtual(){
        Assertions.assertEquals(Year.now().getValue(), new LeapYearCalculator().getCurrentYear());
//        System.out.println(Year.now());
    }


    //Anos normais
    @Test
    public void naoDivisivelPor4() {
        ano = 2003;
        Assertions.assertFalse(calc.isCurrentYearLeapYear());
//        System.out.println(ano);
    }

    @Test
    public void divisivelPor_quatro_cem_MasNaoPor_quatrocentos() {
        ano = 2300;
        Assertions.assertFalse(calc.isCurrentYearLeapYear());
    }

    //Anos bisextos
    @Test
    public void divisivelPor_quatro_MasNaoPor_Cem() {
        ano = 2016;
        Assertions.assertTrue(calc.isCurrentYearLeapYear());
    }

    @Test
    public void divisivelPor_quatro_cem_quatrocentos() {
        ano = 2000;
        Assertions.assertTrue(calc.isCurrentYearLeapYear());
    }

}




