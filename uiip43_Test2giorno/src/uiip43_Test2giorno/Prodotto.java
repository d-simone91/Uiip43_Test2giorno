package uiip43_Test2giorno;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Prodotto implements Serializable{

	String nome;
	double prezzo;
	int unita;
	
	public Prodotto(String nome, double prezzo,int unita) {
		
		this.nome = nome;
		this.prezzo = prezzo;
		this.unita = unita;
		
	}

	public String getNome() {
		return nome;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public int getUnita() {
		return unita;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prezzo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + unita;
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
		Prodotto other = (Prodotto) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(prezzo) != Double.doubleToLongBits(other.prezzo))
			return false;
		if (unita != other.unita)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "[nome=" + nome + ", prezzo=" + prezzo + ", unita=" + unita + "]";
	}
	
	
	
	
}
