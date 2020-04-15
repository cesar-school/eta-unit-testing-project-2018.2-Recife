package school.cesar.eta.unit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.cesar.eta.unit.entity.Person;
import school.cesar.eta.unit.utils.PersonBuilder;
import java.time.LocalDate;
import java.time.Month;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PeopleComparatorTest {
    PeopleComparator peopleComparator;
    PersonBuilder personBuilder;
    LocalDate now = LocalDate.now();

    @BeforeEach
    public void setUpTest(){
        peopleComparator = new PeopleComparator(){
            @Override
            public LocalDate getCurrentDate(){
                return now;
            }
        };
        personBuilder = new PersonBuilder();
    }

    @Test
    public void todayIsThePersonBirthDay(){
        Person person = personBuilder
                .setBirthday(now)
                .builder();
        assertTrue(peopleComparator.isTodayPersonsBirthDay(person));
    }

    @Test
    public void todayIsNotThePersonBirthDay(){
        Person person = personBuilder
                .setBirthday(now.minusDays(1))
                .builder();
        assertFalse(peopleComparator.isTodayPersonsBirthDay(person));
    }

    @Test
    public void leapYearPersonBirthDayOnNonLeapYear(){
        now = LocalDate.of(2018, Month.MARCH, 1);
        LocalDate birthday = LocalDate.of(1984, Month.FEBRUARY, 29);
        Person person = personBuilder
                .setBirthday(birthday)
                .builder();
        assertTrue(peopleComparator.isTodayPersonsBirthDay(person));
    }

    @Test
    public void peopleWithSameInformation(){
        Person firstPerson = personBuilder
                .builder();
        Person secondPerson = personBuilder
                .builder();
        assertFalse(peopleComparator.isSameFamily(firstPerson, secondPerson));
    }

    @Test
    public void peopleWithSameInformationButName(){
        Person firstPerson = personBuilder
                .builder();
        Person secondPerson = personBuilder
                .setName("Ada")
                .builder();
        assertTrue(peopleComparator.isSameFamily(firstPerson, secondPerson));
    }

    @Test
    public void peopleWithSameInformationButNameAndLastName(){
        Person firstPerson = personBuilder
                .builder();
        Person secondPerson = personBuilder
                .setName("Ada")
                .setLastName("Lovelace")
                .builder();
        assertFalse(peopleComparator.isSameFamily(firstPerson, secondPerson));
    }

    @Test
    public void peopleWithSameInformationButNameAndCity(){
        Person firstPerson = personBuilder
                .builder();
        Person secondPerson = personBuilder
                .setName("Ada")
                .setCity("London")
                .builder();
        assertFalse(peopleComparator.isSameFamily(firstPerson, secondPerson));
    }

    @Test
    public void peopleWithSameInformationButNameAndState(){
        Person firstPerson = personBuilder
                .builder();
        Person secondPerson = personBuilder
                .setName("Ada")
                .setState("MG")
                .builder();
        assertFalse(peopleComparator.isSameFamily(firstPerson, secondPerson));
    }

    @Test
    public void twoPeopleWithSameInformation(){
        Person firstPerson = personBuilder.builder();
        Person secondPerson = personBuilder.builder();
        assertTrue(peopleComparator.isSamePerson(firstPerson, secondPerson));
    }

    @Test
    public void twoPeopleWithSameObjectInstance(){
        Person person = personBuilder.builder();
        assertThrows(RuntimeException.class, () -> peopleComparator.isSamePerson(person, person));
    }

    @Test
    public void twoPeopleWithSameInformationButName(){
        Person firstPerson = personBuilder.builder();
        Person secondPerson = personBuilder
                .setName("Ada")
                .builder();
        assertFalse(peopleComparator.isSamePerson(firstPerson, secondPerson));
    }

    @Test
    public void twoPeopleWithSameInformationButLastName(){
        Person firstPerson = personBuilder.builder();
        Person secondPerson = personBuilder
                .setLastName("Lovelace")
                .builder();
        assertFalse(peopleComparator.isSamePerson(firstPerson, secondPerson));
    }

    @Test
    public void twoPeopleWithSameInformationButBirthday(){
        Person firstPerson = personBuilder.builder();
        Person secondPerson = personBuilder
                .setBirthday(now.minusDays(1))
                .builder();
        assertFalse(peopleComparator.isSamePerson(firstPerson, secondPerson));
    }

    @Test
    public void twoPeopleWithSameInformationButMaritalStatus(){
        Person firstPerson = personBuilder.builder();
        Person secondPerson = personBuilder
                .setMaritalStatus("married")
                .builder();
        assertFalse(peopleComparator.isSamePerson(firstPerson, secondPerson));
    }

    @Test
    public void twoPeopleWithSameInformationButCity(){
        Person firstPerson = personBuilder.builder();
        Person secondPerson = personBuilder
                .setCity("London")
                .builder();
        assertFalse(peopleComparator.isSamePerson(firstPerson, secondPerson));
    }

    @Test
    public void twoPeopleWithSameInformationButState(){
        Person firstPerson = personBuilder.builder();
        Person secondPerson = personBuilder
                .setState("MG")
                .builder();
        assertFalse(peopleComparator.isSamePerson(firstPerson, secondPerson));
    }
}
