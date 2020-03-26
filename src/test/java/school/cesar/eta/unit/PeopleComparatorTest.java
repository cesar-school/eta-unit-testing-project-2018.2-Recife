package school.cesar.eta.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testng.annotations.Ignore;
import school.cesar.eta.unit.entity.Person;

import java.time.LocalDate;

import static org.testng.Assert.assertTrue;

public class PeopleComparatorTest {

    @Test
    public void isTodayPersonsBirthDayTrue(){
        Person p = new Person();
        //p.setName("fulana");
       //p.setLastName("de tal");
        p.setBirthday(LocalDate.now());

        PeopleComparator pc = new PeopleComparator();
        boolean TodayPersonsBirthDay = pc.isTodayPersonsBirthDay(p);

        assertTrue(TodayPersonsBirthDay);
    }

}
