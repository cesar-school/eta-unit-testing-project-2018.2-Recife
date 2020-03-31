package school.cesar.eta.unit.Mock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import java.time.LocalDate;

import org.mockito.junit.jupiter.MockitoExtension;
import school.cesar.eta.unit.PeopleComparator;
import school.cesar.eta.unit.entity.Person;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.Year;

@ExtendWith(MockitoExtension.class)
public class  PeopleComparatorTestMock {
    @InjectMocks
    PeopleComparator application;
    @Mock
    Person person;

    @Test
    public void Person_Birthday_true() {
        Person dummy_PersonBirthday = new Person();
        dummy_PersonBirthday.setBirthday(LocalDate.now());
        Assertions.assertTrue(application.isTodayPersonsBirthDay(dummy_PersonBirthday));
    }

    @Test
    public void Person_Birthday_false() {
        Person dummy_PersonBirthday = new Person();
        dummy_PersonBirthday.setBirthday(LocalDate.of(1990,04,22));
        Assertions.assertFalse(application.isTodayPersonsBirthDay(dummy_PersonBirthday));
    }

    @Test
    public void people_SamePerson_false() {
        Person dummy_personOne = new Person();
        Person dummy_personTwo = new Person();
        dummy_personOne.setName("Francisco");
        dummy_personOne.setLastName("Ferreira");
        dummy_personOne.setState("Pernambuco");
        dummy_personOne.setCity("Recife");
        dummy_personTwo.setName("Anne");
        dummy_personTwo.setLastName("Costa");
        dummy_personTwo.setState("Pernambuco");
        dummy_personTwo.setCity("Recife");
        Assertions.assertFalse(application.isSamePerson(dummy_personOne,dummy_personTwo));
    }
    @Test
    public void people_SamePerson_true() {
        Person dummy_personOne = new Person();
        Person dummy_personTwo = new Person();
        dummy_personOne.setName("Francisco");
        dummy_personOne.setLastName("Ferreira");
        dummy_personOne.setState("Pernambuco");
        dummy_personOne.setCity("Recife");
        dummy_personOne.setMaritalStatus("Noivo");
        dummy_personOne.setBirthday(LocalDate.of(1990,05,22));
        dummy_personTwo.setName("Francisco");
        dummy_personTwo.setLastName("Ferreira");
        dummy_personTwo.setState("Pernambuco");
        dummy_personTwo.setCity("Recife");
        dummy_personTwo.setMaritalStatus("Noivo");
        dummy_personTwo.setBirthday(LocalDate.of(1990,05,22));
        Assertions.assertTrue(application.isSamePerson(dummy_personOne,dummy_personTwo));
    }

}
