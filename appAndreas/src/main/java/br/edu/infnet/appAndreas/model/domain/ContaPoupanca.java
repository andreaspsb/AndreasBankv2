package br.edu.infnet.appAndreas.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TContaPoupanca")
public class ContaPoupanca extends Conta {

	private int diaAniversario;
	private float taxaRendimento;

	@Override
	public String toString() {
		return String.format("%s;%d;%.3f", super.toString(), diaAniversario, taxaRendimento);
	}

	public int getDiaAniversario() {
		return diaAniversario;
	}

	public void setDiaAniversario(int diaAniversario) {
		this.diaAniversario = diaAniversario;
	}

	public float getTaxaRendimento() {
		return taxaRendimento;
	}

	public void setTaxaRendimento(float taxaRendimento) {
		this.taxaRendimento = taxaRendimento;
	}

}
