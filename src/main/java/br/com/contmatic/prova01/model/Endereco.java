
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
	
	@Override
	public int hashCode() {
		int hash = 1;
		if (this.endereco != null) {
			hash *= this.endereco.hashCode();			
		}
		
		if (numero != null) {
			hash *= this.numero.hashCode();
		}
		
		if (cidade != null) {
			hash *= this.cidade.hashCode();
		}
		
		if (cep != null) {
			hash *= this.cep.hashCode();
		}
		
		return Math.abs(hash);
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj) {
            return true;
        }
		
        if (!(obj instanceof Endereco)) {
            return false;
        }
        
        Endereco enderecoObj = (Endereco) obj;
        
        if (enderecoObj.endereco != this.endereco) {
        	return false;
        }
        
        if (enderecoObj.numero != this.numero) {
        	return false;
        }
        
        if (enderecoObj.cidade != this.cidade) {
        	return false;
        }
        
        if (enderecoObj.uf != this.uf) {
        	return false;
        }
        
        if (enderecoObj.cep != this.cep) {
        	return false;
        }	
		return true;
	}	
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
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