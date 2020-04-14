package school.cesar.eta.unit;

import java.time.Year;

public class LeapYearCalculator {

    public int getCurrentYear(){
        return Year.now().getValue();
    }

    /**
     * Algorithm:
     * if (year is not divisible by 4) then (it is a common year)
     * else if (year is not divisible by 100) then (it is a leap year)
     * else if (year is not divisible by 400) then (it is a common year)
     * else (it is a leap year)
     *
     * src: https://en.wikipedia.org/wiki/Leap_year#Algorithm
     */
    public boolean isCurrentYearLeapYear() {
        final int year = getCurrentYear();
        if(year % 4 != 0) {
            return false;
        }
        if(year % 100 != 0) {
            return true;
        }
        return year % 400 == 0;

    }
}
