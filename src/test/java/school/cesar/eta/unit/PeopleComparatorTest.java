package school.cesar.eta.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.cesar.eta.unit.entity.Person;



import java.time.LocalDate;


public class PeopleComparatorTest {

    PeopleComparator peopleComparator;
    Person createPerson;
    LocalDate now = LocalDate.now();

    @BeforeEach
    public void setup(){
        peopleComparator = new PeopleComparator() {
            @Override
            public LocalDate getCurrentDate(){
                return now;

            }
        };
        createPerson = new Person ();
    }


    @Test
    public void isTodayPersonsBirthDay_True(){
        Person person = createPerson.setBirthday(now).CreatePerson();
        Assertions.assertTrue(peopleComparator.isTodayPersonsBirthDay(person));
    }



}

