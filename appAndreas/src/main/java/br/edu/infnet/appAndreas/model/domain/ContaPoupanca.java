package br.edu.infnet.appAndreas.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "TContaPoupanca")
public class ContaPoupanca extends Conta {

	private int diaAniversario;
	private float taxaRendimento;

	@Override
	public String toString() {
		return String.format("%s;%d;%.3f", super.toString(), diaAniversario, taxaRendimento);
	}

}
