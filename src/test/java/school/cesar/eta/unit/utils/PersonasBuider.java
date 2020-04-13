package school.cesar.eta.unit.utils;
import school.cesar.eta.unit.entity.Person;
import java.time.LocalDate;


//Classe de apoio (criação da base de dados)

public class PersonasBuider {

    private String nome = "Richard";
    private String sobrenome = "Soares";
    private String estadoCivil = "Casado";
    private String cidade = "Recife";
    private String estado = "Pernambuco";
    private LocalDate aniversario = LocalDate.now();

    public PersonasBuider addNome(String name) {
        this.nome = name;
        return this;
    }

    public PersonasBuider addSobrenome(String lastName) {
        this.sobrenome = lastName;
        return this;
    }

    public PersonasBuider addEstadoCivil(String maritalStatus) {
        this.estadoCivil = maritalStatus;
        return this;
    }

    public PersonasBuider addCidade(String city) {
        this.cidade = city;
        return this;
    }

    public PersonasBuider addEstado(String state) {
        this.estado = state;
        return this;
    }

    public PersonasBuider addAniversario(LocalDate birthday) {
        this.aniversario = birthday;
        return this;
    }

    public Person basePessoa(){
        Person person = new Person();
        person.setName(this.nome);
        person.setLastName(this.sobrenome);
        person.setMaritalStatus(this.estadoCivil);
        person.setCity(this.cidade);
        person.setState(this.estado);
        person.setBirthday(this.aniversario);
        return person;
    }

}