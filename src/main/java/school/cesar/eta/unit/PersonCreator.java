package school.cesar.eta.unit;

import school.cesar.eta.unit.entity.Person;

import java.time.LocalDate;

public class PersonCreator {

    private String name = "Urbano";
    private String lastName = "Santos";
    private String maritalStatus = "married";
    private String city = "Recife";
    private String state = "PE";
    private LocalDate birthday = LocalDate.now();

    public PersonCreator setName(String name) {
        this.name = name;
        return this;
    }

    public PersonCreator setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PersonCreator setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
        return this;
    }

    public PersonCreator setCity(String city) {
        this.city = city;
        return this;
    }

    public PersonCreator setState(String state) {
        this.state = state;
        return this;
    }

    public PersonCreator setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    public Person createPerson(){
        Person person = new Person();
        person.setName(this.name);
        person.setLastName(this.lastName);
        person.setMaritalStatus(this.maritalStatus);
        person.setCity(this.city);
        person.setState(this.state);
        person.setBirthday(this.birthday);
        return person;
    }


}
