package br.com.contmatic.prova01.exceptions;

public class CnpjInvalidoException extends RuntimeException {
	public CnpjInvalidoException() {
		super("CNPJ inválido!");
	}

}
