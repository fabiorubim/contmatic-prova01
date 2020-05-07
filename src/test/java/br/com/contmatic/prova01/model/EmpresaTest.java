package br.com.contmatic.prova01.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static java.time.Duration.ofMillis;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import br.com.contmatic.prova01.exceptions.CnpjInvalidoException;

@TestMethodOrder(OrderAnnotation.class)
public class EmpresaTest {
	private static Empresa empresa;
	private static Empresa empresaIgual;
	
	@BeforeAll
	public static void setUp() {
		empresa = new Empresa("Razão Social", "Nome Fantasia", "52.144.080/0001-52", "935.995.860.240", 
				"Rua Padre Estevão Pernet", "215", "São Paulo", "SP", "03315-000");
		
		empresaIgual = new Empresa("Razão Social", "Nome Fantasia", "52.144.080/0001-52", "935.995.860.240", 
				"Rua Padre Estevão Pernet", "215", "São Paulo", "SP", "03315-000");
	}
	
	@BeforeEach
	public void addDepartment() {
		empresa.adicionarDepartamento("Departamento");
	}
	
	@Test
	@Order(1)
	public void nao_deve_aceitar_razao_social_null() {		
		assertNotNull(empresa.getRazaoSocial());
	}
	
	@Test
	@Order(2)
	public void nao_deve_aceitar_razao_social_vazia() {
		assertNotEquals("", empresa.getRazaoSocial());
	}
	
	@Test
	@Order(3)
	public void devem_possuir_mesmo_hashCode_quando_possuirem_estados_iguais() {
		assertEquals(empresa.hashCode(), empresaIgual.hashCode());
	}
	
	@Test
	@Order(4)
	public void devem_ser_iguais_quando_possuirem_estados_iguais() {
		assertTrue(empresa.equals(empresaIgual));
	}
	
	
	@Test
	@Order(5)
	public void nao_deve_aceitar_nome_fantasia_nulo() {
		assertNotNull(empresa.getNomeFantasia());
	}
	
	@Test	
	@Order(6)
	public void nao_deve_aceitar_nome_fantasia_vazio() {
		assertNotEquals("", empresa.getNomeFantasia());
	}
	
	@Test
	@Order(7)
	public void nao_deve_aceitar_cnpj_nulo() {
		assertNotNull(empresa.getCnpj());
	}
	
	@Test
	@Order(8)
	public void nao_deve_aceitar_cnpj_vazio() {
		assertNotEquals("", empresa.getCnpj());
	}
	
	@Test
	@Order(9)
	public void nao_deve_aceitar_inscricao_estadual_nula() {
		assertNotNull(empresa.getInscricaoEstadual());
	}
	
	@Test
	@Order(10)
	public void nao_deve_aceitar_inscricao_estadual_vazia() {
		assertNotEquals("", empresa.getInscricaoEstadual());
	}	
	
	@Test
	@Order(11)
	public void nao_deve_aceitar_endereco_nulo() {
		assertNotNull(empresa.getEndereco());
	}
	

	@Test
	@Order(12)
	public void nao_deve_aceitar_endereco_vazio() {
		assertNotEquals("", empresa.getEndereco());
	}
	
	@Test
	@Order(13)
	public void nao_deve_aceitar_numero_nulo() {
		assertNotNull(empresa.getEndereco().getNumero());
	}
	
	@Test
	@Order(14)
	public void nao_deve_aceitar_numero_vazio() {
		assertNotEquals("", empresa.getEndereco().getNumero());
	}
	
	@Test
	@Order(15)
	public void nao_deve_aceitar_cidade_nula() {
		assertNotNull(empresa.getEndereco().getCidade());
	}
	

	@Test
	@Order(16)
	public void nao_deve_aceitar_cidade_vazia() {
		assertNotEquals("", empresa.getEndereco().getCidade());
	}
	
	@Test
	@Order(17)
	public void nao_deve_aceitar_uf_nulo() {
		assertNotNull(empresa.getEndereco().getUf());
	}
	

	@Test
	@Order(18)
	public void nao_deve_aceitar_uf_vazio() {
		assertNotEquals("", empresa.getEndereco().getUf());
	}
	
	@Test
	@Order(19)
	public void nao_deve_aceitar_cep_nulo() {
		assertNotNull(empresa.getEndereco().getCep());
		assertTimeout(ofMillis(100), () -> {
			Thread.sleep(95);
		});
	}
	

	@Test
	@Order(20)
	public void nao_deve_aceitar_cep_vazio() {
		assertNotEquals("", empresa.getEndereco().getCep());
	}
	
	@Test
	@Order(21)
	public void nao_deve_aceitar_departamento_nulo() {
		assertNotNull(empresa.getDepartamentos());
	}
	
	@Test
	@Order(22)
	public void nao_deve_aceitar_nome_nulo() {
		Departamento dep = empresa.getDepartamentos().get(0);
		assertNotNull(dep.getNome());
	}
	
	@Test
	@Order(23)
	public void deve_ser_departamentos_com_estados_iguais() {
		Departamento dep1 = empresa.getDepartamentos().get(0);
		Departamento dep2 = empresa.getDepartamentos().get(1);
		dep1.setNome(dep2.getNome());
		assertTrue(dep1.equals(dep2));
	}
	
