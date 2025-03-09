package br.edu.infnet.appAndreas.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "TContaCorrente")
public class ContaCorrente extends Conta {

	private float limite;
	private float taxaManutencao;

	@Override
	public String toString() {
		//return String.format("%s;%.2f;%.2f", super.toString(), limite, taxaManutencao);
		return super.toString();
	}

}
