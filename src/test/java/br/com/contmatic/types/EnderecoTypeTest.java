package br.com.contmatic.types;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EnderecoTypeTest {
    @Test
    public void deve_ser_um_endereco_residencial() {
        assertEquals("RESIDENCIAL", EnderecoType.RESIDENCIAL.name());
    }

    @Test
    public void deve_testar_a_descricao_residencial() {
        assertEquals("Residencial", EnderecoType.RESIDENCIAL.getDescricao());
    }
}
