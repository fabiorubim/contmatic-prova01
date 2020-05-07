package br.com.contmatic.prova01.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterizedEmpresaTest {
	@ParameterizedTest
	@ValueSource(strings = {"33.022.664/0001-00", "85.046.714/0001-93"})
	public void deve_validar_cnpj(String cnpj) {
	    assertTrue(Empresa.validaCnpj(cnpj));
	}
}
