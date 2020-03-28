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

}
