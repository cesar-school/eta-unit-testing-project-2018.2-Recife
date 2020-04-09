package school.cesar.eta.unit;

import school.cesar.eta.unit.entity.Person;

import java.time.LocalDate;

public class CreatePerson {

    public class Person {
        private String name = "Jullyan";
        private String lastName = "Negromonte";
        private LocalDate birthday = LocalDate.now();
        private String maritalStatus = "Single";
        private String city = "Recife";
        private String state = "Pernambuco";

        public Person setName(String name) {
            this.name = name;
            return this;
        }

        public Person setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Person setMaritalStatus(String maritalStatus) {
            this.maritalStatus = maritalStatus;
            return this;
        }

        public Person setCity(String city) {
            this.city = city;
            return this;
        }

        public Person setState(String state) {
            this.state = state;
            return this;
        }

        public Person setBirthday(LocalDate birthday) {
            this.birthday = birthday;
            return this;
        }

        public Person createPerson() {
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