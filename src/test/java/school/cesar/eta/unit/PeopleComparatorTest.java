package school.cesar.eta.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import java.time.LocalDate;

import org.mockito.junit.jupiter.MockitoExtension;
import school.cesar.eta.unit.entity.Person;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.Year;

@ExtendWith(MockitoExtension.class)
public class  PeopleComparatorTest {
    @InjectMocks
    PeopleComparator application;
    @Mock
    Person person;

    @Test
    public void compare_isNotTodayPersonsBirthDay_false() {
        Person dummy = new Person();
        dummy.setBirthday(LocalDate.of(1980,05,29));
        //when(application.isTodayPersonsBirthDay(dummy)).thenReturn(false);
        Assertions.assertFalse(application.isTodayPersonsBirthDay(dummy));
    }
    @Test
    public void compare_isTodayPersonsBirthDay_true() {
        Person dummy = new Person();
        dummy.setBirthday(LocalDate.now());
        Assertions.assertTrue(application.isTodayPersonsBirthDay(dummy));
    }

    @Test
    public void compare_isTodayPersonsBirthDayLeapYear_false() {
        Person dummy = new Person();
        dummy.setBirthday(LocalDate.of(1980,02,29));
        Assertions.assertFalse(application.isTodayPersonsBirthDay(dummy));
    }

    @Test
    public void compare_isNotSamePerson_false() {
        Person dummy = new Person();
        Person dummySecond = new Person();
        dummy.setName("Alessandro");
        dummy.setLastName("Meireles");
        dummy.setState("Pernambuco");
        dummy.setCity("Recife");
        dummySecond.setName("Fabiana");
        dummySecond.setLastName("Meireles");
        dummySecond.setState("Pernambuco");
        dummySecond.setCity("Recife");
        Assertions.assertFalse(application.isSamePerson(dummy,dummySecond));
    }
    @Test
    public void compare_isSamePerson_true() {
        Person dummy = new Person();
        Person dummySecond = new Person();
        dummy.setName("Alessandro");
        dummy.setLastName("Meireles");
        dummy.setState("Pernambuco");
        dummy.setCity("Recife");
        dummy.setMaritalStatus("Casado");
        dummy.setBirthday(LocalDate.of(1980,05,29));
        dummySecond.setName("Alessandro");
        dummySecond.setLastName("Meireles");
        dummySecond.setState("Pernambuco");
        dummySecond.setCity("Recife");
        dummySecond.setMaritalStatus("Casado");
        dummySecond.setBirthday(LocalDate.of(1980,05,29));
        Assertions.assertTrue(application.isSamePerson(dummy,dummySecond));
    }
    @Test
    public void compare_isSameFamilyErroButSamePerson_false() {
        Person dummy = new Person();
        Person dummySecond = new Person();
        dummy.setName("Alessandro");
        dummy.setLastName("Meireles");
        dummy.setState("Pernambuco");
        dummy.setCity("Recife");
        dummy.setMaritalStatus("Casado");
        dummy.setBirthday(LocalDate.of(1980,05,29));
        dummySecond.setName("Alessandro");
        dummySecond.setLastName("Meireles");
        dummySecond.setState("Pernambuco");
        dummySecond.setCity("Recife");
        dummySecond.setMaritalStatus("Casado");
        dummySecond.setBirthday(LocalDate.of(1980,05,29));
        Assertions.assertFalse(application.isSameFamily(dummy,dummySecond));
    }

    @Test
    public void compare_isSameFamily_true() {
        Person dummy = new Person();
        Person dummySecond = new Person();
        dummy.setName("Alessandro");
        dummy.setLastName("Meireles");
        dummy.setState("Pernambuco");
        dummy.setCity("Recife");
        dummy.setMaritalStatus("Casado");
        dummy.setBirthday(LocalDate.of(1980,05,29));
        dummySecond.setName("Fabiana");
        dummySecond.setLastName("Meireles");
        dummySecond.setState("Pernambuco");
        dummySecond.setCity("Recife");
        dummySecond.setMaritalStatus("Casado");
        dummySecond.setBirthday(LocalDate.of(1983,04,25));
        Assertions.assertTrue(application.isSameFamily(dummy,dummySecond));
    }

    @Test
    public void compare_isNotSameFamily_false() {
        Person dummy = new Person();
        Person dummySecond = new Person();
        dummy.setName("Alessandro");
        dummy.setLastName("Meireles");
        dummy.setState("Pernambuco");
        dummy.setCity("Recife");
        dummy.setMaritalStatus("Casado");
        dummy.setBirthday(LocalDate.of(1980,05,29));
        dummySecond.setName("Fabiana");
        dummySecond.setLastName("Sales");
        dummySecond.setState("Pernambuco");
        dummySecond.setCity("Recife");
        dummySecond.setMaritalStatus("Casado");
        dummySecond.setBirthday(LocalDate.of(1980,05,29));
        Assertions.assertFalse(application.isSameFamily(dummy,dummySecond));
    }


    @Test
    public void compare_isSameFamilyButOtherCity_false() {
        Person dummy = new Person();
        Person dummySecond = new Person();
        dummy.setName("Alessandro");
        dummy.setLastName("Meireles");
        dummy.setState("Pernambuco");
        dummy.setCity("Recife");
        dummy.setMaritalStatus("Casado");
        dummy.setBirthday(LocalDate.of(1980,05,29));
        dummySecond.setName("Fabiana");
        dummySecond.setLastName("Meireles");
        dummySecond.setState("Pernambuco");
        dummySecond.setCity("Olinda");
        dummySecond.setMaritalStatus("Solteiro");
        dummySecond.setBirthday(LocalDate.of(1983,04,25));
        Assertions.assertFalse(application.isSameFamily(dummy,dummySecond));
    }

    @Test
    public void compare_isSameFamilyButOtherState_false() {
        Person dummy = new Person();
        Person dummySecond = new Person();
        dummy.setName("Alessandro");
        dummy.setLastName("Meireles");
        dummy.setState("Pernambuco");
        dummy.setCity("Bonito");
        dummy.setMaritalStatus("Casado");
        dummy.setBirthday(LocalDate.of(1980,05,29));
        dummySecond.setName("Fabiana");
        dummySecond.setLastName("Meireles");
        dummySecond.setState("Bahia");
        dummySecond.setCity("Bonito");
        dummySecond.setMaritalStatus("Solteiro");
        dummySecond.setBirthday(LocalDate.of(1983,04,25));
        Assertions.assertFalse(application.isSameFamily(dummy,dummySecond));
    }



}
