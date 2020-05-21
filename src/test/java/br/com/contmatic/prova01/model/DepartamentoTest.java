package br.com.contmatic.prova01.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class DepartamentoTest {
	private static Departamento departamento;
	
	@BeforeAll
	public static void setUp() {
		departamento = new Departamento("RH");		
	}
	
	@BeforeEach
	public void setUpBefore() {
		departamento.setNome("RH");
	}
	
	@Test
	@Order(1)
	public void nao_deve_permitir_nome_nulo() {
		assertNotNull(departamento.getNome());
	}
	
	@Test
	@Order(2)
	public void nao_deve_aceitar_nome_vazio() {
		assertNotEquals("", departamento.getNome());
	}
	
	@Test
	@Order(3)
	public void deve_ter_o_mesmo_departamento_do_setup() {
		assertEquals("RH", departamento.getNome());
	}
	
	@Test
	@Order(4)
	public void deve_permitir_alterar_nome() {
		departamento.setNome("TI");
		assertEquals("TI", departamento.getNome());
	}
	
	@Test
	@Order(5)
	public void deve_comparar_dois_objetos_com_hascode_iguais() {
		Departamento novoDepartamento = new Departamento("TI");
		assertEquals(departamento.hashCode(), novoDepartamento.hashCode());
	}
	
	@Test
	@Order(6)
	public void deve_comparar_dois_objetos_com_hascode_diferentes_nome_nulo() {
		Departamento novoDepartamento = new Departamento(null);
		assertNotEquals(departamento.hashCode(), novoDepartamento.hashCode());
	}
	
	@Test
	@Order(7)
	public void deve_comparar_dois_objetos_iguais() {
		Departamento novoDepartamento = new Departamento("TI");
		assertTrue(departamento.equals(novoDepartamento));
	}
	
	@Test
	@Order(8)
	public void deve_passar_no_teste_se_os_objetos_forem_o_mesmo() {
		assertTrue(departamento.equals(departamento));
	}
	
	@Test
	@Order(9)
	public void deve_passar_note_teste_se_um_dos_objetos_for_nulo() {
		Departamento novoDepartamento = null;
		assertFalse(departamento.equals(novoDepartamento));
	}
	
	@Test
	@Order(10)
	public void deve_passar_no_teste_se_os_objetos_foram_instancias_de_classe_diferentes() {
		Endereco endereco = new Endereco("Rua Padre Estevão Pernet", "215", "São Paulo", "SP", "03315-000");
		assertFalse(departamento.equals(endereco));
	}
	
	@Test
	@Order(11)
	public void deve_comparar_tostring_de_dois_objetos() {
		Departamento novoDepartamento = new Departamento("TI");
		assertTrue(departamento.toString().equals(novoDepartamento.toString()));
	}
	
	@Test
	@Order(12)
	public void deve_passar_no_teste_caso_a_nome_do_departamento1__seja_nulo_e_o_do_outro_objeto_nao_seja_nulo() {
		Departamento departamento1 = new Departamento(null);
		Departamento departamento2 = new Departamento("TI");
		assertFalse(departamento1.equals(departamento2));
	}
	
	@Test@Order(13)
	public void deve_passar_no_teste_caso_o_nome_do_departamento1__seja_diferente_do_outro_objeto() {
		Departamento departamento1 = new Departamento("RH");
		Departamento departamento2 = new Departamento("TI");
		assertFalse(departamento1.equals(departamento2));
	}
}
