package school.cesar.eta.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// * if (year is not divisible by 4) then (it is a common year)
// * else if (year is not divisible by 100) then (it is a leap year)
// * else if (year is not divisible by 400) then (it is a common year)
// * else (it is a leap year)

public class LeapYearCalculatorTest {

    public Integer ano;
    public LeapYearCalculator calc;

    @BeforeEach
    public void start(){
        calc = new LeapYearCalculator(){
            @Override
            public int getCurrentYear(){
                return ano;
            }
        };
    }

    @Test
    public void naoDivisivelPor4_anoNormal() {
        ano = 2003;
        Assertions.assertFalse(calc.isCurrentYearLeapYear());
//        System.out.println(ano);
    }

    @Test
    public void divisivelPor_quatro_cem_MasNaoPor_quatrocentos_anoNormal() {
        ano = 2300;
        Assertions.assertFalse(calc.isCurrentYearLeapYear());
    }

    @Test
    public void divisivelPor_quatro_MasNaoPor_Cem_anoBisexto() {
        ano = 2016;
        Assertions.assertTrue(calc.isCurrentYearLeapYear());
    }

    @Test
    public void divisivelPor_quatro_cem_quatrocentos_anoBisexto() {
        ano = 2000;
        Assertions.assertTrue(calc.isCurrentYearLeapYear());
    }

}




