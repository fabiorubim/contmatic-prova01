
package br.com.contmatic.prova01.model;

public class Endereco {
	private String endereco;
	private String numero;
	private String cidade;
	private String uf;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		return true;
	}	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.endereco);
		sb.append("\nNúmero: ");
		sb.append(this.numero);
		sb.append("\nCidade: ");
		sb.append(this.cidade);
		sb.append("\nUF: ");
		sb.append(this.uf);
		sb.append("\nCEP: ");
		sb.append(this.cep);
		
		return sb.toString();
	}
	
}