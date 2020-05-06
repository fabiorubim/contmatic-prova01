package br.com.contmatic.prova01.main;

import br.com.contmatic.prova01.model.Empresa;

public class Main {
	public static void main(String[] args) {
		Empresa empresa = new Empresa("Razão Social", "Nome Fantasia", "52.144.080/0001-52", "935.995.860.240", 
				" Rua Padre Estevão Pernet", "215", "São Paulo", "SP", "03315-000");

		System.out.println(empresa.toString());
	}
}