
package br.com.contmatic.prova01.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import br.com.contmatic.types.EnderecoType;

public class Endereco {
    private EnderecoType tipoEndereco;
    @NotNull(message = "Endereço não deve ser nulo")
    private String endereco;
    @NotBlank(message = "Número do endereço não deve ser vazio/nulo")
    private String numero;
    @NotNull(message = "Cidade não deve ser nula")
    private String cidade;
    @NotBlank(message = "Estado não deve ser vazio/nulo")
    private String uf;
    @NotNull(message = "CEP não deve ser nulo")
    private String cep;

    public Endereco(String endereco, String numero, String cidade, String uf, String cep) {
        super();
        this.endereco = endereco;
        this.numero = numero;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNumero() {
        return numero;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }

    public String getCep() {
        return cep;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public EnderecoType getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(EnderecoType tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
