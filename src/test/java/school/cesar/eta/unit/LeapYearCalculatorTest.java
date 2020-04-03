package school.cesar.eta.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Year;


public class LeapYearCalculatorTest {

    public Integer currentYear;
    public LeapYearCalculator leapYearCalculator;

    @BeforeEach
    public void setUp() {
        currentYear = null;
        leapYearCalculator = new LeapYearCalculator() {
            @Override
            public int getCurrentYear() {
                return currentYear;
            }
        };
    }


    @Test
    public void isLeapYear_currentYearIsLeapYear(){
        LeapYearCalculator calculator = new LeapYearCalculator();
        Assertions.assertTrue(calculator.isCurrentYearLeapYear());

    }

    @Test
    public void isLeapYear (){
        LeapYearCalculator calculator = new LeapYearCalculator(){

            @Override
            public int getCurrentYear(){
                return 2124;
            }

        };
        Assertions.assertTrue(calculator.isCurrentYearLeapYear());

    }

    @Test
    public void isCommonYear (){
        LeapYearCalculator calculator = new LeapYearCalculator(){

            @Override
            public int getCurrentYear(){
                return 2019;
            }

        };
        Assertions.assertFalse(calculator.isCurrentYearLeapYear());

    }

    @Test
    public void isLeapYear_yearIsDividedByFour (){
        LeapYearCalculator calculator = new LeapYearCalculator(){

            @Override
            public int getCurrentYear(){
                return 1980;
            }

        };
        Assertions.assertTrue(calculator.isCurrentYearLeapYear());

    }

    @Test
    public void isLeapYear_yearNotDividedByOneHundredAndDividedByFourHundred (){
        LeapYearCalculator calculator = new LeapYearCalculator(){

            @Override
            public int getCurrentYear(){
                return 1600;
            }

        };
        Assertions.assertTrue(calculator.isCurrentYearLeapYear());

    }





    @Test
        public void year_NotDivisibleByFour_LeapYearFalse () {
            currentYear = 2001;
            Assertions.assertFalse(leapYearCalculator.isCurrentYearLeapYear());
        }


    }


