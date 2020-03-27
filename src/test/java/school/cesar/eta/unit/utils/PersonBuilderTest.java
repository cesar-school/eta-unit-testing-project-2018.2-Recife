package school.cesar.eta.unit.utils;

        import school.cesar.eta.unit.entity.Person;

        import java.time.LocalDate;

public class PersonBuilderTest {
    private String name = "Lazaro";
    private String lastName = "Santos";
    private LocalDate birthday = LocalDate.now();
    private String maritalStatus = "engaged";
    private String city = "Jaboatao";
    private String state = "PE";

    public PersonBuilderTest setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilderTest setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PersonBuilderTest setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    public PersonBuilderTest setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
        return this;
    }

    public PersonBuilderTest setCity(String city) {
        this.city = city;
        return this;
    }

    public PersonBuilderTest setState(String state) {
        this.state = state;
        return this;
    }

    public Person build(){
        Person person = new Person();
        person.setName(this.name);
        person.setLastName(this.lastName);
        person.setBirthday(this.birthday);
        person.setMaritalStatus(this.maritalStatus);
        person.setCity(this.city);
        person.setState(this.state);
        return person;
    }
}
