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
    public void ConfigPeople(){
        peopleComparator = new PeopleComparator(){
            @Override
            public LocalDate getCurrentDate(){
                return now;
            }
        };
        personBuilder = new PersonBuilder();
    }

    @Test
    public void isPersonBirthDay_todayIsThePersonBirthDay_true(){
        Person person = personBuilder
                .setBirthday(now)
                .builder();
        assertTrue(peopleComparator.isTodayPersonsBirthDay(person));
    }

    @Test
    public void isPersonBirthDay_todayIsThePersonBirthDay_false(){
        Person person = personBuilder
                .setBirthday(now.minusDays(1))
                .builder();
        assertFalse(peopleComparator.isTodayPersonsBirthDay(person));
    }

    @Test
    public void isLeapYearPersonBirthDay_leapYearPersonBirthDayOnNonLeapYear_false(){
        now = LocalDate.of(2018, Month.MARCH, 1);
        LocalDate birthday = LocalDate.of(1984, Month.FEBRUARY, 29);
        Person person = personBuilder
                .setBirthday(birthday)
                .builder();
        assertFalse(peopleComparator.isTodayPersonsBirthDay(person));
    }

    @Test
    public void isSameFamily_peopleWithSameInformation_false(){
        Person firstPerson = personBuilder
                .builder();
        Person secondPerson = personBuilder
                .builder();
        assertFalse(peopleComparator.isSameFamily(firstPerson, secondPerson));
    }

    @Test
    public void isSameFamily_peopleWithSameInformationButName_true(){
        Person firstPerson = personBuilder
                .builder();
        Person secondPerson = personBuilder
                .setName("Ada")
                .builder();
        assertTrue(peopleComparator.isSameFamily(firstPerson, secondPerson));
    }

    @Test
    public void isSameFamily_peopleWithSameInformationButNameAndLastName_false(){
        Person firstPerson = personBuilder
                .builder();
        Person secondPerson = personBuilder
                .setName("Ada")
                .setLastName("Lovelace")
                .builder();
        assertFalse(peopleComparator.isSameFamily(firstPerson, secondPerson));
    }

    @Test
    public void isSameFamily_peopleWithSameInformationButNameAndCity_false(){
        Person firstPerson = personBuilder
                .builder();
        Person secondPerson = personBuilder
                .setName("Ada")
                .setCity("London")
                .builder();
        assertFalse(peopleComparator.isSameFamily(firstPerson, secondPerson));
    }

    @Test
    public void isSameFamily_peopleWithSameInformationButNameAndState_false(){
        Person firstPerson = personBuilder
                .builder();
        Person secondPerson = personBuilder
                .setName("Ada")
                .setState("MG")
                .builder();
        assertFalse(peopleComparator.isSameFamily(firstPerson, secondPerson));
    }

    @Test
    public void isSamePerson_twoPeopleWithSameInformation_true(){
        Person firstPerson = personBuilder.builder();
        Person secondPerson = personBuilder.builder();
        assertTrue(peopleComparator.isSamePerson(firstPerson, secondPerson));
    }

    @Test
    public void isSamePerson_twoPeopleWithSameObjectInstance_throwsException(){
        Person person = personBuilder.builder();
        assertThrows(RuntimeException.class, () -> peopleComparator.isSamePerson(person, person));
    }

    @Test
    public void isSamePerson_twoPeopleWithSameInformationButName_false(){
        Person firstPerson = personBuilder.builder();
        Person secondPerson = personBuilder
                .setName("Ada")
                .builder();
        assertFalse(peopleComparator.isSamePerson(firstPerson, secondPerson));
    }

    @Test
    public void isSamePerson_twoPeopleWithSameInformationButLastName_false(){
        Person firstPerson = personBuilder.builder();
        Person secondPerson = personBuilder
                .setLastName("Lovelace")
                .builder();
        assertFalse(peopleComparator.isSamePerson(firstPerson, secondPerson));
    }

    @Test
    public void isSamePerson_twoPeopleWithSameInformationButBirthday_false(){
        Person firstPerson = personBuilder.builder();
        Person secondPerson = personBuilder
                .setBirthday(now.minusDays(1))
                .builder();
        assertFalse(peopleComparator.isSamePerson(firstPerson, secondPerson));
    }

    @Test
    public void isSamePerson_twoPeopleWithSameInformationButMaritalStatus_false(){
        Person firstPerson = personBuilder.builder();
        Person secondPerson = personBuilder
                .setMaritalStatus("married")
                .builder();
        assertFalse(peopleComparator.isSamePerson(firstPerson, secondPerson));
    }

    @Test
    public void isSamePerson_twoPeopleWithSameInformationButCity_false(){
        Person firstPerson = personBuilder.builder();
        Person secondPerson = personBuilder
                .setCity("London")
                .builder();
        assertFalse(peopleComparator.isSamePerson(firstPerson, secondPerson));
    }

    @Test
    public void isSamePerson_twoPeopleWithSameInformationButState_false(){
        Person firstPerson = personBuilder.builder();
        Person secondPerson = personBuilder
                .setState("MG")
                .builder();
        assertFalse(peopleComparator.isSamePerson(firstPerson, secondPerson));
    }
}
