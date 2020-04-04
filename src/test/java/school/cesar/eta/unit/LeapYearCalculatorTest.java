package school.cesar.eta.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Year;


public class LeapYearCalculatorTest {




    @Test
    public void isLeapYear_currentYearIsLeapYear() {
        LeapYearCalculator calculator = new LeapYearCalculator();
        Assertions.assertTrue(calculator.isCurrentYearLeapYear());

    }

    @Test
    public void isLeapYear() {
        LeapYearCalculator calculator = new LeapYearCalculator() {

            @Override
            public int getCurrentYear() {
                return 2124;
            }

        };
        Assertions.assertTrue(calculator.isCurrentYearLeapYear());

    }

    @Test
    public void isCommonYear() {
        LeapYearCalculator calculator = new LeapYearCalculator() {

            @Override
            public int getCurrentYear() {
                return 2019;
            }

        };
        Assertions.assertFalse(calculator.isCurrentYearLeapYear());

    }

    @Test
    public void isLeapYear_yearIsDivisibleByFour_LeapYearTrue() {
        LeapYearCalculator calculator = new LeapYearCalculator() {

            @Override
            public int getCurrentYear() {
                return 1980;
            }

        };
        Assertions.assertTrue(calculator.isCurrentYearLeapYear());

    }

    @Test
    public void isLeapYear_yearNotIsDivisibleByFour_LeapYearFalse() {
        LeapYearCalculator calculator = new LeapYearCalculator() {

            @Override
            public int getCurrentYear() {
                return 1983;
            }

        };
        Assertions.assertFalse(calculator.isCurrentYearLeapYear());

    }

    @Test
    public void isLeapYear_yearIsDivisibleByFourButNotDivisibleByOneHundred_LeapYearTrue() {
        LeapYearCalculator calculator = new LeapYearCalculator() {

            @Override
            public int getCurrentYear() {
                return 1964;
            }

        };
        Assertions.assertTrue(calculator.isCurrentYearLeapYear());

    }




    @Test
    public void isLeapYear_yearNotDividedByOneHundredAndDividedByFourHundred() {
        LeapYearCalculator calculator = new LeapYearCalculator() {

            @Override
            public int getCurrentYear() {
                return 1600;
            }

        };
        Assertions.assertTrue(calculator.isCurrentYearLeapYear());

    }


    @Test
    public void isLeapYear_yearIsDivisibleByFourByOneHundredAndByFourHundred_LeapYearTrue() {
        LeapYearCalculator calculator = new LeapYearCalculator() {

            @Override
            public int getCurrentYear() {
                return 2000;
            }

        };
        Assertions.assertTrue(calculator.isCurrentYearLeapYear());

    }


}

