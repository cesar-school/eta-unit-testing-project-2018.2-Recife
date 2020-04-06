package school.cesar.eta.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import school.cesar.eta.unit.entity.Person;

import java.time.Clock;
import java.time.LocalDate;
import static org.testng.Assert.*;


public class PeopleComparatorTest {

    PeopleComparator peopleComparator;
    PersonCreator personCreator;
    LocalDate now = LocalDate.now();


    @BeforeEach
    public void Setup(){
        peopleComparator = new PeopleComparator() {
            @Override
            public LocalDate getCurrentDate(){
                return now;
            }
        };
        personCreator = new PersonCreator();
    }


    @Test
    public void isPersonsBirthDay_true(){
        Person person = personCreator.setBirthday(now).createPerson();
        Assertions.assertTrue(peopleComparator.isTodayPersonsBirthDay(person));

    }

    @Test
    public void isTodayPersonsBirthDay_False() {
        Person p = new Person();
        p.setBirthday(now.minusDays(5))

        Assertions.assertTrue(PeopleComparator.isTodayPersonsBirthDay(p));

    }

}

