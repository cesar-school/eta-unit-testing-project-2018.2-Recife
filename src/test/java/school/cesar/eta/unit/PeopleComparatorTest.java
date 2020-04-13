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


    //isTodayPersonsBirthDay (testes)
    @Test
    public void aniversarioHoje(){
        Person pessoa = personasBuider.addAniversario(agora).basePessoa();
        Assertions.assertTrue(peopleComparator.isTodayPersonsBirthDay(pessoa));
    }

    @Test
    public void dataDeAniversarioDiferenteDeHoje(){
        Person pessoa = personasBuider.addAniversario(agora.parse("2020-01-13")).basePessoa();
        Assertions.assertFalse(peopleComparator.isTodayPersonsBirthDay(pessoa));
    }

    @Test
    public void nascimentoEmAnoBisexto(){
        LocalDate aniversario = LocalDate.of(2020, Month.FEBRUARY, 29);
        Person person = personasBuider.addAniversario(aniversario).basePessoa();
        Assertions.assertFalse(peopleComparator.isTodayPersonsBirthDay(person));
    }

    @Test
    public void nascimentoEmAnoNaoBisexto(){
        LocalDate aniversario = LocalDate.of(2019, Month.FEBRUARY, 19);
        Person pessoa = personasBuider.addAniversario(aniversario).basePessoa();
        Assertions.assertFalse(peopleComparator.isTodayPersonsBirthDay(pessoa));
    }

    //isSamePerson (testes)
    @Test
    public void pessoasComNomesIguais(){
        Person pessoa1 = personasBuider.basePessoa();
        Person pessoa2 = personasBuider.basePessoa();
        Assertions.assertTrue(peopleComparator.isSamePerson(pessoa1, pessoa2));
    }

    @Test
    public void pessoasComNomesDiferentes(){
        Person pessoa1 = personasBuider.basePessoa();
        Person pessoa2 = personasBuider.addNome("Lalleska").basePessoa();
        Assertions.assertFalse(peopleComparator.isSamePerson(pessoa1, pessoa2));
    }

    @Test
    public void pessoasComSobrenomesDiferentes(){
        Person pessoa1 = personasBuider.basePessoa();
        Person pessoa2 = personasBuider.addSobrenome("Araujo").basePessoa();
        Assertions.assertFalse(peopleComparator.isSamePerson(pessoa1, pessoa2));
    }

    @Test
    public void pessoasComEstadoCivilDiferentes(){
        Person pessoa1 = personasBuider.basePessoa();
        Person pessoa2 = personasBuider.addEstadoCivil("Solteiro").basePessoa();
        Assertions.assertFalse(peopleComparator.isSamePerson(pessoa1, pessoa2));
    }

    @Test
    public void pessoasDaMesmaCidade(){
        Person pessoa1 = personasBuider.basePessoa();
        Person pessoa2 = personasBuider.addCidade("Recife").basePessoa();
        Assertions.assertTrue(peopleComparator.isSamePerson(pessoa1, pessoa2));
    }

    @Test
    public void pessoasDeCidadesDiferentes(){
        Person pessoa1 = personasBuider.basePessoa();
        Person pessoa2 = personasBuider.addCidade("Olinda").basePessoa();
        Assertions.assertFalse(peopleComparator.isSamePerson(pessoa1, pessoa2));
    }

    @Test
    public void dataDeAniversarioIguais(){
        Person pessoa1 = personasBuider.addAniversario(agora).basePessoa();
        Person pessoa2 = personasBuider.addAniversario(agora).basePessoa();
        Assertions.assertTrue(peopleComparator.isSamePerson(pessoa1, pessoa2));
    }

    @Test
    public void dataDeAniversarioDiverente(){
        Person pessoa1 = personasBuider.addAniversario(agora.parse("2020-01-13")).basePessoa();
        Person pessoa2 = personasBuider.addAniversario(agora).basePessoa();
        Assertions.assertFalse(peopleComparator.isSamePerson(pessoa1, pessoa2));
    }

    @Test
    public void casoDeExcecao(){
        Person pessoa = personasBuider.basePessoa();
        Assertions.assertThrows(RuntimeException.class, () -> peopleComparator.isSamePerson(pessoa, pessoa));
    }

    //isSameFamily (testes)
    @Test
    public void pessoasComMesmoSobrenome(){
        Person pessoa1 = personasBuider.basePessoa();
        Person pessoa2 = personasBuider.addNome("Lalleska").addSobrenome("Soares").basePessoa();
        Assertions.assertTrue(peopleComparator.isSameFamily(pessoa1, pessoa2));
    }

    @Test
    public void pessoasComMesmoEstadoCivil(){
        Person pessoa1 = personasBuider.basePessoa();
        Person pessoa2 = personasBuider.addNome("Lalleska").addSobrenome("Soares")
                .addEstadoCivil("Casado").basePessoa();
        Assertions.assertTrue(peopleComparator.isSameFamily(pessoa1, pessoa2));
    }
}
