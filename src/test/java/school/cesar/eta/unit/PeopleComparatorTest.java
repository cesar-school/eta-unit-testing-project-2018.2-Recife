package school.cesar.eta.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import school.cesar.eta.unit.entity.Person;
import school.cesar.eta.unit.utils.PersonasBuider;

import java.time.LocalDate;
import java.time.Month;

public class PeopleComparatorTest {

    @InjectMocks
    PeopleComparator peopleComparator;
    PersonasBuider personasBuider;
    LocalDate agora = LocalDate.now();

    @BeforeEach
    public void Setup(){
        peopleComparator = new PeopleComparator() {
            @Override
            public LocalDate getCurrentDate(){
                return agora;
            }
        };
        personasBuider = new PersonasBuider();
    }

    //Retornos verdadeiros
    @Test
    public void aniversarioHoje(){
        Person pessoa = personasBuider.addAniversario(agora).basePessoa();
        Assertions.assertTrue(peopleComparator.isTodayPersonsBirthDay(pessoa));
    }

    @Test
    public void pessoasIguais(){
        Person pessoa1 = personasBuider.basePessoa();
        Person pessoa2 = personasBuider.basePessoa();
        Assertions.assertTrue(peopleComparator.isSamePerson(pessoa1, pessoa2));
    }

    @Test
    public void mesmaFamilia(){
        Person pessoa1 = personasBuider.basePessoa();
        Person pessoa2 = personasBuider.addNome("Lalleska").addSobrenome("Soares")
                .addCidade("Recife").addEstado("Pernambuco").basePessoa();
        Assertions.assertTrue(peopleComparator.isSameFamily(pessoa1, pessoa2));
    }

    @Test
    public void casados(){
        Person pessoa1 = personasBuider.basePessoa();
        Person pessoa2 = personasBuider.addNome("Lalleska").addSobrenome("Soares")
                .addEstadoCivil("Casado").basePessoa();
        Assertions.assertTrue(peopleComparator.isSameFamily(pessoa1, pessoa2));
    }

    @Test
    public void nascimentoEmAnoBisexto(){
        LocalDate aniversario = LocalDate.of(2020, Month.FEBRUARY, 29);
        Person person = personasBuider.addAniversario(aniversario).basePessoa();
        Assertions.assertFalse(peopleComparator.isTodayPersonsBirthDay(person));
    }

    //Retornos falsos
    @Test
    public void pessoasDiferentesNome(){
        Person pessoa1 = personasBuider.basePessoa();
        Person pessoa2 = personasBuider.addNome("Lalleska").basePessoa();
        Assertions.assertFalse(peopleComparator.isSamePerson(pessoa1, pessoa2));
    }

    @Test
    public void pessoasDiferentesSobrenome(){
        Person pessoa1 = personasBuider.basePessoa();
        Person pessoa2 = personasBuider.addSobrenome("Araujo").basePessoa();
        Assertions.assertFalse(peopleComparator.isSamePerson(pessoa1, pessoa2));
    }

    @Test
    public void pessoasDiferentesEstadoCivil(){
        Person pessoa1 = personasBuider.basePessoa();
        Person pessoa2 = personasBuider.addEstadoCivil("Solteiro").basePessoa();
        Assertions.assertFalse(peopleComparator.isSamePerson(pessoa1, pessoa2));
    }

    @Test
    public void dataDeAniversarioDiferente(){
        Person pessoa = personasBuider.addAniversario(agora.parse("2020-01-13")).basePessoa();
        Assertions.assertFalse(peopleComparator.isTodayPersonsBirthDay(pessoa));
    }

    @Test
    public void nascimentoEmAnoNaoBisexto(){
        LocalDate aniversario = LocalDate.of(2019, Month.FEBRUARY, 19);
        Person person = personasBuider.addAniversario(aniversario).basePessoa();
        Assertions.assertFalse(peopleComparator.isTodayPersonsBirthDay(person));
    }
}
