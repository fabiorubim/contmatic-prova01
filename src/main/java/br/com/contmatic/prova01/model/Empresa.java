package br.com.contmatic.prova01.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.URL;
import org.hibernate.validator.constraints.br.CNPJ;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CNPJValidator;
import br.com.contmatic.prova01.exceptions.CnpjInvalidoException;
import br.com.contmatic.types.TelefoneType;

public class Empresa {
    @NotNull(message = "Razão Social não pode ser nula")
    private String razaoSocial;
    @NotBlank(message = "Nome Fantasia não pode ser vazio/nulo")
    private String nomeFantasia;
    @CNPJ
    private String cnpj;
    private String inscricaoEstadual;
    private Endereco endereco;
    @NotEmpty
    private List<Departamento> departamentos;
    private TelefoneType tipoTelefone;
    @Size(min = 10, max = 14, message = "O telfone não pode ser menor do que 10 ou maior do que 14 se possuir sua máscara")
    private String telefone;
    @Email(message = "Deve ser um e-mail válido")
    private String email;
    @URL
    private String url;

    public static boolean validaCnpj(String cnpj) {
        CNPJValidator cnpjValidator = new CNPJValidator();
        List<ValidationMessage> erros = cnpjValidator.invalidMessagesFor(cnpj);
        return (erros.isEmpty());
    }

    public Empresa(String razaoSocial, String nomeFantasia, String cnpj, String inscricaoEstadual, String endereco, String numero, String cidade, String uf, String cep) {
        super();
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        if (validaCnpj(cnpj)) {
            this.cnpj = cnpj;
        } else {
            throw new CnpjInvalidoException();
        }
        this.inscricaoEstadual = inscricaoEstadual;
        this.endereco = new Endereco(endereco, numero, cidade, uf, cep);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void adicionarDepartamento(String nome) {
        if (this.departamentos == null) {
            this.departamentos = new ArrayList<Departamento>();

            this.departamentos.add(new Departamento(nome + " 1"));
        } else {
            int numDepartamento = this.departamentos.size() + 1;
            this.departamentos.add(new Departamento(nome + " " + numDepartamento));
        }
    }

    public List<Departamento> getDepartamentos() {
        return this.departamentos;
    }
    
    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public TelefoneType getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(TelefoneType tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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
