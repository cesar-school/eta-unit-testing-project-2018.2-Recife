package school.cesar.eta.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import school.cesar.eta.unit.entity.Person;
import school.cesar.eta.unit.utils.PersonBuilder;
import java.time.LocalDate;
import java.time.Month;

public class PeopleComparatorTest {

    PersonBuilder personBuilder;
    PeopleComparator personComparator;
    LocalDate now = LocalDate.now();

    @BeforeEach
    public void setUpTest(){
        personComparator = new PeopleComparator(){
            @Override
            public LocalDate getCurrentDate(){
                return now;
            }
        };
        personBuilder = new PersonBuilder();
    }

    @Test
    public void dayNow_IsPersonBirthDay_true(){
        Person person = personBuilder.setBirthday(now).build();
        Assertions.assertTrue(personComparator.isTodayPersonsBirthDay(person));
    }

    @Test
    public void today_IsNotPersonBirthDay_false(){
        Person person = personBuilder.setBirthday(now.minusDays(20)).build();
        Assertions.assertFalse(personComparator.isTodayPersonsBirthDay(person));
    }

    @Test
    public void leapYear_PersonBirthDayOnNonLeapYear_false(){
        now = LocalDate.of(2019, Month.MARCH, 12);
        LocalDate birthday = LocalDate.of(1984, Month.FEBRUARY, 29);
        Person person = personBuilder.setBirthday(birthday).build();
        Assertions.assertFalse(personComparator.isTodayPersonsBirthDay(person));
    }
    
    @Test
    public void leapYear_PersonBirthDayOnNonLeapYear_true(){
        now = LocalDate.of(2019, Month.MARCH, 12);
        LocalDate birthday = LocalDate.of(2019, Month.MARCH, 12);
        Person person = personBuilder.setBirthday(birthday).build();
        Assertions.assertTrue(personComparator.isTodayPersonsBirthDay(person));
    }

    @Test
    public void people_SameInformationName_true(){
        Person personOne = personBuilder.build();
        Person personTwo = personBuilder.build();
        Assertions.assertTrue(personComparator.isSameFamily(personOne, personTwo));
    }

    @Test
    public void people_SameInformationButName_true(){
        Person personOne = personBuilder.build();
        Person personTwo = personBuilder.setName("Lazaro").build();
        Assertions.assertTrue(personComparator.isSameFamily(personOne, personTwo));
    }

    @Test
    public void people_SameNameAndLastName_false(){
        Person personOne = personBuilder.build();
        Person personTwo = personBuilder.setName("Lucas").setLastName("Salles").build();
        Assertions.assertFalse(personComparator.isSameFamily(personOne, personTwo));
    }

    @Test
    public void people_SameNameAndLastName_true(){
        Person personOne = personBuilder.build();
        Person personTwo = personBuilder.setName("Lazaro").setLastName("Santos").build();
        Assertions.assertTrue(personComparator.isSameFamily(personOne, personTwo));
    }

    @Test
    public void people_SameNameAndCity_false(){
        Person personOne = personBuilder.build();
        Person personTwo = personBuilder.setName("Daniel").setCity("Recife").build();
        Assertions.assertFalse(personComparator.isSameFamily(personOne, personTwo));
    }

    @Test
    public void people_SameNameAndCity_true(){
        Person personOne = personBuilder.build();
        Person personTwo = personBuilder.setName("Lazaro").setCity("Jaboatao").build();
        Assertions.assertTrue(personComparator.isSameFamily(personOne, personTwo));
    }

    @Test
    public void people_SameNameAndState_false(){
        Person personOne = personBuilder.build();
        Person personTwo = personBuilder.setName("Vitor").setState("RN").build();
        Assertions.assertFalse(personComparator.isSameFamily(personOne, personTwo));
    }

    @Test
    public void people_SameNameAndState_true(){
        Person personOne = personBuilder.build();
        Person personTwo = personBuilder.setName("Lazaro").setState("PE").build();
        Assertions.assertTrue(personComparator.isSameFamily(personOne, personTwo));
    }

    @Test
    public void twoPeople_SameInformation_true(){
        Person personOne = personBuilder.build();
        Person personTwo = personBuilder.build();
        Assertions.assertTrue(personComparator.isSamePerson(personOne, personTwo));
    }

    @Test
    public void twoPersons_SameObjectInstance_throws(){
        Person person = personBuilder.build();
        Assertions.assertThrows(RuntimeException.class, () -> personComparator.isSamePerson(person, person));
    }

    @Test
    public void twoPersons_SameName_false(){
        Person personOne = personBuilder.build();
        Person personTwo = personBuilder.setName("Renato").build();
        Assertions.assertFalse(personComparator.isSamePerson(personOne, personTwo));
    }

    @Test
    public void twoPeople_SameName_true(){
        Person personOne = personBuilder.build();
        Person personTwo = personBuilder.setName("Lazaro").build();
        Assertions.assertTrue(personComparator.isSamePerson(personOne, personTwo));
    }

    @Test
    public void twoPeople_SameLastName_false(){
        Person personOne = personBuilder.build();
        Person personTwo = personBuilder.setLastName("Nascimento").build();
        Assertions.assertFalse(personComparator.isSamePerson(personOne, personTwo));
    }

    @Test
    public void twoPeople_SameLastName_True(){
        Person personOne = personBuilder.build();
        Person personTwo = personBuilder.setLastName("Santos").build();
        Assertions.assertTrue(personComparator.isSamePerson(personOne, personTwo));
    }

    @Test
    public void twoPeople_SameBirthday_false(){
        Person firstPerson = personBuilder.build();
        Person secondPerson = personBuilder.setBirthday(now.minusDays(1)).build();
        Assertions.assertFalse(personComparator.isSamePerson(firstPerson, secondPerson));
    }

    @Test
    public void twoPeople_SameMaritalStatus_false(){
        Person personOne = personBuilder.build();
        Person personTwo = personBuilder.setMaritalStatus("single").build();
        Assertions.assertFalse(personComparator.isSamePerson(personOne, personTwo));
    }

    @Test
    public void twoPeople_SameMaritalStatus_true(){
        Person personOne = personBuilder.build();
        Person personTwo = personBuilder.setMaritalStatus("engaged").build();
        Assertions.assertTrue(personComparator.isSamePerson(personOne, personTwo));
    }

    @Test
    public void twoPeople_SameCity_false(){
        Person personOne = personBuilder.build();
        Person personTwo = personBuilder.setCity("Vitória de Santo Antão").build();
        Assertions.assertFalse(personComparator.isSamePerson(personOne, personTwo));
    }

    @Test
    public void twoPeople_SameCity_true(){
        Person personOne = personBuilder.build();
        Person personTwo = personBuilder.setCity("Jaboatao").build();
        Assertions.assertTrue(personComparator.isSamePerson(personOne, personTwo));
    }

    @Test
    public void twoPeople_SameState_false(){
        Person personOne = personBuilder.build();
        Person personTwo = personBuilder.setState("RJ").build();
        Assertions.assertFalse(personComparator.isSamePerson(personOne, personTwo));
    }

    @Test
    public void twoPeople_SameState_true(){
        Person personOne = personBuilder.build();
        Person personTwo = personBuilder.setState("PE").build();
        Assertions.assertTrue(personComparator.isSamePerson(personOne, personTwo));
    }
}
