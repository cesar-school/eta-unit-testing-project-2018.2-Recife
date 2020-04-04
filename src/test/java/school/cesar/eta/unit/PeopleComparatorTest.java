package school.cesar.eta.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.cesar.eta.unit.entity.Person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PeopleComparatorTest {

    private Person person;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    @BeforeEach
    public void setup(){
        person = new Person.Builder().name("Vitor").lastName("Lima").birthday(LocalDate.parse("03/13/1995", formatter)).maritalStatus("single").city("Recife").state("Pernambuco").build();
    }

    @Test
    public void isSameFamilyTrue(){
        PeopleComparator comparator = new PeopleComparator();
        Person secondPerson = new Person.Builder().name("Vidiane").lastName("Lima").birthday(LocalDate.parse("02/23/1996", formatter)).maritalStatus("single").city("Recife").state("Pernambuco").build();
        Assertions.assertEquals(true, comparator.isSameFamily(person, secondPerson));
    }

    @Test
    public void isSameFamilyFalse(){
        PeopleComparator comparator = new PeopleComparator();
        Person secondPerson = new Person.Builder().name("Vitor").lastName("Matos").birthday(LocalDate.parse("08/24/1976", formatter)).maritalStatus("single").city("Recife").state("Pernambuco").build();
        Assertions.assertEquals(false, comparator.isSameFamily(person, secondPerson));
    }


    @Test
    public void isSamePersonTrue(){
        PeopleComparator comparator = new PeopleComparator();
        Person secondPerson = new Person.Builder().name("Vitor").lastName("Lima").birthday(LocalDate.parse("03/13/1995", formatter)).maritalStatus("single").city("Recife").state("Pernambuco").build();
        Assertions.assertEquals(true, comparator.isSamePerson(person, secondPerson));
    }

    @Test
    public void isSamePersonFalse(){
        PeopleComparator comparator = new PeopleComparator();
        Person secondPerson = new Person.Builder().name("Vitor").lastName("Matos").birthday(LocalDate.parse("09/12/1953", formatter)).maritalStatus("single").city("Olinda").state("Pernambuco").build();
        Assertions.assertEquals(false, comparator.isSamePerson(person, secondPerson));
    }

    @Test
    public void isTodaysPersonBirthDayFalse(){
        PeopleComparator comparator = new PeopleComparator();
        Assertions.assertEquals(false, comparator.isTodayPersonsBirthDay (person));
    }

    @Test
    public void isTodaysPersonBirthDayTrue(){
        PeopleComparator comparator = new PeopleComparator();
        Person secondPerson = new Person.Builder().name("Vitor").lastName("Matos").birthday(comparator.getCurrentDate()).maritalStatus("single").city("Olinda").state("Pernambuco").build();
        Assertions.assertEquals(true, comparator.isTodayPersonsBirthDay (secondPerson));
    }


}
