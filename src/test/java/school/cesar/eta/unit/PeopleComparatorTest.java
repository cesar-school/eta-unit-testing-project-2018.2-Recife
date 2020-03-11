package school.cesar.eta.unit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import school.cesar.eta.unit.entity.Person;

@ExtendWith(MockitoExtension.class)
public class PeopleComparatorTest {

        @InjectMocks
        PeopleComparator peopleComparator;

        //verificar esse é mesmo setPerson
        @Mock
        Person setPerson;

        @Test
        public void verifyPersonsBirthday_isTodayPersonsBirthDay_True(){

        }

}
