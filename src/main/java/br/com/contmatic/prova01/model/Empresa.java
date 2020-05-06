package br.com.contmatic.prova01.model;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
	private String razaoSocial;
	private String nomeFantasia;
	private String cnpj;
	private String inscricaoEstadual;
	private Endereco endereco;
	private List<Departamento> departamentos;
	
	public Empresa(String razaoSocial, String nomeFantasia, String cnpj, String inscricaoEstadual, String endereco,
			String numero, String cidade, String uf, String cep) {
		super();
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.inscricaoEstadual = inscricaoEstadual;
		this.endereco = new Endereco(endereco, numero, cidade, uf, cep);
	}
	
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
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
	
	public String getEndereco() {
		return this.endereco.getEndereco();
	}

	public String getNumero() {
		return this.endereco.getNumero();
	}

	public String getCidade() {
		return this.endereco.getCidade();
	}
	
	public String getUf() {
		return this.endereco.getUf();
	}

	public String getCep() {
		return this.endereco.getCep();
	}
	
	public int getEnderecoHashCode() {
		return this.endereco.hashCode();
	}
	
	@Override
	public int hashCode() {
		int hash = 1;
		
		if (razaoSocial != null) {
			hash *= razaoSocial.hashCode();
		}
		
		if (nomeFantasia != null) {
			hash *= nomeFantasia.hashCode();
		}
		
		if (cnpj != null) {
			hash *= cnpj.hashCode();
		}
		
		if (inscricaoEstadual != null) {
			hash *= inscricaoEstadual.hashCode();
		}
		
		if (endereco != null) {
			hash *= endereco.hashCode();
		}
				
		return Math.abs(hash);
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
	
	public int getQuantidadeDepartamentos() {
		return this.departamentos.size();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
            return true;
        }
		
        if (!(obj instanceof Empresa)) {
            return false;
        }
        
        Empresa empresaObj = (Empresa) obj;
        
        if (empresaObj.razaoSocial != this.razaoSocial) {
        	return false;
        }
        
        if (empresaObj.razaoSocial != this.razaoSocial) {
        	return false;
        }
        
        if (empresaObj.nomeFantasia != this.nomeFantasia) {
        	return false;
        }
        
        if (empresaObj.cnpj != this.cnpj) {
        	return false;
        }
        
        if (empresaObj.inscricaoEstadual != this.inscricaoEstadual) {
        	return false;
        }
                
        if (!empresaObj.endereco.equals(this.endereco)) {
        	return false;
        }
        
        return true;
		
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("Razão Social: ");
		sb.append(this.razaoSocial);
		sb.append("\nNome Fantasia: ");
		sb.append(this.nomeFantasia);
		sb.append("\nCNPJ: ");
		sb.append(this.cnpj);
		sb.append("\nInscrição Estadual: ");
		sb.append(this.inscricaoEstadual);
		sb.append("\nEndereço: ");
		sb.append(this.endereco.toString());
		
		return sb.toString();
	}
}