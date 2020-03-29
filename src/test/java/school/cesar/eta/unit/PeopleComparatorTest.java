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
    public void isBirthday(){
        Assertions.assertEquals(false, person.getBirthday()==LocalDate.now());
    }

    @Test
    public void isBirthdayTrue(){

        LocalDate date = LocalDate.parse("03/13/2020", formatter);
        Assertions.assertEquals(true, person.getBirthday().getMonth()==date.getMonth() && person.getBirthday().getDayOfMonth()==date.getDayOfMonth() );
    }

    @Test
    public void isBirthdayTrue_false(){

        LocalDate date = LocalDate.parse("03/01/2020", formatter);
        Assertions.assertEquals(false, person.getBirthday().getMonth()==date.getMonth() && person.getBirthday().getDayOfMonth()==date.getDayOfMonth() );
    }

    @Test
    public void isBirthdayALeapYear(){
        Assertions.assertEquals(false, person.getBirthday().isLeapYear() );
    }

    @Test
    public void isSameFirstName_true(){
        Person secondPerson = new Person.Builder().name("Vitor").lastName("Duque").birthday(LocalDate.parse("01/10/1981", formatter)).maritalStatus("married").city("Rio de Janeiro").state("Rio de Janeiro").build();
        Assertions.assertEquals(true, person.getName().equals(secondPerson.getName())  );

    }

    @Test
    public void isSameFirstName_false(){
        Person secondPerson = new Person.Builder().name("Alessandro").lastName("Lima").birthday(LocalDate.parse("01/19/1984", formatter)).maritalStatus("married").city("Belo Horizonte").state("Minas Gerais").build();
        Assertions.assertEquals(false, person.getName().equals(secondPerson.getName())  );
    }

    @Test
    public void isSameLastName_true(){
        Person secondPerson = new Person.Builder().name("Vidiane").lastName("Lima").birthday(LocalDate.parse("02/23/1996", formatter)).maritalStatus("single").city("Recife").state("Pernambuco").build();
        Assertions.assertEquals(true, person.getLastName().equals(secondPerson.getLastName()) );
    }

    @Test
    public void isSameLastName_false(){
        Person secondPerson = new Person.Builder().name("Augusto").lastName("Cardoso").birthday(LocalDate.parse("06/23/1987", formatter)).maritalStatus("single").city("Curitiba").state("Paraná").build();
        Assertions.assertEquals(false, person.getLastName().equals(secondPerson.getLastName()) );
    }

    @Test
    public void isSameMaritalStatus_true(){
        Person secondPerson = new Person.Builder().name("Izabela").lastName("Medeiros").birthday(LocalDate.parse("09/22/1959", formatter)).maritalStatus("single").city("João Pessoa").state("Paraíba").build();
        Assertions.assertEquals(true, person.getMaritalStatus().equals(secondPerson.getMaritalStatus()) );
    }

    @Test
    public void isSameMaritalStatus_false(){
        Person secondPerson = new Person.Builder().name("Bruno").lastName("Ferreira").birthday(LocalDate.parse("08/14/1991", formatter)).maritalStatus("married").city("Cajamar").state("São Paulo").build();
        Assertions.assertEquals(false, person.getLastName().equals(secondPerson.getLastName()) );
    }

    @Test
    public void isSameBirthplace_true(){
        Person secondPerson = new Person.Builder().name("Claudia").lastName("Costa").birthday(LocalDate.parse("12/22/1977", formatter)).maritalStatus("single").city("Recife").state("Pernambuco").build();
        Assertions.assertEquals(true, person.getCity().equals(secondPerson.getCity()) && person.getState().equals(secondPerson.getState()) );
    }

    @Test
    public void isSameBirthPlace_false(){
        Person secondPerson = new Person.Builder().name("Carlos").lastName("Alencar").birthday(LocalDate.parse("05/08/1977", formatter)).maritalStatus("married").city("Feira Nova").state("Pernambuco").build();
        Assertions.assertEquals(false, person.getCity().equals(secondPerson.getCity()) && person.getState().equals(secondPerson.getState()) );
}
    @Test
    public void isSameBirthState_true(){
        Person secondPerson = new Person.Builder().name("Vitor").lastName("Lima").birthday(LocalDate.parse("09/22/1957", formatter)).maritalStatus("married").city("Petrolina").state("Pernambuco").build();
        Assertions.assertEquals(false, person.getCity().equals(secondPerson.getCity()) && person.getState().equals(secondPerson.getState()));
    }

    @Test
    public void isSameBirthState_false(){
        Person secondPerson = new Person.Builder().name("Vitor").lastName("Lima").birthday(LocalDate.parse("09/22/1957", formatter)).maritalStatus("married").city("Recife").state("Amazonas").build();
        Assertions.assertEquals(false, person.getCity().equals(secondPerson.getCity()) && person.getState().equals(secondPerson.getState()));
    }


    @Test
    public void isSamePerson(){
        Person secondPerson = new Person.Builder().name("Vitor").lastName("Lima").birthday(LocalDate.parse("03/13/1995", formatter)).maritalStatus("single").city("Recife").state("Pernambuco").build();
        Assertions.assertEquals(true, person.getName().equals(secondPerson.getName()) && person.getLastName().equals(secondPerson.getLastName()) && person.getBirthday().getMonth() == secondPerson.getBirthday().getMonth() && person.getBirthday().getDayOfMonth() == secondPerson.getBirthday().getDayOfMonth() && person.getBirthday().getYear() == secondPerson.getBirthday().getYear() &&person.getMaritalStatus().equals(secondPerson.getMaritalStatus()) && person.getCity().equals(secondPerson.getCity()) && person.getState().equals(secondPerson.getState()));
    }

    @Test
    public void isDifferentFirstNameRestIsTheSame(){
        Person secondPerson = new Person.Builder().name("Marcelo").lastName("Lima").birthday(LocalDate.parse("03/13/1995", formatter)).maritalStatus("single").city("Recife").state("Pernambuco").build();
        Assertions.assertEquals(false, person.getName().equals(secondPerson.getName()) && person.getLastName().equals(secondPerson.getLastName()) && person.getBirthday().getMonth() == secondPerson.getBirthday().getMonth() && person.getBirthday().getDayOfMonth() == secondPerson.getBirthday().getDayOfMonth() && person.getBirthday().getYear() == secondPerson.getBirthday().getYear() &&person.getMaritalStatus().equals(secondPerson.getMaritalStatus()) && person.getCity().equals(secondPerson.getCity()) && person.getState().equals(secondPerson.getState()));
    }

    @Test
    public void isDifferentLastSameRestIsTheSame(){
        Person secondPerson = new Person.Builder().name("Vitor").lastName("Araujo").birthday(LocalDate.parse("03/13/1995", formatter)).maritalStatus("single").city("Recife").state("Pernambuco").build();
        Assertions.assertEquals(false, person.getName().equals(secondPerson.getName()) && person.getLastName().equals(secondPerson.getLastName()) && person.getBirthday().getMonth() == secondPerson.getBirthday().getMonth() && person.getBirthday().getDayOfMonth() == secondPerson.getBirthday().getDayOfMonth() && person.getBirthday().getYear() == secondPerson.getBirthday().getYear() &&person.getMaritalStatus().equals(secondPerson.getMaritalStatus()) && person.getCity().equals(secondPerson.getCity()) && person.getState().equals(secondPerson.getState()));
    }

    @Test
    public void isDifferentBirthdayRestIsTheSame(){
        Person secondPerson = new Person.Builder().name("Vitor").lastName("Lima").birthday(LocalDate.parse("08/28/1994", formatter)).maritalStatus("single").city("Recife").state("Pernambuco").build();
        Assertions.assertEquals(false, person.getName().equals(secondPerson.getName()) && person.getLastName().equals(secondPerson.getLastName()) && person.getBirthday().getMonth() == secondPerson.getBirthday().getMonth() && person.getBirthday().getDayOfMonth() == secondPerson.getBirthday().getDayOfMonth() && person.getBirthday().getYear() == secondPerson.getBirthday().getYear() &&person.getMaritalStatus().equals(secondPerson.getMaritalStatus()) && person.getCity().equals(secondPerson.getCity()) && person.getState().equals(secondPerson.getState()));
    }

    @Test
    public void isDifferentMaritalStatusRestIsTheSame(){
        Person secondPerson = new Person.Builder().name("Vitor").lastName("Lima").birthday(LocalDate.parse("03/13/1995", formatter)).maritalStatus("married").city("Recife").state("Pernambuco").build();
        Assertions.assertEquals(false, person.getName().equals(secondPerson.getName()) && person.getLastName().equals(secondPerson.getLastName()) && person.getBirthday().getMonth() == secondPerson.getBirthday().getMonth() && person.getBirthday().getDayOfMonth() == secondPerson.getBirthday().getDayOfMonth() && person.getBirthday().getYear() == secondPerson.getBirthday().getYear() &&person.getMaritalStatus().equals(secondPerson.getMaritalStatus()) && person.getCity().equals(secondPerson.getCity()) && person.getState().equals(secondPerson.getState()));
    }

    @Test
    public void isDifferentBirthCityRestIsTheSame(){
        Person secondPerson = new Person.Builder().name("Vitor").lastName("Lima").birthday(LocalDate.parse("03/13/1995", formatter)).maritalStatus("single").city("Feira Nova").state("Pernambuco").build();
        Assertions.assertEquals(false, person.getName().equals(secondPerson.getName()) && person.getLastName().equals(secondPerson.getLastName()) && person.getBirthday().getMonth() == secondPerson.getBirthday().getMonth() && person.getBirthday().getDayOfMonth() == secondPerson.getBirthday().getDayOfMonth() && person.getBirthday().getYear() == secondPerson.getBirthday().getYear() &&person.getMaritalStatus().equals(secondPerson.getMaritalStatus()) && person.getCity().equals(secondPerson.getCity()) && person.getState().equals(secondPerson.getState()));
    }

    @Test
    public void isDifferentBirthStateRestIsTheSame(){
        Person secondPerson = new Person.Builder().name("Vitor").lastName("Lima").birthday(LocalDate.parse("03/13/1995", formatter)).maritalStatus("single").city("Recife").state("Goiás").build();
        Assertions.assertEquals(false, person.getName().equals(secondPerson.getName()) && person.getLastName().equals(secondPerson.getLastName()) && person.getBirthday().getMonth() == secondPerson.getBirthday().getMonth() && person.getBirthday().getDayOfMonth() == secondPerson.getBirthday().getDayOfMonth() && person.getBirthday().getYear() == secondPerson.getBirthday().getYear() &&person.getMaritalStatus().equals(secondPerson.getMaritalStatus()) && person.getCity().equals(secondPerson.getCity()) && person.getState().equals(secondPerson.getState()));
    }



}
