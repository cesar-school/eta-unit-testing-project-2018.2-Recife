package school.cesar.eta.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import school.cesar.eta.unit.entity.Person;
import java.time.LocalDate;

public class PeopleComparatorTest {

    @InjectMocks
    PeopleComparator peopleComparator;
    Personas personas;
    LocalDate agora = LocalDate.now();

    @BeforeEach
    public void Setup(){
        peopleComparator = new PeopleComparator() {
            @Override
            public LocalDate getCurrentDate(){
                return agora;
            }
        };
        personas = new Personas();
    }

    //Retornos verdadeiros
    @Test
    public void aniversarioHoje(){
        Person person = personas.addAniversario(agora).basePessoa();
        Assertions.assertTrue(peopleComparator.isTodayPersonsBirthDay(person));
    }

    @Test
    public void pessoasIguais(){
        Person pessoa1 = personas.basePessoa();
        Person pessoa2 = personas.basePessoa();
        Assertions.assertTrue(peopleComparator.isSamePerson(pessoa1, pessoa2));
    }

    @Test
    public void mesmaFamilia(){
        Person pessoa1 = personas.basePessoa();
        Person pessoa2 = personas.addNome("Lalleska").addSobrenome("Soares")
                .addCidade("Recife").addEstado("Pernambuco").basePessoa();
        Assertions.assertTrue(peopleComparator.isSameFamily(pessoa1, pessoa2));
    }

    @Test
    public void casados(){
        Person pessoa1 = personas.basePessoa();
        Person pessoa2 = personas.addNome("Lalleska").addSobrenome("Soares")
                .addEstadoCivil("Casado").basePessoa();
        Assertions.assertTrue(peopleComparator.isSameFamily(pessoa1, pessoa2));
    }

    //Retornos falsos
    @Test
    public void pessoasDiferentesNome(){
        Person pessoa1 = personas.basePessoa();
        Person pessoa2 = personas.addNome("Lalleska").basePessoa();
        Assertions.assertFalse(peopleComparator.isSamePerson(pessoa1, pessoa2));
    }

    @Test
    public void pessoasDiferentesSobrenome(){
        Person pessoa1 = personas.basePessoa();
        Person pessoa2 = personas.addSobrenome("Araujo").basePessoa();
        Assertions.assertFalse(peopleComparator.isSamePerson(pessoa1, pessoa2));
    }

    @Test
    public void pessoasDiferentesEstadoCivil(){
        Person pessoa1 = personas.basePessoa();
        Person pessoa2 = personas.addEstadoCivil("Solteiro").basePessoa();
        Assertions.assertFalse(peopleComparator.isSamePerson(pessoa1, pessoa2));
    }

    @Test
    public void dataDeAniversarioDiferente(){
        Person pessoa = personas.addAniversario(agora.parse("2020-01-13")).basePessoa();
        Assertions.assertFalse(peopleComparator.isTodayPersonsBirthDay(pessoa));
    }

}