	@Test
	@Order(24)
	public void devem_ser_departamentos_com_hashCode_iguais() {
		Departamento dep1 = empresa.getDepartamentos().get(0);
		Departamento dep2 = empresa.getDepartamentos().get(1);
		dep1.setNome(dep2.getNome());
		assertEquals(dep1.hashCode(), dep2.hashCode());
	}
	
	@Test
	@Order(25)
	public void nao_deve_aceitar_nome_vazio() {
		Departamento dep = empresa.getDepartamentos().get(0);
		assertNotEquals("", dep.getNome());
	}
	
	@Test
	@Order(26)
	public void deve_ser_departamentos_com_toString_iguais() {
		Departamento dep1 = empresa.getDepartamentos().get(0);
		Departamento dep2 = empresa.getDepartamentos().get(1);
		dep1.setNome(dep2.getNome());
		assertEquals(dep1.toString(), dep2.toString());
	}
	
	@Test
	@Order(27)
	public void deve_retornar_true_quando_foram_departamentos_com_toString_iguais() {
		String nomeCorporacao = "ACME Corporation";
		Departamento dep1 = empresa.getDepartamentos().get(0);
		dep1.setNome(nomeCorporacao);
		assertEquals(nomeCorporacao, dep1.getNome());
	}
	
	@Test
	@Order(28)
	public void deve_possui_o_mesmo_valor_da_variavel_razaosocial() {
		String razaoSocial = "Isto é o campo razão social";
		empresa.setRazaoSocial(razaoSocial);
		assertEquals(razaoSocial, empresa.getRazaoSocial());
	}
	
	@Test
	@Order(29)
	public void deve_possui_o_mesmo_valor_da_variavel_nome_fantasia() {
		String nomeFantasia = "Isto é o campo nome fantasia";
		empresa.setNomeFantasia(nomeFantasia);
		assertEquals(nomeFantasia, empresa.getNomeFantasia());
	}
	
	
	@Test
	@Order(30)
	public void deve_possui_o_mesmo_valor_da_cnpj() {
		String cnpj = "85.046.714/0001-93";
		empresa.setCnpj(cnpj);
		assertEquals(cnpj, empresa.getCnpj());
	}
	
	
	@Test
	@Order(31)
	public void deve_possui_o_mesmo_valor_da_inscricao_estadual() {
		String incricaoEstadual = "982.571.237.031";
		empresa.setInscricaoEstadual(incricaoEstadual);
		assertEquals(incricaoEstadual, empresa.getInscricaoEstadual());
	}
	
	@Test
	@Order(32)
	public void deve_possui_o_mesmo_valor_do_endereco() {
		String endereco = "Rua da Consolação";
		empresa.getEndereco().setEndereco(endereco);
		assertEquals(endereco, empresa.getEndereco().getEndereco());
	}
	
	@Test
	@Order(33)
	public void deve_possui_o_mesmo_valor_do_numero_do_endereco() {
		String numero = "1521";
		empresa.getEndereco().setNumero(numero);
		assertEquals(numero, empresa.getEndereco().getNumero());
	}
	
	@Test
	@Order(34)
	public void deve_possui_o_mesmo_valor_da_cidade() {
		String cidade = "São Paulo";
		empresa.getEndereco().setCidade(cidade);
		assertEquals(cidade, empresa.getEndereco().getCidade());
	}
	
	@Test
	@Order(35)
	public void deve_possui_o_mesmo_valor_da_uf() {
		String uf = "SP";
		empresa.getEndereco().setUf(uf);
		assertEquals(uf, empresa.getEndereco().getUf());
	}
	
	@Test
	@Order(36)
	public void deve_possui_o_mesmo_valor_do_cep() {
		String cep = "02410-060";
		empresa.getEndereco().setCep(cep);
		assertEquals(cep, empresa.getEndereco().getCep());
	}
	
	@Test
	@Order(37)
	public void devem_retornar_toString_iguais() {
		assertFalse(empresa.toString().equals(empresaIgual.toString()));
	}
	
	@Test
	@Order(38)
	public void deve_aceitar_somente_cnpj_valido() {
		assertTrue(Empresa.validaCnpj("33.022.664/0001-00"));
	}
	
	@Test
	@Order(39)
	public void nao_deve_aceitar_cnpj_invalido() {
		assertFalse(Empresa.validaCnpj("33.022.664/0001-50"));
	}
	
	@Test
	@Order(40)
	public void deve_aceitar_cnpj_valido() {
		assertThat(empresa.getCnpj(), is("85.046.714/0001-93"));
	}
	
	@Test
	@Order(41)
	public void deve_gerar_excecao_para_cnpj_invalido() {
		Exception exception =  assertThrows(CnpjInvalidoException.class,
				() -> { new Empresa("Razão Social ERRADO", "Nome Fantasia ERRADO", "52.144.080/0001-00", "935.995.860.240", 
						"Rua Padre Estevão Pernet", "215", "São Paulo", "SP", "03315-000");
				}
				
				);
		String mensagemEsperada = "CNPJ inválido!";
	    String mensagemGerada = exception.getMessage();
	 
	    assertTrue(mensagemGerada.contains(mensagemEsperada));
	}
			
	@Disabled("Exemplo de utilização do @Ignore, no JUnit 5 é Disabled")
	@Test
	@Order(40)
	public void testGetCepEquals() {
		assertEquals("03315-000", empresa.getEndereco().getCep());
	}
	
	@AfterAll
	public static void quantidadeDepartamentos() {
		assertEquals(41, empresa.getDepartamentos().size());
	}
}
