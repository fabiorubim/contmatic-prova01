package br.com.contmatic.prova01.model;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.contmatic.prova01.fixturefactory.template.FixtureFactoryEmpresaTemplate;
import br.com.six2six.fixturefactory.Fixture;

public class FixFactoryDepartamentoTest {

    @BeforeAll
    public static void setUp() {
        new FixtureFactoryEmpresaTemplate().load();
    }

    @Test
    public void isto_eh_um_teste_de_teste() {
        Departamento departamentoRandom = Fixture.from(Departamento.class).gimme("valido");
        assertNotNull(departamentoRandom.getNome());
    }
}
