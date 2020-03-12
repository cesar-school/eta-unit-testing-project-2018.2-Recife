package school.cesar.eta.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.cesar.eta.unit.entity.Person;

import java.time.LocalDate;


public class PeopleComparatorTest {

        PeopleComparator peopleComparator;
        PersonCreator personCreator;
        LocalDate now = LocalDate.now();

        @BeforeEach
        public void initialSetup(){
                peopleComparator = new PeopleComparator() {
                        @Override
                        public LocalDate getCurrentDate(){
                                return now;
                        }
                };
                personCreator = new PersonCreator();
        }

        @Test
        public void isPersonsBirthDay_true(){
                Person person = personCreator.setBirthday(now).createPerson();
                Assertions.assertTrue(peopleComparator.isTodayPersonsBirthDay(person));
        }

        @Test
        public void isPersonsBirthDay_false(){
                Person person = personCreator.setBirthday(now.minusDays(5)).createPerson();
                Assertions.assertFalse(peopleComparator.isTodayPersonsBirthDay(person));
        }

        @Test
        public void isSamePerson_true(){
                Person firstPerson = personCreator.createPerson();
                Person secondPerson = personCreator.createPerson();
                Assertions.assertTrue(peopleComparator.isSamePerson(firstPerson, secondPerson));
        }

        @Test
        public void isSamePerson_false(){
                Person firstPerson = personCreator.createPerson();
                Person secondPerson = personCreator.setName("Polyana").createPerson();
                Assertions.assertFalse(peopleComparator.isSamePerson(firstPerson, secondPerson));
        }

        @Test
        public void isSameFamily_true(){
                Person firstPerson = personCreator.createPerson();
                Person secondPerson = personCreator.setName("Polyana").setLastName("Santos").createPerson();
                Assertions.assertTrue(peopleComparator.isSameFamily(firstPerson, secondPerson));
        }

        @Test
        public void isSameFamily_false(){
                Person firstPerson = personCreator.createPerson();
                Person secondPerson = personCreator.setName("Urbano").setLastName("Nunes").createPerson();
                Assertions.assertFalse(peopleComparator.isSameFamily(firstPerson, secondPerson));
        }

        @Test
        public void differentNameAndLastName_false(){
                Person firstPerson = personCreator.createPerson();
                Person secondPerson = personCreator.setName("Polyana").setLastName("Nunes").createPerson();
                Assertions.assertFalse(peopleComparator.isSameFamily(firstPerson, secondPerson));
        }

        @Test
        public void allDifferentInformation_false(){
                Person firstPerson = personCreator.createPerson();
                Person secondPerson = personCreator.setName("Polyana").setLastName("Costa").setBirthday(now.minusDays(12))
                        .setState("AL").setCity("Maceió").setMaritalStatus("single").createPerson();
                Assertions.assertFalse(peopleComparator.isSamePerson(firstPerson, secondPerson));
        }


}
