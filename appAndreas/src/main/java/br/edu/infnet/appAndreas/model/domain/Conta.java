package br.edu.infnet.appAndreas.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "TConta")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String numero;
	private float saldo;
	private boolean isAtivo;

	@ManyToOne
	@JoinColumn(name = "idAgencia")
	@JsonBackReference(value = "agencia-conta")
	private Agencia agencia;

	@ManyToOne
	@JoinColumn(name = "idCliente")
	@JsonBackReference(value = "cliente-conta")
	private Cliente cliente;

	@Override
	public String toString() {
		// return String.format("%d;%s;%.2f;%s,%s,%s", id, numero, saldo, isAtivo ?
		// "ativo=sim" : "ativo=não", agencia,
		// cliente);
		return super.toString();
	}

}
