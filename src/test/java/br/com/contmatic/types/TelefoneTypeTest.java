package br.com.contmatic.types;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TelefoneTypeTest {
    @Test
    public void deve_ser_um_telefone_do_tipo_trabalho() {
        assertEquals("TRABALHO", TelefoneType.TRABALHO.name());
    }

    @Test
    public void deve_ser_um_telefone_com_a_descricao_trabalho() {
        assertEquals("Trabalho", TelefoneType.TRABALHO.getDescricao());
    }
    
    @Test
    public void deve_ser_um_telefone_do_tipo_trabalho_com_seu_comprimento() {
        assertEquals(8, TelefoneType.TRABALHO.getComprimento());
    }
}
