package br.com.contmatic.prova01.model;

import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.br.CPF;
import org.joda.time.DateTime;

public class Funcionario {
    @Length(min = 3, max = 10)
    private String nome;
    private String sobrenome;
    private DateTime dataNascimento;
    @CPF
    private String cpf;
    @Range(min = 1500, max = 15000)
    private double salario;
    @Past
    private DateTime dataContratacao;
    @Future
    private DateTime dataFerias;
    @Min(value = 18, message = "No minímo 18 anos")
    @Max(value = 120, message = "No máximo 120 anos")
    private int idade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public DateTime getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(DateTime dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public DateTime getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(DateTime dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public DateTime getDataFerias() {
        return dataFerias;
    }

    public void setDataFerias(DateTime dataFerias) {
        this.dataFerias = dataFerias;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

}
