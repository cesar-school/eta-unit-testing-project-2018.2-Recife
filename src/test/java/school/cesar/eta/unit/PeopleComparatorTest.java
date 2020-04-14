package school.cesar.eta.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.cesar.eta.unit.entity.Person;
import school.cesar.eta.unit.utils.CreatorPerson;



import java.time.LocalDate;


public class PeopleComparatorTest {

    PeopleComparator peopleComparator;
    CreatorPerson personCreator;
    LocalDate now = LocalDate.now();

    @BeforeEach
    public void Setup() {
        peopleComparator = new PeopleComparator() {
            @Override
            public LocalDate getCurrentDate() {
                return now;
            }
        };
        personCreator = new CreatorPerson();
    }

    @Test
    public void isTodayPersonsBirthDay_True() {
        Person person = personCreator.setBirthday(now).createPerson();
        Assertions.assertTrue(peopleComparator.isTodayPersonsBirthDay(person));
    }

    @Test
    public void isTodayPersonsBirthDay_False(){
        Person person = personCreator.setBirthday(now.minusDays(57)).createPerson();
        Assertions.assertFalse(peopleComparator.isTodayPersonsBirthDay(person));
    }

}

