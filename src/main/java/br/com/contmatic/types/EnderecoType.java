package br.com.contmatic.types;

public enum EnderecoType {
                          RESIDENCIAL("Residencial"),
                          COMERCIAL("Comercial"),
                          CORRESPONDECIA("Correspondência"),
                          COBRANCA("Corbança"),
                          ENTREGA("Entrega");

    private String descricao;

    EnderecoType(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }
}
