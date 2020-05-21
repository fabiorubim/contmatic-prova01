package br.com.contmatic.prova01.exceptions;

public class CnpjInvalidoException extends RuntimeException {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;

    public CnpjInvalidoException() {
		super("CNPJ inválido!");
	}

}
