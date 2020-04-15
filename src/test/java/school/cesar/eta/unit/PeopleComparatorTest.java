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
    public void check_TodayPersonsBirthDay_True() {
        Person person = personCreator.setBirthday(now).createPerson();
        Assertions.assertTrue(peopleComparator.isTodayPersonsBirthDay(person));
    }

    @Test
    public void check_TodayPersonsBirthDay_False(){
        Person person = personCreator.setBirthday(now.minusDays(57)).createPerson();
        Assertions.assertFalse(peopleComparator.isTodayPersonsBirthDay(person));
    }
    @Test
    public void check_SameFamily_True () {
        Person firstPerson = personCreator.createPerson();
        Person secondPerson = personCreator.setName("Camilla").setLastName("Negromonte").setCity("Recife").createPerson();
        Assertions.assertEquals(true,peopleComparator.isSameFamily(firstPerson,secondPerson));
    }

    @Test
    public void check_SameFamily_False (){
        Person firstPerson = personCreator.createPerson();
        Person secondPerson = personCreator.setName("Aparecida").setLastName("Gomes").setCity("Olinda").createPerson();
        Assertions.assertEquals(false,peopleComparator.isSameFamily(firstPerson, secondPerson));
    }

    @Test
    public void check_SamePerson_True () {
        Person firstPerson = personCreator.createPerson();
        Person secondPerson = personCreator.createPerson();

        System.out.println("Same instance!");
        Assertions.assertTrue(peopleComparator.isSamePerson(firstPerson,secondPerson));

    }
    @Test
    public void check_SamePersonNameSameName_False (){
    Person firstPerson = personCreator.createPerson();
    Person secondPerson = personCreator.setName("Aparecida").setLastName("Gomes").createPerson();
    Assertions.assertFalse(peopleComparator.isSamePerson(firstPerson,secondPerson));

    }

    @Test
    public void check_SamePersonBirthday_False (){
        Person firstPerson = personCreator.createPerson();
        Person secondPerson = personCreator.setBirthday(now.minusDays(30)).createPerson();
        Assertions.assertFalse(peopleComparator.isSamePerson(firstPerson,secondPerson));
    }

    @Test
    public void check_SamePersonMaritinalStatus_False (){
        Person firstPerson = personCreator.createPerson();
        Person secondPerson = personCreator.setMaritalStatus("Married").createPerson();
        Assertions.assertEquals(false,peopleComparator.isSamePerson(firstPerson,secondPerson));
    }

    @Test
    public void check_SamePersonCityState_True () {
        Person firstPerson = personCreator.createPerson();
        Person secondPerson = personCreator.setCity("Recife").setState("Pernambuco").createPerson();
        Assertions.assertEquals(true, peopleComparator.isSamePerson(firstPerson,secondPerson));
    }

    @Test
    public void check_SamePersonCityState_False () {
        Person firstPerson = personCreator.createPerson();
        Person secondPerson = personCreator.setCity("Cabedelo").setState("Paraíba").createPerson();
        Assertions.assertEquals(false,peopleComparator.isSamePerson(firstPerson,secondPerson));
    }

}

