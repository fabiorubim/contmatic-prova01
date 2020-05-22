package br.com.contmatic.types;

public enum TelefoneType {
                          RESIDENCIAL("Residencial", 8),
                          TRABALHO("Trabalho", 8),
                          COMERCIAL("Comercial", 8),
                          CELULAR("Celular", 9),
                          RECADO("Recado", 9);

    private String descricao;
    private int comprimento;

    TelefoneType(String descricao, int comprimento){
        this.descricao = descricao;
        this.comprimento = comprimento;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public int getComprimento() {
        return this.comprimento;
    }
}
