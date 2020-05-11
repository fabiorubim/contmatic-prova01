package br.com.contmatic.prova01.model;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class EnderecoTest {
	private static Endereco endereco;

	@BeforeAll
	public static void setUp() {
		endereco = new Endereco("Rua Padre Estevão Pernet", "215", "São Paulo", "SP", "03315-000");
	}	

	@Test
	public void nao_deve_aceitar_endereco_nulo() {
		assertNotNull(endereco.getEndereco());
	}

	@Test
	public void nao_deve_aceitar_endereco_vazio() {
		assertNotEquals("", endereco.getEndereco());
	}

	@Test
	public void nao_deve_aceitar_numero_nulo() {
		assertNotNull(endereco.getNumero());
	}

	@Test
	public void nao_deve_aceitar_numero_vazio() {
		assertNotEquals("", endereco.getNumero());
	}

	@Test
	public void nao_deve_aceitar_cidade_nula() {
		assertNotNull(endereco.getCidade());
	}

	@Test
	public void nao_deve_aceitar_cidade_vazia() {
		assertNotEquals("", endereco.getCidade());
	}

	@Test
	public void nao_deve_aceitar_uf_nulo() {
		assertNotNull(endereco.getUf());
	}

	@Test
	public void nao_deve_aceitar_uf_vazio() {
		assertNotEquals("", endereco.getUf());
	}

	@Test
	public void nao_deve_aceitar_cep_nulo() {
		assertNotNull(endereco.getCep());
		assertTimeout(ofMillis(100), () -> {
			Thread.sleep(95);
		});
	}

	@Test
	public void nao_deve_aceitar_cep_vazio() {
		assertNotEquals("", endereco.getCep());
	}

	@Test
	public void deve_permitir_alterar_endereco() {
		endereco.setEndereco("Avenida Paulista");
		assertEquals("Avenida Paulista", endereco.getEndereco());
	}

	@Test
	public void deve_permitir_alterar_numero() {
		endereco.setNumero("1001");
		assertEquals("1001", endereco.getNumero());
	}

	@Test
	public void deve_permitir_alterar_cidade() {
		endereco.setCidade("Campinas");
		assertEquals("Campinas", endereco.getCidade());
	}

	@Test
	public void deve_permitir_alterar_uf() {
		endereco.setUf("MG");
		assertEquals("MG", endereco.getUf());
	}

	@Test
	public void deve_permitir_alterar_cep() {
		endereco.setCep("18080-768");
		assertEquals("18080-768", endereco.getCep());
	}
	
	@Test
	public void deve_possuir_mesmo_hashcode() {
		Endereco novoEndereco = new Endereco("Rua Padre Estevão Pernet", "215", "São Paulo", "SP", "03315-000");
		assertEquals(endereco.hashCode(), novoEndereco.hashCode());		
	}
	
	@Test
	public void deve_possuir_mesmo_hashcode_cep_nulo() {
		Endereco enderecoOriginal = new Endereco("Rua Padre Estevão Pernet", "215", "São Paulo", "SP", null);
		Endereco novoEndereco = new Endereco("Rua Padre Estevão Pernet", "215", "São Paulo", "SP", null);
		assertEquals(enderecoOriginal.hashCode(), novoEndereco.hashCode());		
	}
	
	@Test
	public void deve_possuir_mesmo_hashcode_cidade_nula() {
		Endereco enderecoOriginal = new Endereco("Rua Padre Estevão Pernet", "215", null, "SP", "03315-000");
		Endereco novoEndereco = new Endereco("Rua Padre Estevão Pernet", "215", null, "SP", "03315-000");
		assertEquals(enderecoOriginal.hashCode(), novoEndereco.hashCode());		
	}
	
	@Test
	public void deve_possuir_mesmo_hashcode_endereco_nulo() {
		Endereco enderecoOriginal = new Endereco(null, "215", "São Paulo", "SP", "03315-000");
		Endereco novoEndereco = new Endereco(null, "215", "São Paulo", "SP", "03315-000");
		assertEquals(enderecoOriginal.hashCode(), novoEndereco.hashCode());		
	}
	
	@Test
	public void deve_possuir_mesmo_hashcode_numero_nulo() {
		Endereco enderecoOriginal = new Endereco("Rua Padre Estevão Pernet", null, "São Paulo", "SP", "03315-000");
		Endereco novoEndereco = new Endereco("Rua Padre Estevão Pernet", null, "São Paulo", "SP", "03315-000");
		assertEquals(enderecoOriginal.hashCode(), novoEndereco.hashCode());		
	}
	
	@Test
	public void deve_possuir_mesmo_hashcode_uf_nula() {
		Endereco enderecoOriginal = new Endereco("Rua Padre Estevão Pernet", "215", "São Paulo", null, "03315-000");
		Endereco novoEndereco = new Endereco("Rua Padre Estevão Pernet", "215", "São Paulo", null, "03315-000");
		assertEquals(enderecoOriginal.hashCode(), novoEndereco.hashCode());		
	}
	
	@Test
	@Order(1)
	public void deve_possuir_mesmo_tostring() {
		Endereco novoEndereco = new Endereco("Rua Padre Estevão Pernet", "215", "São Paulo", "SP", "03315-000");
		assertTrue(endereco.toString().equals(novoEndereco.toString()));
	}
	
	@Test
	@Order(2)
	public void deve_retornar_true_caso_os_dois_objetos_possuam_mesmo_estado() {
		Endereco novoEndereco = new Endereco("Rua Padre Estevão Pernet", "215", "São Paulo", "SP", "03315-000");
		assertTrue(endereco.equals(novoEndereco));
	}
	
	@Test
	public void deve_passar_no_teste_caso_um_dos_objetos_seja_nulo() {
		Endereco novoEndereco = null;
		assertFalse(endereco.equals(novoEndereco));
	}
	
	@Test
	public void deve_passar_note_teste_caso_o_objeto_seja_o_mesmo() {
		assertTrue(endereco.equals(endereco));
	}
	
	@Test
	public void deve_passar_no_teste_caso_sejam_instancias_de_classes_diferentes() {
		Departamento departamento = new Departamento("TI");
		assertFalse(endereco.equals(departamento));
	}
	
	@Test
	public void deve_passar_no_teste_caso_o_cep_do_endereco1__seja_nulo_e_o_do_outro_objeto_nao_seja_nulo() {
		Endereco endereco1 = new Endereco("Rua Padre Estevão Pernet", "215", "São Paulo", "SP", "18089-635");
		Endereco endereco2 = new Endereco("Rua Padre Estevão Pernet", "215", "São Paulo", "SP", "03315-000");
		assertFalse(endereco1.equals(endereco2));
	}
	
	@Test
	public void deve_passar_no_teste_caso_o_cep_do_endereco1__seja_diferente_do_outro_objeto() {
		Endereco endereco1 = new Endereco("Rua Padre Estevão Pernet", "215", "São Paulo", "SP", null);
		Endereco endereco2 = new Endereco("Rua Padre Estevão Pernet", "215", "São Paulo", "SP", "03315-000");
		assertFalse(endereco1.equals(endereco2));
	}
	
	@Test
	public void deve_passar_no_teste_caso_a_cidade_do_endereco1__seja_nulo_e_o_do_outro_objeto_nao_seja_nulo() {
		Endereco endereco1 = new Endereco("Rua Padre Estevão Pernet", "215", null, "SP", "03315-000");
		Endereco endereco2 = new Endereco("Rua Padre Estevão Pernet", "215", "São Paulo", "SP", "03315-000");
		assertFalse(endereco1.equals(endereco2));
	}
	
	@Test
	public void deve_passar_no_teste_caso_a_cidade_do_endereco1__seja_diferente_do_outro_objeto() {
		Endereco endereco1 = new Endereco("Rua Padre Estevão Pernet", "215", "Sorocaba", "SP", "03315-000");
		Endereco endereco2 = new Endereco("Rua Padre Estevão Pernet", "215", "São Paulo", "SP", "03315-000");
		assertFalse(endereco1.equals(endereco2));
	}
	
	@Test
	public void deve_passar_no_teste_caso_o_endereco_do_endereco1__seja_nulo_e_o_do_outro_objeto_nao_seja_nulo() {
		Endereco endereco1 = new Endereco(null, "215", "São Paulo", "SP", "03315-000");
		Endereco endereco2 = new Endereco("Rua Padre Estevão Pernet", "215", "São Paulo", "SP", "03315-000");
		assertFalse(endereco1.equals(endereco2));
	}
	
	@Test
	public void deve_passar_no_teste_caso_o_endereco_do_endereco1__seja_diferente_do_outro_objeto() {
		Endereco endereco1 = new Endereco("Avenida Paulista", "215", "São Paulo", "SP", "03315-000");
		Endereco endereco2 = new Endereco("Rua Padre Estevão Pernet", "215", "São Paulo", "SP", "03315-000");
		assertFalse(endereco1.equals(endereco2));
	}
	
	@Test
	public void deve_passar_no_teste_caso_o_numero_do_endereco1__seja_nulo_e_o_do_outro_objeto_nao_seja_nulo() {
		Endereco endereco1 = new Endereco("Rua Padre Estevão Pernet", null, "São Paulo", "SP", "03315-000");
		Endereco endereco2 = new Endereco("Rua Padre Estevão Pernet", "215", "São Paulo", "SP", "03315-000");
		assertFalse(endereco1.equals(endereco2));
	}
	
	@Test
	public void deve_passar_no_teste_caso_o_numero_do_endereco1__seja_diferente_do_outro_objeto() {
		Endereco endereco1 = new Endereco("Rua Padre Estevão Pernet", "5050", "São Paulo", "SP", "03315-000");
		Endereco endereco2 = new Endereco("Rua Padre Estevão Pernet", "215", "São Paulo", "SP", "03315-000");
		assertFalse(endereco1.equals(endereco2));
	}
	
	@Test
	public void deve_passar_no_teste_caso_a_uf_do_endereco1__seja_nulo_e_o_do_outro_objeto_nao_seja_nulo() {
		Endereco endereco1 = new Endereco("Rua Padre Estevão Pernet", "215", "São Paulo", null, "03315-000");
		Endereco endereco2 = new Endereco("Rua Padre Estevão Pernet", "215", "São Paulo", "SP", "03315-000");
		assertFalse(endereco1.equals(endereco2));
	}
	
	@Test
	public void deve_passar_no_teste_caso_a_uf_do_endereco1__seja_diferente_do_outro_objeto() {
		Endereco endereco1 = new Endereco("Rua Padre Estevão Pernet", "215", "São Paulo", "RJ", "03315-000");
		Endereco endereco2 = new Endereco("Rua Padre Estevão Pernet", "215", "São Paulo", "SP", "03315-000");
		assertFalse(endereco1.equals(endereco2));
	}
}
