package br.com.contmatic.prova01.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static java.time.Duration.ofMillis;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class EmpresaTest {
	private static Empresa empresa;
	
	@BeforeAll
	public static void setUp() {
		empresa = new Empresa("Razão Social", "Nome Fantasia", "52.144.080/0001-52", "935.995.860.240", 
				"Rua Padre Estevão Pernet", "215", "São Paulo", "SP", "03315-000");
	}
	
	@BeforeEach
	public void addDepartment() {
		empresa.adicionarDepartamento("Departamento");
	}
	
	@Test
	@Order(1)
	public void isNullRazaoSocial() {		
		assertNotNull(empresa.getRazaoSocial());
	}
	
	@Test
	@Order(2)
	public void isNullNomeFantasia() {
		assertNotNull(empresa.getNomeFantasia());
	}
	
	@Test
	@Order(3)
	public void isNullCNPJ() {
		assertNotNull(empresa.getCnpj());
	}
	
	@Test
	@Order(4)
	public void isNullInscricaoEstadual() {
		assertNotNull(empresa.getInscricaoEstadual());
	}
	
	@Test
	@Order(5)
	public void isNullEndereco() {
		assertNotNull(empresa.getEndereco());
	}
	
	@Test
	@Order(6)
	public void isNullNumero() {
		assertNotNull(empresa.getNumero());
	}
	
	@Test
	@Order(7)
	public void isNullCidade() {
		assertNotNull(empresa.getCidade());
	}
	
	@Test
	@Order(8)
	public void isNullUf() {
		assertNotNull(empresa.getUf());
	}
	
	@Test
	@Order(9)
	public void isNullCep() {
		assertNotNull(empresa.getCep());
		assertTimeout(ofMillis(100), () -> {
			Thread.sleep(95);
		});
	}
	
	@Disabled("Falta terminar de implementar!")
	@Test
	@Order(10)
	public void testGetCepEquals() {
		assertEquals("03315-000", empresa.getCep());
	}
	
	
	@AfterAll
	public static void quantidadeDepartamentos() {
		assertEquals(9, empresa.getQuantidadeDepartamentos());
	}
}
